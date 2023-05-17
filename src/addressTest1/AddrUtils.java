package addressTest1;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddrUtils {
    /**
     * 省级后缀
     */
    private static String[] suffixs = {"省", "市", "自治区", "特别行政区"};
    /**
     * 中国34个省，直辖市，自治区，特别行政区
     */
    @SuppressWarnings("serial")
    private static Map<Integer, String[]> maps = new HashMap<Integer, String[]>() {{
        /**
         * 中国的23个省
         */
        put(1, new String[]{"浙江"});
        /**
         * 中国的市
         */
        put(5, new String[]{"杭州", "宁波", "温州", "嘉兴", "湖州", "绍兴", "金华", "衢州", "舟山", "台州", "丽水",});
    }};

    /**
     * 拼接“省”，“市”后缀
     *
     * @param address
     * @param $suffix
     * @param s
     * @return
     */
    private static String restructure(String address, String $suffix, String s) {
        if (address.indexOf($suffix) == 0) {
            //拼接“省”，“市”关键字
            return address;
        } else {
            if (address.indexOf(s) != 0) {
                //拼接“省”，“市”关键字
                return address.replaceFirst(s, $suffix);
            }
        }
        return null;
    }

    /**
     * 判断是否包含省级地区
     *
     * @param address
     * @return -1（不包含省份 ）， 1（包含23个省份中的一个），2（包含直辖市），3（包含自治区），4（包含特别行政区），5（包含市级）
     */
    public static Integer isExistProvince(String address) {
        Integer isExit = -1;
        for (Map.Entry<Integer, String[]> entry : maps.entrySet()) {
            //过滤掉市级地区
            if (entry.getKey() == 5) break;
            //判断是否存在中国34个省级地址（23个普通省份，4个直辖市，5个自治区，2个特别行政区）
            for (String provin : entry.getValue()) {
                if (address.indexOf(provin) == 0) {
                    return entry.getKey();
                }
            }
        }
        return isExit;
    }

    /**
     * 出现下列关键词的将不作处理
     */
    @SuppressWarnings({"serial"})
    private static Map<Integer, String[]> cityKeyWords = new LinkedHashMap<Integer, String[]>() {{
        put(0, new String[]{"县"});
        put(1, new String[]{"市辖区", "市辖县"});

    }};

    /**
     * 处理没有填写市级地区的地址，一旦检查出来，则添加上后缀
     * 例如：成都高新区
     * 结果：成都市高新区
     *
     * @param address
     * @return
     */
    private static String restructure(String address, String provinces) {
        //provinces == 1
        if (provinces.equals("1")){
            address = new StringBuilder(address).insert(2, "省").toString();
//            address = address.replace(provinces, "");
        }

        //如果第一位是"县"，替换为""
        if (cityKeyWords.get(0)[0].equals(address.substring(0, 1))) {
            address = address.substring(1);
        }
        //如果省份是直辖市，自动插入"市辖区"用于区分
        for (String s : maps.get(1)) {
            if (provinces.equals(s + suffixs[1])) {
                address = cityKeyWords.get(1)[0] + address;
            }
        }
        //后缀
        String suffix = suffixs[1];
        big:
        for (String s : maps.get(5)) {
            //拼接“省”，“市”后缀
            if (address.contains(s)){
                String $address = restructure(address, s + suffix, s);
                if ($address != null) {
                    address = $address;
                    break;
                }
            }
        }
        return address;
    }

    /**
     * 解析地址
     *
     * @param address
     * @return
     */
    public static Map<String, String> addressResolution(String address) {
        String regex = "(?<province>[^特别行政区]+特别行政区|[^自治区]+自治区|[^省]+省|[^市]+市)(?<city>省直辖行政单位|省属虚拟市|市辖县|市辖区|县|自治州|[^地区]+地区|[^州]+州|[^盟]+盟|[^市]+市|[^区]+区|)?(?<county>[^旗]+旗|[^市]+市|[^区]+区|[^县]+县)?(?<town>[^县]+县|[^区]+区|[^乡]+乡|[^村]+村|[^镇]+镇|[^街道]+街道)?(?<village>.*)";

        //正则表达式
   /*     String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)";
        regex += "(?<city>[^市]+自治州|.*?地区|.*?行政单位|.*行政区划|.+盟|市辖区|.*?市|.*?县)";
        regex += "(?<town>[^区].*?县|.*?区|.*?市|.*?旗|.+海域|.*?岛)?";
        regex += "(?<address>.*)";
        */
        Matcher matcher = Pattern.compile(regex).matcher(address);
        Map<String, String> rmap = null;
        while (matcher.find()) {
            rmap = new LinkedHashMap<String, String>();
            rmap.put("province", matcher.group("province") == null ? "" : matcher.group("province").trim());
            rmap.put("city", matcher.group("city") == null ? "" : matcher.group("city").trim());
            rmap.put("county", matcher.group("county") == null ? "" : matcher.group("county").trim());
            rmap.put("town", matcher.group("town") == null ? "" : matcher.group("town").trim());
            rmap.put("village", matcher.group("village") == null ? "" : matcher.group("village").trim());
        }
        //重构一次地址
        return addressResolution(rmap);
    }


    /**
     * 重构一次地址，将直辖市所在区域进行特殊处理
     * 注：如果在地址中出现未明确省市区的将无法去重，由于详细地址中可能出现于省市同名的情况，所有对于这类情况将
     * 保留，即使从肉眼能看出是重复的，也不会处理
     * 例如：四川省成都市高新区四川成都高新xxxx大道xxx号
     *
     * @param rmap
     * @return
     */
    private static Map<String, String> addressResolution(Map<String, String> rmap) {
        if (rmap == null) return rmap;
        //针对直辖市，进行特殊处理
        String city = rmap.get("city");
        //将直辖市-市级全部替换为区级内容，并将区级内容全部替换为""
        for (String s : cityKeyWords.get(1)) {
            if (s.equals(city)) {
                rmap.put("city", rmap.get("county"));
                rmap.put("county", "");
                break;
            }
        }
        //市
        city = rmap.get("city");
        //区（县）
        String county = rmap.get("county");
        //省
        String province = rmap.get("province");
        //街道，乡村，镇
        rmap.put("town", rmap.get("town").replace(city, "").replace(county, "").replace(province, ""));
        //详细地址
        rmap.put("village", rmap.get("village").replace(city, "").replace(county, "").replace(province, ""));

        return rmap;
    }

    /**
     * 格式化省市县/区信息
     *
     * @param address
     * @return
     */
    public static Map<String, String> addressFormat(String address) {
        if (address == null) return null;
        address = address.replaceAll("\\s+", "");
        //判断是否存在省级地区
        int k = isExistProvince(address);
        if (k == -1) {
            return null;
        } else {
            //重构地区格式（拼接省级，市级地区后缀名）
            address = restructure(address, String.valueOf(k));
        }
        //格式化地址
        Map<String, String> addresss = addressResolution(address);
        if (addresss == null) {
            return null;
        }
        //省份
        String province = addresss.get("province");
        //市
        String city = addresss.get("city");
        //区县
        String county = addresss.get("county");

        //详细地址
        String town = addresss.get("town");
        String village = addresss.get("village");

        //完整地址 ： 省 + 市 + 区 + 详细地址
        StringBuilder detailAddress = new StringBuilder();
        detailAddress.append(province).append(" ").append(city).append(" ").append(county).append(" ").append(town).append(village);

        Map<String, String> rmap = new LinkedHashMap<String, String>();
        rmap.put("province", province);
        rmap.put("city", city);
        rmap.put("county", county);
        rmap.put("town", town + village);
        rmap.put("detail", detailAddress.toString().replaceAll("\\s+", ""));
        rmap.put("detail_format", detailAddress.toString());
        return rmap;
    }

    //============================================main==================================================
    public static void main(String[] args) {
        String[] address = {"浙江省南湖区平安小区"};
        for (String s : address) {
            System.out.println(JSONObject.toJSONString(addressFormat(s)));
        }
    }
}
