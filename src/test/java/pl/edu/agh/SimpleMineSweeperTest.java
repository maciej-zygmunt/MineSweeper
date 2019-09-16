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
        String tf="*...\n..*.\n....";
        MineSweeper mineSweeper= new SimpleMineSweeper();
        mineSweeper.setMineField(tf);
        String rb=((SimpleMineSweeper)mineSweeper).getBoard().printBoardRow();
        System.out.println("Input field");
        System.out.println(tf);
        System.out.println("Output field");
        System.out.println(rb);
        Assert.assertEquals(tf,rb);
    }
    @Test
    public void hintMainTest() {
        String tb="*211\n12*1\n0111";
        MineSweeper mineSweeper= new SimpleMineSweeper();
        mineSweeper.setMineField("*...\n..*.\n....");
        String b=mineSweeper.getHintField();
        Assert.assertEquals(b,tb);
        System.out.println("Test hints");
        System.out.println(tb);
        System.out.println("Hints");
        System.out.println(b);
    }
}
