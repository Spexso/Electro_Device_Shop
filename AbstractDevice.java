/**
 * Represents a generic device in the inventory system.
 * This abstract class provides common implementation for devices.
 */
public abstract class AbstractDevice implements Device {

    /**
     * Name Attribute of a Device
     */
    protected String name;

    /**
     * Category Name Attribute of a Device
     */
     protected String categoryName;
    
    /**
     * Price Name Attribute of a Device
     */
    protected double price; 

    /**
     * Quantity Attribute of a Device
     */
    protected int quantity;

    /**
     * Constructs an AbstractDevice with the specified details.
     * @param name the name of the device.
     * @param categoryName the category name of the device.
     * @param price the price of the device.
     * @param quantity the quantity of the device in inventory.
     * Since all these operations are executed sequentially and each of them has a constant time complexity,
     * Time Complexity is O(1)
     */
    public AbstractDevice(String name, String categoryName, double price, int quantity) {
        this.name = name;
        this.categoryName = categoryName;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the name of the device.
     * @return the current name of the device.
     * Direct Acccess
     * Time Complexity is O(1)
     */
    @Override
    public String GetName() {
        return name;
    }

    /**
     * Updates the name of the device.
     * @param newName the new name for the device.
     * Direct Acccess
     * Time Complexity is O(1)
     */
    @Override
    public void SetName(String newName) {
        this.name = newName;
    }

    /**
     * Retrieves the price of the device.
     * @return the current price of the device.
     * Direct Acccess
     * Time Complexity is O(1)
     */
    @Override
    public double GetPrice() {
        return price;
    }

    /**
     * Updates the price of the device.
     * @param newPrice the new price for the device.
     * Direct Acccess
     * Time Complexity is O(1)
     */
    @Override
    public void SetPrice(double newPrice) {
        this.price = newPrice;

        if(price <= 0)
            price = 0;
    }

    /**
     * Retrieves the quantity of the device.
     * @return the current quantity of the device.
     * Direct Acccess
     * Time Complexity is O(1)
     */
    @Override
    public int GetQuantity() {
        return quantity;
    }

    /**
     * Updates the quantity of the device.
     * @param newQuantity the new quantity for the device.
     * No loop, if has constant time complexity
     * Time Complexity is O(1)
     */
    @Override
    public void SetQuantity(int newQuantity) {
        this.quantity = newQuantity;

        if(quantity <= 0)
            quantity = 0;
    }

    /**
     * Retrieves the category name of the device.
     * This method needs to be implemented by subclasses as each device has its own category.
     * @return the category name of the device.
     * Abstract method so no need to analyze for time complexity
     */
    @Override
    public abstract String GetCategoryName();

    /**
     * Prints the informations about a Device 
     * All the println's has constant time complexity 
     * Time Complexity is O(1)
     */
    public void PrintDeviceInfo(){

        System.out.println("Name =>     " + this.GetName() );
        System.out.println("Category => " + this.GetCategoryName() );
        System.out.println("Price =>    " + this.GetPrice() );
        System.out.println("Quantity => " + this.GetQuantity() );    
        System.out.println("---------------------------------------------");  
        System.out.println("---------------------------------------------");  
        System.out.println();
    }
}