import java.util.ArrayList;

public class Contact {
  private ArrayList<Phone> mNumbers = new ArrayList<Phone>();
  private String mFirstName;
  private String mLastName;
  private int mBirthMonth;

  public Contact (String firstname, String lastname) {
    mFirstName = firstname;
    mLastName = lastname;
    mNumbers = new ArrayList<Phone>();
  }

  public String getName() {
    return mFirstName + " " + mLastName;
  }

  public void addBirthMonth(int month) {
    mBirthMonth = month;
  }

  public int getBirthMonth() {
    return mBirthMonth;
  }

  public void addPhone(Phone phone) {
    mNumbers.add(phone);
  }

  public ArrayList<Phone> getNumbers() {
    return mNumbers;
  }
}
