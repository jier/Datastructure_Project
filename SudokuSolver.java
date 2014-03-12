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

	private ArrayList<ArrayList<Integer>> cells = new 
ArrayList<ArrayList<Integer>>(81);
	private ArrayList<ArrayList<Integer>> regionX = new 
ArrayList<ArrayList<Integer>>(3);
	private	ArrayList<ArrayList<Integer>> regionY = new 
ArrayList<ArrayList<Integer>>(3);
	private	ArrayList<ArrayList<ArrayList<Integer>>> region = new 
ArrayList<ArrayList<ArrayList<Integer>>>(81);

	//private int[] incomingStream = new int[81];

	public SudokuSolver(int[] readSudoku){
		//incomingStream = readSudoku;`
		possibilities(readSudoku);
		System.out.println("These are the rows");
		generateRow();
		System.out.println("These are the columns");
		generateColumn();
		System.out.println("These are the regions");
		generateRegion();
	}

	public void possibilities(int[] readSudoku){
		ArrayList<Integer> zero = new ArrayList<Integer>();
		for(int i = 1; i < 10; i++){
			zero.add(i);
		}
		
		for (int i = 0; i < readSudoku.length; i++) {
			
			if( readSudoku[i] == 0 ){
				cells.add(zero);
			}else{
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
		//System.out.println(column);
	}


	public void generateRegion(){
		int r = 3,c = 3;
		for(int i =0; i< cells.size(); i+=3){
			for(int j= 0; j<r; j++){
				ArrayList<Integer> tempValX =  cells.get(j+i);
				/*System.out.println(
				"These are rows:"+tempValX);*/
				regionX.add(tempValX);
				if(j%3 == 0){
				region.add(regionX);}
			}
		}
		
		for(int i =0; i< c; i++){
			for(int j= 0; j< cells.size(); j+= 9){
				ArrayList<Integer> tempValY =  cells.get(j+i);
				/*System.out.println(
				"These are columns"+tempValY);*/
				regionY.add(tempValY);
				//System.out.println(regionY);
				if(i %3 == 0){
				region.add(regionY);}
			}
		}
		/*for(int j = 0; j < region.size();j++){
			if(j% == 0)
		}*/
		System.out.println(region);
	}	

	

}
