
import java.util.ArrayList;
import java.util.Stack;

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

class TopologicalSort {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	
	//Constructor
	public TopologicalSort(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	
	void topologicalSort() {
		Stack<GraphNode>stack = new Stack<>();
		for (GraphNode node : nodeList) { // if a node is unvisited then run topologicalSort on it
			if (!node.isVisited())
				topologicalVisit(node,stack);
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getName()+" ");
		}
	}

	
	// Topological visit by a source node
	void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		for (GraphNode neighbor : node.getNeighbors()){	//if neighbor is not visited then recursive call to it
			if(!neighbor.isVisited()){
				topologicalVisit(neighbor,stack);
			}
		}
		node.setVisited(true);
		stack.push(node);
	} // end of method

	
	// add a directed edge between two nodes
	public void addDirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i - 1);
		GraphNode second = nodeList.get(j - 1);
		first.getNeighbors().add(second);
	} // end of method

}//end of class

public class TopologicalSortMain {

	public static void main(String[] args) {
		ArrayList<GraphNode> nodeList = new ArrayList<>();
		
		
		//create 10 nodes: v1-v10
		for(int i=1;i<9; i++) {
			nodeList.add(new GraphNode("V"+i));
		}
		
		
		TopologicalSort graph = new TopologicalSort(nodeList);
		
		
		//add edges following graph in graph.docx
		graph.addDirectedEdge(1,3);
		graph.addDirectedEdge(2,3);
		graph.addDirectedEdge(3,5);
		graph.addDirectedEdge(2,4);
		graph.addDirectedEdge(4,6);
		graph.addDirectedEdge(5,8);
		graph.addDirectedEdge(5,6);
		graph.addDirectedEdge(6,7);
		
		
		//dfs from v1
		System.out.println("Printing topological sort from  V1");
		graph.topologicalSort();
	}

}
