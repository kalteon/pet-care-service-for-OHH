package pd.systemuser;

import db.SystemUserData;
import java.util.ArrayList;

public class Member extends SystemUser{
    private String enterWay;            // 출입 방법
    private int numOfPet;               // 반려동물 수
    private ArrayList<Pet> pets = new ArrayList<>();
    
    // init
    public Member(SystemUserData systemUserData, String enterWay, int numOfPet) {
        super(systemUserData);
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
    public Pet getPets(){
    	return pets;
    }
}
