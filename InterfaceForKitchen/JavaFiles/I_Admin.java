package adminInterface;
import java.io.File;
import java.util.List;

/**
 * This class specifies the methods that need
 * to be implemented to allow kitchen
 * to send and retrieve data from managements
 * sql server
 *
 * @author : Pyinnyar Kyaw, Zaynab Choudhry, Andrew Roman
 * @version : 1.0.0
 */
public interface I_Admin {
    /**
     * This abstract method is used to define the method that allows kitchen to
     * upload a menu (as a pdf file) to the server and returns a boolean to show
     * if management team has successfully received the menu or not.
     *
     * @param menuPDF This is the pdf file that is to be uploaded to the server
     * @return True means that the file has been successfully uploaded, false means that the file has failed to upload and has not reached the management team
     */
    boolean uploadMenu(File menuPDF);

    /**
     * This abstract method is used to define the method that checks
     * the status of the most recently uploaded menu
     *
     * @return The status of the menu; approved, declined or updated is returned as a string
     * */
    String getMenuStatus();

    /**
     * This abstract method is used to define the method that is used to get the items and their quantities
     * from the most recent delivery (if the delivery has already added to the inventory, null will be returned)
     *
     * @return A 2D list of the items and their quantities, from the most recent delivery that needs to be added to kitchen's inventory, I.e.[[Mushroom, 5, kg], [Olive Oil, 10, l]] or null (if delivery has already been added)
     */
    List<List<String>> updateInventory();
}