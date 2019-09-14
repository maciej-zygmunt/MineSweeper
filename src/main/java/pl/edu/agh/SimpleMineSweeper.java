package pl.edu.agh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleMineSweeper implements MineSweeper {
    private Board a;
    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        a=scanField(mineField);
    }
    private Board  scanField(String field) {
        String [] rows=field.split("[\n]");
        Board fields=new Board(rows.length,rows[0].length());

        for (int i = 0; i < rows.length; i++) {
            int []r=new int[rows[i].length()];
            for (int j = 0; j < rows[i].length(); j++) {
                if(rows[i].charAt(j)=='*') {
                    fields.setMine(i,j);
                }
            }
        }
        return fields;
    }
    private String printBoard(List<int[]> b) {
        String bs="";
        for (int i = 0; i < b.size(); i++) {
            bs+=Arrays.toString(b.get(i))+"\n";

        }
        return bs;
    }
    @Override
    public String getHintField() throws IllegalStateException {
        List<int[]> h= new ArrayList<>();
        int maxRow=a.getNumRows();
        for (int i = 0; i < maxRow; i++) {
            int maxCol=a.getNumColumns();
            int []br=new int[maxCol];
            for (int j = 0; j < maxCol; j++) {
                int n=countNeighbours(i,j);
                br[j]=n;
            }
            h.add(br);
        }
        return printHint(h);
    }

    public String printBoardRow(){
        String bs="";
        for (int i = 0; i < a.getNumRows(); i++) {
            for (int j = 0; j < a.getNumColumns(); j++) {
                if(a.isMine(i,j)) {
                    bs+="*";
                } else {
                    bs+=".";
                }
            }
            if(i<a.getNumRows()-1) {
                bs += "\n";
            }
        }
        return bs;
    }

    private String printHint(List<int[]> h) {
        String bs="";
        for (int i = 0; i < h.size(); i++) {
            for (int j = 0; j < h.get(i).length; j++) {
                if(a.isMine(i,j)) {
                    bs+="*";
                } else {
                    bs+=h.get(i)[j];
                }
            }
            if(i<h.size()-1) {
                bs += "\n";
            }
        }
        return bs;
    }

    private int countNeighbours(int i, int j) {
        int[][] neighbours=cordNeighbourCells(i,j);
        int n=0;
        for (int k = 0; k < neighbours.length; k++) {
            int row=neighbours[k][0];
            int col=neighbours[k][1];
            if(a.isMine(row,col)) {
                n++;
            }
        }
        return n;
    }

    private int [][] cordNeighbourCells(int colCoord, int rowCoord) {

        int [][] list={{colCoord-1, rowCoord-1},{colCoord-1, rowCoord},
                {colCoord-1, rowCoord+1},{colCoord, rowCoord-1},{colCoord, rowCoord+1},
                {colCoord+1, rowCoord-1},{colCoord+1, rowCoord},{colCoord+1, rowCoord+1}};

        return list;
    }


}
