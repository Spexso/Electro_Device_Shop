/**
 * Represents the Keyboard device which will be stored in inventory.
 */
public class Keyboard extends AbstractDevice {

    // Unique Category Name for Keyboard
    private String constCategory;

    /**
     * Constructs the new keyboard device.
     * @param name the name of the Keyboard Device.
     * @param categoryName the name of the category that the Keyboard Device belongs to.
     * @param price the price of the Keyboard Device.
     * @param quantity the quantity of the Keyboard Device.
     * Since all these initializations are executed sequentially and each of them has a constant time complexity,
     * Time Complexity is O(1)
     */
    public Keyboard(String name, String categoryName, double price, int quantity) {
        super(name, categoryName, price, quantity);
        this.constCategory = categoryName;
    }

    /**
     * Retrieves the Category Name of the Keyboard Device.
     * @return the initial Category Name of the Keyboard Device.
     * Direct access and return
     * Time complexity is O(1)
     */
    @Override
    public String GetCategoryName() {
        return constCategory;
    }
}
