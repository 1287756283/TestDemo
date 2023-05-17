package entry;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

/**
 * @author LIAN
 * @create 2021/10/19 9:43
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Comparable {
    private String name;
    private BigDecimal bigDecimal;
    private int age;

    @Override
    public String toString() {
        /*return "{" +
                "name:'" + name + '\'' +
                ", bigDecimal:" + bigDecimal +
                ", age:" + age +
                '}';*/
        //这不是拖了

        return JSON.toJSONString(this);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

/*    @Override
    public boolean equals(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            if (this.name.equals(user.name)) {
                return true;
            }
            return false;
        }
        return false;
    }*/

 /*   @Override
    public int hashCode() {
        if (this.getName() != null) {
            return this.getName().hashCode();
        }
        return this.age;
    }*/


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
