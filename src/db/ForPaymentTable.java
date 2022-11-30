package db;

import java.util.Hashtable;

import pd.application.Application;

/*
 * ForPaymentDM으로 불러온 ForPayment Hashtable을 불러와서 보관하는 고유한 싱글톤 클래스.
 * ForPayemntTable forpaymenttable = ForPaymentTable.getInstance() 형태로 불러오면 어디서든 같은 내용의 ForPaymentTable 사용가능.
 */
public class ForPaymentTable
{
    private static ForPaymentTable forpaymenttable;
    private static Hashtable<String, Application> forpaymenthashtable;
    private ForPaymentDM forpaymentDM;
    
    private ForPaymentTable() {
    	forpaymentDM = new ForPaymentDM("ForPaymentDM");
    }
    
    public static ForPaymentTable getInstance()
    {
        if (forpaymenttable == null)
        {
            synchronized(ForPaymentTable.class)
            {
                forpaymenttable = new ForPaymentTable();
            }
        }
        return forpaymenttable;
    }

    //Active로 상태 이동
    public void moveActive(Application application) {
    	forpaymenthashtable = forpaymentDM.readObjectData();
    	forpaymenthashtable.remove(application.getApplicationID());
    	ActiveTable activetable = ActiveTable.getInstance();
    	application.setState(2);
    	activetable.putActiveHashTable(application.getApplicationID(), application);
    	forpaymentDM.deletObjectData();
		forpaymentDM.writeObjectData(forpaymenthashtable);
    }
    
    //getter 파일이 없으면 null 반환
	public Hashtable<String, Application> getForPaymentHashTable() {
		forpaymenthashtable = forpaymentDM.readObjectData();
		if(forpaymenthashtable == null)
			forpaymenthashtable = new Hashtable<>();
   		return forpaymenthashtable;
	}
	
	//ForPayment Table에 추가
	public void putForPaymentHashTable(String applicationID, Application application) {
		forpaymenthashtable = forpaymentDM.readObjectData();
		forpaymenthashtable.put(applicationID, application);
		forpaymentDM.deletObjectData();
		forpaymentDM.writeObjectData(forpaymenthashtable);
	}

}