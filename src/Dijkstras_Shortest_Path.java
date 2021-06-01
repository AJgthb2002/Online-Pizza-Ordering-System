import java.util.*;

class Dijkstras_Shortest_Path
{
    double  distances[];                // to store minimum distances of all nodes
    private Set<Integer> settled;       // set containing the nodes which have been already evaluated
    private Set<Integer> unsettled;     // set containing the nodes which have not yet been evaluated
    private int  number_of_nodes;       // stores total no of nodes in graph
    private double adjacencyMatrix[][];  
    int inf = Integer.MAX_VALUE;

    public Dijkstras_Shortest_Path(int nodes)  // constructor
    {
        number_of_nodes = nodes;
        distances = new double[number_of_nodes + 1];
        settled = new HashSet<Integer>();   // searching is done in O(1)
        unsettled = new HashSet<Integer>(); // searching is done in O(1)
        adjacencyMatrix = new double[number_of_nodes + 1][number_of_nodes + 1];
    }
 
    public void dijkstra_algorithm(double adjacency_matrix[][])
    {
        int source=0;  // source is always set to 0 i.e. pizza shop
        int evaluationNode;

        // copy the adj matrix passed in as parameter to the class variable
        for (int i = 0; i <number_of_nodes; i++)
            for (int j = 0; j < number_of_nodes; j++)
                adjacencyMatrix[i][j] = adjacency_matrix[i][j];
        
        // initialize all distances to infinity
        for (int i = 0; i < number_of_nodes; i++)
        {
            distances[i] = Integer.MAX_VALUE;
        }
        
        // add the source vertex first to the unsettled set to start its evaluation
        unsettled.add(source);
        // make the distance of the node from itself =0
        distances[source] = 0;
        
        while (!unsettled.isEmpty()) // repeat loop while there are some nodes left for evaluation
        {
            evaluationNode = getNodeWithMinimumDistance();
            // after its evaluation, remove that node from unsettled and add it to settled
            unsettled.remove(evaluationNode); 
            settled.add(evaluationNode);
            // update the distances of remaining nodes from this last evaluated node
            calculateNeighbours(evaluationNode);
        }
    }
 
    private int getNodeWithMinimumDistance()
    {
        double min;
        int node = 0;
        
        // iterator for iterating over all the unsettled nodes
        Iterator<Integer> iterator = unsettled.iterator();
        node = iterator.next();
        min = distances[node];
        // update distances to all the nodes from source node and then return the node with minimum distance from source
        for (int i = 0; i < distances.length; i++)
        {
            if (unsettled.contains(i))  // check if node is not evaluated
            {
                if (distances[i] <= min)  
                {
                    min = distances[i];
                    node = i;
                }
            }
        }
        return node;
    }
 
    private void calculateNeighbours(int evaluationNode)
    {
        double edgeDist = -1;
        double newDist = -1;
 
        for (int destinationNode = 0; destinationNode < number_of_nodes; destinationNode++)
        {
            // do following steps only for those nodes which are not already evaluated
            if (!settled.contains(destinationNode))  
            {
                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)
                {
                    edgeDist = adjacencyMatrix[evaluationNode][destinationNode];
                    newDist = distances[evaluationNode] + edgeDist;
                    // check if new distance calculated is less than the current minimum dist to the node
                    if (newDist < distances[destinationNode])
                    {
                        distances[destinationNode] = newDist; // if yes, update the min distance
                    }
                    unsettled.add(destinationNode);  // add this node in unsettled set
                }
            }
        }
    }
}