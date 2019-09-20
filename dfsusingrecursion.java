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

class DFSRecursive {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	
	public DFSRecursive(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	
	void dfs() {
		//if a node is unvisited then run dfs on it
		for(GraphNode node: nodeList) {
			if(!node.isVisited())
				dfsVisit(node);
		}
	}
	
	
	//dfs traversal by a source node
	void dfsVisit(GraphNode node) {
		//mark node as visited
		node.setVisited(true);
		//print the node
		System.out.print(node.getName()+" ");
		//for each neighbor of present node
		for(GraphNode neighbor: node.getNeighbors()) {
			//if neighbor is not visited 
			if(!neighbor.isVisited()) {
				//recursive call to dfs function
				dfsVisit(neighbor);
			}
		}
	}
	
	// add an undirected edge between two nodes
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i-1);
		GraphNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
	}
	
}

public class dfsusingrecursion {

	public static void main(String[] args) {
		ArrayList<GraphNode> nodeList = new ArrayList<>();
		
		
		//create 10 nodes: v1-v10
		for(int i=1;i<11; i++) {
			nodeList.add(new GraphNode("V"+i));
		}
		
		
		DFSRecursive graph = new DFSRecursive(nodeList);
		
		
		//add edges following graph in graph.docx
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
		
		//dfs from v1
		System.out.println("Printing DFS from source: V1");
		graph.dfs();
	}

}
