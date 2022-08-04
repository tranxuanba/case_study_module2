package view;

import serviceManager.BonsaiFacade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByAdmin {
    public static void main(String[] args) {
        RunByAdmin runByAdmin =new RunByAdmin();
        runByAdmin.menuBonsaiOfAdmin();
    }
    private final Scanner scanner = new Scanner(System.in);
    private final BonsaiFacade bonsaiFacade = BonsaiFacade.getInstance();
    public RunByAdmin() {
    }
    public void menuBonsaiOfAdmin() {
        try {
            do{
                System.out.println("╔============================================================╗");
                System.out.println("║              ▂ ▃ ▅ ▆ █ HỆ THỐNG ADMIN █ ▆ ▅ ▃ ▂            ║");
                System.out.println("╠============================================================╣");
                System.out.println("║>[1]. Thêm sản phẩm                                         ║");
                System.out.println("║>[2]. Sửa thông tin                                         ║");
                System.out.println("║>[3]. Xóa sản phẩm                                          ║");
                System.out.println("║>[4]. Hiển thị sản phẩm                                     ║");
                System.out.println("║>[5]. Khôi phục dữ liệu                                     ║");
                System.out.println("║>[6]. Tim kiem cay canh theo id                             ║");
                System.out.println("║>[0]. Đăng xuất                                             ║");
                System.out.println("╚============================================================╝");
                System.out.println("moi ban nhap lua chon >>");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        menuAddBonsai();
                        break;
                    case 2:
                        try {
                            System.out.println("nhap ma id cua cay muon sua");
                            int id = Integer.parseInt(scanner.nextLine());
                            if (bonsaiFacade.checkID(id)){
                               editBonsai(id);
                                System.out.println("thong tin cay canh da duoc cap nhat");
                            }else {
                                System.out.println("khong tim thay id cay canh trong danh sach");
                                System.out.println("---------------------------------------");
                            }
                        }catch (InputMismatchException e){
                            System.out.println("sai kieu du lieu");
                            System.out.println("------------------------------");
                        }
                        break;
                    case 3:
                        deleteBonsai();
                        break;
                    case 4:
                        display();
                        break;
                    case 5:
                        System.out.println("vui long doi trong giay lat");
                        bonsaiFacade.backUpData();
                        break;
                    case 6:
                        System.out.println("moi nhap id cay canh can tim kiem");
                        int id = Integer.parseInt(scanner.nextLine());
                        bonsaiFacade.findBonsaitById(id);
                        break;


                    case 0:
                        System.out.println("Da thoat khoi he thong Admin");
                        System.out.println("---------------------------------");
//                        new Login().loginSystem();
                        break;
                    default:
                        System.out.println("khong co lua chon phu hop");
                        break;

                }
            }while (true);
        }catch (Exception e){
            System.out.println("nhap sai du lieu, moi ban nhap lai");
            System.out.println("-----------------------------------");
            menuBonsaiOfAdmin();
        }
    }
    public void menuAddBonsai(){
        try {
            do{
                System.out.println("╔===========================================╗");
                System.out.println("║     ▂ ▃ ▅ ▆ █ THÊM CÂY CẢNH  █ ▆ ▅ ▃ ▂    ║");
                System.out.println("╠===========================================╣");
                System.out.println("║>[1]. Cây Cảnh Để Bàn                      ║");
                System.out.println("║>[2]. Cây Cảnh Phong Thuỷ                  ║");
                System.out.println("║>[3]. Cây Cảnh Thuỷ Sinh                   ║");
                System.out.println("║>[0]. Thoát                                ║");
                System.out.println("╚===========================================╝");
                System.out.println("Moi ban nhap vao lua chon: ");
                int choiceAdd = Integer.parseInt(scanner.nextLine());
                if (choiceAdd == 0) {
                    break;
                } else if (choiceAdd < 0 || choiceAdd > 3) {
                    System.out.println("sai lua chon, moi chon lai");
                    menuAddBonsai();
                }
                System.out.println("nhap id cay canh:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("nhap ten cay canh");
                String name = scanner.nextLine();
                System.out.println("nhap gia san pham");
                double price = Double.parseDouble(scanner.nextLine());
                if (!bonsaiFacade.checkID(id)){
                    bonsaiFacade.add(id, name, price, choiceAdd);
                    System.out.println("them cay canh thanh cong");
                }else {
                    System.out.println("san pham bi trung ma id");
                    System.out.println("--------------------------");
                }
                break;
            }while (true);
        }catch (InputMismatchException e) {
            System.out.println("nhap sai du lieu, vui long nhap lai");
            System.out.println("---------------------------------------");
            menuAddBonsai();
        }
    }
    public void editBonsai(int id) {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║     ▂ ▃ ▅ ▆ █  SỬA BONSAI   █ ▆ ▅ ▃ ▂     ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Sửa tên                              ║");
            System.out.println("║>[2]. Sửa giá                              ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            display();
            System.out.println("moi ban nhap vao lua chon: ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            bonsaiFacade.edit(id, choiceAdd);
        }catch (InputMismatchException e) {
            System.out.println("nhap sai du lieu, vui long nhap lai");
            System.out.println("------------------------------------");
            editBonsai(id);
        }
    }
    public void deleteBonsai() {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║     ▂ ▃ ▅ ▆ █ XOÁ CÂY CẢNH  █ ▆ ▅ ▃ ▂     ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Xóa cây cảnh theo ID                 ║");
            System.out.println("║>[2]. Xóa tất cả cây cảnh                  ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            System.out.println("moi ban nhap vao lua chon");
            int choiceAdd = Integer.parseInt(scanner.nextLine());

            switch (choiceAdd) {
                case 1:
                    System.out.println("moi nhap ma id");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (bonsaiFacade.checkID(id)) {
                        bonsaiFacade.delete(id);
                        System.out.println("Xoa thanh cong");
                        System.out.println("--------------------------------------");
                    } else {
                        System.out.println("khong co ma id tren");
                        System.out.println("---------------------------------------");
                    }
                    break;

                case 2:
                    System.out.println("ban chac chan muon xoa het du lieu");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("Y")){
                        bonsaiFacade.deleteAll();
                        System.out.println("da xoa het du lieu");
                        System.out.println("-----------------------");
                    }else {
                        break;
                    }
                case 0:
                    System.out.println("thoat");
                    break;
                default:
                    System.out.println("sai lua chon");
                    break;
            }
        }catch (InputMismatchException e) {
            System.out.println("nhap sai du lieu, moi nhap lai");
            System.out.println("-------------------------------");
            deleteBonsai();
        }
    }
    public void display() {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║  ▂ ▃ ▅ ▆ █ HIỂN THỊ SẢN PHẨM  █ ▆ ▅ ▃ ▂   ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Tất cả cây cảnh                      ║");
            System.out.println("║>[2]. Cây cảnh để bàn                      ║");
            System.out.println("║>[3]. Cây cảnh phong thuy                  ║");
            System.out.println("║>[4]. Cây cảnh thuỷ sinh                   ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            System.out.println("moi nhap vao lua chon");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            bonsaiFacade.displayChoice(choiceAdd);
        }catch (InputMismatchException e) {
            System.out.println("nhap sai du lieu, moi nhap lai");
            System.out.println("-------------------------------");
            display();
        }
    }


}
