package adminInterface;

import java.io.File;
import java.util.List;
import java.util.HashMap;
//4

public interface I_Admin {
    List<Dish> getDishDetails();
    Menu getMenu();
    HashMap<Dish, Wine> WineRecommendations();

    String getMenuStatus();

    List<List<String>> updateInventory();

    HashMap<String, String> getRole(int staffID);
//

}
