package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import entry.WarnDataIssued;

/**
 * @author: lsl
 * @description:
 * @date: 2022/10/26 9:17
 */
public class toJsonUtils {

    public static String toJson(WarnDataIssued warnDataIssued){
       String str= JSON.toJSONString(warnDataIssued,SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteDateUseDateFormat);
       return str;
    }

}
