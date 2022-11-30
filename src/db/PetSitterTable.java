package db;

import java.util.Hashtable;

import pd.systemuser.Member;
import pd.systemuser.PetSitter;

/*
 * PetSitter 데이터를 용이하게 다루려면 hashmap이 필요할 것 같아서 추가했습니다.
 * PetSitterDM을 통해서 얻은 petsitter 데이터를 하나의 hashtable에 묶어두는 싱글톤 클래스입니다.
 */
public class PetSitterTable
{
    private static PetSitterTable petsittertable;
    private static Hashtable<String, PetSitter> petsitterhashtable;
    private PetSitterDM petsitterDM;
    
    private PetSitterTable() {
    	petsitterDM = new PetSitterDM("PetSitter");
    	petsitterhashtable = new Hashtable<>();
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

    //getter
	public Hashtable<String, PetSitter> getpetsitterHashTable() {
		petsitterhashtable = petsitterDM.readObjecfData();
		return petsitterhashtable;
	}

	//setter
	public void putpetsitterHashTable(String petsitterID, PetSitter petsitter) {
		petsitterhashtable.put(petsitterID, petsitter);
		petsitterDM.deletObjectData();
		petsitterDM.writeObjectData(petsitterhashtable);
	}
}