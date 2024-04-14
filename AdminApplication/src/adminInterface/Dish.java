package adminInterface;
import java.util.List;
import java.util.ArrayList;
//3
public class Dish {
    private String name;
    private double price;
    private String description;
    private List<String> allergens;

    protected Dish(String n) {
        this.name = n;
        this.price = 0.0;
        this.description = "";
        this.allergens = new ArrayList<>();
    }

    protected Dish(String n, double p, String d) {
        this.name = n;
        this.price = p;
        this.description = d;
        this.allergens = new ArrayList<>();
    }

    protected Dish(String n, double p, String d, List<String> a) {
        this.name = n;
        this.price = p;
        this.description = d;
        this.allergens = a;
    }

    public List<String> getAllergens() {
        return allergens;
    }

    protected void setAllergens(List<String> allergens) {
        this.allergens = allergens;
    }

    protected void addAllergen(String allergen){allergens.add(allergen);}


    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return description;
    }

    protected void setDesc(String desc) {
        this.description = desc;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }


}