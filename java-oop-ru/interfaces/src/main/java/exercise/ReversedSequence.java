package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    private final String original;

    public ReversedSequence(String input) {
        this.original = new StringBuilder(input).reverse().toString();
    }

    @Override
    public char charAt(int index) {
        return original.charAt(index);
    }

    @Override
    public int length() {
        return original.length();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return original.subSequence(start, end);
    }

    @Override
    public String toString() {
        return original;
    }

}
// END
