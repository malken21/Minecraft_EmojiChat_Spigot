package marumasa.emoji;

import org.bukkit.plugin.java.JavaPlugin;

public final class minecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Event(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
