import java.util.ArrayList;

class Node{

    public final String taskID;
    public double g_scores;
    public double h_scores=0;
    public double f_scores = 0;
    public ArrayList<Edge> adjacencies;
    public Node parent;
    public ArrayList<String> elementsNames;
    public String skill;
    public double performance_h;

    public Node(String taskID, ArrayList<String> elementsNames, String skill, double performance){
        this.taskID = taskID;
        this.elementsNames = new ArrayList<String>();
        
        for(int i = 0; i < elementsNames.size(); i++) {
            this.elementsNames.add(elementsNames.get(i));
        }
        
        this.skill = skill;
        this.performance_h = performance;
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
        					Edge newEdge = new Edge(this, this.performance_h);
        					nodes.get(k).adjacencies.add(newEdge);
        					System.out.println("NODE: " + this.taskID);
                        	System.out.println("PRECEDENCES OF NODE: " + nodes.get(k).taskID);
                        	System.out.println("SKILL: " + this.skill);
                        	for(int l=0; l < this.elementsNames.size(); l++)
                        		System.out.println("ELEMENT NAME: " + this.elementsNames.get(l));
                        	for(int t=0; t < nodes.get(k).elementsNames.size(); t++)
                        		System.out.println("PRECEDENCES ELEMENT NAME: " + nodes.get(k).elementsNames.get(t));
        					System.out.println("PRECEDENCE PERFORMANCE: " + nodes.get(k).performance_h);
                        	System.out.println();

        				}
        			}
        		}
        	}
        }
    }
    
   public static ArrayList<Node> allPossibleAllocations(ArrayList<Task> tasks, ArrayList<Element> elements) {
    	
        ArrayList<Node> nodes = new ArrayList<Node>();
    	
    	for(int i = 0; i < tasks.size(); i++) {
    		
    		ArrayList<Element> taskElements = new ArrayList<Element>(); 
    		
    		for(int j = 0; j < elements.size(); j++) {
    			
    			for(int k = 0; k < elements.get(j).getSkills().size(); k++) {
    				
    				if(tasks.get(i).getSkill().equals(elements.get(j).getSkills().get(k))) {
    					taskElements.add(elements.get(j));
        			}
    			}
    		}
    		
    		ArrayList<Integer> combination = Combination.combination(taskElements.toArray(), tasks.get(i).getNrOfPeople());
    		
    		if(combination == null)
    			return null;
    		
    		for(int t = 0; t < combination.size(); t++) {
				ArrayList<String> elementsNames = new ArrayList<String>(); 
				double performanceGroup = 0.0;
				for(int f = 0; f < tasks.get(i).getNrOfPeople(); f++) {
					elementsNames.add(taskElements.get(combination.get(t + f)).getElementName());
					performanceGroup += taskElements.get(combination.get(t + f)).getPerformance(tasks.get(i).getSkill());
				}
				t += tasks.get(i).getNrOfPeople() -1;
				performanceGroup = performanceGroup / elementsNames.size();
	    		nodes.add(new Node(tasks.get(i).getTaskID(),elementsNames, tasks.get(i).getSkill(), performanceGroup));
	    		System.out.println("TASK: " + tasks.get(i).getTaskID());
	        	System.out.println("SKILL OF TASK: " + tasks.get(i).getSkill());
	        	System.out.println("PERFORMANCE ELEMENT: " + performanceGroup);
	        	for(int f = 0; f < elementsNames.size(); f++) {
	        		System.out.println("ELEMENT NAME: " + elementsNames.get(f) + "\n");
	        	}
    		}
    		

    	}
    	
    	return nodes;
    }
    
    

}
