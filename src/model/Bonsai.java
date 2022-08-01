package model;

public abstract class Bonsai {
    private String id;
    private String name;
    private double price;
    private double originOfTree;

    public Bonsai() {
    }

    public Bonsai(String id, String name, double price, double originOfTree) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.originOfTree = originOfTree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOriginOfTree() {
        return originOfTree;
    }

    public void setOriginOfTree(double originOfTree) {
        this.originOfTree = originOfTree;
    }

    @Override
    public String toString() {
        return String.format("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║", id, name, price, originOfTree);
    }
}
