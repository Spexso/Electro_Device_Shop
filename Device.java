/**
 * This Interface represents devices.
 * Provides abstract methods that every device should implement.
 * Each device has a category, name, price, and quantity.
 */
public interface Device {

    /**
     * Abstract function to return Category Name.
     * @return String variable that represents the Category Name of Device.
     * Method comes from Interface so no need to analyze for time complexity
     */
    String GetCategoryName();

    /**
     * Abstract function to return Category Name.
     * @return String variable that represents the Name of Device Type.
     * Method comes from Interface so no need to analyze for time complexity
     */
    String GetName();

    /**
     * Abstract function to return Category Name.
     * @return double value that represents the Price of Device Type.
     * Method comes from Interface so no need to analyze for time complexity
     */
    double GetPrice();

    /**
     * Abstract function to return Category Name.
     * @return integer value that represents the Quantity of Device Type.
     * Method comes from Interface so no need to analyze for time complexity
     */
    int GetQuantity();

    ////////////////////////////////////////////////////////////////////////////////////

    /**
     * Abstract function to Set Name of Device.
     * @param name the string variable that set as Name of Device.
     * Method comes from Interface so no need to analyze for time complexity
     */
    void SetName(String name);

    /**
     * Abstract function to Set Price of Device.
     * @param price the double value that set as Price of Device.
     * Method comes from Interface so no need to analyze for time complexity
     */
    void SetPrice(double price);

    /**
     * Abstract function to Set Quantity of Device.
     * @param quantity the integer value that set as Quantity of Device Type.
     * Method comes from Interface so no need to analyze for time complexity
     */
    void SetQuantity(int quantity);

}