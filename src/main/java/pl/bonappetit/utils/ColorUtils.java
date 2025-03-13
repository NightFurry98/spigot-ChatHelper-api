package pl.bonappetit.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtils {

    public static String fixColor(String text) {
        final Pattern pattern = Pattern.compile("#[a-fA-f0-9]{6}");
        for (Matcher matcher = pattern.matcher(text); matcher.find(); matcher = pattern.matcher(text)) {
            final String color = text.substring(matcher.start(), matcher.end());
            text = text.replace("&" + color, ChatColor.of(color) + "");
        }
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> fixColor(final List<String> texts) {
        final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
        final List<String> result = new ArrayList<>();
        for (String text : texts) {
            for (Matcher matcher = pattern.matcher(text); matcher.find(); matcher = pattern.matcher(text)) {
                final String color = text.substring(matcher.start(), matcher.end());
                text = text.replace("&" + color, ChatColor.of(color) + "");
            }
            result.add(ChatColor.translateAlternateColorCodes('&', text));
        }
        return result;
    }

}
