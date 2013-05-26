package us.codecraft.blackhole.suite.model;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-3-29
 */
public class UserPassport {

    private int id;

    private String username;

    private String passwordSalt;

    private String salt;

    private String ticket;

    private String zones;

    public String getTicket() {
        return ticket;
    }

    public String getZones() {
        return zones;
    }

    public void setZones(String zones) {
        this.zones = zones;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserPassport() {

    }

    /**
     * @param id
     * @param username
     * @param passwordSalt
     * @param salt
     * @param ticket
     */
    public UserPassport(int id, String username, String passwordSalt, String salt, String ticket) {
        super();
        this.id = id;
        this.username = username;
        this.passwordSalt = passwordSalt;
        this.salt = salt;
        this.ticket = ticket;
    }

    /**
     * @param username
     * @param passwordSalt
     * @param salt
     * @param ticket
     */
    public UserPassport(String username, String passwordSalt, String salt, String ticket) {
        super();
        this.username = username;
        this.passwordSalt = passwordSalt;
        this.salt = salt;
        this.ticket = ticket;
    }

    /**
     * @param username
     * @param passwordSalt
     * @param salt
     */
    public UserPassport(String username, String passwordSalt, String salt) {
        super();
        this.username = username;
        this.passwordSalt = passwordSalt;
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "UserPassport [id=" + id + ", email=" + username + ", passwordSalt=" + passwordSalt
                + ", salt=" + salt + ", ticket=" + ticket + "]";
    }

    public String getUsername() {
        return username;
    }

    public String getSalt() {
        return salt;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public boolean isAdmin(){
        return "admin".equalsIgnoreCase(username);
    }

}
