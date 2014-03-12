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
	private Column column = new Column();
	private Region region = new Region();

	
	//private ArrayList<Integer>[] cellArray = new ArrayList[81];
	private ArrayList<ArrayList<Integer>> cells = new ArrayList<ArrayList<Integer>>(81);

	//private int[] incomingStream = new int[81];

	public SudokuSolver(int[] readSudoku){
		//incomingStream = readSudoku;`
		possibilities(readSudoku);
		generateRow();

	       
	}

	public void possibilities(int[] readSudoku){
		ArrayList<Integer> zero = new ArrayList<Integer>();
		zero.add(1);
		zero.add(2);
		zero.add(3);
		zero.add(4);
		zero.add(5);
		zero.add(6);
		zero.add(7);
		zero.add(8);
		zero.add(9);

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
		//int n = 9;
		//row = new Matrix[n];
		//Matrix[] generatedRow = new Matrix[0];
		//for(int i= 0; i<matrixLength;i++){
	//		row[i]= generatedRow[i];
	//	} 
	//	return generatedRow;
		//int n = 9;
		//int[] row = new int[]

		//ArrayList<ArrayList<Integer>> row = new ArrayList<ArrayList<Integer>>(9);
		//for(int i= 0; i<cells.size(); i++){
		//	System.out.println("bigFor");
		//	for(int k= 0; k<9; k++){
		//		if (i%9 == 0){
		//			ArrayList<Integer> tempArray = new ArrayList<Integer>();
		//			ArrayList<Integer> tempVal = cells.get(k);
		//			System.out.println(tempVal);
		//			tempArray.add(5);
		//			row.add(tempArray);
		//	
		//		}
		//		System.out.println("smallFor");
				
		//	}
		//} 
	}

	/*

	public Matrix[] column(){
		int n = 9;
		column = new Matrix[n];
		Matrix[] generatedColumn = new Matrix[0];
		for(int i= 0; i<matrixLength;i++){
			column[i]= generatedColumn[i];
		}
		return generatedColumn;
	}

	public Matrix[][] region(){
		int r = 3;
		region = new Matrix[r][r];
		Matrix[][] generatedRegion= new Matrix[0][0];
		for(int i=0; i<matrixLength;i++){
			for (int j=0; j<matrixLength; j++){
				region[i][j]= generatedRegion[i][j];	
			}
		}
		return generatedRegion;
	}	
*/
	

}
