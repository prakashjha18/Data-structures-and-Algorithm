import java.util.*;

class FractionalKnapsackItem {
	private int index;
	private int value;
	private int weight;
	private double ratio;

	//constructor
	public FractionalKnapsackItem(int index, int value, int weight) {
		this.index = index;
		this.value = value;
		this.weight = weight;
		ratio = value * 1.0 / weight;
	}//end of method
	

	public int getIndex() {
		return index;
	}//end of method

	
	public void setIndex(int index) {
		this.index = index;
	}//end of method
	

	public int getValue() {
		return value;
	}//end of method
	

	public void setValue(int value) {
		this.value = value;
	}//end of method
	

	public int getWeight() {
		return weight;
	}//end of method
	

	public void setWeight(int weight) {
		this.weight = weight;
	}//end of method
	

	public double getRatio() {
		return ratio;
	}//end of method

	
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}//end of method

	
	@Override
	public String toString() {
		return "Item index=" + index + ", value=" + value + ", weight=" + weight + ", ratio=" + ratio + "]";
	}//end of method

}//end of class

class FractionalKnapsack {

	
	static void knapSack(ArrayList<FractionalKnapsackItem> items, int capacity) {
		// Sort items by descending ratio of value/ weight
		//Implement Comparator interface and specify which variable('Ratio') of user defined class should the 'compare' method work on.
		//This needs to be done because this will be required in Sort method  
		Comparator<FractionalKnapsackItem> comparator = new Comparator<FractionalKnapsackItem>() {
			@Override
			public int compare(FractionalKnapsackItem o1, FractionalKnapsackItem o2) {
				if(o2.getRatio()>o1.getRatio())return 1;
                else return -1;
			}
		};
		
		
		//Sort all the objects stored in the Arraylist by 'Ratio' variable
		Collections.sort(items, comparator);
		
		
		//Run greedy algo
		int usedCapacity = 0;
		double totalValue = 0;
		for (FractionalKnapsackItem item : items) {
			//if full consumption possible then consume it
			if(usedCapacity+ item.getWeight()<=capacity) {
				usedCapacity+=item.getWeight();
				System.out.println("Taken: "+item);
				totalValue+=item.getValue();
			}
			else {
				//else consume fractionally
				int usedWeight = capacity - usedCapacity;
				double value = item.getRatio()*usedWeight;
				System.out.println("Taken: "+"item index = " + item.getIndex() + ",obtained value = " + value + ",used weight = " + usedWeight + ", ratio = " + item.getRatio()
						+ "]");
				usedCapacity+=usedWeight;
				totalValue+=value;
			}
			//if capacity is full then break
			if(usedCapacity==capacity)break;
		}
		//print finally obtained value
		System.out.println("\nTotal value obtained: "+ totalValue);
	}//end of method
	
}//end of class

public class FractionalKnapsackMain {

	public static void main(String[] args) {
		//Create Array of Objects
		ArrayList<FractionalKnapsackItem>items = new ArrayList<>();
		int [] value = {6,2,1,8,3,5};
		int [] weight = {6,10,3,5,1,3};
		int capacity =10;
		
		//Add the user input data in Knapsack
		for(int i = 0; i<value.length;i++) {
			items.add(new FractionalKnapsackItem(i+1, value[i], weight[i]));
		}
				
		//Send the data for further processing
		FractionalKnapsack.knapSack(items, capacity);
	}//end of method

}//end of class
