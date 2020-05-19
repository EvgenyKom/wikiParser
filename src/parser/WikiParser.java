package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WikiParser {

    public boolean containArticle(String article, String url) {
        int linkCount = 0;
        Document document;
        try {
            document = Jsoup.connect(url).get();

            String headArticle = document.getElementById("firstHeading").text();

            Elements links = document.select("a[href^=/wiki/]").select("[title=" + article + "]");

            if (links.size() > 0) {
                return true;
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}