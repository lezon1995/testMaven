package com.stream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @author Wentworth .
 * @date 2019-10-25 20:39
 */
public class LinkageConditionVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private Integer entityType;
    private Integer condType;
    private String entityId;
    private String entityName;
    private String entitySubIds;
    private String entityFetcher;
    private JSONArray expr;
    private String exprDisplay;
    private Integer orderNum;
    private String duration;
    private JSONObject extraInfo;
    private String iconUrl;
    private Integer trigger;
    private String nodeId;
    private String serverProperty;

    @Override
    public String toString() {
        return "LinkageConditionVO{" +
                "id='" + id + '\'' +
                ", entityType=" + entityType +
                ", condType=" + condType +
                ", entityId='" + entityId + '\'' +
                ", entityName='" + entityName + '\'' +
                ", entitySubIds='" + entitySubIds + '\'' +
                ", entityFetcher='" + entityFetcher + '\'' +
                ", expr=" + expr +
                ", exprDisplay='" + exprDisplay + '\'' +
                ", orderNum=" + orderNum +
                ", duration='" + duration + '\'' +
                ", extraInfo=" + extraInfo +
                ", iconUrl='" + iconUrl + '\'' +
                ", trigger=" + trigger +
                ", nodeId='" + nodeId + '\'' +
                ", serverProperty='" + serverProperty + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getEntityType() {
        return entityType;
    }

    public void setEntityType(Integer entityType) {
        this.entityType = entityType;
    }

    public Integer getCondType() {
        return condType;
    }

    public void setCondType(Integer condType) {
        this.condType = condType;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntitySubIds() {
        return entitySubIds;
    }

    public void setEntitySubIds(String entitySubIds) {
        this.entitySubIds = entitySubIds;
    }

    public String getEntityFetcher() {
        return entityFetcher;
    }

    public void setEntityFetcher(String entityFetcher) {
        this.entityFetcher = entityFetcher;
    }

    public JSONArray getExpr() {
        return expr;
    }

    public void setExpr(JSONArray expr) {
        this.expr = expr;
    }

    public String getExprDisplay() {
        return exprDisplay;
    }

    public void setExprDisplay(String exprDisplay) {
        this.exprDisplay = exprDisplay;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public JSONObject getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(JSONObject extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getTrigger() {
        return trigger;
    }

    public void setTrigger(Integer trigger) {
        this.trigger = trigger;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getServerProperty() {
        return serverProperty;
    }

    public void setServerProperty(String serverProperty) {
        this.serverProperty = serverProperty;
    }
}
