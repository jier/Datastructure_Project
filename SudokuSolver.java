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
	private ArrayList<ArrayList<Integer>> cells = new 
	ArrayList<ArrayList<Integer>>(81);

	public List<Row> rows = new ArrayList<Row>();
	public List<Column> columns = new ArrayList<Column>();
	public List<Region> regions = new ArrayList<Region>();
	
	
	public SudokuSolver(int[] readSudoku){
		possibilities(readSudoku);
		generateRow();
		generateColumn();
		generateRegion();
		//debugPrintAll();
		clean();
	}

	public void possibilities(int[] readSudoku){
		
		
		for (int i = 0; i < readSudoku.length; i++) {
			
			if( readSudoku[i] == 0 ){
				ArrayList<Integer> zero = new ArrayList<Integer>();
			for(int j =1; j < 10; j++){
				zero.add(j);
			}
				cells.add(zero);
			}else{
				ArrayList<Integer> tempArray = new ArrayList<Integer>();
				tempArray.add(readSudoku[i]);
				cells.add(tempArray);
			}
		}
	}

	public void createZero(){
		ArrayList<Integer> zero = new ArrayList<Integer>();
		for(int i =1; i < 10; i++){
			zero.add(i);
		}
	}

	public void generateRow(){

		for(int i = 0; i < 9; i++) {
	    	rows.add(new Row());
		}

		ArrayList<ArrayList<Integer>> row = new ArrayList<ArrayList<Integer>>(9);
		for(int i= 0; i<cells.size(); i+=9){
			for(int k= 0; k<9; k++){
				ArrayList<Integer> tempVal = cells.get(k+i);
				rows.get(i/9).addValue(tempVal);		
			}
		}

	}
	
	public void generateColumn(){

		for(int i = 0; i < 9; i++) {
	    columns.add(new Column());
	}

		ArrayList<ArrayList<Integer>> column = new ArrayList<ArrayList<Integer>>(9);
		for(int i = 0; i< 9; i ++){
			for(int k = 0; k< cells.size(); k+=9){
				ArrayList<Integer> tempVal = cells.get(k+i);
				columns.get(i).addValue(tempVal);		
			}
		}

	}


	public void generateRegion(){

		for(int i = 0; i < 9; i++) {
	   		regions.add(new Region());
		}

		for(int i= 0; i<cells.size(); i+=9){
			for(int k= 0; k<9; k++){
				ArrayList<Integer> tempVal = cells.get(k+i);
				if(k<3){
					if(i/9<3){
						regions.get(0).addValue(tempVal);
					}else if(i/9<6){
						regions.get(3).addValue(tempVal);
					}else if(i/9<9){
						regions.get(6).addValue(tempVal);
					}
				}
				else if( k<6 ){
					if(i/9<3){
						regions.get(1).addValue(tempVal);
					}else if(i/9<6){
						regions.get(4).addValue(tempVal);
					}else if(i/9<9){
						regions.get(7).addValue(tempVal);
					}
				}
				else if( k< 9){
					if(i/9<3){
						regions.get(2).addValue(tempVal);
					}else if(i/9<6){
						regions.get(5).addValue(tempVal);
					}else if(i/9<9){
						regions.get(8).addValue(tempVal);
					}
				}				
			}
		} 
	}	

	public void debugPrintAll(){
		System.out.println("The whole matrix:");
		System.out.println(cells);
		System.out.println("\n");
		System.out.println("These are the rows:");
		for(int i = 0; i < rows.size(); i++) {
			System.out.printf("Row %d\n", i+1 );
			System.out.println(rows.get(i).getMatrix());
		}
		System.out.println("\n");
		System.out.println("These are the columns:");
		for(int i = 0; i < columns.size(); i++) {
			System.out.printf("Column %d\n", i+1 );
			System.out.println(columns.get(i).getMatrix());
		}
		System.out.println("\n");
		System.out.println("These are the regions:");
		for(int i = 0; i < regions.size(); i++) {
			System.out.printf("Region %d\n", i+1 );
			System.out.println(regions.get(i).getMatrix());
		}
		System.out.println("Gimme the cell");
		System.out.println(rows.get(4).getCell(7));
	}

	public void clean(){
		for(Row row : rows){
			//System.out.println("original row");
			//System.out.println(row.getMatrix());
			row.clean();
			//System.out.println("done");
			//System.out.println(row.getMatrix());
		}
		for(Column column : columns){
			//System.out.println("original col");
			//System.out.println(column.getMatrix());
			column.clean();
			//System.out.println("done");
			//System.out.println(column.getMatrix());
		}
		for(Region region : regions){
			//System.out.println("original reg");
			//System.out.println(region.getMatrix());
			region.clean();
			//System.out.println("done");
			//System.out.println(region.getMatrix());
		}
		//todo print temp board 
		sudoku.printBoard();
	}
}
