import java.util.ArrayList;

public class Contact {
  private static ArrayList<Contact> mInstances = new ArrayList<Contact>();
  private ArrayList<Phone> mNumbers;
  private String mFirstName;
  private String mLastName;
  private int mBirthMonth;
  private int mId;

  public Contact (String firstname, String lastname) {
    mFirstName = firstname;
    mLastName = lastname;
    mNumbers = new ArrayList<Phone>();
    mInstances.add(this);
    mId = mInstances.size();
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

  public static void clear() {
    mInstances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Contact find(int id){
    try {
      return mInstances.get(id - 1);
    } catch (IndexOutOfBoundsException e){
      return null;
    }
  }
}
