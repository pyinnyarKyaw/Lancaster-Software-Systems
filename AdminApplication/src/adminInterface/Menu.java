package adminInterface;
import java.io.File;
import java.util.HashMap;
import java.util.List;
//5

public class Menu {
    private String startDate;
    private File file;
    private List<Dish> dishDetails;
    private HashMap<Dish, Wine> wineRecommendations;
    private DatabaseManager dbManager = new DatabaseManager();

    protected Menu(String sD) {
        this.startDate = sD;
    }

    protected Menu(String sD, List<Dish> dD, HashMap<Dish, Wine> wR) {
        this.startDate = sD;
//        this.file = f;
        this.dishDetails = dD;
        this.wineRecommendations = wR;
    }


    public String getStartDate() {
        return startDate;
    }

    protected void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public HashMap<Dish, Wine> getWineRecommendations() {
        return wineRecommendations;
    }

    protected void setWineRecommendations(HashMap<Dish, Wine> wineRecommendations) {
        this.wineRecommendations = wineRecommendations;
    }

    public List<Dish> getDishDetails() {
        return dishDetails;
    }

    protected void setDishDetails(List<Dish> dishDetails) {
        this.dishDetails = dishDetails;
    }

    public File getFile() {
        return file;
    }

    protected void setFile(File file) {
        this.file = file;
    }




}
