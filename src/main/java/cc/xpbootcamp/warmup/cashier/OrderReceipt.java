package cc.xpbootcamp.warmup.cashier;

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
        result.append("======Printing Orders======\n");
        result.append(order.getCustomerName());
        result.append(order.getCustomerAddress());

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