package pd.application;

public class Application {

    private int applicationID;                  // ��泥� ID
    private String periodOfService;             // �댁�� 湲곌�
    private String location;                    // ��移�
    private String[] kindOfServices;            // ��泥� ��鍮��� 醫�瑜�
    private int price;                          // 媛�寃�
    private String state;                       // 吏��� ����

    // setter
    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
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
    public void setState(String state) {
        this.state = state;
    }

    // getter
    public int getApplicationID() {
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

}
