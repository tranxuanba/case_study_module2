package crawlsData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//import javax.swing.text.Document;
//import javax.swing.text.Element;
import java.io.IOException;
import java.util.ArrayList;

public class CrowlsDataDeBan {
    private static final String url = "https://caycanhminhan.vn/san-pham/cay-canh-de-ban/";
    private static ArrayList<String> nameDeBan = new ArrayList<>();
    private ArrayList<String> priceDeBan = new ArrayList<>();
    private ArrayList<String> originOfTreeDeBan = new ArrayList<>();
    private ArrayList<String> idDeBan = new ArrayList<>();
    public CrowlsDataDeBan() {
    }
    public ArrayList<String> getNameDeBan() {
        return nameDeBan;
    }
    public ArrayList<String> getPriceDeBan() {
        return priceDeBan;
    }
    public ArrayList<String> getOriginOfTreeDeBan() {
        return originOfTreeDeBan;
    }
    public ArrayList<String> getIdDeBan() {
        return idDeBan;
    }
    public static void getData() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> title = doc.getElementsByClass("name product-title");
            ArrayList<Element> price = doc.getElementsByClass("woocommerce-Price-amount amount");
            String name = title.get(0).getElementsByTag("a").text();
            String price1 = price.get(0).getElementsByTag("span").text();
            System.out.println(name);
            System.out.println(price1);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getData();
    }

}
