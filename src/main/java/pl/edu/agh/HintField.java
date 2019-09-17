package pl.edu.agh;


import pl.edu.agh.model.Neighbour;

import java.util.ArrayList;
import java.util.List;


public class HintField {
    private final MineField mineField;
    private final byte[][] hintField;

    public HintField(MineField mineField) {
        this.mineField = mineField;
        this.hintField = getHintField();
    }

    @Override
    public String toString() {
        List<String> rows = new ArrayList<>();
        for (int i = 0; i < hintField.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < hintField[i].length; j++) {
                if (mineField.isMine(i, j)) {
                    stringBuilder.append("*");
                } else {
                    stringBuilder.append(hintField[i][j]);
                }
            }
            rows.add(stringBuilder.toString());
        }
        return String.join("\n", rows);
    }

    private byte[][] getHintField() {
        int maxRow = mineField.getNumRows();
        int maxCol = mineField.getNumColumns();
        byte[][] h = new byte[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                byte n = countNeighbours(i, j);
                h[i][j] = n;
            }
        }
        return h;
    }

    private byte countNeighbours(int row, int col) {
        Neighbour[] neighbours = cordNeighbourCells(row, col);
        byte n = 0;
        for (Neighbour neighbour : neighbours) {
            if (mineField.isMine(
                    neighbour.getRow(),
                    neighbour.getCol())) {
                n++;
            }
        }
        return n;
    }

    /**
     * Calculate 8 neighbours to the cell. If this is cell on edge it will produce
     * indexes outside board bounds. Board.isMine(row,col) will return false if the index is out
     * of bounds.
     *
     * @param rowCoord
     * @param colCoord
     * @return number of neighbouring mines.
     */
    private Neighbour[] cordNeighbourCells(int rowCoord, int colCoord) {
        Neighbour[] neighbours = new Neighbour[8];
        for (int i = -1, r = 0; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int col = colCoord + j;
                int row = rowCoord + i;
                if (col == colCoord && row == rowCoord) {
                    continue;
                }
                neighbours[r++] = new Neighbour(row, col);
            }
        }
        return neighbours;
    }
}
