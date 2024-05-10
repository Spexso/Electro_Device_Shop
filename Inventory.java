import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * A Class to handle the Inventory of Devices.
 */
public class Inventory {

    // LinkedList Inventory
    private LinkedList<ArrayList<AbstractDevice>> Devices = new LinkedList<>();

    /**
     * Constructs a new Inventory of Devices.
     * Initialization of Linked list has time complexity of O(1)
    */
    public Inventory() {
        this.Devices = new LinkedList<>();
    }


    /**
     * Searches for particular Device in inventory ArrayLists
     * @param name the Name of Device that will searched for
     * @return device if search is succesfull otherwise null
     * Nested loop has time complexity of O(n * m) m is number of devices in ArrayList and n is number of ArrayLists in LinkedList
     */
    private AbstractDevice FindDevice(String name){

        for(ArrayList<AbstractDevice> list : Devices){
            for(AbstractDevice device : list){

                if(device.GetName().equals(name))
                    return device;
            }
        }
        return null;
    }

    /**
     * Method to Add a new Device to Inventory.
     * Checks if category of new device is already listed or not.
     * @param Name the String variable represents Name of Device.
     * @param CategoryName the String variable represents Category Name of Device.
     * @param Price the double variable represents Price of Device.
     * @param Quantity the int variable represents Quantity of Device.
     * 
     * Switch case is direct access, only for loop has time complexity of O(N)
     */
    public void AddNewDevice(String Name, String CategoryName, double Price, int Quantity){

        // Variable to check if ArrayList for that Category already present
        boolean CategoryFound = false;

        AbstractDevice newDevice = null;

        // Create New Device based on Category
        switch (ConvertString(CategoryName)) {
            case "tv":
                newDevice = new TV(Name, CategoryName, Price, Quantity);
                break;

            case "smartphone":
                newDevice = new Smartphone(Name, CategoryName, Price, Quantity);
                break;

            case "laptop":
                newDevice = new Laptop(Name, CategoryName, Price, Quantity);
                break;

            case "headphone":
                newDevice = new Headphone(Name, CategoryName, Price, Quantity);
                break;

            case "keyboard":
                newDevice = new Keyboard(Name, CategoryName, Price, Quantity);
                break;

            default:
                // Unknown Device
                System.out.println("Unknown Category Detected!. Operation Terminated.");
                break;
        }


        // Check if new device's category already present in the invetory 
        for(ArrayList<AbstractDevice> list : Devices){

            if(list.get(0) != null){

                if(!list.isEmpty() && list.get(0).GetCategoryName().equals(CategoryName)){

                    list.add(newDevice);
                    PrintAddedDevice(newDevice);
                    CategoryFound = true;
                    break;
                }
            }
                
        }

        // If new device's Category now present in inventory add it
        if(!CategoryFound){

            ArrayList<AbstractDevice> newList = new ArrayList<>();
            newList.add(newDevice);
            Devices.add(newList);
            PrintAddedDevice(newDevice);
        }

    }

    /**
     * Method to find the particular Device with given Name and Category.  
     * @param name the String variable that is Name of Device.
     * @param Category the String variable that is CategoryName of Device.
     * 
     * If there are n categories and m represents the maximum number of devices in any category, the worst-case scenario for traversing all devices would be O(n * m)
     */
    public void RemoveDevice(String name, String Category){
        
        // Find the Device in inventory
        for(ArrayList<AbstractDevice> list : Devices){

            if(list != null){
                
                Iterator<AbstractDevice> iterator = list.iterator();
                
                while (iterator.hasNext()) {

                    AbstractDevice instance = iterator.next();

                    if (instance != null && instance.GetName().equals(name) && instance.GetCategoryName().equals(Category)) {
                        
                        // Remove the device using the iterator's remove method
                        iterator.remove();

                        // Print the removed device
                        PrintRemovedDevice(instance);
                        
                        return;
                    }
                }
            }
        }

        System.out.println("Entered device is not present in the Inventory!");
    }


    /**
     * Updates the price and quantity details of a specific device in the inventory.
     * The device to be updated is identified by its name. If the device is not found,
     * a message is displayed, and no update is performed. The method allows updating
     * either or both the price and quantity of the device. If either the new price
     * or the new quantity is set to -1, that particular detail is not updated.
     *
     * @param name The name of the device to update. It is used to search for the
     *             device in the inventory.
     * @param newPrice The new price to set for the device. If the value is -1,
     *                 the price is not updated.
     * @param newQuantity The new quantity to set for the device. If the value is -1,
     *                    the quantity is not updated.
     * 
     * Setting price and quantity is direct access but Finding device has time complexity of O(n * m) because of nested loops
     */
    public void UpdateDeviceDetails(String name, double newPrice, int newQuantity){

        AbstractDevice foundDevice = null;

        // Find the device by name
        foundDevice = FindDevice(name);

        if(foundDevice == null){
            System.out.println("Entered Device is not present in the Inventory!");
            return;
        }

        // Update Details of found Device
        if(newPrice != -1)
            foundDevice.SetPrice(newPrice);
        
        if(newQuantity != -1)
            foundDevice.SetQuantity(newQuantity);
    }

