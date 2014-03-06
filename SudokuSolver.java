/*
 *This Class will contain three Objects.
 *These Objects are the representation of the matrix that is the Sudoku.
 *With these objects we will be able to use solve techniques at the Sudoku.
 */
import java.util.*;
import java.lang.*;
import java.io.*;


public class SudokuSolver{

	private final static int matrixLength = 9;
	// private Row row = new Row();
	//private Column column = new Column();
	//private Region region = new Region();

	
	//private ArrayList<Integer>[] cellArray = new ArrayList[81];
	private ArrayList<ArrayList<Integer>> cells = new ArrayList<ArrayList<Integer>>(81);

	//private int[] incomingStream = new int[81];

	public SudokuSolver(int[] readSudoku){
		//incomingStream = readSudoku;`
		possibilities(readSudoku);
		//generateRow();
		//generateColumn();
		//generateRegion();

	       
	}

	public void possibilities(int[] readSudoku){
		ArrayList<Integer> zero = new ArrayList<Integer>();
		for(int i = 1; i < 10; i++){
			zero.add(i);
		}
		/*zero.add(1);
		zero.add(2);
		zero.add(3);
		zero.add(4);
		zero.add(5);
		zero.add(6);
		zero.add(7);
		zero.add(8);
		zero.add(9);*/

		for (int i = 0; i < readSudoku.length; i++) {
			
			if( readSudoku[i] == 0 ){
				cells.add(zero);
			}

			else{
				ArrayList<Integer> tempArray = new ArrayList<Integer>();
				tempArray.add(readSudoku[i]);
				cells.add(tempArray);
			}
		}

		System.out.println(cells);
	}

	/*
	public void run(){
		boolean requested = false;
		while(requested == true){
			if(row.length !=0){
				row();
			}else if (column.length !=0){
				column();
			}else if (region.length !=0){
				region();
			}else{
				row();
				column();
				region();
			}
		}
	}
*/
	public void generateRow(){
		ArrayList<ArrayList<Integer>> row = new ArrayList<ArrayList<Integer>>(9);
		for(int i= 0; i<cells.size(); i+=9){
			for(int k= 0; k<9; k++){
				//ArrayList<Integer> tempArray = new ArrayList<Integer>();
				ArrayList<Integer> tempVal = cells.get(k+i);
				System.out.println(tempVal);
				row.add(tempVal);
			
				
								
			}
		} 
	}
	
	public void generateColumn(){
		ArrayList<ArrayList<Integer>> column = new ArrayList<ArrayList<Integer>>(9);
		for(int i = 0; i< 9; i ++){
			for(int k = 0; k< cells.size(); k+=9){
				//ArrayList<Integer> tempArr = new ArrayList<Integer>();
				ArrayList<Integer> tempVal = cells.get(k+i);
				System.out.println(tempVal);	
				column.add(tempVal);
				
			}
		}
	
	}


	public void generateRegion(){
		ArrayList<ArrayList<Integer>> regionX = new ArrayList<ArrayList<Integer>>(3);
		ArrayList<ArrayList<Integer>> regionY = new ArrayList<ArrayList<Integer>>(3);
		ArrayList<ArrayList<ArrayList<Integer>>> region = new ArrayList<ArrayList<ArrayList<Integer>>>(9);
		int r = 3,c = 3;
		for(int i =0; i< cells.size(); i+=3){
			for(int j= 0; j<r; j++){
				//ArrayList<Integer> tempArrayX = new ArrayList<Integer>();
				ArrayList<Integer> tempValX =  cells.get(j+i);
				//System.out.println(tempValX);
				regionX.add(tempValX);
				region.add(regionX);
			}
		}
		for(int i =0; i< c; i++){
			for(int j= 0; j<cells.size(); j+= 3){
				//ArrayList<Integer> tempArrayY = new ArrayList<Integer>();
				ArrayList<Integer> tempValY =  cells.get(j+i);
				//System.out.println(tempValY);
				regionY.add(tempValY);
				region.add(regionY);
			}
		}
		//region.add(regionX,regionY);
		System.out.println(region);
		
		
	}	

	

}
