package com.stream;

import java.util.List;

/**
 * @author Wentworth .
 * @date 2019-10-26 11:28
 */
public class SensorBean1 {

    /**
     * config : {"fixedEquipment":true}
     * lang : zh
     * name : 声光报警器
     * pid : 8scntis1
     * whiteList : true
     */

    private String config;
    private String lang;
    private String name;
    private String pid;
    private boolean whiteList;

    private List<ActionInfo> actionInfos;
    private String uid;
    private String homeId;

    public List<ActionInfo> getActionInfos() {
        return actionInfos;
    }

    public void setActionInfos(List<ActionInfo> actionInfos) {
        this.actionInfos = actionInfos;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHomeId() {
        return homeId;
    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }

    public static class ActionInfo {
        private String cameraId;
        private String type;

        public String getCameraId() {
            return cameraId;
        }

        public void setCameraId(String cameraId) {
            this.cameraId = cameraId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public boolean isWhiteList() {
        return whiteList;
    }

    public void setWhiteList(boolean whiteList) {
        this.whiteList = whiteList;
    }

    public static class ConfigBean {
        /**
         * fixedEquipment : true
         */

        private boolean fixedEquipment;

        public boolean isFixedEquipment() {
            return fixedEquipment;
        }

        public void setFixedEquipment(boolean fixedEquipment) {
            this.fixedEquipment = fixedEquipment;
        }
    }
}
