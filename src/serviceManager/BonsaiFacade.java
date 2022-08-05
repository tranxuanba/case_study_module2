package serviceManager;

import model.Bonsai;
import model.CayCanhDeBan;
import model.CayCanhPhongThuy;
import model.CayCanhThuySinh;

import java.util.ArrayList;
import java.util.Scanner;

public class BonsaiFacade {
//    public static void main(String[] args) {
//            BonsaiFacade bonsaiFacade = new BonsaiFacade();
//            bonsaiFacade.displayChoice(2);
//    }
    private BonsaisManager bonsaisManager;
    private DeBanManager deBanManager;
    private PhongThuyManager phongThuyManager;
    private ThuySinhManager thuySinhManager;
    private static BonsaiFacade instance;
    private final Scanner scanner = new Scanner(System.in);
    private BonsaiFacade() {
        bonsaisManager = new BonsaisManager();
        deBanManager = new DeBanManager();
        phongThuyManager = new PhongThuyManager();
        thuySinhManager = new ThuySinhManager();
    }

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
    public void edit(int id, int choiceAdd) {
        switch (choiceAdd){
            case 1:
                System.out.println("nhap ten moi");
                String name = scanner.nextLine();
                bonsaisManager.editName(id, name);
                deBanManager.editName(id, name);
                phongThuyManager.editName(id, name);
                thuySinhManager.editName(id, name);
                break;
            case 2:
                System.out.println("nhap gia moi");
                double price = scanner.nextDouble();
                bonsaisManager.editPrice(id, price);
                deBanManager.editPrice(id, price);
                phongThuyManager.editPrice(id, price);
                thuySinhManager.editPrice(id, price);
                break;

        }
    }
    public boolean checkID(int id) {
        for (Bonsai p : bonsaisManager.getBonsaiArrayList()) {
            if (p.getId() == id) {
                return true;
            }
        }
        for (CayCanhDeBan p:
                deBanManager.getDeBanArrayList()) {
            if (p.getId() == id)
                return true;
        }
        for (CayCanhPhongThuy p:
                phongThuyManager.getPhongThuyArrayList()) {
            if (p.getId() == id)
                return true;
        }
        for (CayCanhThuySinh p:
                thuySinhManager.getThuySinhArrayList()) {
            if (p.getId() == id)
                return true;
        }
        return false;
    }

    public void backUpData() {
        bonsaisManager.setLishBonsai();
        System.err.println("Khoi phuc du lieu thanh cong");
        System.out.println("-----------------------------------------------------------------");
    }

    public Bonsai findBonsaitById(int id){
        Bonsai bonsai = null;
        for (Bonsai p: bonsaisManager.getBonsaiArrayList()) {
            if(p.getId() == id) {
                bonsai = p;
                break;
            }
        }
        if (bonsai != null){
            System.out.println(bonsai);
        }else {
            System.out.println("khong tim thay cay canh can tim");
        }

        return bonsai;
    }
    public void searching() {
        System.out.println("nhap tu ten cay can tim kiem");
        String newName = scanner.nextLine();
        ArrayList<Bonsai> list = bonsaisManager.findProductByKey(newName);
        if (list.isEmpty()) {
            System.out.println("khong co cay ban can tim");
        }else {
            for (Bonsai x:
                 list) {
                System.out.println(x);
            }
        }
    }

    public static void main(String[] args) {
        BonsaiFacade bonsaiFacade = new BonsaiFacade();
        bonsaiFacade.searching();
    }

}
