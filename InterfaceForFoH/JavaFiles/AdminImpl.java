package adminInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;

/**
 * This class implements the methods that allow FoH
 * to send and retrieve data from Management's SQL server
 *
 * @author : Pyinnyar Kyaw, Niriksha Pelman, Zaynab Choudhry
 * @version : 1.0.0
 */

public class AdminImpl implements I_Admin {

    /**
     * Default constructor is used
     */
    public AdminImpl(){}

    /**
     * This method retrieves a list of wine recommendations corresponding to various dishes
     *
     * @return a 2D List of dish names and their corresponding wines
     */
    @Override
    public List<List<String>> WineRecommendations(){
        //  Connect to SQL server
        //  Retrieve data
        List<List<String>>  inventory = new ArrayList<>();
        inventory.add(Arrays.asList("Lasagne Of Rabbit Shoulder", "Cabernet Sauvignon"));
        inventory.add(Arrays.asList("Grilled Beef Tongue", "Merlot"));
        inventory.add(Arrays.asList("Our Iberian Pork", "Sparkling Wine"));
        inventory.add(Arrays.asList("Short Rib of Red Ruby Beef", "Red Wine"));
        inventory.add(Arrays.asList("Roast Cornish Monkfish", "Chardonnay"));
        inventory.add(Arrays.asList("Wareham Dorset Sika Deer", "Syrah"));
        inventory.add(Arrays.asList("Apple Parfait", "Garnacha"));
        inventory.add(Arrays.asList("Plum Ripple Ice Cream", "Sauvignon Blanc"));
        inventory.add(Arrays.asList("Custard Flan", "Trebbiano Toscano"));
        inventory.add(Arrays.asList("Selection of Cheese", "Pinot Noir"));
        //  Close SQL server connection
        return inventory;
    }

    /**
     * This method retrieves a list containing details of each dish
     *
     * @return a 2D List containing the name, price and description of each dish
     */
    @Override
    public List<List<String>> getDishDetails() {

        //  Placeholder for connecting to SQL server
        //  Connecting to SQL server
        //  Manually adding dish details for now
        List<List<String>> dishDetails = new ArrayList<>();
        dishDetails.add(Arrays.asList("Our Iberian Pork", "32", "Enhanced with Jerusalem artichoke and pickled walnuts, the Iberian Pork dish combines succulent flavors with a crisp, tangy finish."));
        dishDetails.add(Arrays.asList("Roast Cornish Monkfish", "28", "Paired with butternut squash and sage, the Roast Cornish Monkfish offers a delightful harmony of flavours, showcasing the delicate texture of the fish."));
        dishDetails.add(Arrays.asList("Grilled Beef Tongue", "14", "Elevated with quince, aged vinegar, and beetroot, the Grilled Beef Tongue melds bold flavours with a tender, smoky finish."));
        dishDetails.add(Arrays.asList("Lasagne of Rabbit Shoulder", "12", "Layered with tender rabbit shoulder, mushrooms, Riesling, and thyme, this lasagne offers a rustic, flavourful twist on a classic comfort dish."));
        dishDetails.add(Arrays.asList("Venison Pâté en Croûte", "13", "Accentuated with hedgerow jelly, mustard fruit, and pistachios, this Venison Pâté en Croûte is a refined blend of rich flavours and textures."));
        dishDetails.add(Arrays.asList("Warm Onion Tart", "12", "Rich caramelised onions and creamy Quickes Goats Cheese blend harmoniously in this savoury tart, highlighting the simplicity and quality of its ingredients."));
        //  Placeholder for closing the SQL server connection
        //  Close connection
        return dishDetails;


    }

    /**
     * This method retrieves the menu (containing allergen details) as a PDF File
     *
     * @return a File object that points to the location of the menu PDF
     */
    @Override
    public File getMenu() {
        //  Connect to database
        //  Retrieve menu from database
        //  Disconnect from database

        //  For now, we create a file object that references menu PDF
        //  and return the static file reference
        File file = new File("data/menu.pdf");
        return file;
    }
}