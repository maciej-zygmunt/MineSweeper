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

    public void setMine(int row, int column) {
        if (column > numColumns || row > numRows || column < 0 || row < 0) {
            throw new IllegalArgumentException("Out of the board");
        }
        board[row][column] = '*';

    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getNumRows() {
        return numRows;
    }
}
