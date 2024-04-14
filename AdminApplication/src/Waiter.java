public class Waiter extends StaffMember{
    private Evening assignedEvening;
    public Waiter(String name, int staffId) {
        super(name, staffId);
    }

    public Evening getAssignedEvening() {
        return assignedEvening;
    }
    public void setAssignedEvening(Evening assignedEvening) {
        this.assignedEvening = assignedEvening;
    }

}
