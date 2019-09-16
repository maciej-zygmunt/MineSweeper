package pl.edu.agh;

class Board {
    private int numColumns;
    private int numRows;
    private byte[][] board;

    private Board(int rows, int columns) {
        this.numRows = rows;
        this.numColumns = columns;
        board = new byte[numRows][numColumns];
    }

    public static Board CreateBoard(String field) {
        String [] rows=field.split("[\n]");
        Board fields=new Board(rows.length,rows[0].length());

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                if(rows[i].charAt(j)=='*') {
                    fields.setMine(i,j);
                }
            }
        }
        return fields;
    }

    /**
     * Method is capable to ahndle out of bounds indexes.
     * @param row
     * @param column
     * @return true if mine exists, false otherwise.
     */
    public boolean isMine(int row, int column) {
        if (column >= numColumns || row >= numRows || column < 0 || row < 0) {
            return false;
        }
        return board[row][column] == '*';

    }

    private void setMine(int row, int column) throws IllegalArgumentException{
        if (column >= numColumns || row >= numRows || column < 0 || row < 0) {
            throw new IllegalArgumentException("Out of the board");
        }
        board[row][column] = '*';

    }
    @Override
    public String toString(){
        StringBuilder bs=new StringBuilder();
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumColumns(); j++) {
                if(this.isMine(i,j)) {
                    bs.append("*");
                } else {
                    bs.append(".");
                }
            }
            if(i<this.getNumRows()-1) {
                bs.append("\n");
            }
        }
        return bs.toString();
    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getNumRows() {
        return numRows;
    }
}
