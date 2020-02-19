package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder result = new StringBuilder();

        // print headers
        result.append("===== 老王超市，值得信赖 ======\n");
        if (order.getCustomerName() != null) {
            result.append(order.getCustomerName()).append('\n');
        }
        if (order.getCustomerAddress() != null) {
            result.append(order.getCustomerAddress()).append('\n');
        }
        if (order.getDate() != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年M月d日，EEEE", Locale.CHINA);
            result.append(formatter.format(order.getDate())).append('\n');
        }

        // prints products
        for (Product product : order.getProducts()) {
            result.append(product.getDescription());
            result.append('\t');
            result.append(product.getPrice());
            result.append('\t');
            result.append(product.getQuantity());
            result.append('\t');
            result.append(product.totalAmount());
            result.append('\n');
        }

        // prints the sales tax
        result.append("Sales Tax").append('\t').append(order.totalSalesTax());
        result.append('\n');

        // prints total amount
        result.append("Total Amount").append('\t').append(order.totalAmount());
        result.append('\n');

        return result.toString();
    }
}