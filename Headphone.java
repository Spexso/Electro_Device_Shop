/**
 * Represents the Headphone device which will be stored in inventory.
 */
public class Headphone extends AbstractDevice {

    // Unique Category Name for Headphone
    private String constCategory;

    /**
     * Constructs the new headphone device.
     * @param name the name of the Headphone Device.
     * @param categoryName the name of the category that the Headphone Device belongs to.
     * @param price the price of the Headphone Device.
     * @param quantity the quantity of the Headphone Device.
     * Since all these initializations are executed sequentially and each of them has a constant time complexity,
     * Time Complexity is O(1)
     */
    public Headphone(String name, String categoryName, double price, int quantity) {
        super(name, categoryName, price, quantity);
        this.constCategory = categoryName;
    }

    /**
     * Retrieves the Category Name of the Headphone Device.
     * @return the initial Category Name of the Headphone Device.
     * Direct access and return
     * Time complexity is O(1)
     */
    @Override
    public String GetCategoryName() {
        return constCategory;
    }
}
