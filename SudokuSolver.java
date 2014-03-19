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

	private List<Row> rows = new ArrayList<Row>();
	private List<Column> columns = new ArrayList<Column>();
	private List<Region> regions = new ArrayList<Region>();

	private boolean solved = false;
	
	
	public SudokuSolver(int[] readSudoku){
		possibilities(readSudoku);
		generateHouses();		
		//debugPrintAll();
		clean();
		if( hiddenSingle() == true){
			System.out.println("Solved with hiddenSingle");
			//TODO check if sudoku is valid, if so congractulations
			solved = true;
		}else if(nakedPair() == true){
			System.out.println("Solved with nakedPair");
			//TODO check if sudoku is valid, if so congractulations
			solved = true;
		}else{
			System.out.println("! Failed to solve  at al");
		}		
	}

	public boolean result(){
		return solved;
	}

	private void possibilities(int[] readSudoku){
		for (int i = 0; i < readSudoku.length; i++) {
			
			if( readSudoku[i] == 0 ){
				cells.add(createZero());
			}else{
				ArrayList<Integer> tempArray = new ArrayList<Integer>();
				tempArray.add(readSudoku[i]);
				cells.add(tempArray);
			}
		}
	}

	private ArrayList<Integer> createZero(){
		ArrayList<Integer> zero = new ArrayList<Integer>();
		for(int i =1; i < 10; i++){
			zero.add(i);
		}
		return zero;
	}

	private void generateHouses(){
		generateRow();
		generateColumn();
		generateRegion();
	}

	private void generateRow(){

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
	
	private void generateColumn(){

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


	private void generateRegion(){

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
	}

	public void printBoard() {

			int totalzero = 0;
	
		    for (int i = 0; i < cells.size(); i++) {
		    	
		        if(i%9==0 && i != 0)
		        	System.out.println("|");
		        if(i%27==0)
		            System.out.println(" -----------------------");
		        if(i%3==0)
		        	System.out.print("| ");
		    	
		    	if(cells.get(i).size() == 1){
		    		System.out.print(cells.get(i).get(0));
		    	}
		    	else{
		    		System.out.print(0);
		    		totalzero = totalzero + 1;
		    	}
		    	System.out.print(' ');		  	        
		    }
		    System.out.println("|");
		    System.out.println(" -----------------------");

		    System.out.println("number of empty spots:");
		    System.out.println(totalzero);

		    System.out.print('\n');

		    System.out.print('\n');
		    //System.out.println(cells);

	}

	private boolean sudokuFilled(){
		int filled = 0;
		for (int i = 0; i < cells.size(); i++) {
			if( cells.get(i).size() == 1 ){
				filled ++;
			}
		}
		if( filled == 81 ){
			return true;
		}
		else{
			return false;
		}
	}

	private void clean(){
		boolean improvement = true;
		int improvementShownInAHouse = 1;
		
		while (improvementShownInAHouse > 0 ) {
				improvementShownInAHouse = 0;		
			
			for(Row row : rows){
				improvement = row.cleanMatrix();
				if(improvement == true){
					improvementShownInAHouse ++;
				}
			}
			for(Column column : columns){
				improvement = column.cleanMatrix();
				if(improvement == true){
					improvementShownInAHouse ++;
				}
			}
			for(Region region : regions){
				improvement = region.cleanMatrix();
				if(improvement == true){
					improvementShownInAHouse ++;
				}
				improvement = region.cleanMatrix();
			}
			//printBoard();
			//System.out.println(cells);
		}
		
	}

	private boolean hiddenSingle(){

		int [] freqArrays;
		int[] foundHiddenAndWhere;
		int improvement = 1;

		while( improvement > 0){
			improvement = 0;
			
			for(Row row : rows){
				//make frequenty array of all options, if there is only one occurence of a option it is a hidden single.
				freqArrays = row.buildFreqArray();
				//Now we have the frequency array, check if there is a unique option and find it's index
				foundHiddenAndWhere = hiddenSinglePresent(row, freqArrays);
				if(foundHiddenAndWhere[0] == 1){
					//if an unique option is found place it. 
				  	row.setValue(foundHiddenAndWhere[1], foundHiddenAndWhere[2]);
				  	improvement ++;
		        }
			}
			if( sudokuFilled() == true ){
				return true;
			}
			clean();
			if( sudokuFilled() == true ){
				return true;
			}
			
			for(Column column : columns){
				freqArrays = column.buildFreqArray();
				foundHiddenAndWhere = hiddenSinglePresent(column, freqArrays);
				if(foundHiddenAndWhere[0] == 1){
				  	column.setValue(foundHiddenAndWhere[1], foundHiddenAndWhere[2]);
				  	improvement ++;
		        }
			}
			if( sudokuFilled() == true ){
				return true;
			}
			clean();
			if( sudokuFilled() == true ){
				return true;
			}

			for(Region region : regions){
				//make frequenty array of all options, if there is only one occurence of a option it is a hidden single.
				freqArrays = region.buildFreqArray();
				//Now we have the frequency array, check if there is a unique option and find it's index
				foundHiddenAndWhere = hiddenSinglePresent(region, freqArrays);
				if(foundHiddenAndWhere[0] == 1){
					//if an unique option is found place it. 
				  	region.setValue(foundHiddenAndWhere[1], foundHiddenAndWhere[2]);
				  	improvement ++;
		        }
			}
			if( sudokuFilled() == true ){
				return true;
			}
			clean();
			if( sudokuFilled() == true ){
				return true;
			}
		}
		return false;
	}

	private int[] hiddenSinglePresent(Matrix houseToCheck, int [] freqArrayToSearch ){
		
		int[] foundHiddenAndWhere = new int[3];
		boolean singleHiddenPresent = false;
		int isSingleHiddenHere = 0;
		for (int i : freqArrayToSearch )
        {
        	isSingleHiddenHere ++;
            if (i == 1){
                foundHiddenAndWhere[0] = 1;
                //find its index
                foundHiddenAndWhere[1] = houseToCheck.indexForValue(isSingleHiddenHere);
                foundHiddenAndWhere[2] = isSingleHiddenHere;
            }
        }
        return foundHiddenAndWhere; 
	}

	public boolean nakedPair(){
		System.out.println("Started looking for naked pairs");
		boolean aresame  = false;
		int improvementShown = 1;
		boolean improvement = false;
		int [] freqArray;

		while( improvementShown > 0){
			improvementShown = 0;
			for(Row row : rows){
				freqArray =  row.buildFreqArray();

				System.out.println(Arrays.toString(freqArray));
				

				aresame = false;
				for( int i = 0; i < row.matrixSize(); i++){
					//System.out.println("check a number of values");
					for( int j = 0; j < row.matrixSize(); j++){
					   if( i != j && row.cellSize(i) == 2 && row.cellSize(i) == row.cellSize(j)){
					   aresame = row.getCell(i).equals(row.getCell(j));
					   }
					   	if(aresame == true){
					   		//System.out.println("Dit is best wel lijp");
					   		//System.out.println(column.getMatrix());
					   		for(int k = 0; k < row.cellSize(i); k++){
					   			System.out.println("found the same");
								
					   			for( int l = 0; l < row.matrixSize(); l++){
					   				if(l != i && l != j){
					   					int t = row.getCell(i).get(k);
					   					//System.out.printf("Dit is wat we gaan verwijderen, waar: %d, wat: %d", t ,l);
					   					improvement = row.removeNumber(row.getCell(i).get(k),l);
					   					if( improvement == true ) {
					   						improvementShown ++;
					   					}
					   				}
					   			}
					   		}
					   			//System.out.println(column.getMatrix());
					   	}
					   	aresame = false;
					}
				}
			}
			clean();
			if( sudokuFilled() == true ){
				return true;
			}
			hiddenSingle();
			if( sudokuFilled() == true ){
				return true;
			}
			for(Column column : columns){
				aresame = false;
				for( int i = 0; i < column.matrixSize(); i++){
					//System.out.println("check a number of values");
					for( int j = 0; j < column.matrixSize(); j++){

					   if( i != j && column.cellSize(i) == 2 && column.cellSize(i) == column.cellSize(j)){

					   aresame = column.getCell(i).equals(column.getCell(j));
					   }
					   	if(aresame == true){
					   		//System.out.println("Dit is best wel lijp");
					   		//System.out.println(column.getMatrix());
					   		for(int k = 0; k < column.cellSize(i); k++){
					   			for( int l = 0; l < column.matrixSize(); l++){
					   				if(l != i && l != j){
					   					int t = column.getCell(i).get(k);
					   					//System.out.printf("Dit is wat we gaan verwijderen, waar: %d, wat: %d", t ,l);
					   					column.removeNumber(column.getCell(i).get(k),l);
					   				}
					   			}
					   		}
					   			//System.out.println(column.getMatrix());
					   	}
					   	aresame = false;
					}
				}
			}
			clean();
			if( sudokuFilled() == true ){
				return true;
			}
			hiddenSingle();
			if( sudokuFilled() == true ){
				return true;
			}
			for(Region region : regions){
				aresame = false;
				for( int i = 0; i < region.matrixSize(); i++){
					//System.out.println("check a number of values");
					for( int j = 0; j < region.matrixSize(); j++){

					   if( i != j && region.cellSize(i) == 2 && region.cellSize(i) == region.cellSize(j)){

					   aresame = region.getCell(i).equals(region.getCell(j));
					   }
					   	if(aresame == true){
					   		//System.out.println("Dit is best wel lijp");
					   		//System.out.println(column.getMatrix());
					   		for(int k = 0; k < region.cellSize(i); k++){
					   			for( int l = 0; l < region.matrixSize(); l++){
					   				if(l != i && l != j){
					   					int t = region.getCell(i).get(k);
					   					//System.out.printf("Dit is wat we gaan verwijderen, waar: %d, wat: %d", t ,l);
					   					region.removeNumber(region.getCell(i).get(k),l);
					   				}
					   			}
					   		}
					   			//System.out.println(column.getMatrix());
					   	}
					   	aresame = false;
					}
				}
			}
			clean();
			if( sudokuFilled() == true ){
				return true;
			}
			hiddenSingle();
			if( sudokuFilled() == true ){
				return true;
			}
		}//end while improvement
		//printBoard();
			return false;
	}
}
