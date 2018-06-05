package com.xjtushilei.logagent4networkcollege.entity;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author scriptshi
 * 2018/5/24
 */
@Document(type = "log-4-network-collage", indexName = "action-log", shards = 5, replicas = 0)
public class ActionLog {

    private String id;
    @Field(type = FieldType.Keyword)
    private String user_id;
    private int operationSourceId;
    private int operationId;
    @Field(type = FieldType.Keyword)
    private String courseId;
    private String courseName;
    private String topicName;
    @Field(type = FieldType.Keyword)
    private String topicId;
    private String facetNameLevel1Name;
    @Field(type = FieldType.Keyword)
    private String facetNameLevel1Id;
    private String facetNameLevel2Name;
    @Field(type = FieldType.Keyword)
    private String facetNameLevel2Id;
    @Field(type = FieldType.Keyword)
    private String fragmentId;
    @Field(type = FieldType.Date)
    private Date date;
    private int jumpTargetType;
    private String jumpTargetUrl;

    public ActionLog() {
    }

    @Override
    public String toString() {
        return "ActionLog{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", operationSourceId=" + operationSourceId +
                ", operationId=" + operationId +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", topicName='" + topicName + '\'' +
                ", topicId='" + topicId + '\'' +
                ", facetNameLevel1Name='" + facetNameLevel1Name + '\'' +
                ", facetNameLevel1Id='" + facetNameLevel1Id + '\'' +
                ", facetNameLevel2Name='" + facetNameLevel2Name + '\'' +
                ", facetNameLevel2Id='" + facetNameLevel2Id + '\'' +
                ", fragmentId='" + fragmentId + '\'' +
                ", date=" + date +
                ", jumpTargetType=" + jumpTargetType +
                ", jumpTargetUrl='" + jumpTargetUrl + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getOperationSourceId() {
        return operationSourceId;
    }

    public void setOperationSourceId(int operationSourceId) {
        this.operationSourceId = operationSourceId;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getFacetNameLevel1Name() {
        return facetNameLevel1Name;
    }

    public void setFacetNameLevel1Name(String facetNameLevel1Name) {
        this.facetNameLevel1Name = facetNameLevel1Name;
    }

    public String getFacetNameLevel1Id() {
        return facetNameLevel1Id;
    }

    public void setFacetNameLevel1Id(String facetNameLevel1Id) {
        this.facetNameLevel1Id = facetNameLevel1Id;
    }

    public String getFacetNameLevel2Name() {
        return facetNameLevel2Name;
    }

    public void setFacetNameLevel2Name(String facetNameLevel2Name) {
        this.facetNameLevel2Name = facetNameLevel2Name;
    }

    public String getFacetNameLevel2Id() {
        return facetNameLevel2Id;
    }

    public void setFacetNameLevel2Id(String facetNameLevel2Id) {
        this.facetNameLevel2Id = facetNameLevel2Id;
    }

    public String getFragmentId() {
        return fragmentId;
    }

    public void setFragmentId(String fragmentId) {
        this.fragmentId = fragmentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getJumpTargetType() {
        return jumpTargetType;
    }

    public void setJumpTargetType(int jumpTargetType) {
        this.jumpTargetType = jumpTargetType;
    }

    public String getJumpTargetUrl() {
        return jumpTargetUrl;
    }

    public void setJumpTargetUrl(String jumpTargetUrl) {
        this.jumpTargetUrl = jumpTargetUrl;
    }
}
