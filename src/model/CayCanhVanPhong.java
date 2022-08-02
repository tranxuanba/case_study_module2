package model;

public class CayCanhVanPhong extends Bonsai{
    public CayCanhVanPhong() {
    }

    public CayCanhVanPhong(String id, String name, double price, String originOfTree) {
        super(id, name, price, originOfTree);
    }

    @Override
    public String toString() {
        return String.format("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║", getId(), getName(), getPrice(), getOriginOfTree());
    }
    public void display() {
        System.out.println("╔====================================================================================================================================================╗");
        System.out.printf("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║\n║        %-31s ║ Chi tiết: %-95s ║\n",getId(), getName(), getPrice(), getOriginOfTree());
        System.out.println("╚====================================================================================================================================================╝");
    }
}
