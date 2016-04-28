public class Phone {
  private String mAreaCode;
  private String mType;
  private String mPhoneNumber;

  public Phone(String areaCode, String phoneNumber, String type){
    mAreaCode = areaCode;
    mPhoneNumber = phoneNumber;
    mType = type;
  }

  public String getFullPhoneNumber() {
    return mAreaCode + "-" + mPhoneNumber;
  }
}
