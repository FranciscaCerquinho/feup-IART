
public class Task {

    private int taskID;
    private int nrOfPeople;
    private int nrOfMonths;
    private String skill;
    private ArrayList<Integer> precedences = new ArrayList();

    public Task(int taskID, int nrOfPeople, int nrOfMonths, String skill, ArrayList<Integer> precedences){
        this.taskID= taskID;
        this.nrOfPeople= nrOfPeople;
        this.nrOfMonths=nrOfMonths;
        this.skill=skill;
        this.precedences=precedences;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getNrOfPeople() {
        return nrOfPeople;
    }

    public void setNrOfPeople(int nrOfPeople) {
        this.nrOfPeople = nrOfPeople;
    }

    public int getNrOfMonths() {
        return nrOfMonths;
    }
    
    public void setNrOfMonths(int nrOfMonths) {
        this.nrOfMonths = nrOfMonths;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public ArrayList<Integer> getPrecedences() {
        return precedences;
    }

    public void setPrecedences(ArrayList<Integer> precedences) {
        this.precedences = precedences;
    }
}