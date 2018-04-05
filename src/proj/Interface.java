package proj;
import java.io.*;
import java.util.ArrayList;

public class Interface {

    public Interface() {}
    
    public static void main(String[] args){
    
    String taskFile= args[0];
    String elementsFile=args[1];

    readFromFileTask(taskFile);
    readFromFileElement(elementsFile);

    }

    private static ArrayList<Task> readFromFileTask(String filename){

        String line;
        String[] task;
        int taskID;
        int nrOfPeople;
        int nrOfMonths;
        String skill;
        ArrayList<Integer> precedences = new ArrayList<Integer>();
        String precedencesAux;
        String[] precedencesAux2;
        Task finalTask;
        ArrayList<Task> listOfTasks = new ArrayList<Task>();
        try {

        BufferedReader bufferreader = new BufferedReader(new FileReader(filename));
        line = bufferreader.readLine();
        
        int beginIndex, endIndex;
  
        while (line != null) {    

            task = line.split(";");
            taskID = Integer.parseInt(task[0]);
            nrOfPeople = Integer.parseInt(task[1]);
            nrOfMonths = Integer.parseInt(task[2]);
            skill = task[3]; 
            precedencesAux = task[4];

            beginIndex = precedencesAux.indexOf('[');
            endIndex = precedencesAux.indexOf(']');

            precedencesAux.substring(beginIndex+1, endIndex);

            precedencesAux2 = precedencesAux.split(",");
            for(int i=0; i < precedencesAux2.length;i++){
                precedences.add(Integer.parseInt(precedencesAux2[i]));
            }

            finalTask = new Task(taskID, nrOfPeople, nrOfMonths, skill, precedences);
            listOfTasks.add(finalTask);

            line = bufferreader.readLine();
        }

    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
        return listOfTasks;
    } 

    private static ArrayList<Element> readFromFileElement(String filename){

        String line;
        String[] element;
        String elementName;
        ArrayList<String> skills = new ArrayList<String>();
        ArrayList<Integer> performances = new ArrayList<Integer>();
        String skillsAux;
        String performancesAux;
        String[] skillsAux2;
        String[] performancesAux2;
        Element finalElement;
        ArrayList<Element> listOfElements = new ArrayList<Element>();

        try {

        BufferedReader bufferreader = new BufferedReader(new FileReader(filename));
        line = bufferreader.readLine();
        
        int skillsBeginIndex, skillsEndIndex, performancesBeginIndex, performancesEndIndex;
  
        while (line != null) {    

            element = line.split(";");
            elementName = element[0];
            skillsAux = element[1];
            performancesAux =element[2];

            skillsBeginIndex = skillsAux.indexOf('[');
            skillsEndIndex = skillsAux.indexOf(']');

            skillsAux.substring(skillsBeginIndex+1, skillsEndIndex);

            skillsAux2 = skillsAux.split(",");
            for(int i=0; i < skillsAux2.length;i++){
                skills.add(skillsAux2[i]);
            }


            performancesBeginIndex = performancesAux.indexOf('[');
            performancesEndIndex = performancesAux.indexOf(']');

            performancesAux.substring(performancesBeginIndex+1, performancesEndIndex);

            performancesAux2 = performancesAux.split(",");
            for(int i=0; i < performancesAux2.length;i++){
                performances.add(Integer.parseInt(performancesAux2[i]));
            }

        
            finalElement = new Element(elementName, skills, performances);
            listOfElements.add(finalElement);

            line = bufferreader.readLine();
        }

    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
        return listOfElements;
    } 
}


