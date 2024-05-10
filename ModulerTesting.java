/**
 * Tester class for Devices that implemented as modules
 * Uses PrintDeviceInfo() method for testing the correctness of Device attributes
 */
public class ModulerTesting {

    public static void main(String args[]){

        AbstractDevice  ins1 = new TV("Samsung OLED", "Television", 12500.87, 5);
        AbstractDevice  ins2 = new Smartphone("Samsung NOTE 24", "Smartphone", 24000, 12);
        AbstractDevice  ins3 = new Laptop("Huawei D15", "Laptop", 16500.12, 22);
        AbstractDevice  ins4 = new Headphone("Corsair Void Elite  7.1", "Headphone", 4500.5, 7);

        PrintDeviceInfo(ins1);
        PrintDeviceInfo(ins2);
        PrintDeviceInfo(ins3);
        PrintDeviceInfo(ins4);
    }
    
    /**
     * Prints the informations about a Device 
     * @param instance Device type that information of it gets printed
     * Lowest level of call ends with direct access so,
     * Time complexity is O(1).
     */
    public static void PrintDeviceInfo(AbstractDevice instance){

        instance.PrintDeviceInfo();
    }
}
