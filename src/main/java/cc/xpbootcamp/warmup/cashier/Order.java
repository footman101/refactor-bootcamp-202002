package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String customerName;
    String customerAddress;
    List<Product> products;

    public Order(String customerName, String customerAddress, List<Product> productList) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.products = productList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<Product> getProducts() {
        return products;
    }
}
