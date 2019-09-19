import java.util.ArrayList;
import java.util.LinkedList;

class GraphNode {
	private String name;
	private int index;
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
		return  name;
	}

}

class PathFindingByBFS {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	
	
	//Constructor
	public PathFindingByBFS(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}//end of method

	
	
	//Print path of each of the vertex from source
	public static void pathPrint(GraphNode node) {
		if(node.getParent()!=null)
			pathPrint(node.getParent());  //recursive call to parent
		System.out.print(node+" ");
	}//end of method
	
	
	
	//BFS Traversal by a source node
	void BFSForSSSP(GraphNode node) {
		LinkedList<GraphNode>queue = new LinkedList<>();
		queue.add(node);  //add source node to queue
		while(!queue.isEmpty()) {
			GraphNode presentNode = queue.remove(0);
			presentNode.setVisited(true);
			System.out.print("Printing path for node "+presentNode.getName()+": ");
			pathPrint(presentNode);
			System.out.println();
			for(GraphNode neighbor: presentNode.getNeighbors()) {  //for each neighbor of present node
				if(!neighbor.isVisited()) {
					queue.add(neighbor);
					neighbor.setVisited(true);
					neighbor.setParent(presentNode);
				}//end of if
			}//end of for loop
		}//end of while loop
	}//end of method
	
	
	
	// add an undirected edge between two nodes
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i);
		GraphNode second = nodeList.get(j);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
	}//end of method
	
}//end of class


public class pathfindingusingbfs {

	public static void main(String[] args) {
		
		ArrayList<GraphNode> nodeList = new ArrayList<>();
				
		//create 10 nodes: v1-v10
		for(int i=0;i<10; i++) {
			nodeList.add(new GraphNode(""+i,i));
		}
		
		//Constructor
		PathFindingByBFS graph = new PathFindingByBFS(nodeList);
		//add edges following graph in graph.docx
		graph.addUndirectedEdge(0,8);
		graph.addUndirectedEdge(8,2);
		graph.addUndirectedEdge(8,9);
		graph.addUndirectedEdge(2,1);
		graph.addUndirectedEdge(9,1);
		graph.addUndirectedEdge(2,4);
		graph.addUndirectedEdge(1,3);
		graph.addUndirectedEdge(1,7);
		graph.addUndirectedEdge(3,4);
		graph.addUndirectedEdge(3,5);
		graph.addUndirectedEdge(7,6);
		graph.addUndirectedEdge(5,6);
		
		System.out.println("Printing BFS from source: 2");
		graph.BFSForSSSP(nodeList.get(2));
	}//end of method

}//end of class
