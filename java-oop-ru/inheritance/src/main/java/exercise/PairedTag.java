package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String nameTag, Map<String, String> attributes, String body, List<Tag> children) {
        super(nameTag, attributes);
        this.body = body;
        this.children = children;
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

        if (!body.isEmpty()) {
            tagString.append(body);
        }

        if (children != null && !children.isEmpty()) {
            for (Tag child : children) {
                tagString.append(child.toString());
            }
        }
        tagString.append("</").append(nameTag).append(">");
        return tagString.toString();
    }
}
// END
