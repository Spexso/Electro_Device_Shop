import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main class to Test Device Inventory System
 * Name of class decleared to match the concept
 */
public class ElectroDeviceShop {


    /**
     * Main Method to test inventory class
     * @param args not used
     */
    public static void main(String[] args){

        boolean signal = true;
        Scanner inputScanner = new Scanner(System.in);
        Inventory ShopInventory = new Inventory();

        /* TEST GROUP */
        //ShopInventory.AddNewDevice("Samsung S20 FE", "Smartphone", 20240.4, 54);
        //ShopInventory.AddNewDevice("Logitech G713", "Keyboard", 1200.4, 4);
        //ShopInventory.AddNewDevice("Huawei Mate 30", "Smartphone", 7600.9, 33);
        //ShopInventory.AddNewDevice("Corsair Void Elite 7.1", "Headphone", 15400.3, 120);
        //ShopInventory.AddNewDevice("LG X100", "TV", 35400.1, 20);
       

        while (signal) {

            // Print the menu for options
            PrintMenu();

            // Get the input for option
            int opt = inputScanner.nextInt();
            inputScanner.nextLine();
            
            switch (opt) {
                case 1:
                    // Add a new device
                    AddDevice(inputScanner, ShopInventory);
                    break;

                case 2:
                    // Remove a device
                    RemoveDevice(inputScanner, ShopInventory);
                    break;

                case 3:
                    //Update device details
                    UpdateDeviceDetails(inputScanner, ShopInventory);
                    break;

                case 4:
                    // List all the devices in inventory
                    ShopInventory.DisplayInventory();
                    break;

                case 5:
                    // Find the cheapest device
                    ShopInventory.FindMinPricedDevice();
                    break;

                case 6:
                    // Sort devices by price
                    ShopInventory.SortPrice();
                    break;
                
                case 7:
                    // Calculating Total Inventory Valu
                    ShopInventory.CalculateTotalInventoryValue();
                    break;

                case 8:
                    RestockDevice(inputScanner, ShopInventory);
                    break;

                case 9:
                    ExportReport(ShopInventory);
                    break;

                case 0:
                    // Exit the system 
                    signal = false;
                    PrintCreepyExit();
                    break;

                default:
                    System.out.println("Entered option is not valid!");
                    break;
            }
        }

        inputScanner.close();

        
    }

