package sit.int202.onlineshopwebapp.models;

public interface CartItem {
    public int getQuantity();
    public void setQuantity(int quantity);
    public double getUnitPrice();
    public double getTotal();
    public double getPercentDiscount();
}
