import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Comparator;
import java.util.ArrayList;


public class Algorithms{

  public HashMap<String,String> allocatedResources = new HashMap<String,String>();
  public ArrayList<String> tasksToAllocate = new ArrayList<String>();

    public static void Algorithm(Node source, Node goal, int algorithmType){

            Set<Node> explored = new HashSet<Node>();

            PriorityQueue<Node> queue = new PriorityQueue<Node>(20,new Comparator<Node>(){
                             //override compare method
             public int compare(Node i, Node j){
                if(i.f_scores > j.f_scores){
                    return 1;
                }

                else if (i.f_scores < j.f_scores){
                    return -1;
                }

                else{
                    return 0;
                }
             }

                    }
                    );

            //cost from start
            source.g_scores = 0;

            queue.add(source);

            boolean found = false;

            while((!queue.isEmpty())&&(!found)){

                    //the node in having the lowest f_score value
                    Node current = queue.poll();
                    //guloso g = 0
                    //custo uniforme h= 0
                    explored.add(current);

                    //goal found
                    if(current.taskID.equals(goal.taskID)){
                            found = true;
                    }

                    //check every child of current node
                    for(Edge e : current.adjacencies){
                            Node child = e.targetNode;
                            double cost = e.performance;
                            double temp_g_scores = current.g_scores + cost;
                            double temp_f_scores;
                            if(algorithmType==0)
                            	temp_f_scores = temp_g_scores + child.performance_h;
                            else if(algorithmType == 1)
                            	temp_f_scores = child.performance_h;
                            else
                            	temp_f_scores = temp_g_scores;


                            /*if child node has been evaluated and
                            the newer f_score is higher, skip*/

                            if((explored.contains(child)) &&
                                    (temp_f_scores >= child.f_scores)){
                                    continue;
                            }

                            /*else if child node is not in queue or
                            newer f_score is lower*/

                            else if((!queue.contains(child)) ||
                                    (temp_f_scores < child.f_scores)){

                                    child.parent = current;
                                    if(algorithmType == 0)
                                    	child.g_scores = temp_g_scores;
                                    
                                    child.f_scores = temp_f_scores;

                                    if(queue.contains(child)){
                                            queue.remove(child);
                                    }

                                    queue.add(child);

                            }

                    }

            }

    }

}
