package csd214.bookstore.pojos;

public abstract class Stationery extends Product {
    private String brand;

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    @Override
    public void initialize() {

        System.out.println("Enter Product Name:");
        setName(getInput(""));

        System.out.println("Enter Price:");
        try {
            setPrice(Double.parseDouble(getInput("0.0")));
        } catch (NumberFormatException e) {
            setPrice(0.0);
        }

        System.out.println("Enter Brand:");
        this.brand = getInput("");
    }

    @Override public void edit() {

        System.out.println("Current Name: " + getName() + ". Enter new Name (press Enter to keep):");
        String newName = getInput("");
        if (!newName.isEmpty()) setName(newName);

        System.out.println("Current Price: " + getPrice() + ". Enter new Price (press Enter to keep):");
        String newPrice = getInput("");
        if (!newPrice.isEmpty()) setPrice(Double.parseDouble(newPrice));

        System.out.println("Current Brand: " + brand + ". Enter new Brand (press Enter to keep):");
        String newBrand = getInput("");
        if (!newBrand.isEmpty()) this.brand = newBrand;
    }
}