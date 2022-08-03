package serviceManager;

import model.CayCanhDeBan;
import model.CayCanhPhongThuy;
import model.CayCanhThuySinh;

import java.util.PrimitiveIterator;
import java.util.Scanner;

public class BonsaiFacade {
    private BonsaisManager bonsaisManager;
    private DeBanManager deBanManager;
    private PhongThuyManager phongThuyManager;
    private ThuySinhManager thuySinhManager;
    private static BonsaiFacade instance;
    private final Scanner scanner = new Scanner(System.in);

    public synchronized static BonsaiFacade getInstance(){
        if (instance == null){
            instance = new BonsaiFacade();
        }
        return instance;
    }
    public void add(int id, String name, double price, int choiceAdd) {
        switch (choiceAdd) {
            case 1:
                CayCanhDeBan cayCanhDeBan = new CayCanhDeBan(id, name, price);
                deBanManager.add(cayCanhDeBan);
                bonsaisManager.add(cayCanhDeBan);
                break;
            case 2:
                CayCanhPhongThuy cayCanhPhongThuy = new CayCanhPhongThuy();
                phongThuyManager.add(cayCanhPhongThuy);
                bonsaisManager.add(cayCanhPhongThuy);
                break;
            case 3:
                CayCanhThuySinh cayCanhThuySinh = new CayCanhThuySinh();
                thuySinhManager.add(cayCanhThuySinh);
                bonsaisManager.add(cayCanhThuySinh);
                break;
        }
    }
    public void displayChoice(int choice) {
        switch (choice) {
            case 1:
                bonsaisManager.display();
                break;
            case 2:
                deBanManager.display();
                break;
            case 3:
                phongThuyManager.display();
                break;
            case 4:
                thuySinhManager.display();
                break;
            case 0:
                System.out.println("quay lai");
                break;
            default:
                System.out.println("sai lua chon");
                break;
        }
    }
    public void delete(int id) {
        bonsaisManager.delete(id);
        deBanManager.delete(id);
        phongThuyManager.delete(id);
        thuySinhManager.delete(id);
    }
    public void deleteAll(){
        bonsaisManager.deleteAll();
        deBanManager.deleteAll();
        phongThuyManager.deleteAll();
        thuySinhManager.deleteAll();
    }

}
