package crawlsData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlsDataThuySinh {
    private final String url = "https://caycanhminhan.vn/san-pham/cay-canh-thuy-sinh/";
    private ArrayList<String> nameThuySinh = new ArrayList<>();
    private ArrayList<String> priceThuySinh = new ArrayList<>();
    public CrawlsDataThuySinh() {
    }
    public ArrayList<String> getNameThuySinh() {
        return nameThuySinh;
    }
    public ArrayList<String> getPriceThuySinh() {
        return priceThuySinh;
    }
    public void getData() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elements = doc.getElementsByClass("name product-title");
            ArrayList<Element> elements1 = doc.getElementsByClass("price2");
//            int id = 0;
            for (int i = 1; i <=5 ; i++) {
                nameThuySinh.add(elements.get(i).getElementsByTag("a").text());
                priceThuySinh.add(elements1.get(i).getElementsByTag("span").text());
//                id++;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
