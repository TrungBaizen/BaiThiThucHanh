package model;

public class Product {
    private int id;
    private String nameProduct;
    private double price;
    private int quantity;
    private String color;
    private String descriptions;
    private Category category;

    public Product() {
    }

    public Product(int id, String nameProduct, double price, int quantity, String color, String descriptions, Category category) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descriptions = descriptions;
        this.category = category;
    }
    public Product( String nameProduct, double price, int quantity, String color, String descriptions, Category category) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descriptions = descriptions;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
