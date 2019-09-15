import java.util.ArrayList;
import java.util.LinkedList;


class GraphNode {
	private String name;
	private int index; //index is used to map this Node's name with index of Adjacency Matrix' cell#
	private ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
	private boolean isVisited = false;
	private GraphNode parent;
	
	public GraphNode(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArrayList<GraphNode> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<GraphNode> neighbors) {
		this.neighbors = neighbors;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public GraphNode getParent() {
		return parent;
	}

	public void setParent(GraphNode parent) {
		this.parent = parent;
	}

	public GraphNode(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return  name ;
	}

}

class BFSByAdjacencyMatrix {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	int [][] adjacencyMatrix;

	
	//Constructor
	public BFSByAdjacencyMatrix(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
		adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
	}
	
	
	//BFS Algorithm
	void bfs() {
		for(GraphNode node: nodeList) { //if a node is unvisited then run bfs on it
			if(!node.isVisited())
				bfsVisit(node);
		}
	}
	
	
	//BFS internal method
	void bfsVisit(GraphNode node) {
		LinkedList<GraphNode>queue = new LinkedList<>();
		queue.add(node); //add source node to queue
		while(!queue.isEmpty()) {
			GraphNode presentNode = queue.remove(0);
			presentNode.setVisited(true);
			System.out.print(presentNode.getName()+" ");
			
			ArrayList<GraphNode> neighbors = getNeighbors(presentNode);
			for(GraphNode neighbor: neighbors) { 	//for each neighbor of present node
				if(!neighbor.isVisited()) {
					queue.add(neighbor);
					neighbor.setVisited(true);
				}
			}//end of for loop
		}//end of while loop
	}//end of method
	
	
	
	// get all neighbors of a particular node by checking adjacency matrix and add it to neighbours arraylist
	public  ArrayList<GraphNode> getNeighbors(GraphNode node) {
		ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
		
		//gets row# to search in node index
		int nodeIndex = node.getIndex();
	
		for(int i=0; i<adjacencyMatrix.length;i++) {
			//if a column has 1 in that row then there is a neighbor and add it to list
			if(adjacencyMatrix[nodeIndex][i]==1) {
				neighbors.add(nodeList.get(i));
			}
		}
		return neighbors;
	}
	
	
	// add an undirected edge between two nodes
	public void addUndirectedEdge(int i, int j) {
		//decrement i, j for array indexes
		i--;
		j--;
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;
		
	}
}


public class bfsbyadjmatrix {

	public static void main(String[] args) {
		
		ArrayList<GraphNode> nodeList = new ArrayList<>();
		
		
		//Create 10 nodes: V1-V10
		for(int i=1;i<11; i++) {
			nodeList.add(new GraphNode("V"+i,i-1));
		}
		
		
		//Pass Graph arraylist for further processing
		BFSByAdjacencyMatrix graph = new BFSByAdjacencyMatrix(nodeList);
		
		
		//Add edges in graph
		graph.addUndirectedEdge(1,2);
		graph.addUndirectedEdge(1,4);
		graph.addUndirectedEdge(2,3);
		graph.addUndirectedEdge(2,5);
		graph.addUndirectedEdge(3,6);
		graph.addUndirectedEdge(3,10);
		graph.addUndirectedEdge(4,7);
		graph.addUndirectedEdge(5,8);
		graph.addUndirectedEdge(6,9);
		graph.addUndirectedEdge(7,8);
		graph.addUndirectedEdge(8,9);
		graph.addUndirectedEdge(9,10);
		
		//bfs from v1
		System.out.println("Printing BFS from source: V1");
		graph.bfs();
	}//end of method

}//end of class
