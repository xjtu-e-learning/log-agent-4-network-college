package com.xjtushilei.logagent4networkcollege.entity;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author scriptshi
 * 2018/5/24
 */
@Document(type = "log-4-network-collage", indexName = "visit-log", shards = 5, replicas = 0)
public class VisitLog {

    /*
     * id
     * 因es的springboot有bug，必须要这个字段，其实没啥用
     */
    private String id;
    /*
    课程id
     */
    @Field(type = FieldType.Keyword)
    private String courseId;

    /*
    学生id
     */
    @Field(type = FieldType.Keyword)
    private String studentId;
    /*
    国家
     */
    @Field(type = FieldType.Keyword)
    private String country;

    /*
    省
     */
    @Field(type = FieldType.Keyword)
    private String province;

    /*
    市
     */
    @Field(type = FieldType.Keyword)
    private String city;

    /*
    区
     */
    @Field(type = FieldType.Keyword)
    private String district;

    /*
    域名
     */
    @Field(type = FieldType.Keyword)
    private String domain;
    /*
    网址
     */
    private String url;

    /*
    网页标题
     */
    @Field(type = FieldType.Keyword)
    private String title;

    @Field(type = FieldType.Keyword)
    private String referrer;
    /*
    用户屏幕分辨率-高
     */
    private int sh;
    /*
    用户屏幕分辨率-宽
     */
    private int sw;
    /*
    用户屏幕颜色深度
     */
    private int cd;
    @Field(type = FieldType.Keyword)
    /*
    用户客户端语言
     */
    private String lang;

    @Field(type = FieldType.Ip)
    private String ip;

    private String userAgent;

    /*
    插入时间
     */
    @Field(type = FieldType.Date)
    private Date date;

    @Field(type = FieldType.Keyword)
    private String browserType;
    @Field(type = FieldType.Keyword)
    private String browserRenderingEngine;
    @Field(type = FieldType.Keyword)
    private String browserManufacturer;
    @Field(type = FieldType.Keyword)
    private String browserVersion;
    @Field(type = FieldType.Keyword)
    private String operatingSystemDeviceType;
    @Field(type = FieldType.Keyword)
    private String operatingSystemManufacturer;
    @Field(type = FieldType.Keyword)
    private String operatingSystemName;


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public VisitLog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getBrowserRenderingEngine() {
        return browserRenderingEngine;
    }

    public void setBrowserRenderingEngine(String browserRenderingEngine) {
        this.browserRenderingEngine = browserRenderingEngine;
    }

    public String getBrowserManufacturer() {
        return browserManufacturer;
    }

    public void setBrowserManufacturer(String browserManufacturer) {
        this.browserManufacturer = browserManufacturer;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getOperatingSystemDeviceType() {
        return operatingSystemDeviceType;
    }

    public void setOperatingSystemDeviceType(String operatingSystemDeviceType) {
        this.operatingSystemDeviceType = operatingSystemDeviceType;
    }

    public String getOperatingSystemManufacturer() {
        return operatingSystemManufacturer;
    }

    public void setOperatingSystemManufacturer(String operatingSystemManufacturer) {
        this.operatingSystemManufacturer = operatingSystemManufacturer;
    }

    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    public void setOperatingSystemName(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.HOUR_OF_DAY,8);
//        this.date = calendar.getTime();
        this.date = date;

    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public int getSh() {
        return sh;
    }

    public void setSh(int sh) {
        this.sh = sh;
    }

    public int getSw() {
        return sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "VisitLog{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", domain='" + domain + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", referrer='" + referrer + '\'' +
                ", sh=" + sh +
                ", sw=" + sw +
                ", cd=" + cd +
                ", lang='" + lang + '\'' +
                ", ip='" + ip + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", date=" + date +
                ", browserType='" + browserType + '\'' +
                ", browserRenderingEngine='" + browserRenderingEngine + '\'' +
                ", browserManufacturer='" + browserManufacturer + '\'' +
                ", browserVersion='" + browserVersion + '\'' +
                ", operatingSystemDeviceType='" + operatingSystemDeviceType + '\'' +
                ", operatingSystemManufacturer='" + operatingSystemManufacturer + '\'' +
                ", operatingSystemName='" + operatingSystemName + '\'' +
                '}';
    }
}
