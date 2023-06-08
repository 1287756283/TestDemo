
import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.*;
import cn.hutool.cron.task.RunnableTask;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import entry.Student;
import entry.User;
import entry.WarnDataIssued;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import util.DataUtils;
import util.toJsonUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
;


/**
 * @author LIAN
 */
public class TestByEveryDay<T> {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("CA15911EBE70000180891B521610171B.role_id_1 AS qqq",
                "CA15911EBE70000180891B521610171B.user_id_1 AS www",
                "CA1591201A900001AB7EDF5718C75900.role_id_1 AS rrr",
                "CA1591201A900001AB7EDF5718C75900.user_id_1 AS eee",
                "CA1591201A900001AB7EDF5718C75900.user_id_1 AS eee",
                "CA1591201A900001AB7EDF5718C75900.role_id_1 AS rrr"));
        ArrayList<String> distinct = CollUtil.distinct(list);
        System.out.println(distinct);
    }

    @Test
    public void test2() {
        Stream.of("hello", "world").map(s -> Stream.of(s.split(""))).forEach(System.out::println);
        System.out.println("--------------");
        // Stream.of("hello", "world").flatMap(s -> Stream.of(s.split(""))).forEach(System.out::println);
        System.out.println("--------------");
        List<Integer> list1 = Stream.of(1, 2, 3, 4).map(x -> x * x).collect(Collectors.toList());
        System.out.println(list1);
    }

    @Test
    public void test3() {
        String c = "0.01";
        String b = "0.9";
        BigDecimal bigDecimal2 = new BigDecimal(b);
        BigDecimal bigDecimal1 = new BigDecimal(c);
        BigDecimal multiply = bigDecimal1.multiply(bigDecimal2);
        System.out.println(multiply);
        String a = "0.5";
        BigDecimal bigDecimal = new BigDecimal(a);
        System.out.println(bigDecimal);
    }


    public int reverse(int x) {
        String s1;
        String s = String.valueOf(x);
        for (int i = s.length(); i < s.length(); i--) {

        }
        return x;
    }

    public int reverse1(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    @Test
    public void scriptEngine() {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        a1.addAll(Arrays.asList(1, 2, 3));
        a2.addAll(Arrays.asList(1, 2, 3, 4, 5));
        Collection<Integer> disjunction = CollectionUtil.disjunction(a1, a2);
        System.out.println(disjunction);

    }

    @Test
    public void scriptEngine1() {
        if (1 <= 2) {
            System.out.println(11);
        } else {
            System.out.println(22);
        }
    }

    @Test
    public void test111() {
        final String sysFileId[] = {null};
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> b = Arrays.asList(11, 22, 33, 44, 55);

        for (Integer integer : a) {
            sysFileId[0] = String.valueOf(integer);
        }
        for (Integer integer : b) {
            sysFileId[0] = String.valueOf(b);
        }
        System.out.println(sysFileId[0]);
    }

    @Test
    public void test131() {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("apple", "click"));
        lists.add(Arrays.asList("boss", "dig", "qq", "vivo"));
        lists.add(Arrays.asList("c#", "biezhi"));
        List<String> collect1 = lists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect1);
        List<String> collect = lists.stream().flatMap(Collection::stream)
                .filter(str -> str.length() == 2)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test13111() {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.addAll(Arrays.asList(1, 2, 3, 4, 5));
        b.addAll(Arrays.asList(6));
        boolean contains = a.contains(b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(contains);
        List<Integer> collect = CollUtil.intersection(a, b).stream().collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test999() {
        System.out.println(BigDecimal.ZERO);
        System.out.println(new BigDecimal("2.0"));
        System.out.println(new Double("0"));
        System.out.println(new BigDecimal("2.00"));
        String d = new BigDecimal("100.1000").stripTrailingZeros().toPlainString();
        System.out.println(d);
        System.out.println(new BigDecimal("100.1000").stripTrailingZeros().toPlainString());
    }

    @Test
    public void streamTest() {
        List<String> strs = Arrays.asList("a", "a", "a", "a", "b");
        boolean aa = strs.stream().anyMatch(str -> str.equals("a"));
        boolean bb = strs.stream().allMatch(str -> str.equals("a"));
        boolean cc = strs.stream().noneMatch(str -> str.equals("c"));
        long count = strs.stream().filter(str -> str.equals("a")).count();
        System.out.println(aa);// TRUE
        System.out.println(bb);// FALSE
        System.out.println(cc);// FALSE
        System.out.println(count);// 4
    }


    @Test
    public void assertTest() {
        Set<String> strings = new HashSet<>();
        List<String> a = Arrays.asList();
        List<String> b = Arrays.asList();
        strings.addAll(a);
        strings.addAll(b);
        System.out.println(strings);

    }

    @Test
    public void elseifTest() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));
    }

    @Test
    public void parseInt() {
        String a = "2";
        Integer integer = Integer.valueOf(a);
        System.out.println(integer);
        int i = Integer.parseInt(a);
        System.out.println(i);
        String b = "连石磊 顶顶顶";
        String[] strArray = b.split("\\s+");
        System.out.println(Arrays.asList(strArray));
    }

    @Test
    public void test2021() {
        Integer a = 1000;
        Integer b = a;
        System.out.println(a == b);
    }

    @Test
    public void testByMap() {
        Map<Integer, String> map = new HashMap();
        map.put(1, "一");
        map.put(2, "二");
        map.put(3, "三");
        map.put(4, "四");
        map.put(5, "四");
        System.out.println(map);
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println(entries);
        Set<Integer> integers = map.keySet();
        System.out.println(integers);
        List<String> collect = map.values().stream().collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testHashCode() {
        IntStream intStream = IntStream.of(110, 45, 70, 80, 90, 120);
        OptionalInt first = intStream.findFirst();
        System.out.println(first);
    }

    @Test
    public void testListTest() {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.addAll(Arrays.asList(1, 2, 3));
        b.addAll(Arrays.asList(2, 3, 4));
        a.retainAll(b);
        System.out.println(a);
    }

    @Test
    public void test1111() {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{2, 3, 4};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    list.add(a[i]);
                }
            }
        }
        System.out.println(list);
    }


    @Test
    public void hashTest() {
        User user = new User();
        user.setName("1");
        User user1 = new User();
        user1.setName("1");
        System.out.println(user.getName().equals(user1.getName()));
        HashMap<String, String> map = new HashMap<>();
        map.put(user.getName(), "一");
        map.put(user1.getName(), "二");
        System.out.println(map);
    }

    @Test
    public void hashTest2() {
        User user1 = new User();
        user1.setName("路西");
        user1.setAge(18);
        User user2 = new User();
        user2.setName("路西");
        user2.setAge(18);
        System.out.println(user1.equals(user2));

      /*  Set set =new HashSet();
        set.add(user1);
        set.add(user2);
        Map map=new HashMap();
        map.put(user1,"user1");
        map.put(user2,"user2");
        System.out.println("set 长度"+set.size());
        System.out.println("map 长度"+map.keySet().size());
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());*/
    }

    @Test
    public void stream() {
    /*    List<String> list = Arrays.asList("aa", "ff", "dd");
//String 类自身已实现Compareable接口
        list.stream().sorted().forEach(System.out::println);// aa dd ff*/
        User s1 = new User("aa", 10);
        User s2 = new User("bb", 20);
        User s3 = new User("aa", 30);
        User s4 = new User("dd", 40);
        List<User> studentList = Arrays.asList(s1, s2, s3, s4);
//自定义排序：先按姓名升序，姓名相同则按年龄升序
        studentList.stream().sorted(
                (o1, o2) -> {
                    if (o1.getName().equals(o2.getName())) {
                        return o1.getAge() - o2.getAge();
                    } else {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
        ).forEach(System.out::println);

    }

    @Test
    public void bigMath() {
        int c = 1;
        int a = 36;
        int b = 12;
        int[] d = new int[a / b];

        for (int i = 0; i < 3; i++) {
            if (d[0] == 0) {
                d[i] = 1;
            } else {
                c += 12;
                d[i] = c;
                System.out.println(c);
            }
        }
        System.out.println(Arrays.toString(d));
    }

    @Test
    public void testAerset() {
        del("a", "b", "c", "d");
    }

    @Test
    public void goResult() {
        Double s = 0.00;
        List<String> list = new ArrayList<>();
        list.add("120.00");
        list.add("120.00");
        list.add("120.00");
        for (String s1 : list) {
            s = Double.valueOf(s1) + s;
        }
        System.out.println(s);
    }


    @Test
    public void jjjjjj() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 6) {
                System.out.println(i);
                break;
                // 在执行i==6时强制终止循环，i==6不会被执行
            }
        }
    }


    public void del(String... key) {
        System.out.println(Arrays.toString(key));
    }

    @Test
    public void OptionalTest() throws Exception {
        User user = new User();
        User user1 = new User();
        user.setName(null);
       /* if (user.getName().equals("1")) {
            System.out.println(1111);
        }*/
        if (Optional.ofNullable(user.getName()).orElse("").equals(1)) {
            System.out.println(111111);
        } else {
            System.out.println(222222);
        }
        //customerName = Optional.ofNullable(one).map(ProjectPersonal::getName).orElse("");
    }

    @Test
    public void isNumberTest() {
        String s1 = "{001}*{003}";
        String s2 = "0.10";
        System.out.println("Validator.isNumber(s1) = " + Validator.isNumber(s1));
        System.out.println("Validator.isNumber(s2) = " + Validator.isNumber(s2));
    }


    @Test
    public void ternaryOperator() {
        boolean success = false;
        Boolean aBoolean = Optional.ofNullable(success).orElse(false);
    }

    @Test
    public void bigDecimalTest() {
        String a = "1.00";
        String b1 = "0.00";
        BigDecimal bigDecimal1 = new BigDecimal(a);
        BigDecimal bigDecimal2 = new BigDecimal(b1);
        BigDecimal b = new BigDecimal(b1);
        BigDecimal divide;
        //try {
        divide = bigDecimal1.divide(bigDecimal2);
      /*  }catch (Exception e){
            BigDecimal zero = BigDecimal.ZERO;
            divide=zero;
        }*/
        System.out.println("divide = " + divide);
    }


    @Test
    public void stringTest() {
        int a = 1;
        a += a;
        System.out.println(a);
    }

    @Test
    public void StreamTest() {
        int a = 7;
        int b = 2;
        System.out.println((a % b > 0 ? a / b + 1 : a / b));
    }

    @Test
    public void StreamTest2() {
        BigDecimal a = new BigDecimal("12000");
        BigDecimal b = new BigDecimal("3543.01");
        BigDecimal divide = new BigDecimal("12000.00").divideToIntegralValue(new BigDecimal("3543.01"));
/*
        System.out.println("divide = " + divide);
        BigDecimal bigDecimal = new BigDecimal("12000.00").divideAndRemainder(new BigDecimal("3543.01"))[1];
        System.out.println("bigDecimal = " + bigDecimal);
*/
        BigDecimal zero = BigDecimal.ZERO;
        System.out.println(zero);
    }

    @Test
    public void StreamTest3() {
        BigDecimal a = new BigDecimal("12000.00");
        BigDecimal b = new BigDecimal("2543.1");
        BigDecimal bigDecimal = a.divideAndRemainder(b)[1];
        System.out.println("bigDecimal = " + bigDecimal);
   /*     BigDecimal negate = b.negate();
        BigDecimal divide = a.divide(b);
        System.out.println("divide = " + divide);
        int i = divide.compareTo(new BigDecimal(0.5));
        System.out.println("i = " + i);*/
    }

    @Test
    public void StreamTest1() {
        //标志位
        int w = 0;
        //期限a/频率b
        int a = 20;
        int b = 2;
        int q = 9;

        List list = new ArrayList();
        list.addAll(CollUtil.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

        for (int i = 0; i < list.size(); i++) {
            if (i % 4 == 0) {
                w++;
                System.out.println(list.get(i));
                if (w == q) {
                    break;
                }
            }
        }
    }

    @Test
    public void subTest() {
        List<Integer> list = new ArrayList<>();
        list.addAll(CollUtil.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("list = " + list);
        List<Integer> list1 = list.subList(0, 5);
        System.out.println("list1 = " + list1);
    }

    @Test
    public void subTest1() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setName("11");
        user.setAge(11);
        User user1 = new User();
        user1.setName("12");
        user1.setAge(12);
        list.addAll(CollUtil.newArrayList(user, user1));
        list.stream().forEach(s -> {
            if (s.getName().equals("11")) {
                s.setAge(1111);
            }

        });
        System.out.println(list.get(0).getAge());
    }


    @Test
    //计算IRR
    public void irr() {
        List<Double> cashFlows = new ArrayList<>();
        cashFlows.addAll(CollUtil.newArrayList(100.00, 0.00, 0.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 2.00, 3.00, 4.00, 5.00));
        double guess = 0.000001d;
        int maxIterationCount = 20;
        double absoluteAccuracy = 1.0E-007D;

        double x0 = guess;

        int i = 0;
        while (i < maxIterationCount) {
            double fValue = 0.0D;
            double fDerivative = 0.0D;
            for (int k = 0; k < cashFlows.size(); k++) {
                fValue += cashFlows.get(k) / Math.pow(1.0D + x0, k);
                fDerivative += -k * cashFlows.get(k) / Math.pow(1.0D + x0, k + 1);
            }
            double x1 = x0 - fValue / fDerivative;
            if (Math.abs(x1 - x0) <= absoluteAccuracy) {
                System.out.println(x1);
            }
            x0 = x1;
            i++;
        }
        System.out.println(x0);
    }

    @Test
    public void swichTest() {
        Integer frequency = 4;

        switch (frequency) {
            case 0:
                frequency = 1;
                break;
            case 1:
                frequency = 2;
                break;
            case 2:
                frequency = 3;
                break;
            case 3:
                frequency = 6;
                break;
            case 4:
                frequency = 12;
                break;
        }
        System.out.println(frequency);
    }

    @Test
    public void MapTest() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "111");
        map.put("2", "222");
        map.put("3", "333");
        map.put("4", "444");
        System.out.println("map.get(\"1\") = " + map.get("1"));
        System.out.println("map.get(\"\") = " + map.get("2222"));
    }

    @Test
    public void MapTest11() {
        String name = "0";
        System.out.println(name);
    }

    @Test
    public void MapTest22() {
        String name = "{001}+{002}";
        String replace = name.replace("{", "").replace("}", "");
        System.out.println(replace);
    }


    @Test
    public void yyyy() {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.addAll(CollUtil.newArrayList(1, 2, 3, 4, 5));
        b.addAll(CollUtil.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collection<Integer> intersection = CollUtil.intersection(a, b);
        System.out.println(intersection);
    }

    @Test
    public void yyyy1() {
        System.out.println('s' + 'b');
    }

    @Test
    public void yyyy2() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("", "3");
        map.put("", "2");
        System.out.println(map.get(""));
    }

    @Test
    public void yyyy3() {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(11);
        System.out.println("threadLocal.get() = " + threadLocal.get());
    }

    @Test
    public void yyyy4() {
        User user1 = new User();
        user1.setName("连石磊");
        User user2 = new User();
        user2.setName("连石磊");
        if (user1.getName().equals(user2.getName())) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println("name.hashCode() = " + user1.getName().hashCode());
        System.out.println("name.hashCode() = " + user2.getName().hashCode());
    }

    @Test
    public void yyyy5() {
        ThreadLocal<Integer> THREAD_LOCAL1 = ThreadLocal.withInitial(() -> 3);
        Integer integer1 = THREAD_LOCAL1.get();
        System.out.println(integer1);
        ThreadLocal<Integer> THREAD_LOCAL2 = new ThreadLocal<>();
        THREAD_LOCAL2.set(33);
        Integer integer2 = THREAD_LOCAL2.get();
        System.out.println();
    }

    @Test
    public void strFarmtTest() {
        final String format = StrUtil.format("${}", 111);
        System.out.println(format);
        Object o = new Object();
        Assert.state(ObjectUtil.isNotEmpty(o), "数据为空，不能导出[o]");
    }

    @Test
    public void strFarmtTest1() {
        int a = 1;
        int i = a == 1 ? 2 : 3;
        System.out.println(i);
    }

    @Test
    public void clearList() {
        List<Integer> arrayList = CollUtil.newArrayList(1, 2, 3, 4, 5, 6);
        System.out.println(arrayList.toString());
        arrayList.clear();
        System.out.println(arrayList);
    }

    @Test
    public void DateUtilTest() {
        System.out.println("DateUtil.date().toString() = " + DateUtil.endOfDay(new Date()).toString());
        System.out.println("DateUtil.offsetDay(new Date(),-2) = " + DateUtil.beginOfDay(DateUtil.offsetDay(new Date(), -2)).toString());
    }

    @Test
    public void streamTest111() {
        Integer reduce = CollUtil.newArrayList(1, 2, 3, 4, 5, 6, 7).stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(CollUtil.newArrayList(1, 2, 3, 4, 5, 5, 6, 3, 1));
        HashSet<Integer> set = new HashSet<>();
        set.addAll(list);
        System.out.println(set);
        final Thread thread = new Thread(() -> System.out.println(111));
        thread.start();
        System.out.println("thread.getName() = " + thread.getName());
        final ReentrantLock reentrantLock = new ReentrantLock();

        ArrayList<String> strings = CollUtil.newArrayList(args);
        System.out.println(strings);
    }

    @Test
    public void switchTest() {
        String a = "2";
        switch (a) {
            case "1":
                System.out.println(1);
                break; //可选
            case "2":
                System.out.println(2);
                break; //可选
        }
    }

    @Test
    public void mockTest() {
//        String ids = "1,2,3,4,5,6";
//        String[] split = ids.split(",");
//        List<String> list = Arrays.asList(split);
//        for (String s : list) {
//            System.out.println(s);
//            if (s.equals("3")) {
//                return;
//            }
//        }
        String ids1 = null;
        if (StrUtil.isNotEmpty(ids1)){
            String[] split1 = ids1.split(",");
            List<String> list1 = Arrays.asList(split1);
            for (String s : list1) {
                System.out.println(s);
            }
        }


    }

    @Test
    public void DateTest() throws ParseException {
        Date date = null;
        String dateStr = "2022-06-23 11:20:39";
        //Date disposalTime = DateUtil.format(LocalDateTime.parse(dateStr),"yyyy-MM-dd HH:mm:ss");
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
        System.out.println(parse);
        DateTime parse1 = DateUtil.parse("2022-09-21 22:00:00");
        int hour = DateUtil.date(parse1).hour(true);
        System.out.println("hour = " + hour);
        System.out.println("parse1 = " + parse1);
    }

    @Test
    public void SetData() throws ParseException {
        String list1 = "1,2,3";
        String[] split = list1.split(",");
        List<String> collect = Arrays.stream(list1.split(",")).collect(Collectors.toList());
        System.out.println(collect);
        List<String> list = Arrays.asList(split);
        System.out.println("list = " + list);
        System.out.println("split.length = " + collect.size());
    }

    @Test
    public void logTest() {
        Date date = new Date();
        System.out.println(date);
        DateTime dateTime = DateUtil.offsetHour(date, 4);
        System.out.println(dateTime);
    }

    @Test
    public void dataTest() {
 /*       int day = 0;
        DateTime dateTime = DateUtil.offsetDay(new Date(), -day);
        Date beginTime = DateUtil.beginOfDay(dateTime).toJdkDate();
        Date endTime = DateUtil.endOfDay(dateTime).toJdkDate();
        System.out.println(beginTime);
        System.out.println(endTime);
        System.out.println(new Date());*/
        Date date = new Date();
        String time1 = date.toGMTString();
        System.out.println(time1);
        DateTime parse = DateUtil.parse(time1);
        System.out.println(parse);
    }

    @Test
    public void integerTest() {
        User build = User.builder().build();
        String day = "3";
        Integer valueOf = Integer.valueOf(day);
        System.out.println(-valueOf);
        User user = new User();
        user.setName("111");
        user.setAge(11);
        String s = JSON.toJSONString(user);
        User user1 = JSONObject.parseObject(s, User.class);
        System.out.println(user1);
    }


    @Test
    public void dateTest() {
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(CollUtil.newArrayList(1, 2, 3));
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(3);
        List<Integer> list = CollUtil.addAllIfNotContains(list1, list2);
        System.out.println(list);
    }

    @Test
    public void StreamTest6() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 6);
        HashSet<Integer> set = new HashSet<>();
        set.addAll(numbers);
        int result = numbers
                .stream()
                .reduce(0, Integer::sum);
        List<Integer> distinctList = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctList);
        System.out.println(set);
    }

    @Test
    public void StreamTest7() {
        DateTime date = new DateTime();
        System.out.println(date);
        DateTime dateTime = DateUtil.offsetSecond(date, 10);
        System.out.println(dateTime);
    }

    @Test
    public void StrTest() {
        String str = "南湖市";
        String s = str.replaceAll("区", "").replaceAll("市", "").replaceAll("县", "");
        System.out.println(s);
    }


    @Test
    public void getApi() {
        HttpResponse response;

     /*   response = HttpRequest.get("https://mock.apifox.cn/m2/1159988-0-default/25434802?")
                .execute();*/
        HttpRequest zjhm = HttpRequest.get("https://mock.apifox.cn/m2/1159988-0-default/25434802?zjhm=410421199803284010");
        HttpResponse execute = zjhm.execute();
        System.out.println(execute);
    }

    @Test
    public void getDataType() {
        String address = "浙江省嘉兴市海盐县平安大学";

        boolean contains = address.contains("海盐");
        System.out.println("contains = " + contains);

        HashMap<String, String> MAP = new HashMap<String, String>() {{
            put("JIA_XING", "嘉兴");
            put("NAN_HU", "南湖");
            put("JINGJI_KAIFA", "经济开发");
            put("XIU_ZHOU", "秀洲");
            put("HAI_YAN", "海盐");
            put("JIA_SHAN", "嘉善");
            put("TONG_XIANG", "桐乡");
            put("PING_HU", "平湖");
            put("HAI_NING", "海宁");
            put("GANG", "港");
        }};
        Set<String> strings = MAP.keySet();
        System.out.println(strings);
        Collection<String> values = MAP.values();
        System.out.println(values);
        Set<Map.Entry<String, String>> entries = MAP.entrySet();
        System.out.println(entries);
        String s = StrUtil.toString(MAP.values());
        System.out.println(s);

        boolean state = StrUtil.containsAny(address, MAP.get("NAN_HU"), MAP.get("JINGJI_KAIFA"), MAP.get("XIU_ZHOU"), MAP.get("HAI_YAN"), MAP.get("JIA_SHAN"), MAP.get("TONG_XIANG"), MAP.get("PING_HU"), MAP.get("HAI_NING"), MAP.get("GANG"));
        String s1 = MAP.get("NAN_HU");
        System.out.println(state);
    }

    @Test
    public void getType() {
        User user = new User();
        List<Pair> pairs = new ArrayList<>();
        Pair<Integer, User> userPair = Pair.of(1, user);
        pairs.addAll(CollUtil.newArrayList(userPair));
        for (Pair pair : pairs) {
            Object value = pair.getValue();
            String className = ClassUtil.getClassName(value, true);
            boolean state = ClassUtil.equals(value.getClass(), className, true);
            System.out.println(state);
        }
        List<String> REGION = CollUtil.newArrayList("南湖", "经济开发", "秀洲", "海盐", "嘉善", "桐乡", "平湖", "海宁", "港");
        System.out.println("REGION.toArray() = " + StrUtil.toString(REGION));
    }

    @Test
    public void stringFormatTest() {
        String coke = "可乐";
        String format = StrUtil.format("今天你们喝{}了吗", coke);
        System.out.println(format);
        DateTime date = DateUtil.date();
        DateTime dateTime = DateUtil.offsetHour(date, -1);
        System.out.println(date);
        System.out.println(dateTime);

    }


    @Test
    public void dateTest11() {
//        Student build1 = Student.builder().sno("111").ccreateTime(null).build();
//        Student build2 = Student.builder().sno("222").ccreateTime(DateUtil.date().offset(DateField.MINUTE, 30)).build();
//        Student build3 = Student.builder().sno("333").ccreateTime(DateUtil.date().offset(DateField.MINUTE, -30)).build();
//        System.out.println(build1);
//        System.out.println(build2);
//        System.out.println(build3);
//        List<Student> students = CollUtil.newArrayList(build1, build2, build3);
////        Student student = students.stream().min(Comparator.comparing(Student::getCcreateTime)).get();
////        Student student = students.stream().max(((o1, o2) -> DateUtil.compare(o1.getCcreateTime(), o2.getCcreateTime()))).get();
//        System.out.println("流之前-->" + students);
//        students = students.stream().filter(s -> s.getSno().equals("111")).collect(Collectors.toList());
//        System.out.println("流之后 = " + students);
    }

    @Test
    public void jsonTest() {
        String s = "2021-05-25 00:00:00";
        DateTime parse = DateUtil.parse(s);
        DateTime dateTime = DateUtil.offsetHour(parse, 12);
        System.out.println(parse);
        System.out.println(dateTime);
        int hour1 = parse.hour(true);
        System.out.println(hour1);
        int hour = DateUtil.hour(parse, true);
        System.out.println(hour);
    }

    @Test
    public void jsonTest1() {
        //就比如说这个里面的数据是外部接口拿的，转josn是转不了的
        User user = new User();
        {
            user.setName("连石磊");
            user.setAge(22);
            user.setBigDecimal(BigDecimal.TEN);
        }
        User user1 = new User();
        User user2 = JSON.parseObject("{\"age\":33,\"bigDecimal\":33,\"name\":\"连石磊\"}", User.class);
        List<T> list = new ArrayList<>();
        list.add((T) user);
        list.add((T) user2);
        System.out.println(list);

    }

    @Test
    public void ifTest1() {
        List<Boolean> list = new ArrayList<>();
        list.add(Boolean.TRUE);
        list.add(Boolean.TRUE);
        list.add(Boolean.FALSE);
        Boolean[] booleans = list.toArray(new Boolean[0]);
        System.out.println(Arrays.toString(booleans));
        Boolean flag = BooleanUtil.andOfWrap(list.toArray(new Boolean[0]));
        System.out.println(flag);
    }

    @Test
    public void CopyTest() {
        User user1 = new User();
        User user2 = new User();
        user1.setAge(1);
        user1.setName("LSL1");
        user2.setAge(2);
        user2.setName("LSL2");
        List<User> userList = CollUtil.newArrayList(user1, user2);
        List<String> collect1 = userList.stream().map(s -> s.getName()).collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);
        List<String> collect2 = userList.stream().map(User::getName).collect(Collectors.toList());
        System.out.println("collect2 = " + collect2);
        Map<Integer, List<User>> collect3 = userList.stream().collect(Collectors.groupingBy(o -> o.getAge()));
        System.out.println("collect3 = " + collect3);
        Map<Integer, List<User>> collect4 = userList.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println("collect4 = " + collect4);
        userList.forEach(System.out::println);
        userList.forEach(System.out::print);
    }


    @Test
    public void strTest() {
/*        BiConsumer<Supplier, Supplier> a2 = (t, u) -> flagList.add(Optional.ofNullable(t.get())
                .filter(r -> r.equals(u.get())).map(l -> true).orElse(false));
        a2.accept(req::getDqszddm, yjhfZb::getDqszddm);*/
        List<String> list = new ArrayList<>();
        Consumer<String> consumer = s -> {
            list.add(s);
        };
        String lsl = "连石磊";
        consumer.accept(lsl);
        //==========================================
        Function<String, String> function = s -> {
            s = s + "111";
            return s;
        };
        String functionApply = function.apply(lsl);
        //==========================================
        BiConsumer<List, String> biConsumer = (a, b) -> {
            a.add(null);
            b.equals("");
        };
        BiFunction<String, Integer, Integer> biFunction = (a, b) -> {
            return 0;
        };
        int i = 'j' + 'k';
        if (!"jk".equals('j' + 'k')) {
            System.out.println("you are " + ('j' + 'k'));
        }
        Integer biFunctionApply = biFunction.apply("1", 2);
    }

    @Test
    public void FunctionTest() {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("1", "1", "2", "3"));
        String s = null;
        String join = String.join(",", list);
        System.out.println(join);
        List<String> split = StrUtil.split(join, ',');
        System.out.println(split);

        String a = "1,2,3";
        List<String> collect = Arrays.stream(a.split(",")).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void ternaryOperator1() {
        Integer a = 3;
        String s = a.equals(1) ? "审核中" : a.equals(2) ? "执行中" : a.equals(3) ? "执行成功" : "执行失败";
        System.out.println(s);
        String s1 = "  ";
        System.out.println("StrUtil.isEmpty(s1) = " + StrUtil.isEmpty(s1));
        System.out.println("StrUtil.isNotBlank(s1) = " + StrUtil.isBlank(s1));
    }

    @Test
    public void dateUtils() {
        boolean number1 = Validator.isNumber("1");
        boolean number2 = Validator.isNumber("{\n" +
                "\"cjsj\":\"2022-09-20 00:00:00\"\n" +
                "}");
        System.out.println(number1);
        System.out.println(number2);

        DateTime dateTime = DateUtil.offsetDay(new Date(), -Integer.valueOf(1));
        Date beginTime = DateUtil.beginOfDay(dateTime).toJdkDate();
        Date endTime = DateUtil.endOfDay(dateTime).toJdkDate();
        System.out.println(beginTime);
        System.out.println(endTime);
    }

    @Test
    public void objectToJson() {
        WarnDataIssued warnDataIssued = new WarnDataIssued();
        String str = toJsonUtils.toJson(warnDataIssued);
        System.out.println(str);
    }

    @Test
    public void studentJsonLog() {
        String allLogs = "";
        User user1 = new User();
        user1.setName("日志1");
        user1.setAge(1);
        String Log = JSON.toJSONString(user1);
        System.out.println(Log);
        User user2 = new User();
        user2.setName("日志2");
        user2.setAge(2);
    }

    @Test
    public void BooleanTest() {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(2, "二");
        linkedHashMap.put(3, "三");
        linkedHashMap.put(1, "yi");
        System.out.println(linkedHashMap.values());
        System.out.println(linkedHashMap.entrySet());
        System.out.println(linkedHashMap.keySet());
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "二");
        map.put(3, "三");
        map.put(1, "yi");
        System.out.println(map.values());
        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        TreeMap<Object, Object> treeMap = new TreeMap<>();
    }

    @Test
    public void json111() {
//        String  a="SELECT\n" +
//                "\t`sys_role_1`.`role_id` AS role_id,\n" +
//                "\t`sys_role_1`.`role_name` AS role_name,\n" +
//                "\t`sys_user_1`.`user_id` AS user_id,\n" +
//                "\t`sys_user_1`.`login_name` AS login_name \n" +
//                "FROM\n" +
//                "\tsys_role sys_role_1\n" +
//                "\tINNER JOIN sys_user sys_user_1 ON `sys_role_1`.`role_id` = `sys_user_1`.`user_id` ";
//        List<String> list = Arrays.asList(StrUtil.subBetweenAll(a, "AS", ","));
//        System.out.println(list);

        String sql = "select * from user";
        String format = StrUtil.format("(" + sql + ")");
        System.out.println("format = " + format);
    }

    @Test
    public void demo01() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 1; i < 9; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i);
            map.put("name", "张三丰" + i);
            list.add(map);
        }
        Stream<Map<String, Object>> s1 = list.stream();
        list.stream().forEach(map -> System.out.println(map));

        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
        for (int i = 1; i < 5; i++) {
            Map<String, Object> map2 = new HashMap<>();
            map2.put("id", i);
            map2.put("grade", i + 60);
            list2.add(map2);
        }
        list2.stream().forEach(s -> System.out.println(s));
