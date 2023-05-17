package entry;

import java.lang.reflect.Field;
import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) throws IllegalAccessException {
        HashMap stringHashMap = new HashMap<String,Integer>(16);
        String key="key";
        String key1="key";
        int i1 = key.hashCode();
        int i11= key1.hashCode();
        System.out.println("key.hashCode() = " + key.hashCode());
        System.out.println("key1.hashCode() = " + key1.hashCode());
        int i2 = (16 - 1) & i1;
        int i22 = (16 - 1) & i11;
        System.out.println("i2 = " + i2);
        System.out.println("i22 = " + i22);
        stringHashMap.put(key,1);
        stringHashMap.put(key1,2);
        Class<? extends HashMap> aClass = stringHashMap.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        Field table = null;
        for (Field declaredField : declaredFields) {
            if (declaredField.getName().equals("table")) {
                table=declaredField;
            }
        }
        table.setAccessible(true);
        Object[] o = (Object[])table.get(stringHashMap);
        for (int i = 0; i < o.length; i++) {
            System.out.println(i+" "+ o[i]);
        }
    }
}
