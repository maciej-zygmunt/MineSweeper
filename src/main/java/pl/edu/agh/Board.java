package pl.edu.agh;

public class Board {
    private int numColumns;
    private int numRows;
    byte[][] board;

    public Board(int rows, int columns) {
        this.numRows = rows;
        this.numColumns = columns;
        board = new byte[numRows][numColumns];
    }

    public boolean isMine(int row, int column) {
        if (column >= numColumns || row >= numRows || column < 0 || row < 0) {
            return false;
        }
        return board[row][column] == '*';

    }

    public void setMine(int row, int column) throws IllegalArgumentException{
        if (column > numColumns || row > numRows || column < 0 || row < 0) {
            throw new IllegalArgumentException("Out of the board");
        }
        board[row][column] = '*';

    }
    public String printBoardRow(){
        String bs="";
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumColumns(); j++) {
                if(this.isMine(i,j)) {
                    bs+="*";
                } else {
                    bs+=".";
                }
            }
            if(i<this.getNumRows()-1) {
                bs += "\n";
            }
        }
        return bs;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getNumRows() {
        return numRows;
    }
}
