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
/*
    Read the inputs:
        - Files:
            - Alias map: alias_map.csv
            - Last week's SKU: last_week_skus.txt
            - Vendor product lists: vendor_alpha.csv, vendor_beta.csv
        - methods: loadAliasMap, loadSkuList, processVendorFile
   In out main:
    - We won't hardcode file path like this String path = ".../resources/catalog_sample/alias_map.csv";

    How do we store the input?
    List, Map, Queue, Set
        - We'll store the alias map in a Map (HashMap)
        - Sku must be unique -> Set
        -
 */
public class CatalogAggregator {
    // src/main/resources/catalog_sample/alias_map.csv src/main/resources/catalog_sample/last_week_skus.txt src/main/resources/catalog_sample/vendor_alpha.csv src/main/resources/catalog_sample/vendor_beta.csv
    public static void main(String[] args) throws IOException {
        // validation
        if(args.length < 3) {
            System.err.println("Missing sufficient input files");
            System.exit(1);
        }

        Path aliasMapPath = Path.of(args[0]);
        Path lastWeekPath = Path.of(args[1]);

        // Alias to SKU map
        Map<String, String> aliasToSku = new HashMap<>();

        // Unique set of conflict
        Set<String> conflictAliases = new HashSet<>();
        HashMap<String, String> aliasToUnkownSku = new HashMap<>();
        loadAliasMap(aliasMapPath, aliasToSku, conflictAliases);

    }

    // method: loadAliasMap; parameters: Path, aliasToSku, conflictAliases
    public static void loadAliasMap(Path path, Map<String, String> aliasToSku, Set<String> conflictAliases)
        throws IOException {
        Scanner sc = new Scanner(Files.newBufferedReader(path));
        while(sc.hasNextLine()) {
            //System.out.println(sc.nextLine());
            String line = sc.nextLine().trim();

            if(line.isEmpty()) continue;
            // skip the header
            if(line.toLowerCase().startsWith("alias,")) continue;

            //eg: galaxy s24 ultra 256 black,SAM-S24U-256-BLK
            String[] parts = line.split(",");
            if(parts.length < 2) continue;

            String aliasRaw = parts[0];
            String skuRaw = parts[1];
            // what if these are empty?

            // normalize
            String alias = aliasRaw.toLowerCase();
            String sku = skuRaw.toLowerCase();

            // add the key/value pair to aliasToSku map WHEN it doesn't exist in the map already
            String existing = aliasToSku.get(alias);
            if(existing == null) {
                aliasToSku.put(alias, sku);
            } else if(!existing.equals(sku)) {
                // if it already exists, we've a conflict -> so add it to conflictAliases
                conflictAliases.add(alias);
            }



        }
    }
}
