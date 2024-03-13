package adminInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * This class implements the methods that allow kitchen
 * to send and retrieve data from management's
 * sql server
 *
 * @author : Pyinnyar Kyaw, Zaynab Choudhry, Andrew Roman
 * @version : 1.0.0
 */
public class AdminImpl implements I_Admin{
    /**
     * Default constructor is used
     */
    public AdminImpl(){}

    /**
     * This method is allows kitchen to upload a menu (as a pdf file) to the server and returns a boolean to show
     * if management team have successfully received the menu or not.
     *
     * It does this by creating a separate thread to upload a pdf file to management's server,
     * if the upload is taking too long, the newly created thread is shutdown. The file has a maximum of 10
     * seconds to upload, before it is shutdown and false is returned to show that the file has not
     * reached the management team. This has been implemented to account for loss of an internet connection,
     * extremely slow Wi-Fi speeds, database connectivity issues etc.
     *
     * @param menuPDF This is the pdf file that is to be uploaded to the server
     * @return True means that the file has been successfully uploaded, false means that the file has failed to upload and has not reached the management team
     */
    @Override
    public boolean uploadMenu(File menuPDF) {
        /*
            Kitchen team has requested that they are notified if
            the file has been successfully uploaded or not.
            To fulfill this request, a timeout function is included, where if;

            1) The upload is complete under 10 seconds, the file has been added to the database
            successfully and true is returned, to notify kitchen that the file has reached the management team

            2) The upload is taking longer than 10 seconds, the operation is cancelled and false is
            returned, to notify kitchen that the file has not reached the management team
            executed away from the main thread.

            The newly created thread is interrupted and closed if
            the upload is taking too long for reasons such as; no internet, slow Wi-Fi,
            database connectivity issues etc.
        */

        /*  Some code below is part of an answer written
            by BalusC on Feb 16, 2010 on stack overflow
            https://stackoverflow.com/questions/2275443/how-to-timeout-a-thread
        */

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new Task(menuPDF));
        boolean fileUploaded = false;

        try {
            future.get(10, TimeUnit.SECONDS);

            /*
                Task.call() has been completed under 10 seconds,
                meaning the file has been uploaded successfully, so
                the fileUploaded variable is set to true.
            */

            fileUploaded = true;
        } catch (TimeoutException | InterruptedException | ExecutionException e) {

            /*
                Task.call() has taken longer 10 seconds to execute,
                so it will be interrupted and the fileUploaded variable
                will remain false.
            */

            future.cancel(true);
        }
        //  The thread gets shutdown here
        executor.shutdownNow();

        // True is returned if file has been uploaded successfully
        // False is returned if file has failed to upload
        return fileUploaded;
    }


    /**
     * This method is used to check the status of the most recently uploaded menu
     *
     * @return The status of the menu; approved, declined or updated is returned as a string
     * */
    @Override
    public String getMenuStatus() {

        // Placeholder to read status from SQL server

        // Create a connection to SQLServer
        // Using the MenusFromKitchenTable
        // Find the most recently uploaded menu
        // Get the menu's status
        // Close the connection

        /*
            // Example:

            String sql = "SELECT status FROM MenusFromKitchenTable WHERE MAX(Date)";

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.CreateStatement();
            String status = st.executeQuery(sql) // status is returned here
            con.close(); // connection is closed here
        */

        String status = "approved";
        return status;
    }

    /**
     * This method is used to get the items and their quantities from the most recent delivery (if the delivery has already added to the inventory, null will be returned)
     *
     * @return A 2D list of the items and their quantities, from the most recent delivery that needs to be added to kitchen's inventory I.e.[[Mushroom, 5, kg], [Olive Oil, 10, l]]
     * */
    @Override
    public List<List<String>> updateInventory(){
        //  Placeholder for connecting to SQL server

        //  Connecting to SQL server
        //  Using the DeliveriesTable
        //  Find the most recent delivery
        //  Make sure it has not been added to stock already
        //  Retrieve the delivered items and store them in a 2D list
        //  Find the most recently uploaded menu
        //  Get the menu's status

        /*
            // Example:

            String sql = "SELECT delivery FROM DeliveryTable WHERE MAX(Date) AND NOT added";

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.CreateStatement();
            List<List<String>> inventory = st.executeQuery(sql) // inventory is returned here
            con.close(); // connection is closed here
        */

        //  Manually inserting inventory items for now
        List<List<String>> inventory = new ArrayList<>();
        inventory.add(Arrays.asList("Mushroom", "5", "kg"));
        inventory.add(Arrays.asList("Sage", "1", "kg"));
        inventory.add(Arrays.asList("Spring Onion", "2", "kg"));
        inventory.add(Arrays.asList("Spinach", "5", "kg"));
        inventory.add(Arrays.asList("Olive Oil", "10", "l"));

        //Placeholder for closing the SQL server connection
        // Close connection

        //  If the most recently delivery has already added, inventory will still be returned
        //  but since it is empty it's value will be null

        return inventory;
    }
}
