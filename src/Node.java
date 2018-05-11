class Node{

    public final String value;
    public double g_scores;
    public double h_scores=0;
    public double f_scores = 0;
    public Edge[] adjacencies;
    public Node parent;
    public String name;

    //hval será a soma do custo dos desempenhos nas tarefas já alocadas
    public Node(String val, double hVal){
        value = val;
        h_scores = hVal;
    }

    public Node(String val, String name){
        value = val;
        this.name = name;
    }

    public String toString(){
            return value;
    }
    
    public ArrayList<Node>

}
