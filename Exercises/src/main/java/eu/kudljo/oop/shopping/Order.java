package eu.kudljo.oop.shopping;

import java.util.Date;
import java.util.UUID;

public class Order {

    private String id;
    private Date orderDate;
    private Customer customer;
    private Product product;
    private int productQuantity;

    public Order() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double calculateTotalPrice() {
        if (product == null) {
            return null;
        }

        return (product.getPrice() * productQuantity) * ((100 - product.getDiscount()) / 100);
    }
}
