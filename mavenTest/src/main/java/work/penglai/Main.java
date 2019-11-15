package work.penglai;

import com.alibaba.fastjson.JSONObject;
import work.interfaces.HttpsUtil;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Wentworth .
 * @date 2019-10-14 10:40
 */
public class Main {
    public static void main(String[] args) throws Exception {
//        String url = "https://penglai.tuya-inc.top:7799/api/v1/meta/app/list";
//        HashMap<String, String> headers = new HashMap<>();
//        HashMap<String, String> parameters = new HashMap<>();
//        headers.put("cookie", "7ce0ff06556c05363a176b03dfdd5680=1897; SSO_USER_TOKEN=p_08cb3598c648f65a8541dfb0a02262d4; cd1f6c4c522c03e21ad83ee2d7b0c515=Wentworth%EF%BC%88%E6%9C%B1%E4%BA%AE%EF%BC%89; e255ad9b8262a02d28bca48235a96357=2135; csid=f7fdc6f3-f4a8-41e7-a350-ded6599f0e48");
//        headers.put("Content-Type", "application/json");
//        parameters.put("appName", "");
//        parameters.put("limit", "401");
//        parameters.put("page", "1");
//        HttpsUtil httpsUtil = HttpsUtil.getInstance();
//        String json = httpsUtil.sendHttpsPost(url, headers, parameters);
//        AppResponse response = JSONObject.parseObject(json, AppResponse.class);
//        for (AppResponse.PageBean.ListBean listBean : response.getPage().getList()) {
//            String appName = listBean.getAppName();
//            String appRemark = listBean.getAppRemark();
//            System.out.println(appName + " --- " + appRemark);
//        }
//        ArrayList<String> objects = new ArrayList<>();
//        String s = objects.stream()
//                .filter(m -> m.equals("1"))
//                .findAny().orElse(null);
//        System.out.println(objects);
//        System.out.println(s);
        long sum = 0;
        int step = 5000;
        double rate = 0.12;
        int mounths = 360;
        for (int i = 1; i <= 30; i++) {
            sum += step * 12;
            double delta = sum * rate;
            sum += delta;
            System.out.println(sum / 10000.0d + "万元 -第" + i + "年 -涨幅 " + delta + "日收入 " + delta / 365.0);
        }
    }
}