    /**
     * Displays the information of all devices in the inventory. If the inventory is empty,
     * a message indicating that the inventory is empty will be displayed. The method
     * iterates through each list of devices categorized by their type and calls the
     * PrintDeviceInfo method for each device to display its details.
     * 
     * Method's time complexity is O(n * m), where n is the number of device categories in the inventory and m is the maximum number of devices in any category.
     */
    public void DisplayInventory(){

        if(Devices.isEmpty()){

            System.out.println("Inventory is empty!");
            return;
        }

        for(ArrayList<AbstractDevice> list : Devices){

            for(AbstractDevice dvc : list){

                dvc.PrintDeviceInfo();
            }
        }
    }

    /**
     * Searches through the entire inventory to find the device with the minimum price. 
     * Iterates through all devices in all categories and compares their prices to identify 
     * the one with the lowest price. Once the minimum priced device is found, its details 
     * are printed in a horizontal format. If the inventory is empty, no action is taken.
     * 
     * The method uses nested loops to iterate over all devices across all categories. If there are n categories and m represents the maximum number of devices in any category, 
     * Time complexity is O(n * m)
     */
    public void FindMinPricedDevice(){
        
        AbstractDevice MinPricedDevice = null; 
        double minPrice = Double.MAX_VALUE;

        // Find the Device in inventory
        for(ArrayList<AbstractDevice> list : Devices){

            for(AbstractDevice device : list){

                if(device.GetPrice() < minPrice){
                    minPrice = device.GetPrice();
                    MinPricedDevice = device;
                }
            }
        }

        // Print Info for min priced Device
        if (MinPricedDevice != null ) {
            PrintDeviceInfoHorizontal(MinPricedDevice);
        }
    }

    /**
     * Sorts all devices in the inventory by their price in ascending order and then prints
     * the sorted list. Initially, the method flattens the LinkedList of ArrayLists into a single
     * ArrayList, then applies a bubble sort algorithm to order the devices by price. Finally,
     * the sorted list is printed, displaying each device's details in a horizontal format.
     * 
     * Bubble Sort is used as sorting algorithm, Since method iterates over same ArrayList back and forth for sorting time complexity is O(N^2)
     */
    public void SortPrice(){
        
        AbstractDevice temp = null;

        // Flatten the LinkedList to a single ArrayList
        ArrayList<AbstractDevice> allDevices = new ArrayList<>();
         
        for (ArrayList<AbstractDevice> deviceList : Devices) {
            
            allDevices.addAll(deviceList);
        }

        // Sort the All Device list based on price
        for (int i = 0; i < allDevices.size() - 1; i++) {
            for (int j = 0; j < allDevices.size() - i - 1; j++) {
                
                if (allDevices.get(j).GetPrice() > allDevices.get(j + 1).GetPrice()) {
                    
                    // Swapping
                    temp = allDevices.get(j);
                    allDevices.set(j, allDevices.get(j + 1));
                    allDevices.set(j + 1, temp);
                }
            }
        }

        int counter = 1;
        System.out.println("Devices sorted by price:");
        // Print List
        for(AbstractDevice device : allDevices){
            
            System.out.print(counter + ". ");
            PrintDeviceInfoHorizontal(device);
            counter++;
        }
    }

    /**
     * Calculates the total value of all devices in the inventory. The method iterates through
     * each device in every category, summing up the price of each device to compute the total
     * inventory value. The result is then printed to the console. This method does not account
     * for the quantity of each device, but rather sums up the individual price of each device
     * listed in the inventory.
     * 
     * Since Method iterates over every Device element inside nested loop time complexity is O(n * m) 
     */
    public void CalculateTotalInventoryValue(){

        double totalValue = 0;

        for(ArrayList<AbstractDevice> list : Devices){

            for(AbstractDevice device : list){

                totalValue = totalValue + device.GetPrice();
            }
        }

        System.out.println("Total inventory value: $" + totalValue);
    }

