package entry.DoMian;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String sno;

    private String name;

    private String cid;

    private int age;

    private char sex;
}
