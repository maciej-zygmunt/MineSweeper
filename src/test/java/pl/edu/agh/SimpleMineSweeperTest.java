package pl.edu.agh;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SimpleMineSweeperTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void initializeMainTest() {
        String testField="*...\n..*.\n....";
        MineSweeper mineSweeper= new SimpleMineSweeper();
        mineSweeper.setMineField(testField);
        String returnedField=mineSweeper.toString();
        System.out.println("Input field");
        System.out.println(testField);
        System.out.println("Returned field");
        System.out.println(returnedField);
        Assert.assertEquals(testField,returnedField);
    }
    @Test
    public void hintMainTest() {
        String testHints="*211\n12*1\n0111";
        MineSweeper mineSweeper= new SimpleMineSweeper();
        mineSweeper.setMineField("*...\n..*.\n....");
        String returnedHint=mineSweeper.getHintField();
        System.out.println("Test hints");
        System.out.println(testHints);
        System.out.println("Returned Hints");
        System.out.println(returnedHint);
        Assert.assertEquals(returnedHint,testHints);
    }
    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentTest() {
        String testField="*...\n..*.*\n....";
        MineSweeper mineSweeper= new SimpleMineSweeper();
        mineSweeper.setMineField(testField);
        System.out.println(mineSweeper);
    }
    @Test(expected = IllegalStateException.class)
    public  void illegalStateTest() {
        MineSweeper mineSweeper= new SimpleMineSweeper();
        String returnedHints=mineSweeper.getHintField();
        System.out.println(returnedHints);
    }
}
