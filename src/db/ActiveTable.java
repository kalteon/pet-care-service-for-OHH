package db;

import java.util.Hashtable;

import pd.application.Application;

/*
 * ActiveDM으로 불러온 Active Hashtable을 불러와서 보관하는 고유한 싱글톤 클래스.
 * ActiveTable activetable = ActiveTable.getInstance() 형태로 불러오면 어디서든 같은 내용의 ForPaymentTable 사용가능.
 */
public class ActiveTable
{
    private static ActiveTable activetable;
    private static Hashtable<String, Application> activehashtable;
    private ActiveDM activeDM;
    
    private ActiveTable() {
    	activeDM = new ActiveDM("ActiveDM");
    }
    
    public static ActiveTable getInstance()
    {
        if (activetable == null)
        {
            synchronized(ActiveTable.class)
            {
                activetable = new ActiveTable();
            }
        }
        return activetable;
    }

    //Complete로 상태 전환 및 이동
    public void moveComplete(Application application) {
    	activehashtable = activeDM.readObjectData();
    	activehashtable.remove(application.getApplicationID());
    	CompleteTable completetable = CompleteTable.getInstance();
    	application.setState(3);
    	completetable.putCompleteHashTable(application.getApplicationID(), application);
    	activeDM.deletObjectData();
		activeDM.writeObjectData(activehashtable);
    }
    //getter 파일이 없으면 null 반환
	public Hashtable<String, Application> getActiveHashTable() {
		activehashtable = activeDM.readObjectData();
		if(activehashtable == null)
			activehashtable = new Hashtable<>();
   		return activehashtable;
	}
	
	//ActiveTable에 추가
	public void putActiveHashTable(String applicationID, Application application) {
		activehashtable = activeDM.readObjectData();
		activehashtable.put(applicationID, application);
		activeDM.deletObjectData();
		activeDM.writeObjectData(activehashtable);
	}

}