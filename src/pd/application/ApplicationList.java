package pd.application;

import java.util.Hashtable;

public final class ApplicationList {
    private static final ApplicationList list = new ApplicationList();
    private final Hashtable<Integer, Application> htForPresent = new Hashtable<Integer, Application>();
    private final Hashtable<Integer, Application> htForPast = new Hashtable<Integer, Application>();
    private ApplicationList() {}

    public static ApplicationList getList(){
        return list;
    }

    // getter
    public Hashtable<Integer, Application> getHtForPast() {
        return htForPast;
    }
    public Hashtable<Integer, Application> getHtForPresent() {
        return htForPresent;
    }

    // add Data to hash table
    public void addToPresent(int ID, Application application){
        htForPresent.put(ID, application);
    }
    public void addToPast(int ID, Application application){
        htForPresent.remove(ID);
        htForPast.put(ID, application);
    }

    // remove data from hash table
    public void removeFromPresent(int ID){
        htForPresent.remove(ID);
    }
    public void removeFromPast(int ID){
        htForPast.remove(ID);
    }

}
