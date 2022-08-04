package view;

import model.Bonsai;
import serviceManager.BonsaiFacade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByUser {
    private final Scanner scanner = new Scanner(System.in);
    private final BonsaiFacade bonsaiFacade = BonsaiFacade.getInstance();
    private final RunByAdmin runByAdmin = new RunByAdmin();
    private ArrayList<Bonsai> listCart = new ArrayList<>();

    public RunByUser() {
    }
//    public void menuBonsaiOfUser() {
//        try {
//            do {
//                System.out.println("╔============================================================╗");
//                System.out.println("║              ▂ ▃ ▅ ▆ █ HỆ THỐNG USER █ ▆ ▅ ▃ ▂             ║");
//                System.out.println("╠============================================================╣");
//                System.out.println("║>[1]. Hiển thị sản phẩm trong shop                          ║");
//                System.out.println("║>[2]. Tìm kiếm sản phẩm trong shop theo ten                 ║");
//                System.out.println("║>[3]. Thêm sản phẩm vào giỏ hàng                            ║");
//                System.out.println("║>[4]. Xóa sản phẩm khỏi giỏ hàng                            ║");
//                System.out.println("║>[5]. Hiển thị sản phẩm trong giỏ hàng                      ║");
//                System.out.println("║>[6]. Thanh toán                                            ║");
//                System.out.println("║>[0]. Đăng xuất                                             ║");
//                System.out.println("╚============================================================╝");
//                System.out.println("moi ban nhap lua chon");
//                int choice = Integer.parseInt(scanner.nextLine());
//                switch (choice) {
//                    case 1:
//                        runByAdmin.display();
//                        break;
//                    case 2:
//                        bonsaiFacade.searching();
//                    case 3:
//                        runByAdmin.display();
//                        addBonsaiToCart();
//                        break;
//                    case 4:
//                        displayCart();
//                        removeBonsaiFromCart();
//                        break;
//                    case 5:
//                        displayCart();
//                        break;
//                    case 6:
//
//                }
//            }
//        }
//    }
    public void addBonsaiToCart() {
        try {
            System.out.print("Nhap ma cay vao gio");
            int id = Integer.parseInt(scanner.nextLine());
            Bonsai bonsai = bonsaiFacade.findBonsaitById(id);
            if (bonsai == null) {
                System.out.println("khong dung ma cay canh");
            } else {
                listCart.add(bonsai);
                System.out.println("da them cay canh vao gio hang");
            }
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------");
            addBonsaiToCart();
        }
    }
    public void displayCart() {
        if (listCart.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào trong giỏ hàng");
        } else {
            for (Bonsai x:
                 listCart) {
                System.out.println(x);
            }
        }
    }
    public void removeBonsaiFromCart() {
        try {
            if (listCart.isEmpty()) {
                System.out.println("Giỏ hàng trống rỗng");
            } else {
                System.out.print("nhap ma id cua cay muon xoa khoi gio hang");
                int idCheck = Integer.parseInt(scanner.nextLine());
                boolean check = listCart.removeIf(p -> p.getId() == idCheck);
                if (!check) {
                    System.out.println("Không có sản phẩm có mã ID trên trong giỏ hàng");
                } else {
                    System.out.println("Đã xóa sản phẩm thành công khỏi giỏ hàng");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("-----------------------------------------------------");
            addBonsaiToCart();
        }
    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Bonsai x : listCart) {
            totalPrice += x.getPrice();
        }
        return totalPrice;
    }
//    public void payment() {
//        if(!listCart.isEmpty()) {
//            System.out.println("tong gia tien co ");
//            System.out.print("[\uD83C\uDF81] Xác nhân thanh toán (Y/N): ");
//            String result = scanner.nextLine();
//            if (result.equalsIgnoreCase("Y")) {
//                ArrayList<Bill> bills = userHistory.getHistoryList().get(Login.nameAccountUser);
//                bills.add(new Bill(Login.nameAccountUser,cartUser, getTotalPrice(), LocalDateTime.now()));
//                userHistory.add(Login.nameAccountUser,bills);
//                for (Product p : cartUser) {
//                    productFacade.delete(p.getId());
//                }
//                cartUser.clear();
//                System.out.println("[\uD83D\uDC4C] Thanh toán hoàn tất! Xin trân trọng cảm ơn quý khách đã mua sản phẩm!!\uD83C\uDF81 \uD83D\uDC97 \uD83D\uDC97");
//            } else {
//                System.out.println("[❌] Bạn cần thanh toán hóa đơn để có sản phẩm");
//            }
//        }
//        else {
//            System.out.println("[❌] Chưa có sản phẩm nào trong giỏ hàng ");
//        }
//    }
}
