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

    public double totalSalesTax() {
        double result = 0d;
        for (Product product : products) {
            result += product.getSalesTax();
        }
        return result;
    }

    public double totalAmount() {
        double result = 0d;
        for (Product product : products) {
            result += product.totalAmount() + product.getSalesTax();
        }
        return result;
    }
}
