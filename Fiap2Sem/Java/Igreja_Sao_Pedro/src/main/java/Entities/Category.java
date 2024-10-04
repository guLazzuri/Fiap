package Entities;

import java.util.List;

public class Category extends _BaseEntities{
    private String nameCategory;
    private List<Products> listProducts;

    public Category(String nameCategory, List<Products> listProducts) {
        this.nameCategory = nameCategory;
        this.listProducts = listProducts;
    }

    public Category(int id, String nameCategory, List<Products> listProducts) {
        super(id);
        this.nameCategory = nameCategory;
        this.listProducts = listProducts;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Products> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Products> listProducts) {
        this.listProducts = listProducts;
    }

    @Override
    public String toString() {
        return "Category{" +
                "nameCategory='" + nameCategory + '\'' +
                ", listProducts=" + listProducts +
                '}';
    }
}
