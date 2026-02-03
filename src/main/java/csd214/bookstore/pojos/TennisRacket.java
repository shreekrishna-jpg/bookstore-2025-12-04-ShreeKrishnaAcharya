package csd214.bookstore.pojos;

public class TennisRacket extends SportsEquipment {

    private int stringTension;  // <-- add field

    public int getStringTension() {
        return stringTension;
    }

    public void setStringTension(int stringTension) {
        this.stringTension = stringTension;
    }

    @Override
    public void initialize() {
        super.initialize();
        System.out.println("Enter String Tension:");
        String input = getInput("");
        this.stringTension = Integer.parseInt(input);
    }

    @Override
    public void edit() {
        super.edit();
        System.out.println("Current String Tension: " + stringTension);
        System.out.println("Enter new tension (press Enter to keep current):");
        String newValue = getInput("");
        if (!newValue.isEmpty()) {
            this.stringTension = Integer.parseInt(newValue);
        }
    }


    @Override
    public String toString() {
        return "Tennis Racket: " + getName() + " (" + getSportType() + ", Tension: " + stringTension + ", Price: $" + getPrice() + ")";
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Tennis Racket with tension " + stringTension);
    }
}
