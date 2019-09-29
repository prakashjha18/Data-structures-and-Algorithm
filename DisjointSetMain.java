
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

class DisjointSet {
	
	private ArrayList<WeightedNode> nodes = new ArrayList<>();
	
	
	public static void driver(ArrayList<WeightedNode> nodeList){
		makeSet(nodeList); //Create Disjoint Sets for each node in this list.
		for(int i= 0; i<nodeList.size()-1; i++) {
			WeightedNode firstNode = nodeList.get(i);
			WeightedNode secondNode = nodeList.get(i+1);
			System.out.println("Checking if node "+firstNode.getName()+" and "+secondNode.getName() +" belongs to different set, if yes, will Union them...");
			System.out.println("\nFirst Set name is: " + firstNode.getName());
			firstNode.getSet().printAllNodesOfThisSet();
			System.out.println("\nSecond Set name is: " + secondNode.getName());
			secondNode.getSet().printAllNodesOfThisSet();
			if(!findSet(firstNode).equals(findSet(secondNode))) {
				System.out.println("\nMaking union "+firstNode+" and "+secondNode );
				DisjointSet unionedSet = union(firstNode, secondNode);
				unionedSet.printAllNodesOfThisSet();
			}
			System.out.println("\n**************************************\n");
		}
	}//end of method
	
	
	public static void makeSet(ArrayList<WeightedNode> nodeList) {
		//for each node in list, create a disjoint set
		for(WeightedNode node: nodeList) {
			DisjointSet set = new DisjointSet();
			set.getNodes().add(node);
			node.setSet(set);//Storing the reference of this Disjoint set in Node class
		}
	}//end of method
	
	
	public static DisjointSet getSet(WeightedNode node) {
		 return node.getSet();
	}//end of method
	
	
	public static DisjointSet findSet(WeightedNode node) {
		return node.getSet();
	}//end of method
	
	
	public static DisjointSet union(WeightedNode node1, WeightedNode node2) {
		if(node1.getSet().equals(node2.getSet())) { //if two nodes are of same set then no union needed
			return null;
		}	
		else {
			//get set object of two nodes
			DisjointSet set1 = node1.getSet();
			DisjointSet set2 = node2.getSet();
			// if first set is bigger then update each node of second set to merge to set1
			if(set1.getNodes().size()>set2.getNodes().size()) {
				ArrayList<WeightedNode> nodeSet2 = set2.getNodes();
				for(WeightedNode node: nodeSet2) { //update each node of second set to merge to set1
					node.setSet(set1);
					set1.getNodes().add(node);
				}
				return set1;
			}
			else {
				// if second set is bigger/equal then update each node of first set to merge to set2
				ArrayList<WeightedNode> nodeSet1 = set1.getNodes();
				for(WeightedNode node: nodeSet1) {//update each node of first set to merge to set2
					node.setSet(set2);
					set2.getNodes().add(node);
				}
				return set2;
			}//end of inner if-else
		}//end of outer if-else
	}//end of method
	
	
	public ArrayList<WeightedNode> getNodes() {
		return nodes;
	}//end of method
	
	
	public void setNodes(ArrayList<WeightedNode> nodes) {
		this.nodes = nodes;
	}//end of method
	
	
	public void printAllNodesOfThisSet() {
		System.out.println("Printing all nodes of the set: ");
		for(WeightedNode node: nodes) {
			System.out.print(node + "  ");
		}
		System.out.println();
	}//end of method
	
}//end of class

public class DisjointSetMain {

	public static void main(String[] args) {
		
		// Constructor for ArrayList
		ArrayList<WeightedNode> nodeList = new ArrayList<>();

		// create 10 nodes: 1-10
		for (int i = 0; i < 10; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}

		// Calling DisjointSet
		DisjointSet.driver(nodeList);

	}// end of method
}// end of class
