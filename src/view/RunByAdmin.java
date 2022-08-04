package view;

import serviceManager.BonsaiFacade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByAdmin {
//    public static void main(String[] args) {
//        RunByAdmin runByAdmin =new RunByAdmin();
//        runByAdmin.display();
//    }
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
                System.out.println("║>[5]. Thông tin khách hàng                                  ║");
                System.out.println("║>[6]. Doanh thu sản phẩm                                    ║");
                System.out.println("║>[7]. Khôi phục dữ liệu                                     ║");
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
                        System.out.println("vui long doi trong giay lat");
                        bonsaiFacade.backUpData();
                        break;
                    case 0:
                        System.out.println("Da thoat khoi he thong Admin");
                        System.out.println("---------------------------------");
                        new Login().loginSystem();
                        break;
                    default:
                        System.out.println("khong co lua chon phu hop");
                        break;

                }
            }while (true)
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
            System.out.println("moi ban nhap vao lua chon: ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            bonsaiFacade.edit(id, choiceAdd);
        }catch (InputMismatchException e) {
            System.out.println("nhap sai du lieu, vui long nhap lai");
        }
    }

}
