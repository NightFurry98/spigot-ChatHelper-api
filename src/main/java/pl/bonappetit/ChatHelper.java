package pl.bonappetit;

import org.bukkit.entity.Player;
import pl.bonappetit.utils.ColorUtils;
import pl.bonappetit.utils.GradiantUtils;
import pl.bonappetit.utils.SmallTextUtils;

import java.util.List;

public class ChatHelper {

    /**
     * Colors a String with a gradiant.
     *
     * @param text The text that will have a gradient effect applied to it.
     * @param hexColors A varargs parameter containing hex color codes to be used for the gradient.
     *                  These colors should be provided in the order they should appear in the gradient.
     *                  Each color should be in the format "#RRGGBB" or "RRGGBB" (without the '#' symbol).
     * @return A string with the gradient applied to the text.
     */
    public static String createGradiant(String text, String... hexColors) {
        return GradiantUtils.createGradiant(text, hexColors);
    }

    /**
     * Converts the provided text to a version where all alphabetic characters are replaced with
     * their small text equivalents.
     *
     * @param input The input text that will be converted to small text. The alphabetic characters
     *              (both uppercase and lowercase) will be converted to small letter equivalents.
     *              Other characters such as digits, punctuation, and color codes are left unchanged.
     * @return The input text with alphabetic characters replaced by their small text versions.
     */
    public static String toSmallText(String input) {
        return SmallTextUtils.toSmallText(input);
    }

    /**
     * Colors a String
     *
     * @param text The input text containing hex color codes (e.g. "&#FF5733") or Minecraft color codes
     *             (e.g. "&a" for green). The text is converted to Minecraft's color format.
     * @return The input text with colors converted to Minecraft-compatible format.
     */
    public static String fixColor(String text) {
        return ColorUtils.fixColor(text);
    }

    /**
     * Colors a list of strings
     *
     * @param texts A list of text strings containing hex color codes (e.g. "&#FF5733") or Minecraft color codes
     *              (e.g. "&a" for green). The colors in each string are converted to Minecraft's color format.
     * @return A list of text strings with colors converted to Minecraft-compatible format.
     */
    public static List<String> fixColor(List<String> texts) {
        return ColorUtils.fixColor(texts);
    }

    /**
     * Sends a colored message to a single player. The message supports Minecraft color codes.
     *
     * @param player The player to whom the message will be sent.
     * @param text The text message to be sent, which can contain Minecraft color codes.
     * @return Always returns true, indicating the message was successfully sent.
     */
    public static boolean sendMessage(final Player player, final String text) {
        player.sendMessage(ColorUtils.fixColor(text));
        return true;
    }

    public static boolean sendTitle(final Player player, final String title, final String subTitle, int fadeIn, int stay, int fadeOut) {
        player.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
        return true;
    }
}
