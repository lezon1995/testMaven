package work.interfaces;

import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Wentworth .
 * @date 2019-09-09 16:16
 */
public class ExportUtil {
    public static void main(String[] args) {
//        String url = "https://gwweb-us.wgine.com:7799/apis/search";
        String url="https://gwweb-us.tuya-inc.top:7799/apis/search";
        HashMap<String, String> headers = new HashMap<>();
        HashMap<String, String> parameters = new HashMap<>();
        headers.put("cookie", "7ce0ff06556c05363a176b03dfdd5680=1897; SSO_USER_TOKEN=p_5dc6f6757c30d93b8aca45550cb1f31b; cd1f6c4c522c03e21ad83ee2d7b0c515=Wentworth%EF%BC%88%E6%9C%B1%E4%BA%AE%EF%BC%89; e255ad9b8262a02d28bca48235a96357=2135; JSESSIONID=0D3F58087B1DD9BA13D702E6F24BBF73");
//        headers.put("cookie", "7ce0ff06556c05363a176b03dfdd5680=1897; SSO_USER_TOKEN=p_624f5498e084ddc0f6713c5bdee7e8be; cd1f6c4c522c03e21ad83ee2d7b0c515=Wentworth%EF%BC%88%E6%9C%B1%E4%BA%AE%EF%BC%89; e255ad9b8262a02d28bca48235a96357=2135; JSESSIONID=54D46A982C8982656B3E96F83B416E1F");
        headers.put("Content-Type", "application/json");


        String json = HttpUtil.post(url, "{\n" +
                "    \"appId\": \"36\",\n" +
                "    \"apiName\": \"\",\n" +
                "    \"offset\": \"0\",\n" +
                "    \"limit\": \"100\",\n" +
                "    \"state\": \"\",\n" +
                "    \"updatedTimeStart\": \"0\",\n" +
                "    \"updateTimeEnd\": \"1568016303244\"\n" +
                "}");
//        HttpResponse httpResponse = null;
//        try {
//            httpResponse = HttpsUtil.getInstance().sendHttpsPostForHttpResponse(url, headers, parameters);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Header[] cookies = httpResponse.getHeaders("Set-Cookie");
//        String json = null;
//        try {
//            json = EntityUtils.toString(httpResponse.getEntity());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        json = new String(json.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        ExportDTO response = JSONObject.parseObject(json, ExportDTO.class);
        StringBuilder sb = new StringBuilder();
        String encode = null;
        try {
            encode = URLEncoder.encode(",", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<ExportDTO.RsBean.RowsBean> rows = response.getRs().getRows();
        Collections.sort(rows, new Comparator<ExportDTO.RsBean.RowsBean>() {
            @Override
            public int compare(ExportDTO.RsBean.RowsBean o1, ExportDTO.RsBean.RowsBean o2) {
                return o1.getUpdateTime() - o2.getUpdateTime() > 0L ? -1 : 1;
            }
        });
        for (ExportDTO.RsBean.RowsBean row : response.getRs().getRows()) {
//            sb.append(row.getId()+",");
            System.out.println(row.getApiName() + "\t\t\t\t\t\t\t\t" + row.getApiVersion() + "\t\t\t\t" + format.format(new Date(row.getUpdateTime())+" - " +format.format(new Date(row.getCreateTime()))));
        }


//        sb.deleteCharAt(sb.length());
//        System.out.println(sb.toString());
    }
}
