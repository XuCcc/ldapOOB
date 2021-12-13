package person.xu.oob.ldapoob;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//表明这是个需要生成数据表的类
//public class User {
//        定义主键id
//    @Id
//    声明一个策略通用生成器，name为”system-uuid”,策略strategy为”uuid”。
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    用generator属性指定要使用的策略生成器。
//    @GeneratedValue(generator = "system-uuid")
//    private String id;
//    private String name;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
@Entity
public class Record {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    public boolean isAccess() {
        return isAccess;
    }

    public void setAccess() {
        isAccess = true;
    }

    private boolean isAccess = false;

    public String getId() {
        return id;
    }


}
