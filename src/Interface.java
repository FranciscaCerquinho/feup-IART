import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Interface {

    public ArrayList<Task> tasks;
    public ArrayList<Element> elements;
    public ArrayList<Node> nodes;
    public Node initialNode;
    public Node finalNode;


    public Interface(ArrayList<Task> t,  ArrayList<Element> e){
        
        tasks =t;
        elements = e;

        getNodesAndEdges();
        if(menuOptions())
            return;
    }


    public void getNodesAndEdges(){
        System.out.println("Nodes:\n");
        nodes = Node.allPossibleAllocations(tasks, elements);
        
        if(nodes == null)
            return;
        
        System.out.println("\nEdges:\n");
        for(int i = 0; i < nodes.size(); i++) {
            nodes.get(i).buildAdjacencies(nodes, tasks, elements);
        }
        
        initialNode = new Node("T0",new ArrayList<String>(),"",0);
        
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getPrecedences().isEmpty()) {
                for(int j = 0; j < nodes.size(); j++) {
                    if(nodes.get(j).taskID.equals(tasks.get(i).getTaskID())) {
                           Edge edge = new Edge(nodes.get(j),0);
                        initialNode.adjacencies.add(edge); 
                    } 
                }
            }
              
        }
        
        finalNode = null;
        
        for(int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).adjacencies.isEmpty()) {
                System.out.println("Final NODE: " + nodes.get(i).taskID);
                finalNode = nodes.get(i);
            } 
        }
    }

    public boolean menuOptions(){
        boolean quit = false;

        while(!quit) {
            System.out.println();
            System.out.println("Choose the Alghorithm: ");
            System.out.println();
            System.out.println("Astar Alghorithm - 1");
            System.out.println("Uniform Cost - 2");
            System.out.println("Greedy Alghorithm - 3");
            System.out.println("Breadth First Search Alghorithm - 4");
            System.out.println("Exit - 5");
            System.out.println();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int option = 0;
            try{
                option = Integer.parseInt(br.readLine());
                if(option <= 0 || option > 5) throw new NumberFormatException();
            }catch(NumberFormatException nfe){
                System.out.println();
                System.err.println("Invalid Format! Value must be integer in the range of 1 to 5");
                continue;
            }catch (IOException e) {
                System.out.println();
                System.err.println("Unexpected error");
                continue;
            }
            System.out.println();

            if(option == 1)
                Algorithms.Algorithm(initialNode, finalNode, 0);
            if(option == 2)
                Algorithms.Algorithm(initialNode, finalNode, 2);
            if(option == 3)
                Algorithms.Algorithm(initialNode, finalNode, 1);
            if(option == 4)
                BreadthFirstSearch.AlgorithmBreadthFirstSearch(initialNode, finalNode);
            if(option == 5)
                quit=true;
            if(option !=5){
                List<Node> path = printPath(finalNode);

                System.out.println("Path: " + path);
                
                for(int i = 0; i < path.size(); i++) {
                    System.out.println("TASKID: " + path.get(i).taskID);
                    for(int j = 0; j < path.get(i).elementsNames.size(); j++)
                        System.out.println("ELEMENT: "+ path.get(i).elementsNames.get(j));
                }
            }
        }

        return true;
    }
    public static ArrayList<Task> readFromFileTask(String filename){

        String line;
        String[] task;
        String taskID;
        int nrOfPeople;
        String skill;
        ArrayList<String> precedences = new ArrayList<String>();
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
            taskID = task[0];
            nrOfPeople = Integer.parseInt(task[1]);
            skill = task[2];
            precedencesAux = task[3];

            beginIndex = precedencesAux.indexOf('[');
            endIndex = precedencesAux.indexOf(']');

            precedencesAux=precedencesAux.substring(beginIndex+1, endIndex);

            precedencesAux2 = precedencesAux.split(",");
            if(!precedencesAux2[0].isEmpty()){
            for(int i=0; i < precedencesAux2.length;i++){
                precedences.add(precedencesAux2[i]);
            }
        }

            finalTask = new Task(taskID, nrOfPeople, skill, precedences);

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

    public static List<Node> printPath(Node target){
        List<Node> path = new ArrayList<Node>();

        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args){

        String taskFile= args[0];
        String elementsFile=args[1];
  
        ArrayList<Task> tasks= readFromFileTask(taskFile);
        ArrayList<Element> elements= readFromFileElement(elementsFile);
        
        Interface start = new Interface(tasks,elements);
            
    }
  
}
