package adminInterface;
import java.util.List;
import java.io.File;

/**
 * This class specifies the methods that need to be implemented
 * to allow FoH to send and retrieve data from management's SQL server
 *
 * @author : Pyinnyar Kyaw, Niriksha Pelman, Zaynab Choudhry
 * @version : 1.0.0
 */
public interface I_Admin{

    /**
     * This abstract method is used to define the method that
     * retrieves a list of wine recommendations corresponding to various dishes
     *
     *  @return a 2D List of dish names and their corresponding wines
     */
    List<List<String>> WineRecommendations();

    /**
     * This abstract method is used to define the method that
     * retrieves a list containing details of each dish
     *
     * @return a 2D List containing the name, price and description of each dish
     */
    List<List<String>> getDishDetails();

    /**
     * This abstract method is used to define the method that
     * retrieves the menu (containing allergen details) as a PDF File
     *
     * @return a File object that points to the location of the menu PDF
     */
    File getMenu();
}