package pl.edu.agh;

public class SimpleMineSweeper implements MineSweeper {
    private Board board;
    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        board =Board.CreateBoard(mineField);
    }
    @Override
    public String getHintField() throws IllegalStateException {
        if(board==null) {
            throw new IllegalStateException("Call setMineFiled first");
        }
        return (new Hints(board)).toString();
    }

    @Override
    public String toString() {
        return board.toString();
    }



}
