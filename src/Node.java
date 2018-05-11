import java.util.ArrayList;

class Node{

    public final String taskID;
    public double g_scores;
    public double h_scores=0;
    public double f_scores = 0;
    public ArrayList<Edge> adjacencies;
    public Node parent;
    public String elementName;
    public String skill;
    public int performance;

    //hval será a soma do custo dos desempenhos nas tarefas já alocadas

    public Node(String taskID, String elementName, String skill, int performance){
        this.taskID = taskID;
        this.elementName = elementName;
        this.skill = skill;
        this.performance = performance;
        this.adjacencies = new ArrayList<Edge>();
    }

    public String toString(){
            return taskID;
    }
    
    public void buildAdjacencies(ArrayList<Node> nodes, ArrayList<Task> tasks, ArrayList<Element> elements){
    	
        for(int i=0; i < tasks.size();i++){
        	
        	if(tasks.get(i).getTaskID().equals(this.taskID)) {
        		
        		for(int j=0; j < tasks.get(i).getPrecedences().size(); j++) {
        			for(int k=0; k < nodes.size(); k++) {

        				if(nodes.get(k).taskID.equals(tasks.get(i).getPrecedences().get(j))) {
        					Edge newEdge = new Edge(this, this.performance);
        					nodes.get(k).adjacencies.add(newEdge);
        					System.out.println("NODE: " + this.taskID);
                        	System.out.println("PRECEDENCES OF NODE: " + nodes.get(k).taskID);
                        	System.out.println("SKILL: " + this.skill);
                        	System.out.println("ELEMENT NAME: " + this.elementName);
                        	System.out.println("PRECEDENCES ELEMENT NAME: " + nodes.get(k).elementName);
        					System.out.println("PRECEDENCE PERFORMANCE: " + nodes.get(k).performance);
                        	System.out.println();

        				}
        			}
        		}
        	}
        }
    }
    

}
