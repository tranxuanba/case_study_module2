package view;

import serviceManager.BonsaiFacade;

import java.util.Scanner;

public class RunByUser {
    private final Scanner scanner = new Scanner(System.in);
    private final BonsaiFacade bonsaiFacade = BonsaiFacade.getInstance();
    private final RunByAdmin runByAdmin = new RunByAdmin();
    public RunByUser() {
    }
    public void menuBonsaiOfUser() {
//        try {
//            do {
//                System.out.println("╔============================================================╗");
//                System.out.println("║              ▂ ▃ ▅ ▆ █ HỆ THỐNG USER █ ▆ ▅ ▃ ▂             ║");
//                System.out.println("╠============================================================╣");
//                System.out.println("║>[1]. Hiển thị sản phẩm trong shop                          ║");
//                System.out.println("║>[2]. Thêm sản phẩm vào giỏ hàng                            ║");
//                System.out.println("║>[3]. Xóa sản phẩm khỏi giỏ hàng                            ║");
//                System.out.println("║>[4]. Hiển thị sản phẩm trong giỏ hàng                      ║");
//                System.out.println("║>[5]. Thanh toán                                            ║");
//                System.out.println("║>[0]. Đăng xuất                                             ║");
//                System.out.println("╚============================================================╝");
//                System.out.println("moi ban nhap lua chon");
//                int choice = Integer.parseInt(scanner.nextLine());
//                switch (choice) {
//                    case 1:
//                        runByAdmin.display();
//                        break;
//                    case 2:
//
//                }
//            }
//        }
    }
}
