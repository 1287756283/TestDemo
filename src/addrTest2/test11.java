package addrTest2;

import jdk.nashorn.internal.runtime.regexp.joni.Option;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author zxy
 * @Date 2022-05-10
 * @Desc 使用正则表达式匹配省市县
 */
public class test11 {
    /**
     * @param address
     * @return List<Map < String, String>>
     * @Desc regexAddress()函数，传入地址，以List存储省市县
     */
    public static Map<String, String> regexAddress(String address) {
        // 自定义正则表达式
        // 由于后续通过province分组无法获取到四个直辖市，所以在后续代码中再次处理，这里只需要匹配成功即可
        //String regex = "((?<province>[^省]+省|))(?<city>[^市]+市|.+区)?(?<country>[^县]+县|.+市|[^区]+.+区)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        //String regex = "((?<province>[^省]+省|))(?<city>[^市]+市|.+区)?(?<country>[^县]+县|.+市|[^区]+.?+区)?(?<street>[^县]+县|[^区]+区|[^乡]+乡|[^村]+村|[^镇]+镇|[^街道]+街道)";
        String regex = "((?<province>[^省]+省|))(?<city>[^市]+市|.+区)?(?<country>[^县]+县|.+市|(.?区))";
        //{浙江省嘉兴市南湖区平安小区}
        // 使用regex正则表达式匹配address地址
        Matcher matcher = Pattern.compile(regex).matcher(address);
        // 初始化省市县
        String province = null, city = null, country = null, street =null;
        // 定义ArrayList<>()
        Map<String, String> row = null;
        //匹配成功的情况
        while (matcher.find()) {
            row = new HashMap<>();
            // 否则直接通过matcher从regex中根据分组province匹配获得
            setAddrList(address, matcher, row);
        }
        return row;
    }

    static void setAddrList(String address, Matcher matcher, Map<String, String> row) {
        String province;
        String city;
        String country;
        String street;
        province = matcher.group("province");
        row.put("province", province == null ? "" : province.trim());
        city = matcher.group("city");
        Optional<Object> empty = Optional.empty();
        if (address.contains("市")) {
            row.put("city", city == null ? "" : city.trim());
        }
        country = matcher.group("country");
        row.put("country", country == null ? "" : country);

     /*   street = matcher.group("street");
        row.put("street", street == null ? "" : street);*/
    }

    public static void main(String[] args) {
        String address = "浙江省嘉兴市海宁市平安大道";
        Map<String, String> address1 = regexAddress(address);
        System.out.println(address1);
    }
}

