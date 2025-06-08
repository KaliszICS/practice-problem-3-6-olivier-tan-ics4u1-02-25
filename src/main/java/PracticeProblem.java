public class PracticeProblem {

	public static void main(String args[]) {

	}

    public static int searchMazeMoves(String[][] arr) {
        int startRow = arr.length - 1; 
        int startCol = 0;
        int[] result = dfsHelper(arr, startRow, startCol, 0, 0);
        return result[0]; 
    }

	public static int noOfPaths(String[][] arr) {
		int startRow = arr.length - 1;
		int startCol = 0;
        int[] result = dfsHelper(arr, startRow, startCol, 0, 0);
		return result[1];
	}

	public static int[] dfsHelper(String[][] arr, int row, int col, int moves, int paths) { 
		if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length) {  
            return new int[]{-1, paths}; 
        } 
        else if (arr[row][col].equals("F")) { 
            return new int[]{moves, paths + 1}; 
        } 
        if (arr[row][col].equals("*")) {
			return new int[]{-1, paths}; 
		}


        int[] moveUp = dfsHelper(arr, row - 1, col, moves + 1, paths);
        int[] moveRight = dfsHelper(arr, row, col + 1, moves + 1, paths);

        if (moveUp[0] == -1) return moveRight;
        if (moveRight[0] == -1) return moveUp; 

        int minMoves = Math.min(moveUp[0], moveRight[0]); 
        int totalPaths = moveUp[1] + moveRight[1];
        return new int[]{minMoves, totalPaths}; 
    }

}