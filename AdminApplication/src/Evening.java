import java.util.ArrayList;
import java.util.List;

public class Evening {
    private int numberOfTables;
    private String tableLayoutPath;
    private List<Waiter> waiters;

    public Evening(int numberOfTables, String tableLayoutPath){
        this.numberOfTables = numberOfTables;
        this.tableLayoutPath = "data/images/tablePlans/Table.png";
        this.waiters = new ArrayList<>();
    }

    public void assignWaiter(Waiter waiter){
        waiters.add(waiter);
        waiter.setAssignedEvening(this);
    }

    public int getNumberOfTables(){
        return numberOfTables;
    }
    public void setNumberOfTables(int numberOfTables){
        this.numberOfTables = numberOfTables;
    }

    public String getTableLayoutPath(){
        return tableLayoutPath;
    }
    public void setTableLayoutPath(String tableLayoutPath){
        this.tableLayoutPath = tableLayoutPath;
    }

    public List<Waiter> getWaiters(){
        return waiters;
    }

}
