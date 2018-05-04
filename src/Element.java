
import java.util.ArrayList;

public class Element {

    private String elementName;
    private ArrayList<String> skills = new ArrayList<String>();
    private ArrayList<Integer> performances = new ArrayList<Integer>();

    public Element(String elementName, ArrayList<String> skills, ArrayList<Integer> performances){
        this.elementName=elementName;

        for(int i = 0; i < skills.size(); i++)
            this.skills.add(skills.get(i));

        for(int i = 0; i < performances.size(); i++)
            this.performances.add(performances.get(i));

    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public ArrayList<Integer> getPerformances() {
        return performances;
    }

    public void setPerformances(ArrayList<Integer> performances) {
        this.performances = performances;
    }
}
