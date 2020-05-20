package main;

import org.jsoup.nodes.Document;
import parser.WikiParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://ru.wikipedia.org/wiki/%D0%A1%D0%BB%D1%83%D0%B6%D0%B5%D0%B1%D0%BD%D0%B0%D1%8F:%D0%A1%D0%BB%D1%83%D1%87%D0%B0%D0%B9%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0";
        String article = "Философия";

        for (int i = 0; i< 1000; i++) {
            WikiParser wikiParser = new WikiParser();
            Document document = wikiParser.getCurrentDocument(url);
            boolean containPhilosophy = wikiParser.containArticle(article, document);

            System.out.println(wikiParser.getTitle(document));
            System.out.println(containPhilosophy);

            if (containPhilosophy) {
                break;
            }
        }
    }
}