    /**
     * Updates the stock quantity of a specific device in the inventory. The device is identified
     * by its name. The stock quantity is either increased or decreased based on the parameters
     * provided. If the device is not found in the inventory, a message is displayed and no
     * action is taken. The method allows for both restocking (adding to the quantity) and
     * destocking (subtracting from the quantity) operations.
     *
     * @param name The name of the device to be restocked or destocked. This name is used to
     *             search for the device in the inventory.
     * @param amount The amount by which the stock should be adjusted. This value is added to
     *               or subtracted from the current stock quantity depending on the value of
     *               isMinus.
     * @param isMinus A boolean flag indicating the type of stock adjustment. If true, the
     *                amount is subtracted from the device's current quantity. If false, the
     *                amount is added to the current quantity.
     * 
     * The Method FindDevice(String) has the worst time complexity which is O(n * m).
     * Dominant factor is the nested loops, giving an overall time complexity of O(n * m)
     */
    public void RestockDevice(String name, int amount, boolean isMinus){

        AbstractDevice foundDevice = null;

        // Find the device by name
        foundDevice = FindDevice(name);

        // Check if device is found 
        if(foundDevice == null){
            System.out.println("Entered Device is not present in the Inventory!");
            return;
        }

        // Add or remove based on choice
        if(isMinus){
            // Remove
            foundDevice.SetQuantity(foundDevice.GetQuantity() - amount);
            System.out.println(foundDevice.GetName() + " stock reduced. New quantity: " + foundDevice.GetQuantity());
        }
        else{
            // Add
            foundDevice.SetQuantity(foundDevice.GetQuantity() + amount);
            System.out.println(foundDevice.GetName() + " stock increased. New quantity: " + foundDevice.GetQuantity());
        }
    }
    
    /**
     * Exports an inventory report to a file. The method iterates through all devices in the 
     * inventory, writing details of each device to the provided FileWriter in a formatted manner. 
     * After listing all devices, it appends a summary that includes the total number of devices 
     * and the total value of the inventory. Each device's details are written in a tabular format 
     * with indices, category name, device name, price, and quantity.
     *
     * @param writer The FileWriter object to which the inventory report will be written. It should 
     *               be opened and ready to accept output. The caller is responsible for closing the 
     *               FileWriter after this method returns.
     * 
     * Because of nested loops time complexity is O(n * m).
     */
    public void ExportInventoryReport(FileWriter writer){
        
        double totalValue = 0;
        int totalSize = 0;
        int index = 1;

        for (ArrayList<AbstractDevice> list : Devices) {
            for(AbstractDevice device : list){

                String line = String.format("| %d | %s | %s | $%.2f | %d |\n", index++, device.GetCategoryName(), device.GetName(), device.GetPrice(), device.GetQuantity());
                try {
                    writer.write(line);
                } catch (IOException e) {
                    // Catch block
                    e.printStackTrace();
                }
                totalValue += device.GetPrice() * device.GetQuantity();
            }
            
            totalSize += list.size();
        }

        try {
            writer.write("---------------------------------------\n");
            writer.write(String.format("Summary:\n- Total Number of Devices: %d\n- Total Inventory Value: $%.2f\n", totalSize, totalValue));
            writer.write("End of Report\n");
        } catch (IOException e) {
            // Catch block
            e.printStackTrace();
        }
       
    }

    /**
     * Prints the details of a device in a horizontal format. The device's category name, 
     * name, price, and quantity are displayed in a single line separated by commas.
     * 
     * @param dvc Device instance whose information will be printed.
     * All inside methods are direct access,
     * Time complexity is O(1)
     */
    private void PrintDeviceInfoHorizontal(AbstractDevice dvc){

        System.out.println("Category: " + dvc.GetCategoryName()  + ", " + 
                               "Name: " + dvc.GetName() + ", " + 
                               "Price: " + dvc.GetPrice() + ", " + 
                               "Quantity: " + dvc.GetQuantity());
    }

    /**
     * Prints the add info  
     * @param dvc AbstractDevice instance  
     * Direct print Time complexity is O(1)
     */
    private static void PrintAddedDevice(AbstractDevice dvc){

        System.out.println(dvc.GetName() + ", " +  dvc.GetCategoryName() + ", " + dvc.GetPrice() + ", " + dvc.GetQuantity() + " added to inventory...");
    }

    /**
     * Prints the remove info
     * @param dvc AbstractDevice instance
     * Direct print Time complexity is O(1)
     */
    private static void PrintRemovedDevice(AbstractDevice dvc){

        System.out.println(dvc.GetName() + ", " +  dvc.GetCategoryName() + ", " + dvc.GetPrice() + ", " + dvc.GetQuantity() + " removed from inventory...");
    }
 
    /**
     * Converts the String to all lower case for comparison purposes
     * @param defaultStr Original version of String 
     * @return the converted String
     * Since toLowerCase iterates over every element of String 
     * Time complexity is O(N)
     */
    private String ConvertString(String defaultStr){

        return defaultStr.toString().toLowerCase();
    }

}
