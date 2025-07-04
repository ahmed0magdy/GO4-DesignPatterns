package Creational.Builder.WordProcessor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Creational.Builder.WordProcessor.html.HtmlDocument;
import Creational.Builder.WordProcessor.html.HtmlImage;
import Creational.Builder.WordProcessor.html.HtmlParagraph;

public class Document {
    private List<Element> elements = new ArrayList<>();

    public void add(Element element) {
        elements.add(element);
    }

    public void export(ExportFormat format, String fileName) throws IOException {
        String content = "";

        if (format == ExportFormat.HTML) {
            var document = new HtmlDocument();

            for (Element element : elements) {
                if (element instanceof Text) {
                    var text = ((Text) element).getContent();
                    document.add(new HtmlParagraph(text));
                } else if (element instanceof Image) {
                    var source = ((Image) element).getSource();
                    document.add(new HtmlImage(source));
                }
            }

            content = document.toString();
        } else if (format == ExportFormat.TEXT) {
            var builder = new StringBuilder();

            for (Element element : elements) {
                if (element instanceof Text) {
                    var text = ((Text) element).getContent();
                    builder.append(text);
                }
            }

            content = builder.toString();
        }

        var writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }
}
