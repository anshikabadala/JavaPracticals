
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateFiller {

    public static String fillTemplate(String text, String[] keys, String[] values) {

        Pattern p = Pattern.compile("\\{([^{}]+)\\}");
        Matcher m = p.matcher(text);

        StringBuffer output = new StringBuffer();

        while (m.find()) {

            String key = m.group(1);
            String value = "[?]";

            int index = 0;

            while (index < keys.length) {
                if (keys[index].equals(key)) {
                    value = values[index];
                    break;
                }
                index++;
            }

            m.appendReplacement(
                output,
                Matcher.quoteReplacement(value)
            );
        }

        m.appendTail(output);

        return output.toString();
    }
}