    /**
     * Method to export the inventory report to a txt file
     * @param list the class that stores collections of devices
     * 
     * Since most complex method is ExportInventoryReport(String, double, int),
     * Time complexity is O(n * m).
     */
    private static void ExportReport(Inventory list){

        try {
            FileWriter writer = new FileWriter("InventoryReport.txt");
            
            writer.write("Electronics Shop Inventory Report\n");
            writer.write("---------------------------------------\n");
            writer.write("| No. | Category   | Name    | Price   | Quantity |\n");
            writer.write("---------------------------------------\n");

            list.ExportInventoryReport(writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    /**
     * Interactively adjusts the stock level of a specified device in the inventory. The user is prompted
     * to enter the device's name and specify whether they want to add or remove stock. The user then enters
     * the quantity to adjust the stock by. Depending on the user's choice, the stock level of the device
     * will either increase or decrease by the specified quantity.
     * 
     * @param addInput A Scanner object used to capture user input from the console.
     * @param List An Inventory object whose device stock will be adjusted.
     * 
     * Since most complex method is RestockDevice(String, double, int),
     * Time complexity is O(n * m).
     */
    private static void RestockDevice(Scanner addInput, Inventory List){
        
        String name = null;
        String condition = null;
        int quantity;
        boolean switchD;

        // Enter the name of device
        System.out.println("Enter the name of the device to restock: ");
        name = addInput.nextLine();

        // Decide wheter 
        System.out.println("Do you want to add or remove stock? (Add/Remove): ");
        condition = addInput.nextLine();

        if(condition.equalsIgnoreCase("add"))
            switchD = false;
        else if(condition.equalsIgnoreCase("remove"))
            switchD = true;
        else 
            switchD = true;

        // Enter the name of device
        System.out.println("Enter the quantity to change: ");
        quantity = addInput.nextInt();

        List.RestockDevice(name, quantity, switchD);

    }

    /**
     * Interactively updates the details of an existing device in the inventory. The user is prompted
     * to enter the name of the device to be updated and can optionally update the price and quantity
     * of the device. If the user leaves the input for price or quantity blank, the current value is retained.
     * If the input is not a valid number, an error message is displayed, and the update is not performed
     * for that field.
     * 
     * @param addInput A Scanner object used to capture user input from the console.
     * @param List An Inventory object whose device details will be updated.
     * 
     * Since most complex method is UpdateDeviceDetails(String, double, int),
     * Time complexity is O(n * m).
     */
    private static void UpdateDeviceDetails(Scanner addInput, Inventory List){

        String Name;
        double Price = -1;
        int Quantity = -1;

        // Enter name for finding the device in the Inventory 
        System.out.println("Enter Name of device to update: ");
        Name = addInput.nextLine();

        // Get new price info
        System.out.println("Enter new price (leave blank to keep current price): ");
        String input = addInput.nextLine();  // Read the input as a string

        if (input.trim().isEmpty()) {

            System.out.println("No input provided, keeping the current price.");
        } else {

            try {

                // Try to parse the string input to a double
                Price = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                // input is not a valid double
                System.out.println("Invalid input, not a valid number.");
            }

        }

        // Get new quantity info
        System.out.println("Enter new quantity (leave blank to keep current quantity): ");
        String input2 = addInput.nextLine();  // Read the input as a string

        if (input2.trim().isEmpty()) {

            System.out.println("No input provided, keeping the current price.");
        } else {

            try {

                // Try to parse the string input to a double
                Quantity = Integer.parseInt(input2);
            } catch (NumberFormatException e) {
                // input is not a valid double
                System.out.println("Invalid input, not a valid number.");
            }

        }

        // Try to update details of given device
        List.UpdateDeviceDetails(Name, Price, Quantity);
    }


    /**
     * Interactively adds a new device to the inventory based on user input. This method prompts the user
     * to enter details for the new device, including its name, category, price, and quantity. After
     * gathering all necessary information, it calls the AddNewDevice method of the Inventory class
     * to add the device to the inventory.
     * @param addInput A Scanner object used to capture user input from the console.
     * @param List An Inventory object to which the new device will be added.
     * 
     * Since AddNewDevice(String, String, double, int) is the most complex operation in this method and has a complexity of O(n),
     * Time complexity is O(N).
     */
    private static void AddDevice(Scanner addInput, Inventory List){

        String Name;
        String Category;
        double Price;
        int Quantity;

        // Get information for new device 
        System.out.println("Enter Name of device: ");
        Name = addInput.nextLine();

        // Get information for new device 
        System.out.println("Enter Category of device: ");
        Category = addInput.nextLine();

          // Get information for new device 
        System.out.println("Enter Price of device: ");
        Price = addInput.nextDouble();

        // Get information for new device 
        System.out.println("Enter Quantity of device: ");
        Quantity = addInput.nextInt();

        // Try to add entered device to inventory
        List.AddNewDevice(Name, Category, Price, Quantity);
    }


    /**
     * Interactively removes a device from the inventory based on user input. This method prompts the user 
     * to enter the name and category of the device they wish to remove. After obtaining this information, 
     * it calls the RemoveDevice method of the Inventory class to attempt the removal of the specified device.
     *
     * @param addInput A Scanner object used to capture user input from the console.
     * @param List An Inventory object from which the device will be removed.
     * 
     * The Method has time complexity of O(n * m) because of RemoveDevice(String, String) method
     */
    private static void RemoveDevice(Scanner addInput, Inventory List){

        String Name;
        String Category;

        // Get information for new device 
        System.out.println("Enter Name of device: ");
        Name = addInput.nextLine();

        // Get information for new device 
        System.out.println("Enter Category of device: ");
        Category = addInput.nextLine();

        // Try to add entered device to inventory
        List.RemoveDevice(Name, Category);
    }

    /**
     * Easter Egg print message for exit signal
     */
    public static void PrintCreepyExit(){

        System.out.println("");
                    System.out.println("");
                    System.out.println("         |\r\n" + //
                                                "    _____|_____\r\n" + //
                                                "   |           |\r\n" + //
                                                "   |  (o)  (o) |\r\n" + //
                                                "   |     |     |\r\n" + //
                                                "   |   \\___/   |\r\n" + //
                                                "   |___________|\r\n" + //
                                                "");
                    System.out.println("See you");
    }

    /**
     * Prints the Menu Template for UI
     * Since there are only direct printing calls,
     * Time complexity is O(1) 
     */
    private static void PrintMenu(){

        System.out.println("");
        System.out.println("");
        System.out.println("---Inventory Dashboard---");
        System.out.println("Select an option from below:");
        System.out.println("");
        System.out.println("1. Add a new Device");
        System.out.println("2. Remove a device");
        System.out.println("3. Update Device Details");
        System.out.println("4. List All Devices");
        System.out.println("5. Find the cheapest Device");
        System.out.println("6. Sort Devices by Price");
        System.out.println("7. Calculate total inventory value");
        System.out.println("8. Restock a device");
        System.out.println("9. Export inventory report");
        System.out.println("0. Exit System");
        System.out.print("Selection => ");
    }
}
