package marumasa.emoji;

import org.bukkit.plugin.java.JavaPlugin;

public final class minecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config(this);

        if (getServer().getPluginManager().isPluginEnabled("LunaChat")) {
            getServer().getPluginManager().registerEvents(new LunaChatEvent(config), this);
        } else {
            getServer().getPluginManager().registerEvents(new Event(config), this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
