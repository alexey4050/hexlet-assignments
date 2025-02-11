package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String nameTag, Map<String, String> attributes) {
        super(nameTag, attributes);
    }

    @Override
    public String toString() {
        StringBuilder tagString = new StringBuilder();
        tagString.append("<").append(nameTag);

        if (attributes != null && !attributes.isEmpty()) {
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
                tagString.append(" ")
                        .append(entry.getKey())
                        .append("=\"")
                        .append(entry.getValue())
                        .append("\"");
            }
        }
        tagString.append(">");
        return tagString.toString();
    }
}
// END
