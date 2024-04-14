public class StaffMember {
    private String name;
    private int staffId;
    private boolean onHoliday;

    public StaffMember (String name, int staffId){
        this.name = name;
        this.staffId = staffId;
        this.onHoliday = false;
    }

    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }

    public int getStaffId(){
        return staffId;
    }
    public void setStaffId(){
        this.staffId = staffId;
    }

    public boolean getOnHoliday(){
        return onHoliday;
    }
    public void setOnHoliday(){
        onHoliday = onHoliday;
    }
}
