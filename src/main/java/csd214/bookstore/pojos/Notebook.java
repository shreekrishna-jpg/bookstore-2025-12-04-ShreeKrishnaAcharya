package csd214.bookstore.pojos;

public class Notebook extends Stationery {

    private int pageCount;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public void initialize() {
        super.initialize(); 

        System.out.println("Enter Page Count:");
        String input = getInput("100");

        try {
            this.pageCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            this.pageCount = 100;
        }
    }

    @Override
    public String toString() {
        return "Notebook: " + getName() + " (" + getBrand() + ", Pages: " + pageCount + ", Price: $" + getPrice() + ")";
    }


    @Override
    public void sellItem() {
        System.out.println("Selling " + getBrand() + " Notebook with " + pageCount + " pages...");
    }
}
