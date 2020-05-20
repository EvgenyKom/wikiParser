package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Set;

public class WikiParser {
    public static int linkClickCount = 1;

    public Document getCurrentDocument(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public boolean containArticle(String article, Document document) {
        Elements links = document.select("a[href^=/wiki/]").select("[title=" + article + "]");

        return links.size() > 0;
    }

    public Elements getLinks(Document document) {
        return document.select("a[href^=/wiki/]");
    }

    public String getTitle(Document document) {
        return document.getElementById("firstHeading").text();
    }

    public boolean isLinksContainArticle(Set<String> linksSet, String article) throws IOException {
        boolean contain = false;

        for (String link : linksSet) {
            Document document = getCurrentDocument(link);

            if (containArticle(article, document)) {
                contain = true;
            }
        }

        return contain;
    }
}