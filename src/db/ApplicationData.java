package db;

public class ApplicationData {
    private String periodOfService;             // 이용 시간
    private String location;                    // 위치
    private String[] kindOfServices;            // 신청 서비스 종류
    private int price;                          // 가격
    private String state;                       // 진행 상황

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
    public void setState(String state) {
        this.state = state;
    }

    // getter
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

}
