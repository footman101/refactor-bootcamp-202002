package cc.xpbootcamp.warmup.cashier;

import java.util.Date;
import java.util.List;

public class Order {
    String customerName;
    String customerAddress;
    List<Product> products;
    Date date;

    public Order(String customerName, String customerAddress, List<Product> productList, Date date) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.products = productList;
        this.date = date;
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

    public Date getDate() { return date; }

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

    public double getDiscount() {
        System.out.println(date.getDate());
        if (date != null && (date.getDate() == 2)) {
            return totalAmount() * 0.98;
        }
        return 0;
    }
}
