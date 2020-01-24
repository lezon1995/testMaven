package work.interfaces;

import java.util.Comparator;
import java.util.List;

/**
 * @author Wentworth .
 * @date 2019-09-09 16:16
 */
public class ExportDTO {


    private String code;
    private String message;
    private RsBean rs;
    private boolean success;
    private boolean failure;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RsBean getRs() {
        return rs;
    }

    public void setRs(RsBean rs) {
        this.rs = rs;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isFailure() {
        return failure;
    }

    public void setFailure(boolean failure) {
        this.failure = failure;
    }

    public static class RsBean {


        private int total;
        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {



            private int id;
            private String description;
            private long createTime;
            private Long updateTime;
            private int appId;
            private String appName;
            private String apiName;
            private String apiVersion;
            private String invokeTimeout;
            private boolean sessionRequire;
            private String serverInterface;
            private String interfaceMethod;
            private String params;
            private String apiDefinitionConfig;
            private String apiPermissionConfig;
            private int state;
            private String operator;
            private Object tags;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public Long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Long updateTime) {
                this.updateTime = updateTime;
            }

            public int getAppId() {
                return appId;
            }

            public void setAppId(int appId) {
                this.appId = appId;
            }

            public String getAppName() {
                return appName;
            }

            public void setAppName(String appName) {
                this.appName = appName;
            }

            public String getApiName() {
                return apiName;
            }

            public void setApiName(String apiName) {
                this.apiName = apiName;
            }

            public String getApiVersion() {
                return apiVersion;
            }

            public void setApiVersion(String apiVersion) {
                this.apiVersion = apiVersion;
            }

            public String getInvokeTimeout() {
                return invokeTimeout;
            }

            public void setInvokeTimeout(String invokeTimeout) {
                this.invokeTimeout = invokeTimeout;
            }

            public boolean isSessionRequire() {
                return sessionRequire;
            }

            public void setSessionRequire(boolean sessionRequire) {
                this.sessionRequire = sessionRequire;
            }

            public String getServerInterface() {
                return serverInterface;
            }

            public void setServerInterface(String serverInterface) {
                this.serverInterface = serverInterface;
            }

            public String getInterfaceMethod() {
                return interfaceMethod;
            }

            public void setInterfaceMethod(String interfaceMethod) {
                this.interfaceMethod = interfaceMethod;
            }

            public String getParams() {
                return params;
            }

            public void setParams(String params) {
                this.params = params;
            }

            public String getApiDefinitionConfig() {
                return apiDefinitionConfig;
            }

            public void setApiDefinitionConfig(String apiDefinitionConfig) {
                this.apiDefinitionConfig = apiDefinitionConfig;
            }

            public String getApiPermissionConfig() {
                return apiPermissionConfig;
            }

            public void setApiPermissionConfig(String apiPermissionConfig) {
                this.apiPermissionConfig = apiPermissionConfig;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public String getOperator() {
                return operator;
            }

            public void setOperator(String operator) {
                this.operator = operator;
            }

            public Object getTags() {
                return tags;
            }

            public void setTags(Object tags) {
                this.tags = tags;
            }
        }
    }
}
