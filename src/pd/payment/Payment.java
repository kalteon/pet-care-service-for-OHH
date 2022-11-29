package pd.payment;

import pd.application.Application;

public class Payment {
    private String wayToPay;
    public Payment(String wayToPay, Application application) {
    	this.wayToPay = wayToPay;
    	application.setState(3);
    }
}
