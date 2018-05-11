import java.util.ArrayList;
class Edge{
    public final double performance;
    public final Node targetNode;

    public Edge(Node targetNode, double costPerformance){
            this.targetNode = targetNode;
            this.performance = costPerformance;
    }
 

}
