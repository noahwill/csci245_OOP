package game;

import java.util.ArrayList;
import java.util.Random;

public class MazeGraph {
	int count; 
    int[][] adjacencyarray;
    private Random rand = new Random();

    MazeGraph(int count) { 
        this.count = count; 
        adjacencyarray = new int[count][count];
          
        //Inception array to populate with 0.
    	for (int i=0;i<count;i++) {
    		for (int j=0;j<count;j++) {
    			adjacencyarray[i][j] = 0;
        	}
        }
    	printGrid(adjacencyarray,count);
        System.out.println("end");
    } 
    /*
    // Populates graph with a randomly scattered # of doors to any other array.
    public void buildGraph(int difficulty) {
    	
    	//For each array
    	for (i=0;i<adjacencyarray.l : adjacencyarray) {
    		
        	//Add randomly scattered edges
        	int edgecount = 1+rand.nextInt(difficulty);
        	for (int i=0;i<edgecount;i++) {
        		int chosenedge = rand.nextInt(count-1);
        		int currentedge = currentarray.get(chosenedge);
        		currentedge++;
        		currentarray.add(chosenedge,currentedge);
            	System.out.println(currentarray);
        	}
    	}
    }
    
    public void checkGraph() {
    	
    	//Make initial network from first array, each value being a connected index.
    	ArrayList<Integer> connected = new ArrayList<Integer>(count);
    	for (Integer i : adjacencyarray.get(0))
    		if (i>0)
    			connected.add(i);

    	//Tweak arrays if they are disconnected.
    	for (ArrayList<Integer> currentarray : adjacencyarray)
    		if (!connectedArray(connected,currentarray)) {
    			
    			//Remove an edge randomly and select new index to connect.
    			decRandomElement(currentarray);
    			Integer[] toinc = randomElement(connected);
    			int indextoinc = toinc[1];
    			
    			//Increment value at chosen index.
    			Integer valtoinc = currentarray.get(indextoinc);
    			valtoinc++;
    			currentarray.add(indextoinc,valtoinc);
    			
    			//Adds index of current array to connected array.
    			connected.add(adjacencyarray.indexOf(currentarray));
    			
    			//Increase network size if connected doesn't contain all of 
    			growConnected(connected,currentarray);
    				
    		}
    }
    */
    
    private void printGrid(int[][] grid,int count) {
    	for (int i=0;i<count;i++) {
    		for (int j=0;j<count;j++) {
    			System.out.printf("%s - ",grid[i][j]);
    		}
    		System.out.println();
    	}
    		
    }
    
    @SuppressWarnings("unused")
	private boolean connectedArray(ArrayList<Integer> connected,ArrayList<Integer> currentarray) {
    	for (Integer i : currentarray)
    		if (connected.contains(i))
    			return true;
    	return false;
    }
    
    /**
     * Returns index and val of randomly chosen element.
     * @param array
     * @return
     */
    private Integer[] randomElement(ArrayList<Integer> array) {
    	int index = rand.nextInt(array.size());
    	return new Integer[] {
    		index,array.get(index)
    	};
    }
    
    /**
     * Decrements a random element.
     * @param array
     */
    @SuppressWarnings("unused")
	private void decRandomElement(ArrayList<Integer> array) {
    	Integer[] todecr = null;
    	while (todecr[1]<1)
    		todecr = randomElement(array);
    	todecr[1]--;
    	array.add(todecr[0],todecr[1]);
    }
    
    /**
     * Adds any indeces in array to connected.
     * @param connected
     * @param array
     */
    @SuppressWarnings("unused")
	private void growConnected(ArrayList<Integer> connected,ArrayList<Integer> array) {
    	for (int i=0;i<array.size();i++)
    		if (array.get(i)>0)
    			if (!connected.contains(i))
    				connected.add(i);
    }
}

