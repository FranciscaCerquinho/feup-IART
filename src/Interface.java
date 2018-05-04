import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Interface {

    public Interface() {}

    public static ArrayList<Task> readFromFileTask(String filename){

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

            precedencesAux=precedencesAux.substring(beginIndex+1, endIndex);

            precedencesAux2 = precedencesAux.split(",");
            if(!precedencesAux2[0].isEmpty()){
            for(int i=0; i < precedencesAux2.length;i++){
                precedences.add(Integer.parseInt(precedencesAux2[i]));
            }
        }

            finalTask = new Task(taskID, nrOfPeople, nrOfMonths, skill, precedences);

            listOfTasks.add(finalTask);
            precedences.clear();
            line = bufferreader.readLine();
        }
        bufferreader.close();
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
        return listOfTasks;
    }

    public static ArrayList<Element> readFromFileElement(String filename){

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

        BufferedReader bufferreader2 = new BufferedReader(new FileReader(filename));
        line = bufferreader2.readLine();

        int skillsBeginIndex, skillsEndIndex, performancesBeginIndex, performancesEndIndex;

        while (line != null) {

            element = line.split(";");
            elementName = element[0];
            skillsAux = element[1];
            performancesAux =element[2];

            skillsBeginIndex = skillsAux.indexOf('[');
            skillsEndIndex = skillsAux.indexOf(']');

            skillsAux=skillsAux.substring(skillsBeginIndex+1, skillsEndIndex);

            skillsAux2 = skillsAux.split(",");
            if(!skillsAux2[0].isEmpty()){
            for(int i=0; i < skillsAux2.length;i++){
                skills.add(skillsAux2[i]);
            }
            }

            performancesBeginIndex = performancesAux.indexOf('[');
            performancesEndIndex = performancesAux.indexOf(']');

            performancesAux=performancesAux.substring(performancesBeginIndex+1, performancesEndIndex);

            performancesAux2 = performancesAux.split(",");
            if(!performancesAux2[0].isEmpty()){
            for(int i=0; i < performancesAux2.length;i++){
                performances.add(Integer.parseInt(performancesAux2[i]));
            }
            }
            if(performances.size()!=skills.size()){
                System.out.println("Performances size doesn't match to skills size, check your file!");
                return null;
            }

            finalElement = new Element(elementName, skills, performances);

            listOfElements.add(finalElement);
            performances.clear();
            skills.clear();
            line = bufferreader2.readLine();
        }
        bufferreader2.close();
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
        return listOfElements;
    }
}
