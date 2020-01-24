package netease_api.core;

import com.alibaba.fastjson.JSONObject;
import netease_api.bean.CloudMusicSearchResponse;
import netease_api.bean.SongsBean;
import netease_api.netease.Api;
import netease_api.netease.UrlParamPair;
import netease_api.secret.JSSecret;
import netease_api.type.SearchType;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 * Created by MiChong on 2017/11/22 0022.
 * <p>
 * 测试搜索功能，包括搜索歌曲，歌手，用户等
 */
public class Demo3 {
    public static void main(String[] args) {
        try {
            String music_name = "小丑面具";
            UrlParamPair upp = Api.SearchMusicList(music_name, SearchType.SINGLE);
            String req_str = upp.getParas().toJSONString();
            System.out.println("req_str:" + req_str);
            Connection.Response
                    response = Jsoup.connect("http://music.163.com/weapi/cloudsearch/get/web?csrf_token=")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Connection", "keep-alive")
                    .header("Host", "music.163.com")
                    .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                    .header("DNT", "1")
                    .header("Pragma", "no-cache")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data(JSSecret.getDatas(req_str))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .timeout(10000)
                    .execute();
            String list = response.body();
            System.out.println(list);
//            CloudMusicSearchResponse cloudMusicSearchResponse = JSONObject.parseObject(list, CloudMusicSearchResponse.class);
//            SongsBean songsBean = cloudMusicSearchResponse.getResult().getSongs().get(0);
//            int id = songsBean.getId();
//            String songName = songsBean.getName();
//            String author = songsBean.getAr().get(0).getName();
//            String downloadPath = "/Users/wentworth/Downloads";
//            String result = Api.download(String.valueOf(id), songName, author, downloadPath);
//            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
