package csd214.bookstore.pojos;

public class Football extends SportsEquipment {

    private int size; 

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void initialize() {
        super.initialize();
        System.out.println("Enter Football Size (3, 4, 5):");
        String input = getInput("5");
        try {
            this.size = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            this.size = 5;
        }
    }

    @Override
    public void edit() {
        super.edit();
        System.out.println("Current Size: " + size);
        System.out.println("Enter new Size (press Enter to keep current):");
        String input = getInput(String.valueOf(size));
        if (!input.isEmpty()) {
            try {
                this.size = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid size. Keeping current.");
            }
        }
    }

    @Override
    public String toString() {
        return "Football: " + getName() + " (" + getSportType() + ", Size: " + size + ", Price: $" + getPrice() + ")";
    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + getSportType() + " Football size " + size + "...");
    }
}
