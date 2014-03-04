import java.util.*;
import java.lang.*;
<<<<<<< HEAD

public class Sudoku{
	private Cell[][] grid;
	private Selection[][] groups;
	private int[][] original, generated;
	private Set solvedCells;
	private int count,turns,wipes, startCount;
	private boolean stuck;
	
	public sudoku{
		this(new int[9][9]);
	}
	
	public sudoku(int [][] org){
=======
import java.io.*;

public class Sudoku{

	long start = 0;
	long end = 0;
	ArrayList<Integer> list = new ArrayList<Integer>();

	private String grid;
	//private array[][] grid;
	//private Selection[][] groups;
	private int[][] original, generated;
	//private Set solvedCells;
	private int count,turns,wipes, startCount;
	private boolean stuck;
	
	public Sudoku(){
		this(new int[9][9]);
	}
	
	public Sudoku(int [][] org){
>>>>>>> ec07d99c525b1c759d2c53506761a31c316240b4
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
<<<<<<< HEAD
		
	}
	
	public void read(){
=======
	}
	
	public void read(){
		 System.out.println("ik ga inlezen");
		 try {
            BufferedReader file = new BufferedReader(new FileReader("single.txt"));
            //start = System.currentTimeMillis();
            String str, copy;
            while ((str = file.readLine()) != null) {
            	//int sudokuStream = Integer.parseInt(src.toString());
  
                for(int i = 0; i < str.length(); i++)
					{
					char c = str.charAt(i);
				   int f = Character.digit(c,10); 
				   System.out.printf("%s\n", c);
				   list.add(f);
				}				
            }

            ///end = System.currentTimeMillis();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
>>>>>>> ec07d99c525b1c759d2c53506761a31c316240b4
	}
	
	public void benchmark(){
	}
	
	public void update (){
	}
	
	public void solve(){
	}
	
	public boolean isSolved(){
<<<<<<< HEAD
=======
		return false;
>>>>>>> ec07d99c525b1c759d2c53506761a31c316240b4
	}
	 
	public int getCount(){
		return count;
	}
	
	public int[][] getOrg(){
		return original;
	}
	
	public int[][] getGen(){
		return generated;
	}
	
	public int getTurn(){
		return turns;
	}
	
	public int getStartCount(){
		return startCount;
	}
<<<<<<< HEAD
	
	public int[][] printMatrix(){
		 int[][] temp = new int[9][9];
		 for(int i =0; i < 9; i++){
		 	for(int j= 0; j< 9; j++){
		 		temp[i][j]= grid[i][j];
		 	}
		 }
		 return temp;
	}
	public int [][] printResults(){
=======

	public void printBoard() {
	
		    for (int k = 0; k < list.size(); k++) {
		    	
		        if(k%9==0 && k != 0)
		        		System.out.println("|");
		        	if(k%27==0)
		                System.out.println(" -----------------------");
		        if(k%3==0)
		        	System.out.print("| ");
		    	
		    	System.out.print(list.get(k));
		    	System.out.print(' ');

		            //System.out.print("\n");
		            
		        
		    }
		    System.out.println("|");
		    System.out.println(" -----------------------");

		    System.out.print('\n');
	}
	
	public int[][] printMatrix(){
		 int[][] temp = new int[9][9];
		
		 return temp;
	}
	public int printResults(){

		System.out.println("this is the end");
		int size = list.size();
		System.out.println(size);
		return 6;
	}

	public static void main(String[] args) {
		System.out.println("test");
	    Sudoku sudoku = new Sudoku();
	    System.out.println(sudoku.list);
	    sudoku.read();
	    System.out.println(sudoku.list);
	    sudoku.printResults();
	    sudoku.printBoard();
>>>>>>> ec07d99c525b1c759d2c53506761a31c316240b4
	}
	
	
}
