package pl.bonappetit.utils;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GradiantUtils {

    public static String createGradiant(String text, String... hexColors) {
        for (int i = 0; i < hexColors.length; i++) {
            hexColors[i] = hexColors[i].replace("#", "");
        }
        List<Color> colors = new ArrayList<>();
        for (String hex : hexColors) {
            colors.add(Color.decode("#" + hex));
        }
        List<Character> nonSpaceChars = new ArrayList<>();
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                nonSpaceChars.add(c);
            }
        }

        int totalChars = nonSpaceChars.size();
        if (totalChars == 0) {
            return text; 
        }
        int totalSegments = colors.size() - 1;
        StringBuilder gradientText = new StringBuilder();
        int charIndex = 0; 
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                gradientText.append(c); 
                continue;
            }
            float ratio = (float) charIndex / (totalChars - 1);
            int segment = (int) (ratio * totalSegments);
            float segmentRatio = (ratio * totalSegments) - segment;
            Color startColor = colors.get(segment);
            Color endColor = colors.get(Math.min(segment + 1, totalSegments));
            int r = startColor.getRed() + Math.round((endColor.getRed() - startColor.getRed()) * segmentRatio);
            int g = startColor.getGreen() + Math.round((endColor.getGreen() - startColor.getGreen()) * segmentRatio);
            int b = startColor.getBlue() + Math.round((endColor.getBlue() - startColor.getBlue()) * segmentRatio);
            String fixColor = String.format("&#%02X%02X%02X", r, g, b);
            gradientText.append(fixColor).append(c);
            charIndex++; 
        }

        return ColorUtils.fixColor(gradientText.toString());
    }
}