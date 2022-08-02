package crawlsData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlsDataPhongThuy {
    private final String url = "https://caycanhminhan.vn/cay-canh-phong-thuy/";
    private ArrayList<String> namePhongThuy = new ArrayList<>();
    private ArrayList<String> pricePhongThuy = new ArrayList<>();
    public CrawlsDataPhongThuy() {
    }
    public ArrayList<String> getNamePhongThuy() {
        return namePhongThuy;
    }
    public ArrayList<String> getPricePhongThuy() {
        return pricePhongThuy;
    }
    public void getData() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elements = doc.getElementsByClass("name product-title");
            ArrayList<Element> elements1 = doc.getElementsByClass("woocommerce-Price-amount amount");
//            int id = 0;
            for (int i = 1; i <=5 ; i++) {
                namePhongThuy.add(elements.get(i).getElementsByTag("a").text());
                pricePhongThuy.add(elements1.get(i).getElementsByTag("span").text());
//                id++;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
