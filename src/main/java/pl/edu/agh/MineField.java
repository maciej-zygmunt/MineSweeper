package pl.edu.agh;

import java.util.ArrayList;
import java.util.List;

public class MineField {
    private int numColumns;
    private int numRows;
    private byte[][] mineField;

    private MineField(int rows, int columns) {
        this.numRows = rows;
        this.numColumns = columns;
        mineField = new byte[numRows][numColumns];
    }

    public static MineField CreateMineField(String mineFieldStr) throws IllegalArgumentException {
        String[] rows = mineFieldStr.split("[\n]");
        MineField mineField = new MineField(rows.length, rows[0].length());
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                if (rows[i].charAt(j) == '*') {
                    mineField.setMine(i, j);
                }
            }
        }
        return mineField;
    }

    /**
     * Method is capable to ahndle out of bounds indexes.
     *
     * @param row
     * @param column
     * @return true if mine exists, false otherwise.
     */
    public boolean isMine(int row, int column) {
        if (column >= numColumns || row >= numRows || column < 0 || row < 0) {
            return false;
        }
        return mineField[row][column] == '*';
    }

    private void setMine(int row, int column) throws IllegalArgumentException {
        if (column >= numColumns || row >= numRows || column < 0 || row < 0) {
            throw new IllegalArgumentException("Out of the board");
        }
        mineField[row][column] = '*';
    }

    @Override
    public String toString() {
        List<String> rows = new ArrayList<>();
        for (int i = 0; i < this.getNumRows(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < this.getNumColumns(); j++) {
                if (this.isMine(i, j)) {
                    stringBuilder.append("*");
                } else {
                    stringBuilder.append(".");
                }
            }
            rows.add(stringBuilder.toString());
        }
        return String.join("\n", rows);
    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getNumRows() {
        return numRows;
    }
}
