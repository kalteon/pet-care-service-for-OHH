package db;

import java.util.Hashtable;
import java.util.ArrayList;
import pd.systemuser.Pet;

/*
 * Pet데이터를 용이하게 다루려면 hashmap이 필요할 것 같아서 추가했습니다.
 * PetDM을 통해서 얻은 user데이터를 하나의 hashtable에 묶어두는 싱글톤 클래스입니다.
 */
public class PetTable
{
    private static PetTable pettable;
    public Hashtable<String, ArrayList<Pet>> petHashTable;
    
    private PetTable() {
    	PetDM petDM = new PetDM("filepath");
    	petHashTable = new Hashtable<>();
    	while(true) {
    		Pet pet;
			try {
				pet = petDM.readObjecfData();
			} catch (Exception e) {
				break;
			}
			/*
			 * 같은 userID로 여러개의 pet이 연결될 수 있으므로 ArrayList로 묶어서 저장한다.
			 * 중복이 발생하면 pets ArrayList를 불러온뒤 add한 후에 다시 put한다.
			 */
			ArrayList<Pet> pets = new ArrayList<>();
			if(petHashTable.get(pet.getUserID()) != null)
				pets = petHashTable.get(pet.getUserID());
			pets.add(pet);
			petHashTable.put(pet.getUserID(), pets);
    	}
    }
    
    public static PetTable getInstance()
    {
        if (pettable == null)
        {
            synchronized(PetTable.class)
            {
                pettable = new PetTable();
            }
        }
        
        return pettable;
    }

	public Hashtable<String, ArrayList<Pet>> getUserhashTable() {
		return petHashTable;
	}

}