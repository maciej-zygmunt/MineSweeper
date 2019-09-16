package pl.edu.agh;


import pl.edu.agh.model.Neighbour;

import java.util.ArrayList;
import java.util.List;


class Hints {
    private final Board board;
    private final List<int[]> hints;
    public Hints(Board board) {
        this.board = board;
        this.hints =getHints();
    }

    private List<int[]> getHints() {
        List<int[]> h = new ArrayList<>();
        int maxRow= board.getNumRows();
        for (int i = 0; i < maxRow; i++) {
            int maxCol= board.getNumColumns();
            int []br=new int[maxCol];
            for (int j = 0; j < maxCol; j++) {
                int n=countNeighbours(i,j);
                br[j]=n;
            }
            h.add(br);
        }
        return h;
    }
    private int countNeighbours(int i, int j) {
        Neighbour[] neighbours=cordNeighbourCells(i,j);
        int n=0;
        for (Neighbour neighbour: neighbours) {
            if(board.isMine(neighbour.getRow(),
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
     * @param rowCoord
     * @param colCoord
     * @return number of neighbouring mines.
     */
    private  Neighbour [] cordNeighbourCells(int rowCoord, int colCoord) {
        Neighbour [] neighbours=new Neighbour[8];
        for (int i = -1,r=0; i <=1 ; i++) {
            for (int j = -1; j <=1 ; j++) {
                int col=colCoord+j;
                int row=rowCoord+i;
                if(col==colCoord && row==rowCoord) {
                    continue;
                }
                neighbours[r++]=new Neighbour(row,col);
            }
        }
        return neighbours;
    }
    @Override
    public  String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < hints.size(); i++) {
            for (int j = 0; j < hints.get(i).length; j++) {
                if(board.isMine(i,j)) {
                    stringBuilder.append("*");
                } else {
                    stringBuilder.append(hints.get(i)[j]);
                }
            }
            if(i< hints.size()-1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
