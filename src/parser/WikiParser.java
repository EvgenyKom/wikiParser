package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WikiParser {

    public Document getCurrentDocument(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public boolean containArticle(String article, Document document) {
        Elements links = document.select("a[href^=/wiki/]").select("[title=" + article + "]");

        return links.size() > 0;
    }

    public Elements getLinks(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        return document.select("a[href^=/wiki/]");
    }

    public String getTitle(Document document) {
        return document.getElementById("firstHeading").text();
    }
}