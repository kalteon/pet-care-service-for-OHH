package db;

import java.util.Hashtable;
import pd.systemuser.SystemUser;

/*
 * SystemUser데이터를 용이하게 다루려면 hashmap이 필요할 것 같아서 추가했습니다.
 * SystemUserDM을 통해서 얻은 user데이터를 하나의 hashtable에 묶어두는 싱글톤 클래스입니다.
 */
public class SystemUserTable
{
    private static SystemUserTable systemusertable;
    private Hashtable<String, SystemUser> userHashTable;
    
    private SystemUserTable() {
    	SystemUserDM systemuserDM = new SystemUserDM("filepath");
    	userHashTable = new Hashtable<>();
    	while(true) {
    		SystemUser user;
			try {
				user = systemuserDM.readObjecfData();
			} catch (Exception e) {
				break;
			}
			userHashTable.put(user.getUserID(), user);
    	}
    }
    
    public static SystemUserTable getInstance()
    {
        if (systemusertable == null)
        {
            synchronized(SystemUserTable.class)
            {
                systemusertable = new SystemUserTable();
            }
        }
        
        return systemusertable;
    }

	public Hashtable<String, SystemUser> getUserHashTable() {
		return userHashTable;
	}

}
