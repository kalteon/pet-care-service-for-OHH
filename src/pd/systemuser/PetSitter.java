package pd.systemuser;

import db.SystemUserData;

public class PetSitter extends SystemUser{
    private String[] certificate;             // 소지 자격증
    private int numOfCertificate;             // 자격증 수

    // init
    public PetSitter(SystemUserData systemUserData, String certificate) {
        super(systemUserData);
        setNumOfCertificate(0);
        setCertificate(certificate);
    }

    // setter
    public void setCertificate(String certificate) {
        this.certificate[this.numOfCertificate++] = certificate;
    }
    public void setNumOfCertificate(int numOfCertificate) {
        this.numOfCertificate = numOfCertificate;
    }

    // getter
    public String getCertificate() {
        return String.join(", ", certificate);
    }
    public int getNumOfCertificate() {
        return numOfCertificate;
    }
}
