import java.util.*;

class WeightedNode implements Comparable<WeightedNode> {
	public String name;

	private ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
	private HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
	private boolean isVisited = false;
	private WeightedNode parent;
	private int distance;
	private DisjointSet set; //used in DisjointSet Algorithm

	public WeightedNode(String name) {
		this.name = name;
		distance = Integer.MAX_VALUE;
	}

	public DisjointSet getSet() {
		return set;
	}

	public void setSet(DisjointSet set) { //used in DisjointSet Algorithm
		this.set = set;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<WeightedNode> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<WeightedNode> neighbors) {
		this.neighbors = neighbors;
	}

	public HashMap<WeightedNode, Integer> getWeightMap() {
		return weightMap;
	}

	public void setWeightMap(HashMap<WeightedNode, Integer> weightMap) {
		this.weightMap = weightMap;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public WeightedNode getParent() {
		return parent;
	}

	public void setParent(WeightedNode parent) {
		this.parent = parent;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(WeightedNode o) {
		return this.distance - o.distance;
	}

}

class Prims {

	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	//Constructor
	public Prims(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}//end of method

	
	// Prim's algorithm from source node
	void prims(WeightedNode node) {
	  for (int counter = 0; counter < nodeList.size(); counter++) {
	      nodeList.get(counter).setDistance(Integer.MAX_VALUE);
	  } 
	  node.setDistance(0); // Setting '0' distance for Source Vertex
	  
	  
	  
	  System.out.println("I am waiting");
	  try {Thread.sleep( 1000);} catch (InterruptedException e) {e.printStackTrace();}
		
	  
	  
		
		PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
		
		queue.addAll(nodeList);
		while (!queue.isEmpty()) {
            
			WeightedNode presentNode = queue.remove(); // Remove vertex which has min distance
			
			
			for (WeightedNode neighbor : presentNode.getNeighbors()) {
                if (queue.contains(neighbor)) {//If vertex is not processed, only then enter in if-else 
                    
					//If known weight of this �adjacent vertex� is more than current edge, 
					//then update �adjacent vertex�s� distance and parent
					if (neighbor.getDistance() > presentNode.getWeightMap().get(neighbor)) {
						neighbor.setDistance(presentNode.getWeightMap().get(neighbor));
						neighbor.setParent(presentNode);
						queue.remove(neighbor); // Refresh the priority queue
						queue.add(neighbor);
					}//end of if-else
				}//end of if-else
			}//end of for loop
		}//end of while loop
		
		int cost = 0;
		// print table of node with minimum distance and shortest path from source
		for (WeightedNode nodeToCheck : nodeList) {
			System.out.println("Node " + nodeToCheck + ", key: " + nodeToCheck.getDistance() + ", Parent: " + nodeToCheck.getParent());
			cost = cost + nodeToCheck.getDistance();
		}//end of for loop
		
		System.out.println("\nTotal cost of MST: " + cost);
	}//end of method


	// add a weighted undirected edge between two nodes
	public void addWeightedUndirectedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i-1);
		WeightedNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
		first.getWeightMap().put(second,d);
		second.getWeightMap().put(first, d);
	}//end of method
	
}//end of class

public class PrimsMain {

	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		
		//Create 5 nodes: A,B,C,D,E
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedNode(""+(char)(65+i)));
		}
		
		Prims graph = new Prims(nodeList);
		graph.addWeightedUndirectedEdge(1,2,10);
		
		//Add A<-> C , weight 20
		graph.addWeightedUndirectedEdge(1,3,20);
		
		graph.addWeightedUndirectedEdge(2,3,30);
		
		graph.addWeightedUndirectedEdge(2,4,5);
		
		graph.addWeightedUndirectedEdge(3,4,15);
		graph.addWeightedUndirectedEdge(3,5,6);
		
		graph.addWeightedUndirectedEdge(4,5,8);
		
		System.out.println("Printing Prim's Algo from source: A");
		graph.prims(nodeList.get(0));
		
	}//end of method

}//end of class
