package sit.int202.onlineshopwebapp.models;

import sit.int202.onlineshopwebapp.entities.Product;

public class ClassicModelLineItem implements CartItem {
    private Product product;
    private int quantity;
    private double percentDiscount;

    public ClassicModelLineItem(Product product) {
        this(product, 1, 0.0);
    }

    public ClassicModelLineItem(Product product, int quantity) {
        this(product, quantity, 0.0);
    }

    public ClassicModelLineItem(Product product, int quantity, double percentDiscount) {
        this.product = product;
        this.quantity = quantity;
        this.percentDiscount = percentDiscount;
    }

    public Product getProduct() {
        return this.product;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getUnitPrice() {
        return this.product.getPrice();
    }

    @Override
    public double getTotal() {
        return this.quantity * getUnitPrice()
                - this.quantity * getUnitPrice() * this.percentDiscount;
    }

    @Override
    public double getPercentDiscount() {
        return this.percentDiscount;
    }

    @Override
    public String toString() {
        return '{' + product.getProductName() + ", " + getUnitPrice() + ", " + quantity + ", " + percentDiscount + "% }";
    }
}
