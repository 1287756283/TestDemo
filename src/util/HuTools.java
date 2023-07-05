package util;

import cn.hutool.Hutool;
import cn.hutool.db.DbUtil;
import org.junit.Test;

import javax.sql.DataSource;

/**
 *
 */
public class HuTools {


    @Test
    public void test() {
        Hutool.getAllUtils().stream().forEach(s-> System.out.println(s));
        DataSource ds = DbUtil.getDs();
    }

}
