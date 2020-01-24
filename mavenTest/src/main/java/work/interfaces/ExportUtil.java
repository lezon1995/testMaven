package work.interfaces;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author Wentworth .
 * @date 2019-09-09 16:16
 */
public class ExportUtil {
    public static void main(String[] args) {
        //美国预发
        String url_america_pre = "https://gwweb-us.wgine.com:7799/api/apis/search";
        //美国线上
//        String url_america_online = "https://gwweb-us.tuya-inc.top:7799/api/apis/search";
        String cookie_america_online = "_tpmGuid=TY-9a7dfc81d834ab7b; gTyPlatLang=en; 7ce0ff06556c05363a176b03dfdd5680=1897; SSO_USER_TOKEN=p_681f797bbfa9fee78d91980c4c8b5389; a608ea7c4cbd1919ce039822a2e5d753=01897; cd1f6c4c522c03e21ad83ee2d7b0c515=Wentworth%EF%BC%88%E6%9C%B1%E4%BA%AE%EF%BC%89; e255ad9b8262a02d28bca48235a96357=2135; JSESSIONID=DB508BC30DD629A2B1B997A626BDBA06";

        //中国预发
        String url_china_pre = "https://gwweb-pre-cn.wgine.com:7799/api/apis/search";
        //中国日常
//        String url_china_daily = "https://gwweb-daily.tuya-inc.cn:7799/api/apis/search";
        String cookie_china_daily = "_tpmGuid=TY-9a7dfc81d834ab7b; gTyPlatLang=en; 7ce0ff06556c05363a176b03dfdd5680=1897; SSO_USER_TOKEN=p_681f797bbfa9fee78d91980c4c8b5389; a608ea7c4cbd1919ce039822a2e5d753=01897; cd1f6c4c522c03e21ad83ee2d7b0c515=Wentworth%EF%BC%88%E6%9C%B1%E4%BA%AE%EF%BC%89; e255ad9b8262a02d28bca48235a96357=2135; JSESSIONID=DA279135B0D666820C1D70A459B6DC76";

        ExportDTO response_china_pre = getExportDTO(url_china_pre, cookie_america_online, "59");

        ExportDTO response_america_pre = getExportDTO(url_america_pre, cookie_china_daily, "35");


//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        List<ExportDTO.RsBean.RowsBean> rows = response_china_daily.getRs().getRows();
//        Collections.sort(rows, (o1, o2) -> o1.getUpdateTime() - o2.getUpdateTime() > 0L ? -1 : 1);


        HashMap<String, Integer> americaMap = new HashMap<>();
        HashMap<String, Integer> chinaMap = new HashMap<>();

        for (ExportDTO.RsBean.RowsBean row : response_china_pre.getRs().getRows()) {
            String skey = row.getApiName() + "_" + row.getApiVersion();
            chinaMap.put(skey, row.getId());
        }

        for (ExportDTO.RsBean.RowsBean row : response_america_pre.getRs().getRows()) {
            String skey = row.getApiName() + "_" + row.getApiVersion();
            americaMap.put(skey, row.getId());
        }

        Set<String> americaSet = americaMap.keySet();
        Set<String> chinaSet = chinaMap.keySet();
//        Sets.SetView<String> difference = Sets.difference(americaSet, chinaSet);
        Sets.SetView<String> difference = Sets.difference(chinaSet, americaSet);

        difference.forEach(System.out::println);

//        StringBuffer sb = new StringBuffer();
//
//        difference.forEach(s -> {
//            Integer id = americaMap.get(s);
//            sb.append(id).append("%2C");
//        });
//        StringBuffer result = sb.delete(sb.length() - 3, sb.length());
////        System.out.println(result.toString());
//        String url = "https://gwweb-us.tuya-inc.top:7799/apis/api/export/batch?ids="+result.toString();
//        String cookie = "UM_distinctid=16e64285220b73-050504f3524093-1c3a6a5b-13c680-16e6428522138a; 7ce0ff06556c05363a176b03dfdd5680=1897; SSO_USER_TOKEN=p_66f470169dfcb585f0d9efb30c2324a5; a608ea7c4cbd1919ce039822a2e5d753=01897; cd1f6c4c522c03e21ad83ee2d7b0c515=Wentworth%EF%BC%88%E6%9C%B1%E4%BA%AE%EF%BC%89; e255ad9b8262a02d28bca48235a96357=2135; JSESSIONID=E1CB4A06FE7FE165D7312312F9728F84";
//        try {
//            HttpRequest.downLoadFromUrl(url, "abc.zip", "/Users/wentworth/Documents/github/testMaven/mavenTest/src/main/java/work/interfaces", cookie);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(difference.size());
    }

    public static ExportDTO getExportDTO(String url, String cookie, String appId) {
        HashMap<String, String> headers = new HashMap<>();
        HashMap<String, String> parameters = new HashMap<>();
        headers.put("cookie", cookie);
        headers.put("Content-Type", "application/json");

        String pa = "{\"appId\":\"" + appId + "\",\"apiName\":\"\",\"dubboInterfaceName\":\"\",\"dubboMethodName\":\"\",\"offset\":0,\"limit\":500,\"state\":\"\",\"updatedTimeStart\":0,\"updateTimeEnd\":1573833599999}";
        String json = HttpUtil.post(url, pa, cookie);

        ExportDTO response = JSONObject.parseObject(json, ExportDTO.class);
        return response;
    }


}
