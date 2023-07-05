package GuessAddrUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test4 {

    /**
     * 解析地址
     *
     * @param address
     * @return
     * @author lin
     */
    public static List<Map<String,String>> addressResolution(String address){
        String regex="((?<province>[^省]+省|.+自治区)|上海|北京|天津|重庆)(?<city>[^市]+市|.+自治州)(?<county>[^县]+县|.+区|.+镇|.+局)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m=Pattern.compile(regex).matcher(address);
        String province=null,city=null,county=null,town=null,village=null;
        List<Map<String,String>> table=new ArrayList<Map<String,String>>();
        Map<String,String> row=null;
        while(m.find()){
            row=new LinkedHashMap<String,String>();
            province=m.group("province");
            row.put("province", province==null?"":province.trim());
            city=m.group("city");
            row.put("city", city==null?"":city.trim());
            county=m.group("county");
            row.put("county", county==null?"":county.trim());
            town=m.group("town");
            row.put("town", town==null?"":town.trim());
            village=m.group("village");
            row.put("village", village==null?"":village.trim());
            table.add(row);
        }
        return table;
    }

    public static void main(String[] args) {
        System.out.println(addressResolution("浙江省平湖市平湖市华威印花有限公司"));
        System.out.println(addressResolution("浙江省海盐县国际大厦"));
        System.out.println(addressResolution("浙江省嘉兴市嘉善县苏家浜小区"));
        System.out.println(addressResolution("浙江省海盐县宜家花城"));
        System.out.println(addressResolution("浙江省南湖区隆兴公寓"));
        System.out.println(addressResolution("绍兴市柯桥区安昌镇前庄村"));
        System.out.println(addressResolution("嘉兴市秀洲区王江泾镇虹桥路鸣业纺织"));
        System.out.println(addressResolution("浙江省南湖区平安小区"));
        System.out.println(addressResolution("浙江省嘉兴市平湖市吉祥小区"));

    }
}