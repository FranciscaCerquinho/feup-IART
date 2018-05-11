import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class Astar{

  public HashMap<String,String> allocatedResources = new HashMap<String,String>();
  public ArrayList<String> tasksToAllocate = new ArrayList<String>();

  public static void main(String[] args){

      String taskFile= args[0];
      String elementsFile=args[1];

      ArrayList<Task> tasks= Interface.readFromFileTask(taskFile);
      ArrayList<Element> elements= Interface.readFromFileElement(elementsFile);
      
      System.out.println("Nodes:\n");
      ArrayList<Node> nodes = Edge.allPossibleAllocations(tasks, elements);
      
      
      System.out.println("\nEdges:\n");
      for(int i = 0; i < nodes.size(); i++) {
    	  nodes.get(i).buildAdjacencies(nodes, tasks, elements);
      }
      
      Node initialNode = new Node("T0","","",0);
      
      for(int i = 0; i < tasks.size(); i++) {
    	  if(tasks.get(i).getPrecedences().isEmpty()) {
    		  for(int j = 0; j < nodes.size(); j++) {
    			  if(nodes.get(j).taskID.equals(tasks.get(i).getTaskID())) {
    				  
    				  System.out.println("INITIAL NODE PRECEDENCE: " + nodes.get(i).taskID);
            		  Edge edge = new Edge(nodes.get(i),0);
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
      
      //AstarSearch(n1,n13);

      //List<Node> path = printPath(n13);

      //System.out.println("Path: " + path);

    }

    public static List<Node> printPath(Node target){
            List<Node> path = new ArrayList<Node>();

    for(Node node = target; node!=null; node = node.parent){
        path.add(node);
    }

    Collections.reverse(path);

    return path;
    }

    public static void AstarSearch(Node source, Node goal){
//
//            Set<Node> explored = new HashSet<Node>();
//
//            PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
//                    new Comparator<Node>(){
//                             //override compare method
//             public int compare(Node i, Node j){
//                if(i.f_scores > j.f_scores){
//                    return 1;
//                }
//
//                else if (i.f_scores < j.f_scores){
//                    return -1;
//                }
//
//                else{
//                    return 0;
//                }
//             }
//
//                    }
//                    );
//
//            //cost from start
//            source.g_scores = 0;
//
//            queue.add(source);
//
//            boolean found = false;
//
//            while((!queue.isEmpty())&&(!found)){
//
//                    //the node in having the lowest f_score value
//                    Node current = queue.poll();
//
//                    explored.add(current);
//
//                    //goal found
//                    if(current.value.equals(goal.value)){
//                            found = true;
//                    }
//
//                    //check every child of current node
//                    for(Edge e : current.adjacencies){
//                            Node child = e.target;
//                            double cost = e.performance;
//                            double temp_g_scores = current.g_scores + cost;
//                            double temp_f_scores = temp_g_scores + child.h_scores;
//
//
//                            /*if child node has been evaluated and
//                            the newer f_score is higher, skip*/
//
//                            if((explored.contains(child)) &&
//                                    (temp_f_scores >= child.f_scores)){
//                                    continue;
//                            }
//
//                            /*else if child node is not in queue or
//                            newer f_score is lower*/
//
//                            else if((!queue.contains(child)) ||
//                                    (temp_f_scores < child.f_scores)){
//
//                                    child.parent = current;
//                                    child.g_scores = temp_g_scores;
//                                    child.f_scores = temp_f_scores;
//
//                                    if(queue.contains(child)){
//                                            queue.remove(child);
//                                    }
//
//                                    queue.add(child);
//
//                            }
//
//                    }
//
//            }

    }

}
