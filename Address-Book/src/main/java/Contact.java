public class Contact {
  private String mFirstName;
  private String mLastName;
  private int mBirthMonth;

  public Contact (String firstname, String lastname) {
    mFirstName = firstname;
    mLastName = lastname;
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

  // public
}
