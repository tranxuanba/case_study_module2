package crawlsData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//import javax.swing.text.Document;
//import javax.swing.text.Element;
import java.io.IOException;
import java.util.ArrayList;

public class CrowlsDataDeBan {
    private final String url = "https://caycanhminhan.vn/san-pham/cay-canh-de-ban/";
    private ArrayList<String> nameDeBan = new ArrayList<>();
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
    public void getData() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elements = doc.getElementsByClass("menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-2021");
            for (int i = 1; i <=5; i++) {
                nameDeBan.add(elements.get(i).getElementsByTag("a").attr())
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
