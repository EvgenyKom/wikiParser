package main;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.WikiParser;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://ru.wikipedia.org/wiki/%D0%A1%D0%BB%D1%83%D0%B6%D0%B5%D0%B1%D0%BD%D0%B0%D1%8F:%D0%A1%D0%BB%D1%83%D1%87%D0%B0%D0%B9%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0";
        String searchedArticle = "Философия";

        Map<String, Integer> titlesMap = new TreeMap<String, Integer>();

        for (int i = 0; i < 5; i++) {
            WikiParser wikiParser = new WikiParser();
            WikiParser.linkClickCount = 1;

            Document document = wikiParser.getCurrentDocument(url);
            boolean containPhilosophy = wikiParser.containArticle(searchedArticle, document);
            String article = wikiParser.getTitle(document);

            System.out.println(article);
            System.out.println(containPhilosophy);

            if (containPhilosophy) {
                titlesMap.put(article, WikiParser.linkClickCount);
                continue;
            }

            WikiParser.linkClickCount++;

            Elements links = wikiParser.getLinks(document);
            Set<String> linksSet = new HashSet<String>();
            for (Element link : links) {
                linksSet.add(link.text());
            }

        }
    }
}