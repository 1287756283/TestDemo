package entry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 浙江刑总预警数据对外接口 - 预警数据下发 实体类
 * @author ljh
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarnDataIssued {

    /**
     * 预警数据ID，对应预警数据表唯一主键ID
     */

    private String ticketId;

    /**
     * 数据类型，1可疑号码，2APP推送，3高危网址，4高危交易
     */

    private String dataType;

    /**
     * 运营商：1、移动 2、 联通 3、电信4、通管局，5、jZ  6、vos 7、蚂蚁金服 8 云深 99、其他，typeName必填
     */

    private String yys;

    /**
     * 其他运营商名称
     */
    private String typeName;

    /**
     * 受害人号码
     */

    private String billNo;


    /**
     * 预警等级
     */

    private Integer yjdj;

    /**
     * 受害人姓名
     */

    private String billName;

    /**
     * 受害人号码归属地名称
     */
    private String cityName;

    /**
     * 受害人号码归属地代码
     */

    private String cityCode;

    /**
     * 受害人性别
     */

    private String billSex;

    /**
     * 受害人地址
     */

    private String billAddress;

    /**
     * 受害人地址代码
     */

    private String billAddressCode;

    /**
     * 嫌疑人号码，网站、APP类不必填
     */

    private String blackBill;

    /**
     * 嫌疑人姓名
     */

    private String blackName;

    /**
     * 首次通话时间
     */

    private Date connectTime;

    /**
     * 联系时长
     */

    private String connectLength;

    /**
     * 联系类型，如电话、短信
     */

    private String connectType;

    /**
     * 诈骗等级，1-5，1最低，5最高
     */

    private String lvl;

    /**
     * 判断时间
     */

    private Date doneDate;

    /**
     * 疑似诈骗类型
     */

    private String suspectType;

    /**
     * 联系次数
     */

    private String cntCishu;

    /**
     * 亲情网号码
     */
    private String billFamilyMsisdn;

    /**
     * APP名称-APP推送
     */
    private String appName;

    /**
     * APP包名-APP推送
     */
    private String appPackage;

    /**
     * APP安装时间-APP推送
     */
    private Date appInstallTime;

    /**
     * 网站标题-高危网址
     */
    private String urlTittle;

    /**
     * 网站url-高危网址
     */
    private String url;

    /**
     * 网站访问频次-高危网址
     */
    private String urlAccess;

    /**
     * 建议负责单位代码
     */
    private String jyfzdwdm;

    /**
     * 建议负责单位名称
     */
    private String jyfzdwmc;

    /**
     * 姓名
     */
    private String jzXm;

    /**
     * 证件号码
     */
    private String jzZjhm;

    /**
     * 号码归属地
     */
    private String jzHmgsd;

    /**
     * 现住地址
     */
    private String jzXzdz;

    /**
     * 户籍地址
     */
    private String jzHjdz;

    /**
     * 当前所在地城市名称
     */
    private String jzHmszdcs;

    /**
     * 当前所在地城市代码
     */
    private String jzHmszdcsdm;

    /**
     * 当前所在地区县
     */
    private String jzHmszdqx;

    /**
     * 当前所在地区县代码
     */
    private String jzHmszdqxdm;

    /**
     * 当前所在地小区
     */
    private String jzHmszdxq;

    /**
     * 当前所在地小区代码
     */
    private String jzHmszdxqdm;

    /**
     * 号码关联的情亲号，多个逗号
     */
    private String jzHmqqh;

    /**
     * 经度
     */
    private String jzLon;

    /**
     * 纬度
     */
    private String jzLat;

    /**
     * 基站lac
     */
    private String jzLac;

    /**
     * 基站ci
     */
    private String jzCi;

    /**
     * 受害人支付宝账号(登陆账号)-高危交易
     */
    private String account;

    /**
     * 交易时间(年月日时分秒)-高危交易
     */
    private String transactiontime;

    /**
     * 交易金额(元)-高危交易
     */
    private String transactionamount;

    /**
     * 交易发生地-高危交易
     */
    private String transactionaddress;

    /**
     * 受害人姓名-高危交易
     */
    private String name;

    /**
     * 受害人身份证号-高危交易
     */
    private String idcard;

    /**
     * 受害人联系方式-高危交易
     */
    private String telephone;

    /**
     * 受害人常用收货地址-高危交易
     */
    private String address;

    /**
     * 嫌疑人账号-高危交易
     */
    private String blackacount;

    /**
     * 交易结果(成功/失败)-高危交易
     */
    private String status;

    /**
     * 涉案类型/受害等级-高危交易
     */
    private String salxshdj;

    /**
     * 入库时间
     */
    private Date rksj;

    /**
     * 下发时间
     */
    private Date fzxfsj;
}
