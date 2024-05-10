/**
 * Represents the Laptop device which will be stored in inventory.
 */
public class Laptop extends AbstractDevice {

    // Unique Category Name for Laptop
    private String constCategory;

    /**
     * Constructs the new laptop device.
     * @param name the name of the Laptop Device.
     * @param categoryName the name of the category that the Laptop Device belongs to.
     * @param price the price of the Laptop Device.
     * @param quantity the quantity of the Laptop Device.
     * Since all these initializations are executed sequentially and each of them has a constant time complexity,
     * Time Complexity is O(1).
     */
    public Laptop(String name, String categoryName, double price, int quantity) {
        super(name, categoryName, price, quantity);
        this.constCategory = categoryName;
    }

    /**
     * Retrieves the Category Name of the Laptop Device.
     * @return the initial Category Name of the Laptop Device.]
     * Direct access and return,
     * Time complexity is O(1).
     */
    @Override
    public String GetCategoryName() {
        return constCategory;
    }
}
