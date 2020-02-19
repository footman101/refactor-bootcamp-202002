package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
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
    private DecimalFormat decimalFormat = new DecimalFormat(".00");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年M月d日，EEEE", Locale.CHINA);

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder result = new StringBuilder();

        appendHeader(result);
        result.append("\n");
        appendBody(result);
        appendFooter(result);

        return result.toString();
    }

    private void appendLine(StringBuilder result, String ...args) {
        for (String arg: args) {
            result.append(arg);
        }
        result.append("\n");
    }

    private void appendFooter(StringBuilder result) {
        appendLine(result, "税额：", decimalFormat.format(order.totalSalesTax()));
        appendLine(result, "折扣：", decimalFormat.format(order.getDiscount()));
        appendLine(result, "总价：", decimalFormat.format(order.totalAmount()));
    }

    private void appendBody(StringBuilder result) {
        for (Product product : order.getProducts()) {
            appendLine(result, product.getDescription(), ", ", decimalFormat.format(product.getPrice()),
                " x ", "" + product.getQuantity(), ", ", decimalFormat.format(product.totalAmount()));
        }
    }

    private void appendHeader(StringBuilder result) {
        appendLine(result, "===== 老王超市，值得信赖 ======");
        if (order.getCustomerName() != null) {
            appendLine(result, order.getCustomerName());
        }
        if (order.getCustomerAddress() != null) {
            appendLine(result, order.getCustomerAddress());
        }
        if (order.getDate() != null) {
            appendLine(result, dateFormat.format(order.getDate()));
        }
    }
}