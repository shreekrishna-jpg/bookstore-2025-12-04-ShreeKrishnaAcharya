package csd214.bookstore.pojos;

import java.io.Serializable;
import java.util.UUID;

public class Widget extends Product implements Serializable {

    private String widgetName;

    public Widget() {
    }

    public Widget(String widgetName, double price) {
        this.widgetName = widgetName;
        setPrice(price);
        setProductId(UUID.randomUUID().toString());
    }

    public String getWidgetName() {
        return widgetName;
    }

    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName;
    }
    @Override
    public void sellItem() {
    }

    @Override
    public void edit() {
        System.out.print("Enter widget name: ");
        setWidgetName(input.nextLine());

        System.out.print("Enter price: ");
        setPrice(Double.parseDouble(input.nextLine()));

        System.out.print("Enter copies: ");
        setCopies(Integer.parseInt(input.nextLine()));
    }
}