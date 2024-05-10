/**
 * Represents the Smartphone device which will be stored in inventory.
 */
public class Smartphone extends AbstractDevice {

    // Unique Category Name for Smartphone
    private String constCategory;

    /**
     * Constructs the new smartphone device.
     * @param name the name of the Smartphone Device.
     * @param categoryName the name of the category that the Smartphone Device belongs to.
     * @param price the price of the Smartphone Device.
     * @param quantity the quantity of the Smartphone Device.
     * Since all these initializations are executed sequentially and each of them has a constant time complexity,
     * Time Complexity is O(1).
     */
    public Smartphone(String name, String categoryName, double price, int quantity) {

         // Call the superclass constructor with the category name for the Smartphone
         super(name, categoryName, price, quantity);

         this.constCategory = categoryName;
    }

    /**
     * Retrieves the Category Name of the Smartphone Device.
     * @return the initial Category Name of the Smartphone Device.
     * Direct access and return,
     * Time complexity is O(1).
     */
    @Override
    public String GetCategoryName() {
        return constCategory;
    }
}
