package db;

import java.util.Hashtable;

import pd.application.Application;

/*
 * CompleteDM으로 불러온 Complete Hashtable을 불러와서 보관하는 고유한 싱글톤 클래스.
 * CompleteTable completetable = CompleteTable.getInstance() 형태로 불러오면 어디서든 같은 내용의 CompleteTable 사용가능.
 */
public class CompleteTable
{
    private static CompleteTable completetable;
    private static Hashtable<String, Application> completehashtable;
    private CompleteDM completeDM;
    
    private CompleteTable() {
    	completeDM = new CompleteDM("CompleteDM");
    	completehashtable = new Hashtable<>();
    }
    
    public static CompleteTable getInstance()
    {
        if (completetable == null)
        {
            synchronized(CompleteTable.class)
            {
                completetable = new CompleteTable();
            }
        }
        return completetable;
    }

    //getter 파일이 없으면 null 반환
	public Hashtable<String, Application> getCompleteHashTable() {
		completehashtable = completeDM.readObjectData();
		if(completehashtable == null)
			completehashtable = new Hashtable<>();
   		return completehashtable;
	}
	//Complete Table에 추가
	public void putCompleteHashTable(String applicationID, Application application) {
		completehashtable = completeDM.readObjectData();
		completehashtable.put(applicationID, application);
		completeDM.deletObjectData();
		completeDM.writeObjectData(completehashtable);
	}

}