package model;

import java.io.Serializable;

public class CayCanhPhongThuy extends Bonsai implements Serializable {
    public CayCanhPhongThuy() {
    }

    public CayCanhPhongThuy(int id, String name, double price) {
        super(id, name, price);
    }
    @Override
    public String toString() {
        return "CayCanhPhongThuy" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
    public void display() {
        System.out.println("╔====================================================================================================================================================╗");
        System.out.printf("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║\n║        %-31s ║ Chi tiết: %-95s ║\n",getId(), getName(), getPrice());
        System.out.println("╚====================================================================================================================================================╝");
    }
}
