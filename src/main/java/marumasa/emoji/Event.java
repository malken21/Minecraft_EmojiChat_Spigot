package marumasa.emoji;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TranslatableComponent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;

public class Event implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        TranslatableComponent component =
                new TranslatableComponent(":thinking:");



        event.setMessage(component.toLegacyText());
    }
}