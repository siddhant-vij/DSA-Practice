package myPackage.j4recursion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecursionBasicsTest {
  @Test
  public void testGuessOutput3ForNEquals56() {
    int test = (int) (Math.floor((Math.log(56)) / Math.log(2)));
    assertEquals(test, RecursionBasics.guessOutput3(56));
  }

  @Test
  public void testGuessOutput3ForNEquals9875612() {
    int test = (int) (Math.floor((Math.log(9875612)) / Math.log(2)));
    assertEquals(test, RecursionBasics.guessOutput3(9875612));
  }

  @Test
  public void testGuessOutput4ForNEquals9() {
    int test = (int) (Math.floor((Math.log(9)) / Math.log(3)));
    assertEquals(test, RecursionBasics.guessOutput4(9));
  }

  @Test
  public void testGuessOutput4ForNEquals987412563() {
    int test = (int) (Math.floor((Math.log(987412563)) / Math.log(3)));
    assertEquals(test, RecursionBasics.guessOutput4(987412563));
  }
}