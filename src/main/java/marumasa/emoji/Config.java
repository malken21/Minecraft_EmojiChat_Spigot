package marumasa.emoji;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Config {
    public final List<String> emojiList = new ArrayList<>();

    public Config(minecraft plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        final List<?> items = config.getList("emojis");

        if(items == null)return;
        for (Object item : items) {
            emojiList.add((String) item);
        }
    }
}