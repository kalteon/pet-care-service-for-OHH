package pd.application;

import java.util.Hashtable;
import java.util.ArrayList;

import db.SystemUserTable;
import db.PetSitterTable;
import pd.systemuser.Pet;
import pd.systemuser.PetSitter;
import pd.systemuser.SystemUser;

public final class ApplicationList {
    private static final ApplicationList list = new ApplicationList();
    private final Hashtable<String, Application> htForPresent = new Hashtable<String, Application>();
    private final Hashtable<String, Application> htForPast = new Hashtable<String, Application>();
    private ApplicationList() {}
    public static ApplicationList getList(){
        return list;
    }

    // getter
    public Hashtable<String, Application> getHtForPast() {
        return htForPast;
    }
    public Hashtable<String, Application> getHtForPresent() {
        return htForPresent;
    }

    /**
     * 입력으로 들어온 신청 정보를
     * htForPresent 에 저장
     * @param application 추가할 신청 정보
     */
    public void addToPresent(Application application){
        htForPresent.put(application.getApplicationID(), application);
    }

    /**
     * 입력으로 들어온 application ID 로
     * htForPresent 에 있는 정보를 삭제한 후
     * htForPast 에 저장
     * @param applicationID 삭제할 신청 정보
     */
    public void removeFromPresent(String applicationID){
        Application application;
        application = htForPresent.get(applicationID);
        htForPresent.remove(applicationID);
        htForPast.put(application.getApplicationID(), application);
    }

    /**
     * 사용자 ID를 input 으로 받아
     * 상태가 "신청 대기"나 "결제 대기"에 있는 신청이 있는지 검사하고
     * 있으면 그 신청의 ID, 없으면 null 을 반환
     * @param userID 사용자 ID
     * @return key or null
     */
    public String isExistInPresent(String userID){
        for(String key:htForPresent.keySet()){
            if(key.split("-")[0].compareTo(userID) == 0){
                return key;
            }
        }
        return null;
    }

    public void printHashTable(){
        System.out.println("htForPresent");
        for(String key: htForPresent.keySet()){
            System.out.println(htForPresent.get(key).getApplicationID());
        }
        System.out.println("htForPast");
        for(String key: htForPast.keySet()){
            System.out.println(key);
        }
        System.out.println("");
    }
    
    /*
     * 돌봄이가 신청정보를 선택해 조회하면 Application에서 userID를 인자로 사용하여 Member를 찾아 Pet ArrayList 반환
   
    public ArrayList<Pet> getPetArrayList(Application application) {
    	SystemUserTable systemuserTable = SystemUserTable.getInstance();
    	systemuserTable.getUserHashTable().get(application.getUserID()).get;
    }
     */
    /*
     * 신청을 수락하면 "결제 대기" 상태로 바꾸고 돌봄ID를 Application에 넣음
     */
    public void accpetApplication(Application application) {
    	application.setState(2);
    	application.setPetsitterID("petsitterID");
    }
    
    public PetSitter getPetSitter(Application application) {
    	PetSitterTable petsittertable = PetSitterTable.getInstance();
    	return petsittertable.getUserhashTable().get(application.getUserID());
    }
}
