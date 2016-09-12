/***************************************
 * SudokuBoard.java
 * 
 * @author wagnern17
 * @version 9/11/2016
 * @description Generates a Sudoku board that can then be changed to create new boards.
 * 				Generates through a backtracking algorithm which randomly 
 * 				
 *
 */
public class SudokuBoard {
	
	public static void main(String[] args) {
		
		int[][] board = new int[9][9]; //inits 9x9 board
		
		int[][] sect1 = new int[3][3]; //inits subsections of 3x3's to check validity
		int[][] sect2 = new int[3][3];
		int[][] sect3 = new int[3][3];
		int[][] sect4 = new int[3][3];
		int[][] sect5 = new int[3][3];
		int[][] sect6 = new int[3][3];
		int[][] sect7 = new int[3][3];
		int[][] sect8 = new int[3][3];
		int[][] sect9 = new int[3][3];
		
		int testArray[] =  {1,2,3,4,5,6,7,8,9}; //array for backtracking algo to utilize
		
		

	}
	
	/****
	 * rowCheck:
	 * 			checks for conflicts in a row
	 * @param tester
	 * @param row
	 * @return boolean, true if not conflicts
	 */
	public boolean rowCheck(int tester, int[] row){
		if (tester > 9 || tester < 1){ //error checking
			return false;
		}
		if (row.length < 1){ //if no nums in the row
			return true;
		}
		for(int i=0; i<row.length; i++){ //iterate over every num in the row
			if(row[i]==tester){ //if the test num is in the row already
				return false;
			}
		}
		return true;
	}
	
	/****
	 * colCheck:
	 * 			checks for conflicts in a col
	 * @param tester
	 * @param col
	 * @return boolean, true if no conflicts
	 */
	public boolean colCheck(int tester, int[] col){
		if (tester > 9 || tester < 1){ //error checking
			return false;
		}
		if (col.length < 1){ //if no nums in the col
			return true;
		}
		for(int i=0; i<col.length; i++){ //iterate over every num in the col
			if(col[i]==tester){ //if the test num is in the col already
				return false;
			}
		}
		return true;
	}

}
