package csd214.bookstore.pojos;

public class Pen extends Stationery {
    // Field: private String color; (e.g., Blue, Red)
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void initialize() {

        super.initialize();

        System.out.println("Enter Color:");

        this.color = getInput(""); // Provides empty string as default
    }

    @Override
    public void sellItem() {

        System.out.println("Selling " + this.color + " Pen...");
    }

    @Override
    public String toString() {
        return "Pen: " + this.getName() + " (" + this.getBrand() +
                ", Color: " + this.color + ", Price: $" + this.getPrice() + ")";
    }

}