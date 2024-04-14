public class DailySales {
    private int totalSales;
    private int totalIngredientsCost;
    private int turnover;
    private int totalQuantitySold;
    private String menu; // change into menu class
    private String[][] salesTable;
    private String date;
    private int tablesBooked;
    private int covers;

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public int getTotalIngredientsCost() {
        return totalIngredientsCost;
    }

    public void setTotalIngredientsCost(int totalIngredientsCost) {
        this.totalIngredientsCost = totalIngredientsCost;
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public int getTotalQuantitySold() {
        return totalQuantitySold;
    }

    public void setTotalQuantitySold(int totalQuantitySold) {
        this.totalQuantitySold = totalQuantitySold;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String[][] getSalesTable() {
        return salesTable;
    }

    public void setSalesTable(String[][] salesTable) {
        this.salesTable = salesTable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTablesBooked() {
        return tablesBooked;
    }

    public void setTablesBooked(int tablesBooked) {
        this.tablesBooked = tablesBooked;
    }

    public int getCovers() {
        return covers;
    }

    public void setCovers(int covers) {
        this.covers = covers;
    }

    public DailySales(){

    }
}
