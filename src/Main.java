import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        List<Article> articleList =new ArrayList<>();
        Document doc=Jsoup.connect("https://4pda.to").get();
        Elements h2Elements =doc.getElementsByAttributeValueContaining("class", "list-post-title");

        h2Elements.forEach (h2Element ->{
            Element a1 =h2Element.child(0);
            String url = a1.attr("href");
            String title = a1.child(0).text();
            articleList.add(new Article(url, title));
        });
        articleList.forEach(System.out::println);
    }
}
