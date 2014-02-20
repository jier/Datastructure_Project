import java.util.*;
import java.lang.*;

public class sudoku{
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
		
	}
	
	public void read(){
	}
	
	public void benchmark(){
	}
	
	public void update (){
	}
	
	public void solve(){
	}
	
	public boolean isSolved(){
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
	}
	
	
}
