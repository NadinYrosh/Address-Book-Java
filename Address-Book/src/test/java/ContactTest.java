import org.junit.*;
import static org.junit.Assert.*;


public class ContactTest {
  @Test
  public void checkContackCreation() {
    Contact testContact = new Contact("Harry", "Potter");
    assertEquals(true, testContact instanceof Contact);
  }

  @Test
  public void checkforName() {
    Contact testContact = new Contact("Harry", "Potter");
    assertEquals("Harry Potter", testContact.getName());
  }

  @Test
  public void checkforBirthMonth() {
    Contact testContact = new Contact("Harry", "Potter");
    testContact.addBirthMonth(7);
    assertEquals(7, testContact.getBirthMonth());
  }

  @Test
  public void getFullPhoneNumber() {
    Phone testPhone = new Phone("503", "555-1234", "Home");
    assertEquals("503-555-1234", testPhone.getFullPhoneNumber());
  }

  @Test
  public void get_PhoneNumberType_Home(){
    Phone testPhone = new Phone("503", "555-1234", "Home");
    assertEquals("Home", testPhone.getPhoneType());
  }

  // @Test
  // public void

  // public void category_instantiatesCorrectly_true() {
  //   Category testCategory = new Category("Home");
  //   assertEquals(true, testCategory instanceof Category);
  // }
}