//==============================================================================================
//   List<Map<String, Object>> resultList2 = list.stream().map(map -> list2.stream()
//                  .filter(m -> Objects.equals(m.get("id"), map.get("id")))
//                  .findFirst().map(m -> {
//                      map.putAll(m);
//                      map.put("grade",90);
//                      return map;
//                  }).orElse(null))
//                  .filter(Objects::nonNull).collect(Collectors.toList());
//        resultList.stream().forEach(s-> System.out.println(s));
//       List<Map<String, Object>> resultList2 = list.stream().map(m->{
//                    m.put("grade",null);
//                    for (int i=0;i<list2.size();i++){
//                        if(m.get("id").equals(list2.get(i).get("id"))){
//                            m.put("grade",list2.get(i).get("grade"));
//                            break;
//                        }
//                    }
//                    return m;
//                }).collect(Collectors.toList());
        List<Map<String, Object>> resultList2 = list.stream().map(m -> {
            m.put("grade", null);
            list2.stream().filter(m2 -> Objects.equals(m.get("id"), m2.get("id"))).forEach(s -> m.put("grade", s.get("grade")));
            return m;
        }).collect(Collectors.toList());
        resultList2.stream().forEach(s -> System.out.println(s));
    }

    @Test
    public void testStreamGroup() {
        List<Student> stuList = new ArrayList<Student>();
        Student stu1 = new Student("10001", "孙权", "1000101", 16, '男');
        Student stu2 = new Student("10001", "曹操", "1000102", 16, '男');
        Student stu3 = new Student("10002", "刘备", "1000201", 16, '男');
        Student stu4 = new Student("10002", "大乔", "1000202", 16, '女');
        Student stu5 = new Student("10002", "小乔", "1000203", 16, '女');
        Student stu6 = new Student("10003", "诸葛亮", "1000301", 16, '男');

        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);
        stuList.add(stu4);
        stuList.add(stu5);
        stuList.add(stu6);

        Map<String, List<Student>> collect = stuList.stream().collect(Collectors.groupingBy(Student::getSno));
        for (Map.Entry<String, List<Student>> stuMap : collect.entrySet()) {
            String classId = stuMap.getKey();
            List<Student> studentList = stuMap.getValue();
            System.out.println("classId:" + classId + ",studentList:" + studentList.toString());
        }
    }

    @Test
    public void jmzkTest() {
        List<String> strings = CollUtil.newArrayList(Arrays.asList("一", "二", "三", "四", "五", "五"));
        System.out.println(strings.size());
        List<String> distinct = CollUtil.distinct(strings);
        System.out.println(distinct.size());
        List<String> strings1 = CollUtil.newArrayList(Arrays.asList("qq", "ww", "ee", "rr", "qq", "qq"));
        System.out.println(strings1.size());
        List<String> distinct1 = CollUtil.distinct(strings1);
        System.out.println(distinct1.size());
        List<Integer> list = Arrays.asList(4, 7, 9, 11, 12);
        list.stream()
                .peek(x -> System.out.println("stream: " + x))
                .map(x -> x + 2)
                .peek(x -> System.out.println("map: " + x))
                .filter(x -> x % 2 != 0)
                .peek(x -> System.out.println("filter: " + x))
                .limit(2)
                .peek(x -> System.out.println("limit: " + x))
                .collect(Collectors.toList());
    }

    @Test
    public void dateDiffer() {
        DateTime parse = DateUtil.parse("2022-12-13 08:00:00");
        long l = DateUtil.betweenMs(parse, DateUtil.date());
        System.out.println(l);
    }

    @Test
    public void isNull() {
        String a = "()";
//        String replace = a.replace("(", "").replace(")", "");
//        System.out.println(replace);
//        if (StrUtil.isNotEmpty(replace)){
//            System.out.println(true);
//        }else {
//            System.out.println(false);
//        }
//        String s = UUID.fastUUID().toString();
//        System.out.println("s = " + s);
//        int i = RandomUtil.randomInt(1, 9);
//        System.out.println(i);
        String s = "fK0YeTDJU0FZIOAEyiXMjwEzeUIaUnwQ4SEW0b1TsqgfXDCqlYwa%2BN9UHD2IN6%2BirtfdssCvBV%2F7%0A%2B9eTEbypJg7qIRPWkXa4Qz5NJo4MSAFoc7fD5lx9t9SEmdFL8zVqWkdninlYvM%2BN%2Bkkm8cVYKZD7%0A0s4C2RY5Y%2BmXSunLc2wyvcPosd29ULOJO5b7cla0tuRedTGzr9bdm7V7WqCv0OcDJuH%2B7XkCVaFl%0A0IeR8vaNqo7NMY8NXSUh4HhhRmySt8p%2B3D4TVEA6d1RhEjQjfyGkwouVUaV8r0STeDEviBUUiSr%2B%0AjDIHDqmzAco%3D|预订|62000G135202|G1352|AOQ|AOH|AOQ|HGH|08:30|15:11|06:41|Y|cRcTKxHFqD0mM2fqYpETwmTNDAsBlYXcufiR9TfqGQMVjgrR|20230126|3|Q7|01|17|1|0|||||||||||无|无|2||90M0O0|9MO|0|1||9165950002M087850000O052800000|0|||||1|0#1#0#0#z||";
        Arrays.stream(s.split("\\|")).forEach(System.out::println);
    }


    @Test
    public void sum() {
      User user=null;
      if (user.getName() != null){
          System.out.println(11);
      }
    }

    @Test
    public void stringToLong() {
        Map<String, AtomicInteger> map2 = new HashMap<>();
        // 统计字段出现个数
        List<String> list = CollUtil.newArrayList("h", "e", "l", "l", "o", "w", "o", "r", "l", "d");
        for (String str : list) {
            map2.computeIfAbsent(str, k -> new AtomicInteger()).getAndIncrement();
        }
        // 遍历
        map2.forEach((k, v) -> System.out.println(k + " " + v));
    }


    @Test
    public void ListTest1111() {
        User user = User.builder().age(11).name("ssss").build();

        User user2 = User.builder().age(22).name("wwww").build();
        List<User> users = Collections.singletonList(user);
        List<User> users1 = Collections.singletonList(user2);
        if (CollUtil.isNotEmpty(users)) {
            System.out.println(Collections.emptyList());
        }

    }

    @Test
    public void ListTest2222() {
        User user = User.builder().age(11).name("ssss").build();

        User user2 = User.builder().age(22).name("wwww").build();
        List<User> users = Collections.singletonList(user);
        List<User> users1 = Collections.singletonList(user2);
        if (CollUtil.isNotEmpty(users)) {
            System.out.println(Collections.emptyList());
        }

    }

    @Test
    public void ListTest3333() {
        User user = User.builder().age(11).name("ssss").build();

        User user2 = User.builder().age(22).name("wwww").build();
        List<User> users = Collections.singletonList(user);
        List<User> users1 = Collections.singletonList(user2);
        if (CollUtil.isNotEmpty(users)) {
            System.out.println(Collections.emptyList());
        }

    }
}


