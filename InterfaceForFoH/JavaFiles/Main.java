package adminInterface;
import java.util.List;

/**
 * @author : Pyinnyar Kyaw, Niriksha Pelman, Zaynab Choudhry
 * @version : 1.0.0
 */

class Main {
    public static void main(String[]args){
        I_Admin admin =new AdminImpl();
        //  Test Wine Recommendations
        System.out.println("Wine Recommendations");
        List<List<String>> wineRecommendations= admin.WineRecommendations();
        printList(wineRecommendations);

        //  Test Dish Details
        System.out.println("\n" + "Dish Details");
        List<List<String>> dishDetails= admin.getDishDetails();
        printList(dishDetails);

        //  Test Weekly Menu
        System.out.println("\n" + "Weekly Menu " + admin.getMenu().getName());
    }

    private static void printList(List<List<String>> list) {
        for (List<String> dish: list){
            System.out.println(dish);
        }
    }

}