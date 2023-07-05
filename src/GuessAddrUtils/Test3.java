package GuessAddrUtils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Pair;
import entry.DoMian.User;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test3 {

    public static double irr(double[] income) {
        return irr(income, 0.1D);
    }

    public static double irr(double[] values, double guess) {
        int maxIterationCount = 20;
        double absoluteAccuracy = 1.0E-007D;

        double x0 = guess;

        int i = 0;
        while (i < maxIterationCount) {
            double fValue = 0.0D;
            double fDerivative = 0.0D;
            for (int k = 0; k < values.length; k++) {
                fValue += values[k] / Math.pow(1.0D + x0, k);
                fDerivative += -k * values[k] / Math.pow(1.0D + x0, k + 1);
            }
            double x1 = x0 - fValue / fDerivative;
            if (Math.abs(x1 - x0) <= absoluteAccuracy) {
                return x1;
            }
            x0 = x1;
            i++;
        }
        return (0.0D / 0.0D);
    }


    public static void main(String[] args) {
        double[] income = {-9272.49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 888.49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 888.49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 888.49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 888.49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 888.49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 888.49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 888.49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 888.49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 888.49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 888.49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 888.49,};
        double ret = irr(income, 0.00001d);
        System.out.println(new BigDecimal(ret));

    }


    @Test
    public void logTest() {
        List<User> list = null;
        Map<String, User> collect = list.stream().collect(Collectors.toMap(User::getName, Function.identity()));
        System.out.println(collect);
        User user = collect.get("111");
        System.out.println(user);
    }


    @Test
    public void errorTest() {
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        List<Object> objects = Collections.synchronizedList(new ArrayList<>());
        Pair<Object, Object> objectObjectPair = new Pair<>("1", "1");

    }


    { String regex = "(?<province>[^省]+.*?省)(?<city>嘉兴市|[^市]+.*?市)";
        String countyRegex = "(?<county>嘉善县|海盐县|平湖市|海宁市|桐乡市|[^区]+区)";
        String detailAddress = "?(?<detail>.*)";}
    public static Map<String, String> addressResolution(String address) {

        String regex = "(?<province>[^省]+.*?省)(?<city>嘉兴市|[^市]+.*?市)";
        String countyRegex = "(?<county>嘉善县|海盐县|平湖市|海宁市|桐乡市|[^区]+区)";
        String detailAddress = "?(?<detail>.*)";
        Matcher matcher = Pattern.compile(regex + countyRegex + detailAddress).matcher(address);
        //省份
        String province = null;
        //城市
        String city = null;
        //区县
        String county = null;
        //详细地址
        String detail =null;
        Map<String, String> row = new LinkedHashMap<>(3);
        while (matcher.find()) {
            province = matcher.group("province");
            row.put("province", province == null ? null : province.trim());
            city = matcher.group("city");
            row.put("city", city == null ? null : city.trim());
            county = matcher.group("county");
            row.put("county", county == null ? null : county.trim());
            detail = matcher.group("detail");
            row.put("detail", detail == null ? "" : detail.trim());
        }
        return row;
    }

    @Test
    public void ClassTest() {
        Map<String, String> addressResolution1 = addressResolution("浙江省平湖市平湖市华威印花有限公司");
        Map<String, String> addressResolution2 = addressResolution("浙江省海盐县国际大厦");
        Map<String, String> addressResolution3 = addressResolution("浙江省嘉兴市嘉善县苏家浜小区");
        Map<String, String> addressResolution4 = addressResolution("浙江省海盐县宜家花城");
        Map<String, String> addressResolution5 = addressResolution("浙江省南湖区隆兴公寓");
        Map<String, String> addressResolution6 = addressResolution("绍兴市柯桥区安昌镇前庄村");
        Map<String, String> addressResolution7 = addressResolution("嘉兴市秀洲区王江泾镇虹桥路鸣业纺织");
        Map<String, String> addressResolution8 = addressResolution("衢州市江山市虎山街道鹿溪南路");
        Map<String, String> addressResolution9 = addressResolution("浙江省嘉兴市平湖市吉祥小区");

        List<Map<String, String>> addressResolutionList = new ArrayList<>();
        addressResolutionList.addAll(CollUtil.newArrayList(addressResolution1,addressResolution2,addressResolution3,addressResolution4,addressResolution5,addressResolution6,addressResolution7,addressResolution8,addressResolution9));
        System.out.println(addressResolutionList);
    }
}

