package adminInterface;

import java.io.File;
import java.util.concurrent.Callable;

/*  Some code below is part of an answer written
    by BalusC on Feb 16, 2010 on stack overflow
    https://stackoverflow.com/questions/2275443/how-to-timeout-a-thread
*/

/**
 * This class is hidden from the kitchen team, they cannot declare an
 * object of this class and directly to connect to management's sql server,
 * they must instead go through one of the methods provided by the interface
 * 
 * This class is used to upload pdf files
 * to management's sql server
 *
 * @author : Pyinnyar Kyaw, Andrew Roman
 * @version : 1.0.0
 */
class Task implements Callable<String> {
    private final File menuPDF;
    /**
     * Used to pass in the file to be later used by the upload method
     */
    Task(File f){
        menuPDF = f;
    }

    /**
     * This method is used to upload a pdf file to management's server,
     * this method can be interrupted if the upload is taking too long,
     * for reasons such as no internet, slow Wi-Fi, database connectivity issues etc.
     * @return "Task Complete" which means that the file has finished uploading
     */
    @Override
    public String call() throws Exception {
        // Placeholder to insert pdf into SQL server

        // Create a connection to SQLServer
        // Select the MenusFromKitchenTable
        // Insert the menu.pdf file as a file stream
        // Close the connection

        /*
            // Example:

            String sql = "INSERT MenusFromKitchenTable VALUES = FileStream.(menuPDF)";

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.CreateStatement();
            st.executeQuery(sql) // menu is uploaded here
            con.close(); // connection is closed here
        */

        // Assume operation above, takes 4 seconds

        Thread.sleep(4000);

        return "Task Complete";
    }
}