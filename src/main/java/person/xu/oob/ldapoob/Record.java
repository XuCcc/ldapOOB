package person.xu.oob.ldapoob;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Record {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;
    private boolean isAccess = false;
    private String createTime = new Date().toString();
    private String receiveTime;

    public boolean isAccess() {
        return isAccess;
    }

    public void setAccess() {
        isAccess = true;
    }

    public String getId() {
        return id;
    }

    public void updateReceiveTime() {
        this.receiveTime = new Date().toString();
    }


}
