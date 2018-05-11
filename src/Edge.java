import java.util.ArrayList;
class Edge{
    public final double performance;
    public final Node targetNode;

    public Edge(Node targetNode, double costPerformance){
            this.targetNode = targetNode;
            performance = costPerformance;
    }
    
    public static ArrayList<Node> allPossibleAllocations(ArrayList<Task> tasks, ArrayList<Element> elements) {
    	
        ArrayList<Node> nodes = new ArrayList<Node>();
    	
    	for(int i = 0; i < tasks.size(); i++) {
    		    		
    		for(int j = 0; j < elements.size(); j++) {
    			
    			for(int k = 0; k < elements.get(j).getSkills().size(); k++) {
    				
    				if(tasks.get(i).getSkill().equals(elements.get(j).getSkills().get(k))) {
        	    		nodes.add(new Node(tasks.get(i).getTaskID(),elements.get(j).getElementName(), tasks.get(i).getSkill(), elements.get(j).getPerformances().get(k)));
        	    		System.out.println("TASK: " + tasks.get(i).getTaskID());
                    	System.out.println("SKILL OF TASK: " + tasks.get(i).getSkill());
                    	System.out.println("ELEMENT: " + elements.get(j).getElementName());
                    	System.out.println("PERFORMANCE ELEMENT: " + elements.get(j).getPerformances().get(k) + "\n");
        			}
    			}
    			
    		}
    		
    	}
    	
    	return nodes;
    }
    

}
