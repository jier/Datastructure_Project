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

	public void setValue(int index, int elemToSet){
		//System.out.println("Matrix before setting:");
		//System.out.println(getMatrix());
		//System.out.printf("setting %d, for index %d \n", elemToSet, index);
		//System.out.println( elemToSet);
		getCell(index).clear();
		getCell(index).add(elemToSet);
		//System.out.println(matrix);
	}	

	public boolean removeNumber(int what, int where){
		boolean improvement = false;
		ArrayList<Integer> removeFromCell = getCell(where);
		for (int i=0; i<removeFromCell.size(); i++) {
			int val = removeFromCell.get(i);
			if (val == what) {
				removeFromCell.remove(i);
				improvement = true;
			}
		}
		return improvement; 
	}

	public int matrixSize(){
		return getMatrix().size();
	}

	public int cellSize(int cellNumber){
		return getCell(cellNumber).size();
	}

	public int filledCellValue(int cellNumber){
		return getCell(cellNumber).get(0);
	}

	private boolean checkAndRemove(int indexToMatch){
		boolean improvement = false;
		for( int i = 0; i < matrixSize(); i++ ){
			if( indexToMatch != i && getCell(i).contains(filledCellValue(indexToMatch)) ){
				improvement = true;
				removeNumber(filledCellValue(indexToMatch), i);
			}
		}
		return improvement;
	}

	public boolean cleanMatrix(){
		boolean improvement = false;
		for(int i=0; i<matrixSize(); i++){
			//Search for single elements, which are in their definite place.
			//If we find such an element, remove these number from other arraylist within the matrix
			if( cellSize(i) == 1  && checkAndRemove(i) == true ){
					improvement = true;
			}
		}
		return improvement;
	}

	public void checkHiddenSingle(){

	}

	public int indexForValue(int wantedValue){
		int index = 0;
		for(int i =0; i < matrixSize(); i++){
			if(cellSize(i) != 1){
				for(int j = 0 ; j < cellSize(i); j++){
					if(getCell(i).get(j) == wantedValue){
						index = i; 
					}
				}
			}
		}
		return index;
	}

	public int [] buildFreqArray(){
		int [] freqArray = new int [9];
		for(int i = 0 ; i < matrixSize(); i++){
			ArrayList<Integer> tempt = getCell(i);
			//if cell is not already filled in
			if(tempt.size() != 1){
				for(int j = 0 ; j < tempt.size(); j++){
					int toAddToFreq = tempt.get(j);
			        switch (toAddToFreq) {
			            case 1:  freqArray[0] = freqArray[0]+1;
			                     break;
			            case 2:  freqArray[1] = freqArray[1]+1;
			                     break;
			            case 3:  freqArray[2] = freqArray[2]+1;
			                     break;
			            case 4:  freqArray[3] = freqArray[3]+1;
			                     break;
			            case 5:  freqArray[4] = freqArray[4]+1;
			                     break;
			            case 6:  freqArray[5] = freqArray[5]+1;
			                     break;
			            case 7:  freqArray[6] = freqArray[6]+1;
			                     break;
			            case 8:  freqArray[7] = freqArray[7]+1;
			                     break;
			            case 9:  freqArray[8] = freqArray[8]+1;
			                     break;
					}
				}
			}
		}
		return freqArray;
	}
}
