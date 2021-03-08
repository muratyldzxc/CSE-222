package gtu.cargo.company;
/**
 * Presents people who has to login the system with ID and password
 * @author Murat YILDIZ
 */
public interface Loginable {
    /**
     * Checks given ID with ID which object has
     * @param ID ID that will be compared with object ID
     * @return If ID is equal to object ID returns true, otherwise it returns false
     */
    abstract boolean checkID( String ID );
    /**
     * Checks given Password with ID which object has
     * @param Password Password that will be compared with object Password
     * @return If Password is equal to object Password returns true, otherwise it returns false
     */
    abstract boolean checkPassword( String Password );
}
