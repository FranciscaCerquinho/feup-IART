import java.util.ArrayList;

public class Interface {

    public static void main(String[] args){
        //Tarefa;nr_pessoas;nr_meses
    
    String taskFile= args[0];
    String elementsFile=args[1];

    readFromFileTask(taskFile);
    File elementsTask = new File(elementsFile);

    }

    private static Task[] readFromFileTask(String filename){

        String line;
        String[] task;
        int taskID;
        int nrOfPeople;
        int nrOfMonths;
        String skill;
        ArrayList<Integer> precedences = new ArrayList();
        String precedencesAux;
        int[] precedencesAux2;
        Task finalTask;
        ArrayList<Task> listOfTasks = new ArrayList();
        try {

        BufferedReader bufferreader = new BufferedReader(new FileReader(filename));
        line = bufferreader.readLine();
        
        int firstIndex,secondIndex;
  
        while (line != null) {    

            task = line.split(";");
            taskID = task[0];
            nrOfPeople = task[1];
            nrOfMonths = task[2];
            skill = task[3]; 
            precedencesAux = task[4];

            beginIndex = precedencesAux.indexOf('[');
            endIndex = precedencesAux.indexOf(']');

            precedencesAux.substring(beginIndex+1, endIndex);

            precedencesAux2 = precedencesAux.split(",");
            for(int i=0; i < precedencesAux2.length;i++){
                precedences.add(precedencesAux2[i]);
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
}


