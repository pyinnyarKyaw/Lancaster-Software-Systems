package adminInterface;
import java.io.File;

/**
 * Authors: Pyinnyar Kyaw, Zaynab Choudhry, Andrew Roman
 * Version: 1.0.0
 */
class Main {
    public static void main(String[] args) {
        AdminImpl adminImpl = new AdminImpl();

        // True is print as operation finished in 4 seconds, timeout is 10 seconds
        System.out.println("uploadMenu():");
        System.out.println(adminImpl.uploadMenu(new File("")));

        // approved is returned
        System.out.println("getMenuStatus():");
        System.out.println(adminImpl.getMenuStatus());

        // A 2D list of delivery items and quantities is returned
        System.out.println("updateInventory():");
        System.out.println(adminImpl.updateInventory());
    }
}
