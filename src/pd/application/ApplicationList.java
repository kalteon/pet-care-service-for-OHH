package pd.application;

import java.util.Hashtable;
import java.util.ArrayList;

import db.*;
import pd.systemuser.PetSitter;
import pd.systemuser.Pet;

public final class ApplicationList {
    private static final ApplicationList list = new ApplicationList();
    private final Hashtable<String, Application> htForPresent = new Hashtable<String, Application>();
    private final Hashtable<String, Application> htForPast = new Hashtable<String, Application>();
    private ApplicationList() {}

    private final Hashtable<String, Application> forAcceptTable =
            ForAcceptTable.getInstance().getForAcceptHashTable();           // 수락 대기 테이블
    private final Hashtable<String, Application> forPaymentTable =
            ForPaymentTable.getInstance().getForPaymentHashTable();         // 결제 대기 테이블
    private final Hashtable<String, Application> forActiveTable =
            ActiveTable.getInstance().getActiveHashTable();                 // 진행중 테이블
    private final Hashtable<String, Application> forCompleteTable =
            CompleteTable.getInstance().getCompleteHashTable();             // 완료 테이블

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

    public Hashtable<String, Application> getForAcceptTable() {
        return forAcceptTable;
    }

    public Hashtable<String, Application> getForPaymentTable() {
        return forPaymentTable;
    }

    public Hashtable<String, Application> getForActiveTable() {
        return forActiveTable;
    }

    public Hashtable<String, Application> getForCompleteTable() {
        return forCompleteTable;
    }

    /**
     * 입력으로 들어온 신청 정보를
     * htForPresent 에 저장
     * @param application 추가할 신청 정보
     */
    public void addToPresent(Application application){
        forAcceptTable.put(application.getApplicationID(), application);
    }

    /**
     * 입력으로 들어온 application ID 로
     * htForPresent 에 있는 정보를 삭제한 후
     * htForPast 에 저장
     * @param applicationID 삭제할 신청 정보
     */
    public void removeFromPresent(String applicationID){
        Application application;
        application = forAcceptTable.get(applicationID);
        forAcceptTable.remove(applicationID);
        application.setState(3);
        forCompleteTable.put(applicationID, application);
    }

    /**
     * 사용자 ID를 input 으로 받아
     * 상태가 "신청 대기"나 "결제 대기"에 있는 신청이 있는지 검사하고
     * 있으면 그 신청의 ID, 없으면 null 을 반환
     * @param userID 사용자 ID
     * @return key or null
     */
    public String isExistInPresent(String userID){
        for(String key:forAcceptTable.keySet()){
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
}
