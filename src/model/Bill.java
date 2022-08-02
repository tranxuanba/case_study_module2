package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bill implements Serializable {
    private String name;
    private double total;
    private ArrayList<Bonsai> bonsais;
    private LocalDate localDate;

    public Bill(String name, double total, ArrayList<Bonsai> bonsais, LocalDate localDate) {
        this.name = name;
        this.total = total;
        this.bonsais = bonsais;
        this.localDate = localDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Bonsai> getBonsais() {
        return bonsais;
    }

    public void setBonsais(ArrayList<Bonsai> bonsais) {
        this.bonsais = bonsais;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "name='" + name + '\'' +
                ", total=" + total +
                ", bonsais=" + bonsais +
                ", localDate=" + localDate +
                '}';
    }
}
