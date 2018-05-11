
import java.util.ArrayList;

public class Task {

    private String taskID;
    private int nrOfPeople;
    private String skill;
    private ArrayList<String> precedences = new ArrayList<String>();

    public Task(String taskID, int nrOfPeople, String skill, ArrayList<String> precedences){
        this.taskID= taskID;
        this.nrOfPeople= nrOfPeople;
        this.skill=skill;

        for(int i = 0; i < precedences.size(); i++)
            this.precedences.add(precedences.get(i));

    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public int getNrOfPeople() {
        return nrOfPeople;
    }

    public void setNrOfPeople(int nrOfPeople) {
        this.nrOfPeople = nrOfPeople;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public ArrayList<String> getPrecedences() {
        return precedences;
    }

    public void setPrecedences(ArrayList<String> precedences) {
        this.precedences = precedences;
    }
}