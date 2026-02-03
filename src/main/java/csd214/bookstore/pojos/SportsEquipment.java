package csd214.bookstore.pojos;

public abstract class SportsEquipment extends Product {
    private String material;
    private String sportType;

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public String getSportType() { return sportType; }
    public void setSportType(String sportType) { this.sportType = sportType; }

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

        System.out.println("Enter Material:");
        this.material = getInput("Generic");

        System.out.println("Enter Sport Type:");
        this.sportType = getInput("Generic");
    }

    @Override
    public void edit() {
        System.out.println("Current Name: " + getName() + ". Enter new Name:");
        String n = getInput("");
        if (!n.isEmpty()) setName(n);

        System.out.println("Current Price: " + getPrice() + ". Enter new Price:");
        String p = getInput("");
        if (!p.isEmpty()) setPrice(Double.parseDouble(p));

        System.out.println("Current Sport Type: " + sportType);
        String s = getInput("");
        if (!s.isEmpty()) this.sportType = s;
    }
}