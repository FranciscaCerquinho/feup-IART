import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * basic breadth first search in java
 */
public class BreadthFirstSearch {

    static Node startNode2;
    static Node goalNode2;

    public static void AlgorithmBreadthFirstSearch(Node startNode, Node goalNode){
        if(startNode.equals(goalNode)){
            System.out.println("Goal Node Found!");
            System.out.println(startNode);
        }

        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> explored = new ArrayList<>();
        queue.add(startNode);
        explored.add(startNode);
        Node child ;

        while(!queue.isEmpty()){
            Node current = queue.remove();
        
            if(current.equals(goalNode)) {
              //  System.out.println(explored);
            }
            else{
                if(current.adjacencies.isEmpty()) {
                    continue;
                }
                else {
           
                	for(int i = 0; i < current.adjacencies.size(); i++) {     
                        child= current.adjacencies.get(i).targetNode;            
                        queue.add(current.adjacencies.get(i).targetNode);
                        child.parent=current;
                	}

                }
            }
            explored.add(current);
      
        }
    }
    
    public static void main(String[] args){

        String taskFile= args[0];
        String elementsFile=args[1];

        ArrayList<Task> tasks= Interface.readFromFileTask(taskFile);
        ArrayList<Element> elements= Interface.readFromFileElement(elementsFile);
        
        System.out.println("Nodes:\n");
        ArrayList<Node> nodes = Node.allPossibleAllocations(tasks, elements);
        
        if(nodes == null)
      	  return;
        
        System.out.println("\nEdges:\n");
        for(int i = 0; i < nodes.size(); i++) {
      	  nodes.get(i).buildAdjacencies(nodes, tasks, elements);
        }
        
        Node initialNode = new Node("T0",new ArrayList<String>(),"",0);
        
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
        
  	  Node finalNode = null;
        
  	  for(int i = 0; i < nodes.size(); i++) {
  		  if(nodes.get(i).adjacencies.isEmpty()) {
  			  System.out.println("Final NODE: " + nodes.get(i).taskID);
  			  finalNode = nodes.get(i);
  		  } 
  	  }
        

       AlgorithmBreadthFirstSearch(initialNode,finalNode);
       System.out.println();
       System.out.println("Algorithm Breadth First Search:");
       System.out.println();
        List<Node> path = printPath(finalNode);

        System.out.println("Path: " + path);
        
        for(int i = 0; i < path.size(); i++) {
      	  System.out.println("TASKID: " + path.get(i).taskID);
      	  for(int j = 0; j < path.get(i).elementsNames.size(); j++)
      		  System.out.println("ELEMENT: "+ path.get(i).elementsNames.get(j));
        }

      }
    

	public static List<Node> printPath(Node target){
              List<Node> path = new ArrayList<Node>();

           
      for(Node node = target; node!=null; node = node.parent){
          path.add(node);
      }

      Collections.reverse(path);

      return path;
      }

}