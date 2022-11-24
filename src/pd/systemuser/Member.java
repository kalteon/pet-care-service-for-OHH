package pd.systemuser;

public class Member extends SystemUser{
    private String enterWay;            // 출입 방법
    private int numOfPet;               // 반려동물 수

    // init
    public Member(String name, String birth, int age, String address, String cellPhoneContact,
                  String email, String loginID, String password, int ID, String enterWay, int numOfPet) {
        super(name, birth, age, address, cellPhoneContact, email, loginID, password, ID);
        setEnterWay(enterWay);
        setNumOfPet(numOfPet);
    }

    // setter
    public void setEnterWay(String enterWay) {
        this.enterWay = enterWay;
    }
    public void setNumOfPet(int numOfPet) {
        this.numOfPet = numOfPet;
    }

    // getter
    public String getEnterWay() {
        return enterWay;
    }
    public int getNumOfPet() {
        return numOfPet;
    }
}
