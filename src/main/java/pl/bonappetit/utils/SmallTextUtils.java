package pl.bonappetit.utils;

public class SmallTextUtils {

    private static final char[] SMALL_LETTERS = {
            'ᴀ', 'ʙ', 'ᴄ', 'ᴅ', 'ᴇ', 'ғ', 'ɢ', 'ʜ', 'ɪ', 'ᴊ', 'ᴋ', 'ʟ', 'ᴍ', 'ɴ', 'ᴏ',
            'ᴘ', 'ǫ', 'ʀ', 's', 'ᴛ', 'ᴜ', 'ᴠ', 'ᴡ', 'x', 'ʏ', 'ᴢ'
    };

    public static String toSmallText(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        StringBuilder formatted = new StringBuilder();
        boolean inColorCode = false;
        for (char c : input.toCharArray()) {
            if (c == '&' || c == '§') {
                inColorCode = true;
                formatted.append(c);
            } else if (inColorCode) {
                formatted.append(c);
                inColorCode = false;
            } else if (c >= 'A' && c <= 'Z') {
                formatted.append(SMALL_LETTERS[c - 'A']);
            } else if (c >= 'a' && c <= 'z') {
                formatted.append(SMALL_LETTERS[c - 'a']);
            } else {
                formatted.append(c);
            }
        }

        return formatted.toString();
    }
}
