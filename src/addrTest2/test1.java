package addrTest2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author zxy
 * @Date 2022-05-10
 * @Desc 使用正则表达式匹配省市县
 */
public class test1 {
    /**
     * @param address
     * @return List<Map < String, String>>
     * @Desc regexAddress()函数，传入地址，以List存储省市县
     */
    public static List<Map<String, String>> regexAddress(String address) {
        // 自定义正则表达式
        // 由于后续通过province分组无法获取到四个直辖市，所以在后续代码中再次处理，这里只需要匹配成功即可
        //String regex = "((?<province>[^省]+省|))(?<city>[^市]+市|.+区)?(?<country>[^县]+县|.+市|[^区]+.+区)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        String regex = "((?<province>[^省]+省|))(?<city>[^市]+市|.+区)?(?<country>[^县]+县|.+市|[^区]+.?+区)";
        //String regex = "((?<province>[^省]+省|))(?<city>[^市]+市|.+区)?(?<country>[^县]+县|.+市|(.?区))";
        //{浙江省嘉兴市南湖区平安小区}
        // 使用regex正则表达式匹配address地址
        Matcher matcher = Pattern.compile(regex).matcher(address);
        // 初始化省市县
        String province = null, city = null, country = null;
        // 定义ArrayList<>()
        ArrayList<Map<String, String>> table = new ArrayList<>();
        Map<String, String> row = null;
        //匹配成功的情况
        while (matcher.find()) {
            row = new LinkedHashMap<String, String>();
            //自定义正则表达式2，用于匹配四个直辖市
            String regex2 = "(上海市|北京市|天津市|重庆市)";
            Matcher matcher1 = Pattern.compile(regex2).matcher(address);
            //如果匹配成功，则将直辖市复制给province变量
            if (matcher1.find()) {
                province = matcher1.group(1);
            } else{
                // 否则直接通过matcher从regex中根据分组province匹配获得
                province = matcher.group("province");
            }
            row.put("province", province == null ? "" : province.trim());
            city = matcher.group("city");
            if (address.contains("市")) {
                row.put("city", city == null ? "" : city.trim());
            }
            country = matcher.group("country");
            row.put("country", country == null ? "" : country);
            table.add(row);
        }
        return table;
    }

    public static void main(String[] args) {
        String[] addressList = {"浙江省海宁市南湖区平安小区"};
        for (String address : addressList) {
            List<Map<String, String>> address1 = regexAddress(address);
            String province = address1.get(0).get("province");
            String city = address1.get(0).get("city");
            String country = address1.get(0).get("country");
            System.out.printf("province:%s,city:%s,country:%s\n", province, city, country);
        }
    }
}

