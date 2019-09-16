package pl.edu.agh;

import java.util.ArrayList;

import java.util.List;

public class SimpleMineSweeper implements MineSweeper {
    private Board board;
    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        board =scanField(mineField);
    }
    @Override
    public String getHintField() throws IllegalStateException {
        if(board==null) {
            throw new IllegalStateException("Method call setMineFiled first");
        }
        List<int[]> h= new ArrayList<>();
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
        return printHint(h);
    }

    public Board getBoard() {
        return board;
    }

    private Board  scanField(String field) throws IllegalArgumentException {
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

    private String printHint(List<int[]> h) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < h.size(); i++) {
            for (int j = 0; j < h.get(i).length; j++) {
                if(board.isMine(i,j)) {
                    stringBuilder.append("*");
                } else {
                    stringBuilder.append(h.get(i)[j]);
                }
            }
            if(i<h.size()-1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private int countNeighbours(int i, int j) {
        int[][] neighbours=cordNeighbourCells(i,j);
        int n=0;
        for (int k = 0; k < neighbours.length; k++) {
            int row=neighbours[k][0];
            int col=neighbours[k][1];
            if(board.isMine(row,col)) {
                n++;
            }
        }
        return n;
    }

    private int [][] cordNeighbourCells(int colCoord, int rowCoord) {
        int [][] neighbours=new int[8][2];
        int r=0;
        for (int i = -1; i <=1 ; i++) {
            for (int j = -1; j <=1 ; j++) {
                int x=colCoord+j;
                int y=rowCoord+i;
                if(x==colCoord && y==rowCoord) {
                    continue;
                }
                neighbours[r][0]=x;
                neighbours[r][1]=y;
                r++;
            }
        }
        return neighbours;
    }
}
