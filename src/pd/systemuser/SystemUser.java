package pd.systemuser;

public class SystemUser {
    // 개인 정보
    protected String name;                  // 이름
    protected String birth;                 // 생년월일
    protected int age;                      // 나이
    protected String address;               // 주소
    protected String cellPhoneContact;      // 연락처
    protected String email;                 // 이메일

    // 로그인 정보
    protected String loginID;               // 로그인 ID
    protected String password;              // 로그인 비밀번호

    protected int ID;                       // 회원 ID

    // init
    public SystemUser(String name, String birth, int age, String address, String cellPhoneContact, String email,
                      String loginID, String password, int ID){
        setName(name);
        setBirth(birth);
        setAge(age);
        setAddress(address);
        setCellPhoneContact(cellPhoneContact);
        setEmail(email);
        setLoginID(loginID);
        setPassword(password);
        setID(ID);
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCellPhoneContact(String cellPhoneContact) {
        this.cellPhoneContact = cellPhoneContact;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    // getter
    public int getID() {
        return ID;
    }

}
