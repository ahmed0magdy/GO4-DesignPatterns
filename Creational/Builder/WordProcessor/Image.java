package Creational.Builder.WordProcessor;

public class Image implements Element {
    private String source;

    public Image(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
