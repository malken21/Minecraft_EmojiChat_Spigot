package marumasa.emoji;

import com.github.ucchyocean.lc.event.LunaChatBaseCancellableEvent;
import com.github.ucchyocean.lc3.bukkit.event.LunaChatBukkitBaseCancellableEvent;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Event implements Listener {

    private final Config con;
    private final Logger logger = Bukkit.getLogger();
    private final Server.Spigot spigot = Bukkit.spigot();

    public Event(Config config) {
        con = config;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        List<BaseComponent> message = new ArrayList<>(List.of(new TextComponent(event.getMessage())));

        final List<BaseComponent> messageCopy = message;
        message = emoji.Translatable(message, con.emojiList);

        if (message.equals(messageCopy)) {
            return;
        }

        final BaseComponent result = new TextComponent("<" + event.getPlayer().getDisplayName() + "> ");
        for (BaseComponent component : message) {
            result.addExtra(component);
        }

        event.setCancelled(true);

        spigot.broadcast(result);
        logger.info(result.toLegacyText().replaceAll("§.",""));
    }
}