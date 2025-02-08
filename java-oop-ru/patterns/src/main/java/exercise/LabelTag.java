package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private final String text;
    private final TagInterface childTag;

    public LabelTag(String text, TagInterface childTag) {
        this.text = text;
        this.childTag = childTag;
    }

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", text, childTag.render());
    }
}
// END
