package crawlsData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//import javax.swing.text.Document;
//import javax.swing.text.Element;
import java.io.IOException;
import java.util.ArrayList;

public class CrawlsDataDeBan {
    private final String url = "https://caycanhminhan.vn/san-pham/cay-canh-de-ban/";
    private ArrayList<String> nameDeBan = new ArrayList<>();
    private ArrayList<String> priceDeBan = new ArrayList<>();
    private ArrayList<Integer> idDeBan = new ArrayList<>();
    public CrawlsDataDeBan() {
    }
    public ArrayList<String> getNameDeBan() {
        return nameDeBan;
    }
    public ArrayList<String> getPriceDeBan() {
        return priceDeBan;
    }
    public ArrayList<Integer> getIdDeBan() {
        return idDeBan;
    }
    public void getData() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elements = doc.getElementsByClass("name product-title");
            ArrayList<Element> elements1 = doc.getElementsByClass("woocommerce-Price-amount amount");
            int id = 0;
            for (int i = 1; i <=5 ; i++) {
               String name = elements.get(i).getElementsByTag("a").text();
               String price = elements1.get(i).getElementsByTag("span").text();
               id++;
               idDeBan.add(id);
               nameDeBan.add(name);
               priceDeBan.add(price);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
