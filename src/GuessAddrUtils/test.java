package GuessAddrUtils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args) {
        Map<String, String> addressResolution1 = addressResolution("浙江省平湖市平湖市华威印花有限公司");
        Map<String, String> addressResolution2 = addressResolution("浙江省海盐县国际大厦");
        Map<String, String> addressResolution3 = addressResolution("浙江省嘉兴市嘉善县苏家浜小区");
        Map<String, String> addressResolution4 = addressResolution("浙江省海盐县宜家花城");
        Map<String, String> addressResolution5 = addressResolution("浙江省南湖区隆兴公寓");
        Map<String, String> addressResolution6 = addressResolution("绍兴市柯桥区安昌镇前庄村");
        Map<String, String> addressResolution7 = addressResolution("嘉兴市秀洲区王江泾镇虹桥路鸣业纺织");
        Map<String, String> addressResolution8 = addressResolution("浙江省南湖区平安小区");
        Map<String, String> addressResolution9 = addressResolution("浙江省嘉兴市平湖区吉祥小区");
        List<Map<String, String>> addressResolutionList = new ArrayList<>();
        addressResolutionList.addAll(CollUtil.newArrayList(addressResolution1,addressResolution2,addressResolution3,addressResolution4,addressResolution5,addressResolution6,addressResolution7,addressResolution8,addressResolution9));
        System.out.println(addressResolutionList);
    }

    public static Map<String, String> addressResolution(String AllAddress) {
        //有手动空格解析
        Matcher m = Pattern.compile("\\S+").matcher(AllAddress);
        List<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group());
        }
        HashMap<String, String> map = new HashMap<>();
        if (list.size() == 4) {
            map.put("province", list.get(0));
            map.put("city", list.get(1));
            map.put("town", list.get(2));
            map.put("address", list.get(3));
            return map;
        }
        //省份处理
        String provinceSplit = AllAddress.substring(0, 2);//截取前2位
        //直辖市4 vipCityList
        List<String> vipCityList= CollUtil.newArrayList("北京","上海","天津","重庆");
        //省23 sf
        List<String> SFbyList = CollUtil.newArrayList("黑龙", "吉林", "辽宁", "河北", "山西", "青海", "山东", "河南", "江苏", "安徽", "浙江",
                "福建", "江西", "湖南", "湖北", "广东", "台湾", "海南", "甘肃", "陕西", "四川", "贵州", "云南");
        //城市处理
        List<String> cities= CollUtil.newArrayList("杭州","湖州","嘉兴","金华","丽水","宁波","衢州","绍兴","台州","温州","舟山");

        //如果直辖市集合包含地址前两位
        if (vipCityList.contains(provinceSplit)) {
            int s = AllAddress.indexOf('市');
            if (s != 2) {
                StringBuffer stringBuilder = new StringBuffer(AllAddress);
                stringBuilder.insert(2, "市");
                AllAddress = stringBuilder.toString();
            }
        } else if (SFbyList.contains(provinceSplit)) {
            int s = AllAddress.indexOf('省');
            StringBuffer stringBuilder = new StringBuffer(AllAddress);
            if (provinceSplit == "黑龙" && s != 3) {
                stringBuilder.insert(3, "省");
                AllAddress = stringBuilder.toString();
            } else if (provinceSplit != "黑龙" && s != 2) {
                stringBuilder.insert(2, "省");
                AllAddress = stringBuilder.toString();
            }
        }
        //正则表达式
        String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)";
        regex += "(?<city>[^市]+自治州|.*?地区|.*?行政单位|.*行政区划|.+盟|市辖区|.*?市|.*?县)";
        regex += "(?<town>[^区].*?县|.*?区|.*?市|.*?旗|.+海域|.*?岛)?";
        regex += "(?<address>.*)";
        m = Pattern.compile(regex).matcher(AllAddress);
        while (m.find()) {
            //一级地址
            String province = m.group("province");
            map.put("province", province == null ? "" : province.trim());
            //二级地址
            String city = m.group("city");
            map.put("city", city == null ? "" : city.trim());
            //三级地址
            String town = m.group("town");
            map.put("town", town == null ? "" : town.trim());
            //四级地址
            String address = m.group("address");
            map.put("address", address == null ? "" : address.trim());
        }
        return map;
    }

}
