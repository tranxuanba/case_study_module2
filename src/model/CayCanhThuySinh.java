package model;

public class CayCanhThuySinh extends Bonsai{
    public CayCanhThuySinh() {
    }

    public CayCanhThuySinh(String id, String name, double price) {
        super(id, name, price);
    }
    @Override
    public String toString() {
        return String.format("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║", getId(), getName(), getPrice());
    }
    public void display() {
        System.out.println("╔====================================================================================================================================================╗");
        System.out.printf("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║\n║        %-31s ║ Chi tiết: %-95s ║\n",getId(), getName(), getPrice());
        System.out.println("╚====================================================================================================================================================╝");
    }
}
