/**
 * Represents the TV device which will be stored in inventory.
 */
public class TV extends AbstractDevice {

    // Unique Category Name
    private String constCategory;

    /**
     * Constructs the new tv device.
     * @param Cname the name of TV Device.
     * @param CCategoryname the name of category that TV Device belongs to.
     * @param Cprice the price of TV Device.
     * @param Cquantity the quantity of TV Device.
     * Since all these initializations are executed sequentially and each of them has a constant time complexity,
     * Time Complexity is O(1).
     */
    public TV(String Cname, String CCategoryname, double Cprice, int Cquantity){

        // Call the superclass constructor with the category name set to "TV"
        super(Cname, CCategoryname, Cprice, Cquantity);

        this.constCategory = CCategoryname;
    }

    /**
     * Retrieves the Category Name of the TV Device.
     * Direct access and return,
     * Time complexity is O(1).
     * @return the initial Category Name of the TV Device.
     */
    @Override
    public String GetCategoryName() {
        return constCategory;
    }
}
