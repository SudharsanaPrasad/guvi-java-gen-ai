package com.guvi.collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
You ingest weekly product lists from multiple vendors. Each vendor uses their own alias for a
product (e.g., “Galaxy S24 Ultra 256 Black” vs “SM-S928B-256-BLK”). A separate file maps every
alias to sku (Stock Keeping Unit), your canonical identifier.

Task
 - Build the unique set of SKUs offered this week (by mapping vendor aliases to skus).
 - Compare last week’s SKUs to find new and discontinued items.
 - Flag data quality issues:
    - Unknown aliases (appear in vendor files but missing from the alias map)
    - Alias conflicts (same alias mapped to different skus in the alias map)
 - Include test cases to validate expected outcome for certain input
    - Test case: input only has 2 files
        - Expectation: error thrown
        - Reality: program doesn't throw an error
 - Inputs
    - alias_map.csv: alias,sku
    - last_week_skus.txt: one sku per line
    - One or more vendor CSVs: alias,price,stock,... (we only need alias)

*/
public class CatalogAggregator {
    // src/main/resources/catalog_sample/alias_map.csv src/main/resources/catalog_sample/last_week_skus.txt src/main/resources/catalog_sample/vendor_alpha.csv src/main/resources/catalog_sample/vendor_beta.csv
    // Collection data structures -> List, Queue, Map, Set
    /*
        args[0] - alias map
        args[1] - last week's skus
        args[2] or above - vendor product list
     */
    public static void main(String[] args) throws IOException {
        // validation: check whether we've at least 3 files
        if(args.length < 3) {
            // throw new IllegalArgumentException()
            System.err.println("Invalid arguments. Expected: alias map, last week's skus, vendor product list");
        }

        // construct the Path to read the input files
        Path aliasMapPath = Path.of(args[0]);
        Path lastWeekPath = Path.of(args[1]);

        // declare variables to store the input data in memory
        // aliasToSku map -> HashMap<String, String>
        Map<String, String> aliasToSku = new HashMap<>();
        // skuToAlias map ->  HashMap<String, Set<String>> that gives us the aliases for a given sku
        Map<String, Set<String>> skuToAlias = new HashMap<>();
        // conflictAliases -> Set
        Set<String> conflictAliases = new HashSet<>();

        // loadAliasMap
        loadAliasMap(aliasMapPath, aliasToSku, conflictAliases, skuToAlias);

        // loadSkuList
        Set<String> lastWeekSkus = loadSkuList(lastWeekPath);

        // declare variables to store the vendor data
        // thisWeekSkus -> Set<String>
        Set<String> thisWeekSkus = new HashSet<>();
        // unknownAliases -> Set<String>
        Set<String> unknownAliases = new HashSet<>();

        // loadVendorFile
        for(var i = 2; i < args.length; i++) {
            loadVendorFile(Path.of(args[i]), aliasToSku, thisWeekSkus, unknownAliases);
        }

        // Deltas - new skus & discontinued skus
        // Set of this week's SKUs, remove last week's SKUs -> new skus
        Set<String> newSkus = new HashSet<>(thisWeekSkus);
        newSkus.removeAll(lastWeekSkus);

        // Set of last weeks' SKUs, remove this week's SKUs -> discontinued skus
        Set<String> discontinuedSkus = new HashSet<>(lastWeekSkus);
        discontinuedSkus.removeAll(thisWeekSkus);

        // Output
        System.out.println("==== SUMMARY ====");
        System.out.println("This week SKUs: " + thisWeekSkus.size());
        System.out.println("Last week SKUs: " + lastWeekSkus.size());
        System.out.println("New SKUs: " + newSkus.size());
        System.out.println("Discontinued SKUs: " + discontinuedSkus.size());
        System.out.println("Unknown aliases: " + unknownAliases.size());
        System.out.println("Alias conflicts in alias_map: " + conflictAliases.size());

        int count = 0;
        for(String str : newSkus) {
            System.out.println(str);
            count++;
            if(count == 10) break;
        }
    }

    // loadAliasMap: path, aliasToSku, conflictAliases, skuToAlias
    public static void loadAliasMap(Path path, Map<String, String> aliasToSku,
                                    Set<String> conflictAliases, Map<String, Set<String>> skuToAlias) throws IOException {
        Scanner sc = new Scanner(Files.newBufferedReader(path));
        while(sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            // what if line is empty?
            if(line.isEmpty()) continue;

            // "Alias,sku" -> "alias,sku".startsWith("alias,")
            if(line.toLowerCase().startsWith("alias,")) continue;

            // Input: galaxy s24 ultra 256 black,SAM-S24U-256-BLK
            // parts = ["galaxy s24 ultra 256 black", "SAM-S24U-256-BLK"]
            String[] parts = line.split(",");
            if(parts.length != 2) continue;

            String aliasRaw = parts[0].trim().toLowerCase();
            String skuRaw = parts[1].trim().toLowerCase();
            // what if these are empty?

            String existing = aliasToSku.get(aliasRaw);
            if(existing == null) {
                aliasToSku.put(aliasRaw, skuRaw);
            } else {
                conflictAliases.add(aliasRaw);
            }

            Set<String> aliases = skuToAlias.get(skuRaw);
            if(aliases == null) {
                aliases = new HashSet<>();
                skuToAlias.put(skuRaw, aliases);
            }
            aliases.add(aliasRaw);
        }
    }

    // loadSkuList: path -> Set<String>
    public static Set<String> loadSkuList(Path path) throws IOException {
        // declare a Set<String>
        Set<String> skus = new HashSet<>();
        // read from the sku list file
        Scanner sc = new Scanner(Files.newBufferedReader(path));
        while(sc.hasNextLine()) {
            // for each given line, add it to a set
            String sku = sc.nextLine().trim();
            skus.add(sku.toLowerCase());
        }
        // return the set
        return skus;
    }

    // loadVendorFile: path, aliasToSku, thisWeekSkus, unknownAliases
    public static void loadVendorFile(Path path, Map<String, String> aliasToSku,
                                      Set<String> thisWeekSkus, Set<String> unknownAliases) throws IOException {
        Scanner sc = new Scanner(Files.newBufferedReader(path));
        while(sc.hasNextLine()) {
            String line = sc.nextLine().trim();;
            // if line is empty? continue
            if(line.toLowerCase().startsWith("alias,")) continue;

            String[] parts = line.split(",");
            // if parts.length < 1 continue

            String aliasRaw = parts[0].trim().toLowerCase();
            // if aliasRaw is empty? continue

            String sku = aliasToSku.get(aliasRaw);
            if(sku == null) {
                unknownAliases.add(aliasRaw);
                continue;
            }
            thisWeekSkus.add(sku);
        }
    }
}
