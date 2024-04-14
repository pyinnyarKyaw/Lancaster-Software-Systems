package adminInterface;
//6
public class Wine {
    private String name;
    protected Wine(String n) {
        this.name = n;
    }
    public String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name = name;
    }


}
