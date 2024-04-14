// Works with the following libraries:
// 1.junit-4.13.2.jar
// 2. hamcrest-core-1.3.jar

package myPackage.j2Maths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArmstrongTest {
  @Test
  public void is153Armstrong(){
    assertTrue(Armstrong.isArmstrong(153));
  }

  @Test
  public void is303Armstrong() {
    assertFalse(Armstrong.isArmstrong(303));
  }

  @Test
  public void is1Armstrong() {
    assertTrue(Armstrong.isArmstrong(1));
  }

  @Test
  public void is10Power9Plus7Armstrong() {
    assertFalse(Armstrong.isArmstrong(1000000007));
  }
}
