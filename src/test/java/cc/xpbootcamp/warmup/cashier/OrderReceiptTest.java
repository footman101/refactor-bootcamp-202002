package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationAndOrderDate() throws ParseException {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<Product>(),
                new SimpleDateFormat("yyyy-MM-dd").parse("2020-2-19"));
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
        assertThat(output, containsString("2020年2月19日，星期三"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() throws ParseException {
        List<Product> products = new ArrayList<Product>() {{
            add(new Product("巧克力", 21.5, 2));
            add(new Product("小白菜", 10.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, products, new SimpleDateFormat("yyyy-MM-dd").parse("2020-2-17")));

        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年2月17日，星期一"));
        assertThat(output, containsString("巧克力, 21.50 x 2, 43.00\n"));
        assertThat(output, containsString("小白菜, 10.00 x 1, 10.00\n"));
        assertThat(output, containsString("税额：5.30"));
        assertThat(output, containsString("总价：58.30"));
    }

    @Test
    public void shouldDiscountInformation() throws ParseException {
        List<Product> products = new ArrayList<Product>() {{
            add(new Product("巧克力", 21.5, 2));
            add(new Product("小白菜", 10.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, products, new SimpleDateFormat("yyyy-MM-dd").parse("2020-2-19")));

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力, 21.50 x 2, 43.00\n"));
        assertThat(output, containsString("小白菜, 10.00 x 1, 10.00\n"));
        assertThat(output, containsString("税额：5.30"));
        assertThat(output, containsString("折扣：1.17"));
        assertThat(output, containsString("总价：57.13"));
    }
}