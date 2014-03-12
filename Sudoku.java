import java.util.*;
import java.lang.*;
import java.io.*;



public class Sudoku{

	long start = 0;
	long end = 0;
	//ArrayList<Integer> list = new ArrayList<Integer>();
	static int[] sudokuStringArray = new int[81];

	/*private String grid;
	//private array[][] grid;
	//private Selection[][] groups;
	private int[][] original, generated;
	//private Set solvedCells;
	private int count,turns,wipes, startCount;
	private boolean stuck;
	
	public Sudoku(){
		this(new int[9][9]);
	}
	
	/*public Sudoku(int [][] org){
		turns =0;
		original = new int[9][9];
		generated = new int[9][9];
		for(int r =0; r< 9; r++){
			for(int c =0; c< 9; c++){
				if (org[r][c] != 0){
					original[r][c] = org[r][c];
					generated[r][c] = org[r][c];
				}
			}
		}
		
	}*/
		
	public void read(){
		 //System.out.println("ik ga inlezen");
		try {
			BufferedReader file = new BufferedReader(new 
FileReader("single.txt"));
            //start = System.currentTimeMillis();
			String str, copy;
			while ((str = file.readLine()) != null) {
            	//int sudokuStream = Integer.parseInt(src.toString());
  
				for(int i = 0; i < str.length(); i++){
					char c = str.charAt(i);
					int f = Character.digit(c,10); 
					//System.out.printf("%s\n", c);
					//list.add(f);
					sudokuStringArray[i] = f;
				}
				printBoard();
			}
		///end = System.currentTimeMillis();
		file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void benchmark(){
	}
	
	public void update (){
	}
	
	public void solve(){
		SudokuSolver solver = new SudokuSolver(sudokuStringArray);
	}
	
	public boolean isSolved(){
		return false;
	}
	 
	public int getCount(){
		return 5;
	}
	
	public int getOrg(){
		return 5;
	}
	
	public int getGen(){
		return 5;
	}
	
	public int getTurn(){
		return 5;
	}
	
	public int getStartCount(){
		return 5;
	}

	/*public int[][] printMatrix(){
		 int[][] temp = new int[9][9];
		 for(int i =0; i < 9; i++){
		 	for(int j= 0; j< 9; j++){
		 		temp[i][j]= grid[i][j];
		 	}
		 }
		 return temp;
	}*/

	public void printBoard() {
	
		    for (int k = 0; k < sudokuStringArray.length; k++) {
		    	
		        if(k%9==0 && k != 0)
		        		System.out.println("|");
		        	if(k%27==0)
		                System.out.println(" -----------------------");
		        if(k%3==0)
		        	System.out.print("| ");
		    	
		    	System.out.print(sudokuStringArray[k]);
		    	System.out.print(' ');

		            //System.out.print("\n");
		            
		        
		    }
		    System.out.println("|");
		    System.out.println(" -----------------------");

		    System.out.print('\n');
	}
	
	/*public int[][] printMatrix(){
		 int[][] temp = new int[9][9];
		
		 return temp;
	}*/
	public int printResults(){

		System.out.println("this is the end");
		//int size = list.size();
		//System.out.println(size);
		return 6;
	}

	public static void main(String[] args) {
		System.out.println("Begin of program");
	    Sudoku sudoku = new Sudoku();
	   // System.out.println(sudoku.list);
	    sudoku.read();
	    /*System.out.println(sudoku.list);
	    sudoku.printResults();
	    sudoku.printBoard();*/
	    sudoku.solve();
	}
	
	
}
