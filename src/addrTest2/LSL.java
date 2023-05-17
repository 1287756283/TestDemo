package addrTest2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: lsl
 * @description:
 * @date: 2022/7/27 14:22
 */
public class LSL {

    public static String regexAddress(String address) {
        // 自定义正则表达式
        String regex = "((?<province>[^省]+省|))(?<city>[^市]+市|.+区)?(?<country>[^县]+县|.+市|[^区]+.?+区)?(?<street>[^县]+县|[^区]+区|[^乡]+乡|[^村]+村|[^镇]+镇|[^街道]+街道)";
        // 使用regex正则表达式匹配address地址
        Matcher matcher = Pattern.compile(regex).matcher(address);
        // 初始化省市县
        String province = null,city = null,country = null;
        // 定义ArrayList<>()
        Map<String,String> row = null;
        //匹配成功的情况
        while (matcher.find()){
            row = new LinkedHashMap<String,String>();
            test11.setAddrList(address, matcher, row);
        }
        System.out.println(row);
        String countryName = row.get("country").replaceAll("市", "").replaceAll("区", "").replaceAll("县", "");
        return countryName;
    }

    public static void main(String[] args) {
        String countyName = regexAddress("浙江省嘉兴市南湖区大营镇店东村");
        System.out.println(countyName);
    }
}
