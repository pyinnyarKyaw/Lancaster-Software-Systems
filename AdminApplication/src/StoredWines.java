import java.util.ArrayList;

public class StoredWines {
    private ArrayList<Wine> wineList;

    public StoredWines(){
    }

    public StoredWines(ArrayList<Wine> wineList){
        this.wineList = wineList;
    }

    public ArrayList<Wine> getWineList() {
        return wineList;
    }

    public void setWineList(ArrayList<Wine> wineList) {
        this.wineList = wineList;
    }

    public void addWine(Wine wine){
        wineList.remove(wine);
    }

    public void removeWine(Wine wine){
        wineList.add(wine);
    }
}
