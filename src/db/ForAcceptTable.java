package db;

import java.util.Hashtable;

import pd.application.Application;

/*
 * ForAcceptDM으로 불러온 ForAccept Hashtable을 불러와서 보관하는 고유한 싱글톤 클래스.
 * ForAcceptTable foraccepttable = ForAcceptTable.getInstance() 형태로 불러오면 어디서든 같은 내용의 ForAcceptTable 사용가능.
 */
public class ForAcceptTable
{
    private static ForAcceptTable foraccepttable;
    private static Hashtable<String, Application> foraccepthashtable;
    private ForAcceptDM foracceptDM;
    
    private ForAcceptTable() {
    	foracceptDM = new ForAcceptDM("ForAcceptDM");
    }
    
    public static ForAcceptTable getInstance()
    {
        if (foraccepttable == null)
        {
            synchronized(ForAcceptTable.class)
            {
                foraccepttable = new ForAcceptTable();
            }
        }
        return foraccepttable;
    }
    
    // ForPayment 단계로 이동
    public void moveForPayment(Application application) {
    	foraccepthashtable = foracceptDM.readObjectData();
    	foraccepthashtable.remove(application.getApplicationID());
    	ForPaymentTable forpaymenttable = ForPaymentTable.getInstance();
    	application.setState(1);
    	forpaymenttable.putForPaymentHashTable(application.getApplicationID(), application);
    	foracceptDM.deletObjectData();
		foracceptDM.writeObjectData(foraccepthashtable);
    }
    
    //getter 파일이 없으면 null이 반환
	public Hashtable<String, Application> getForAcceptHashTable() {
		foraccepthashtable = foracceptDM.readObjectData();
		if(foraccepthashtable == null)
			foraccepthashtable = new Hashtable<>();
   		return foraccepthashtable;
	}
	
	//ForAcceptTable에 추가
	public void putForAcceptHashTable(String applicationID, Application application) {
		foraccepthashtable = foracceptDM.readObjectData();
		foraccepthashtable.put(applicationID, application);
		foracceptDM.deletObjectData();
		foracceptDM.writeObjectData(foraccepthashtable);
	}

}