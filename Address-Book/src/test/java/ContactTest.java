import org.junit.*;
import static org.junit.Assert.*;


public class ContactTest {
  @Test
  public void checkContackCreation() {
    Contact testContact = new Contact("Harry");
    assertEquals(true, testContact instanceof Contact);
  }

  // public void category_instantiatesCorrectly_true() {
  //   Category testCategory = new Category("Home");
  //   assertEquals(true, testCategory instanceof Category);
  // }
}
