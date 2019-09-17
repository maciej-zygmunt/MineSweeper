package pl.edu.agh;

public class SimpleMineSweeper implements MineSweeper {
    private MineField mineField;

    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        this.mineField = MineField.CreateMineField(mineField);
    }

    @Override
    public String getHintField() throws IllegalStateException {
        if (mineField == null) {
            throw new IllegalStateException("Call setMineFiled first");
        }
        return (new HintField(mineField)).toString();
    }

    @Override
    public String toString() {
        return mineField.toString();
    }
}
