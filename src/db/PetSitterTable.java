package db;

import java.util.Hashtable;
import pd.systemuser.PetSitter;

/*
 * PetSitter 데이터를 용이하게 다루려면 hashmap이 필요할 것 같아서 추가했습니다.
 * PetSitterDM을 통해서 얻은 petsitter 데이터를 하나의 hashtable에 묶어두는 싱글톤 클래스입니다.
 */
public class PetSitterTable
{
    private static PetSitterTable petsittertable;
    public Hashtable<String, PetSitter> petsitterHashTable;
    
    private PetSitterTable() {
    	PetSitterDM petsitterDM = new PetSitterDM("filepath");
    	petsitterHashTable = new Hashtable<>();
    	while(true) {
    		PetSitter petsitter;
			try {
				petsitter = petsitterDM.readObjecfData();
			} catch (Exception e) {
				break;
			}
			petsitterHashTable.put(petsitter.getUserID(), petsitter);
    	}
    }
    
    public static PetSitterTable getInstance()
    {
        if (petsittertable == null)
        {
            synchronized(PetSitterTable.class)
            {
                petsittertable = new PetSitterTable();
            }
        }
        
        return petsittertable;
    }

	public Hashtable<String, PetSitter> getUserhashTable() {
		return petsitterHashTable;
	}

}