import java.util.ArrayList;
class Edge{
    public final double performance;
    public final Node target;

    public Edge(Node targetNode, double costPerformance){
            target = targetNode;
            performance = costPerformance;
    }


    public static ArrayList<Node> nodesList(ArrayList<Task> tasks, Task task, ArrayList<Element> elements){
 
        ArrayList<Node> nodes = new ArrayList<Node>();

        for(int i=0; i < tasks.size();i++){
          
            ArrayList<String> precedences= new ArrayList<String>();
            precedences = tasks.get(i).getPrecedences();
           
           for(int j=0; j < precedences.size();j++){
               if(precedences.get(j).equals(task.getTaskID())){
                    for(int k=0; k < elements.size();k++){
                       
                        ArrayList<String> skills = new ArrayList<String>();
                        skills = elements.get(k).getSkills();
                        for(int l=0; l < skills.size();l++){
                            if(skills.get(l).equals(task.getSkill()))
                                nodes.add(new Node(tasks.get(i).getTaskID(),elements.get(k).getElementName()));
                        }
                        
                    }
                       
               }
           }
        }
       System.out.println(nodes);
        return nodes;
    }


}
