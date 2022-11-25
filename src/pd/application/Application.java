package pd.application;

import java.util.Scanner;

public class Application {
    private String applicationID;               // 신청 ID        형태: "userId-idIdx"
    private String periodOfService;             // 이용 시간
    private String location;                    // 위치
    private String[] kindOfServices;            // 신청 서비스 종류
    private int price;                          // 가격
    private String state;                       // 진행 상황
    static private int idIdx;
    String[] stateList = {"신청 대기", "수락 대기", "결제 대기", "완료"};

    public Application(){
        this.applicationID = "";
        this.periodOfService = "";
        this.location = "";
        this.kindOfServices = new String[3];
        this.price = 0;
        this.state = stateList[0];
    }
    // setter

    /**
     * applicationID 는 "userId-idIdx" 의 형태를 가진다
     * @param userId 사용자 ID
     */
    public void setApplicationID(String userId) {
        this.applicationID = userId + "-"+ Integer.toString(idIdx++);
    }
    public void setPeriodOfService(String periodOfService) {
        this.periodOfService = periodOfService;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setKindOfServices(String[] kindOfServices) {
        this.kindOfServices = kindOfServices;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setState(int index) {
        this.state = stateList[index];
    }

// getter

    public String getApplicationID() {
        return applicationID;
    }
    public String getPeriodOfService() {
        return periodOfService;
    }
    public String getLocation() {
        return location;
    }
    public String getKindOfServices() {
        return String.join(", ", kindOfServices);
    }
    public int getPrice() {
        return price;
    }
    public String getState() {
        return state;
    }
    public String getUserID(){
        return this.applicationID.split("-")[0];
    }

    /**
     * 신청 정보를 신청 목록에 등록한다
     * 순서
     * 1. 신청 목록에 중복된 정보가 있는 지 확인한다
     * - 있다면 대체 여부를 묻는다
     * - - 대체한다고 하면 중복 정보를 삭제한다
     * - - 대체하지 않으면 그대로 종료한다
     * 2. 신청 목록에 신청 정보를 등록한다
     */
    public void requestApplication(){
        ApplicationList list = ApplicationList.getList();
        String redundantID;

        String check;
        Scanner scanner = new Scanner(System.in);

        redundantID = list.isExistInPresent(this.getUserID());
        if(redundantID != null){
            // 대체 여부 묻기
            System.out.println("중복된 신청이 있습니다. 대체하시겠습니까?"); // 나중에 UI로 대체
            check = scanner.next();
            // 대체할 경우 신청 삭제 요청
            if(check.compareTo("y") == 0){
                list.removeFromPresent(redundantID);
            }
            else{
                // 아닌 경우 메세지 출력 후 종료
                System.out.println("생성한 신청이 삭제 되었습니다.");
                return;
            }
        }
        // 신청 등록
        this.setState(1);
        list.addToPresent(this);
    }

}
