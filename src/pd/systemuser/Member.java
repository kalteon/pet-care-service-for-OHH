package pd.systemuser;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Member extends SystemUser{
    private String enterWay;            // 출입 방법
    private int numOfPet;               // 반려동물 수
    private ArrayList<Pet> pets = new ArrayList<>();
    
    // init
    public Member(String name, String birth, int age, String address, String cellPhoneContact, String email,
    		String loginID, String password, String userID, String enterWay, int numOfPet) {
        super(name, birth, age, address, cellPhoneContact, email, loginID, password, userID);
        setEnterWay(enterWay);
        setNumOfPet(numOfPet);
    }

    public void addPet(Pet pet) {
    	pets.add(pet);
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
    public ArrayList<Pet> getPets(){
    	return pets;
    }
}
