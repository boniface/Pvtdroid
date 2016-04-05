package zm.hashcode.pvtdroid.domain;

import java.io.Serializable;

/**
 * Created by hashcode on 2016/04/05.
 */
public class Settings implements Serializable{
    private String orgId;
    private String emailAddress;
    private String password;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
