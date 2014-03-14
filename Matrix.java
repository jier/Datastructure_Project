/* 
*This class is an abstract class that will contains contains common methods 
that will be used in the classes of the previous named objects.
*/
import java.util.*;
import java.lang.*;

public abstract class Matrix{

	private ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>(9);
	
	public ArrayList<ArrayList<Integer>> getMatrix(){
		return matrix;
	}

	public ArrayList<Integer> getCell(int cellNumber){
		return getMatrix().get(cellNumber);
	}
	
	public void addValue(ArrayList<Integer> elemToAdd){
		matrix.add(elemToAdd);
	}	

	public void removeNumber(int what, int where){
		ArrayList<Integer> removeFromCell = getCell(where);
		for (int i=0; i<removeFromCell.size(); i++) {
			int val = removeFromCell.get(i);
			if (val == what) {
				removeFromCell.remove(i);
			}
		} 
	}

	public void clean(){
		//System.out.println("cleaning initialized");
		for(int i=0; i<getMatrix().size(); i++){
			//Search for single elements, which are in their definite place.
			//If we find such an element, remove these number from other arraylist within the matrix
			if(getCell(i).size() == 1){
				for(int j=0; j<getMatrix().size(); j++){
					if( i != j && getCell(j).contains(getCell(i).get(0)) ){
						removeNumber(getCell(i).get(0),j);
					}
				}
			}
		}
	}
}
