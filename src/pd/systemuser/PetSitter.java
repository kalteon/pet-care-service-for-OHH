package pd.systemuser;

public class PetSitter extends SystemUser{
    private String[] certificate;             // 소지 자격증
    private int numOfCertificate;             // 자격증 수

    // init
    public PetSitter(String name, String birth, int age, String address, String cellPhoneContact,
                     String email, String loginID, String password, int ID, String certificate) {
        super(name, birth, age, address, cellPhoneContact, email, loginID, password, ID);
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
