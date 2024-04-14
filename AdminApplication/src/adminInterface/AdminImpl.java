package adminInterface;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
//1

public class AdminImpl extends Object implements I_Admin {

    public AdminImpl() {

    }

    private DatabaseManager dbManager = new DatabaseManager();

    @Override
    public List<Dish> getDishDetails() {
        List<Dish> dishes = new ArrayList<>();

        String sql = "SELECT DishName, DishDescr, Price FROM Dish";

        try {
            ResultSet rs = dbManager.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("DishName");
                double price = rs.getDouble("Price");
                String description = rs.getString("DishDescr");


                Dish dish = new Dish(name, price, description, new ArrayList<>());
                dishes.add(dish);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return dishes;
    }


    @Override
    public Menu getMenu() {


        try {

            String sql = "SELECT " +
                    "D.DishID, " +
                    "D.DishName, " +
                    "D.DishDescr, " +
                    "D.Price, " +
                    "D.WineName, " +
                    "A.AllergenName " +
                    "FROM Dish D " +
                    "JOIN Allergen A ON D.DishID = A.DishID " +
                    "WHERE D.MenuID = 1";
            // Replace with (SELECT MAX(menuID) FROM Dish) when there are more menus in the database



            ResultSet rs = dbManager.executeQuery(sql);

            if (!rs.next()) {
                return null; // No menu found
            }

            List<Dish> dishes = new ArrayList<>();
            HashMap<Dish, Wine> wineRecommendations = new HashMap<>();
            Map<Integer, Dish>  dishMap = new HashMap<>();


            do {
                Integer dishID = rs.getInt("DishID");
                String allergen = null;

                if (!dishMap.containsKey(dishID)) {
                    String name = rs.getString("DishName");
                    double price = rs.getDouble("Price");
                    String description = rs.getString("DishDescr");
                    List<String> allergens = new ArrayList<>();
                    if (rs.getString("AllergenName") != null) {
                        allergen = rs.getString("AllergenName");
                        allergens.add(allergen);
                    }
                    String wine = rs.getString("WineName");
                    Dish dish = new Dish(name, price, description, allergens);
                    dishMap.put(dishID, dish);
                    wineRecommendations.put(dish, new Wine(wine));
                } else {
                    allergen = rs.getString("AllergenName");
                    dishMap.get(dishID).addAllergen(allergen);
                }
            } while (rs.next());

            for (Integer id: dishMap.keySet()) {
                dishes.add(dishMap.get(id));
            }

            sql = "SELECT StartDate FROM `Menu` WHERE MenuID = 1;";

            try {
                rs = dbManager.executeQuery(sql);
                rs.next();
                String startDate = rs.getString("StartDate");
                return new Menu(startDate, dishes, wineRecommendations);
            }
            catch (SQLException e){
                e.printStackTrace();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }




    }

    @Override
    public HashMap<Dish, Wine> WineRecommendations() {

        HashMap<Dish, Wine> wineRecommendations = new HashMap<>();
        String sql = "SELECT DishName, DishDescr, Price, Allergen, WineName FROM MenuDishAllergen WHERE WineName IS NOT NULL";

        try {
            ResultSet rs = dbManager.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("DishName");
                double price = rs.getDouble("Price");
                String description = rs.getString("DishDescr");
                String wineName = rs.getString("WineName");
                List<String> allergens = new ArrayList<>();
                if (rs.getString("Allergen") != null) {
                    for (String allergen : rs.getString("Allergen").split(",")) {
                        allergens.add(allergen.trim());
                    }
                }

                Dish dish = new Dish(name, price, description, allergens);
                Wine wine = new Wine(wineName);
                wineRecommendations.put(dish, wine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return wineRecommendations;
    }

    @Override
    public String getMenuStatus(){
        String sql = "SELECT Status FROM Menu ORDER BY StartDate DESC LIMIT 1";
        try (

                ResultSet rs = dbManager.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getString("Status");
            } else {
                return "No menus found";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error retrieving menu status";
        }

    }

    @Override
    public List<List<String>> updateInventory(){
        List<List<String>> inventoryUpdates = new ArrayList<>();
        String sql = "SELECT ItemName, Quantity FROM deliveryItems " +
                "WHERE orderDate = (SELECT MAX(orderDate) FROM deliveryItems)";

        try (
                ResultSet rs = dbManager.executeQuery(sql)) {

            if (!rs.next()) {
                return null;
            }




            do {
                List<String> itemDetails = new ArrayList<>();
                itemDetails.add(rs.getString("ItemName"));
                itemDetails.add(rs.getString("Quantity"));

                inventoryUpdates.add(itemDetails);
            } while (rs.next());

            return inventoryUpdates;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }




    }



    @Override
    public HashMap<String, String> getRole(int staffId) {
        String sql = "SELECT StaffName, StaffRole FROM Staff WHERE StaffID = " + staffId;
        try (ResultSet rs = dbManager.executeQuery(sql)) {
            if (rs.next()) {
                String name = rs.getString("StaffName");
                String role =  rs.getString("StaffRole");
                HashMap<String, String> map = new HashMap<>();
                map.put(name, role);
                return map;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }








//
//    public static void main(String[] args) {
////        AdminImpl admin = new AdminImpl();
////        List<Dish> dishes = admin.getDishDetails();
////
////        for (Dish dish : dishes) {
////            System.out.println("Dish Name: " + dish.getName());
////            System.out.println("Description: " + dish.getDesc());
////            System.out.println("Price: " + dish.getPrice());
////            System.out.println("----------------------------------");
////        }
////    }
//    }

//        public static void main(String[] args) {
//            AdminImpl admin = new AdminImpl();
//            Menu menu = admin.getMenu();
//
//            if (menu == null) {
//                System.out.println("No menu found or failed to retrieve menu.");
//                return;
//            }
//
//            // Print the start date of the menu
//            System.out.println("Menu Start Date: " + menu.getStartDate());
//
//            // Print details of each dish in the menu
//            for (Dish dish : menu.getDishDetails()) {
//                System.out.println("\nDish Name: " + dish.getName());
//                System.out.println("Description: " + dish.getDesc());
//                System.out.println("Price: £" + dish.getPrice());
//                System.out.print("Allergens: ");
//                if (dish.getAllergens().isEmpty()) {
//                    System.out.println("None");
//                } else {
//                    System.out.println(String.join(", ", dish.getAllergens()));
//                }
//            }
//        }

//    public static void main(String[] args) {
//        AdminImpl admin = new AdminImpl();
//        HashMap<Dish, Wine> wineRecommendations = admin.WineRecommendations();
//
//        if (wineRecommendations == null || wineRecommendations.isEmpty()) {
//            System.out.println("No wine recommendations found or failed to retrieve data.");
//            return;
//        }
//
//
//        System.out.println("Wine Recommendations:");
//        for (Map.Entry<Dish, Wine> entry : wineRecommendations.entrySet()) {
//            Dish dish = entry.getKey();
//            Wine wine = entry.getValue();
//            System.out.println("\nDish: " + dish.getName());
//            System.out.println("Description: " + dish.getDesc());
//            System.out.println("Price: $" + dish.getPrice());
//            System.out.print("Allergens: " + (dish.getAllergens().isEmpty() ? "None" : String.join(", ", dish.getAllergens())));
//            System.out.println(" Recommended Wine: " + wine.getName());
//        }
//    }

//    public static void main(String[] args) {
//        AdminImpl admin = new AdminImpl();
//        String menuStatus = admin.getMenuStatus();
//
//        // Print the retrieved status of the most recently uploaded menu
//        System.out.println("The status of the most recently uploaded menu is: " + menuStatus);
//    }

    //    public static void main(String[] args) {
//        AdminImpl admin = new AdminImpl();
//
//        Menu menu = admin.getMenu();
//
//        System.out.println("Menu start date:");
//        System.out.println(menu.getStartDate());
//        List<Dish> dishes = menu.getDishDetails();
//
//        System.out.println();
//
//        System.out.println("Dishes from menu:");
//        for(Dish dish:dishes){
//            System.out.println(dish.getName());
//            System.out.println(dish.getDesc());
//            System.out.println(dish.getPrice());
//            System.out.println(dish.getAllergens());
//        }
//
//        HashMap<Dish, Wine> dishWineHashMap = menu.getWineRecommendations();
//
//        System.out.println("Dish and wines:");
//        for (Dish dish: dishWineHashMap.keySet()) {
//            System.out.println(dish.getName());
//            System.out.println(dishWineHashMap.get(dish).getName());
//            System.out.println();
//        }
//
//        List<List<String>> inventoryUpdates = admin.updateInventory();
//
//        if (inventoryUpdates == null) {
//            System.out.println("No recent deliveries found or already added to the inventory.");
//        } else {
//            System.out.println("Recent Inventory Updates:");
//            for (List<String> itemDetails : inventoryUpdates) {
//                System.out.println("Item: " + itemDetails.get(0) + ", Quantity: " + itemDetails.get(1));
//            }
//        }
//    }
    public static void main(String[] args) {
        AdminImpl admin = new AdminImpl();
        int staffId = 106;  // Example StaffID
        HashMap<String, String> map = admin.getRole(staffId);
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("Staff id: " + staffId);
            System.out.println("Name : " + entry.getKey());
            System.out.println("Role : "+ entry.getValue());
        }
    }

}