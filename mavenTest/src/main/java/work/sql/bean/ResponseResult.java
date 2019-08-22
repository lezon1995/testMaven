package work.sql.bean;

import java.util.List;

/**
 * @author Wentworth .
 * @date 2019-08-22 11:07
 */
public class ResponseResult {
    public int status;
    public String message;
    public Data data;

    public static class Data {
        public String tablestruct;
        public List<String> tablefileds;
        public List<String> tablefiledscomment;

        @Override
        public String toString() {
            return "Data{" +
                    "tablestruct='" + tablestruct + '\'' +
                    ", tablefileds=" + tablefileds +
                    ", tablefiledscomment=" + tablefiledscomment +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
