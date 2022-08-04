package crawlsData;

import model.CayCanhDeBan;
import model.CayCanhPhongThuy;
import model.CayCanhThuySinh;

import java.util.ArrayList;

public class NewDataBonsai {
    private CrawlsDataDeBan crawlsDataDeBan = new CrawlsDataDeBan();
    private CrawlsDataThuySinh crawlsDataThuySinh = new CrawlsDataThuySinh();
    private CrawlsDataPhongThuy crawlsDataPhongThuy = new CrawlsDataPhongThuy();

    public NewDataBonsai() {
        crawlsDataDeBan.getData();
        crawlsDataPhongThuy.getData();
        crawlsDataThuySinh.getData();
    }

    public ArrayList<CayCanhDeBan> newLishDeBan(){
        ArrayList<CayCanhDeBan> deBanArrayList = new ArrayList<>();
        ArrayList<String> nameLish = crawlsDataDeBan.getNameDeBan();
        ArrayList<String> priceLish = crawlsDataDeBan.getPriceDeBan();
        ArrayList<Integer> idLish = crawlsDataDeBan.getIdDeBan();
        for (int i = 0; i < nameLish.size(); i++) {
            double price = Double.parseDouble(priceLish.get(i).replaceAll("₫","").trim());
            String name = nameLish.get(i);
            int id = idLish.get(i);
            CayCanhDeBan cayCanhDeBan = new CayCanhDeBan(id, name, price);
            deBanArrayList.add(cayCanhDeBan);
        }
        return deBanArrayList;
    }
    public ArrayList<CayCanhPhongThuy> newLishPhongThuy(){
        ArrayList<CayCanhPhongThuy> phongThuyArrayList = new ArrayList<>();
        ArrayList<String> nameLish = crawlsDataPhongThuy.getNamePhongThuy();
        ArrayList<String> priceLish = crawlsDataPhongThuy.getPricePhongThuy();
        int id = 10;
        for (int i = 0; i < nameLish.size(); i++) {
            double price = Double.parseDouble(priceLish.get(i).replaceAll("₫","").trim());
            id= id + 1;
            String name = nameLish.get(i);
            CayCanhPhongThuy cayCanhPhongThuy = new CayCanhPhongThuy(id, name, price);
            phongThuyArrayList.add(cayCanhPhongThuy);
        }
        return phongThuyArrayList;
    }
    public ArrayList<CayCanhThuySinh> newLishThuySinh(){
        ArrayList<CayCanhThuySinh> thuySinhArrayList = new ArrayList<>();
        ArrayList<String> nameLish = crawlsDataThuySinh.getNameThuySinh();
        ArrayList<String> priceLish = crawlsDataThuySinh.getPriceThuySinh();
        int id = 20;
        for (int i = 0; i < nameLish.size(); i++) {
            double price = Double.parseDouble(priceLish.get(i).replaceAll("đ","").trim());
            id = id + 1;
            String name = nameLish.get(i);
            CayCanhThuySinh cayCanhThuySinh = new CayCanhThuySinh(id, name, price);
            thuySinhArrayList.add(cayCanhThuySinh);
        }
        return thuySinhArrayList;
    }
}
