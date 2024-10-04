package Entities;

public class Products extends _BaseEntities {
    private String name;
    private int qtd;
    private String type;
    private double price;

    public Products(int id, String name, int qtd, String type, double price) {
        super(id);
        this.name = name;
        this.qtd = qtd;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", qtd=" + qtd +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
