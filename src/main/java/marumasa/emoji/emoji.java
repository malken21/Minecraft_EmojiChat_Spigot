package marumasa.emoji;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.TranslatableComponent;

import java.util.ArrayList;
import java.util.List;

public class emoji {
    public static List<BaseComponent> Translatable(List<BaseComponent> message, final List<String> emojiList) {

        for (String emoji : emojiList) {

            final List<BaseComponent> baseComponents = new ArrayList<>();

            for (BaseComponent baseComponent : message) {

                if (baseComponent instanceof TextComponent textComponent) {

                    final String text = textComponent.getText();
                    List<String> items = new ArrayList<>(List.of(
                            text.split("(?<=" + emoji + ")|(?=" + emoji + ")")
                    ));

                    for (String item : items) {
                        if (item.equals(emoji)) {
                            baseComponents.add(new TranslatableComponent(emoji));
                        } else {
                            baseComponents.add(new TextComponent(item));
                        }
                    }
                } else {
                    baseComponents.add(baseComponent);
                }
            }
            message = baseComponents;
        }

        return message;
    }
}
