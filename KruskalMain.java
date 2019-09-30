import java.util.*;

class UndirectedEdge {
    private WeightedNode first;
    private WeightedNode second;
    private int weight;
    
    public UndirectedEdge(WeightedNode first, WeightedNode second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }
    
    public WeightedNode getFirst() {
        return first;
    }
    public void setFirst(WeightedNode first) {
        this.first = first;
    }
    public WeightedNode getSecond() {
        return second;
    }
    public void setSecond(WeightedNode second) {
        this.second = second;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return "Edge (" + first + "," + second + "), weight=" + weight + "]";
    }
    
}

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

class Kruskal {
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

	public Kruskal(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	
	// Kruskal algo
	void kruskal() {
		// make disjoint sets for each node
		DisjointSet.makeSet(nodeList);
		
		// sort the edges in ascending order
		Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
			@Override
			public int compare(UndirectedEdge o1, UndirectedEdge o2) {
				return o1.getWeight() - o2.getWeight();
			}
		};
		Collections.sort(edgeList, comparator);

		int cost = 0;
		for (UndirectedEdge edge : edgeList) {
			WeightedNode first = edge.getFirst();
			WeightedNode second = edge.getSecond();
			if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))) {
				DisjointSet.union(first, second);
				cost += edge.getWeight();
				System.out.println("Taken " + edge);
			}
		}

		System.out.println("\nTotal cost of MST: " + cost);
	}

	
	// add a weighted undirected edge between two nodes
	public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
		UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex - 1), nodeList.get(secondIndex - 1), weight);
		WeightedNode first = edge.getFirst();
		WeightedNode second = edge.getSecond();
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
		first.getWeightMap().put(second, weight);
		second.getWeightMap().put(first, weight);
        edgeList.add(edge);
        
	}
}

public class KruskalMain {
	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		
		//create 10 nodes: v1-v10
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedNode(""+(char)(65+i)));
		}
		Kruskal graph = new Kruskal(nodeList);
		//add weighted edges following graph in graph.docx
		
		//Add A<-> B , weight 10
		graph.addWeightedUndirectedEdge(1,2,10);
		
		//Add A<-> C , weight 20
		graph.addWeightedUndirectedEdge(1,3,20);
		
		graph.addWeightedUndirectedEdge(2,3,30);
		
		graph.addWeightedUndirectedEdge(2,4,5);
		
		graph.addWeightedUndirectedEdge(3,4,15);
		graph.addWeightedUndirectedEdge(3,5,6);
		
		graph.addWeightedUndirectedEdge(4,5,8);
		
		
		//run kruskal on graph
		System.out.println("Running Kruskal's Algo on the graph: ");
		graph.kruskal();
	}//end of method
	
}//end of class
