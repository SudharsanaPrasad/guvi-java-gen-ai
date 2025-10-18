package warmup.plugins;

import java.util.*;

// No generics yet, so everything is just Object
interface PluginLegacy {
    void execute();
}

class AudioPluginLegacy implements PluginLegacy {
    public void execute() {
        System.out.println("Playing audio...");
    }
}

public class PluginManagerLegacy {

    // Returns a raw List, meaning: "List of unknown stuff"
    public static List loadPlugins(String typeName) {
        List plugins = new ArrayList();

        if ("audio".equalsIgnoreCase(typeName)) {
            plugins.add(new AudioPluginLegacy());
        } else {
            plugins.add("Not a plugin at all!"); // accidental misuse
        }
        return plugins;
    }

    public static void main(String[] args) {
        List plugins = loadPlugins("audio");

        for (Object p : plugins) {
            // Assumption: it's always a PluginLegacy
            ((PluginLegacy) p).execute(); // runtime crash if p isn’t a Plugin
        }

        // Try a bad call to show what happens
        List broken = loadPlugins("wrongType");
        for (Object p : broken) {
            ((PluginLegacy) p).execute(); // ClassCastException
        }
        System.out.println(broken);
    }
}
