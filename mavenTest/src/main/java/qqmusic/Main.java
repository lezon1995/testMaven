package qqmusic;

import com.alibaba.fastjson.JSONObject;
import work.interfaces.HttpUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

/**
 * @author Wentworth .
 * @date 2019-10-11 17:39
 */
public class Main {
    public static void main(String[] args) throws Exception {
        search("断了的弦", 1);

//        search1();
    }


    private static void search(String s, int i) throws Exception {
        String url = "https://c.y.qq.com/soso/fcgi-bin/client_search_cp" +
                "?ct=24" +
                "&qqmusic_ver=1298" +
                "&new_json=1" +
                "&remoteplace=txt.yqq.song" +
                "&searchid=0" +
                "&t=0" +
                "&aggr=1" +
                "&cr=1" +
                "&catZhida=1" +
                "&lossless=0" +
                "&flag_qc=0" +
                "&p=" + i + "" +
                "&n=20" +
                "&g_tk=5381" +
                "&loginUin=0" +
                "&hostUin=0" +
                "&format=jsonp" +
                "&inCharset=utf8" +
                "&outCharset=utf-8" +
                "&notice=0" +
                "&platform=yqq" +
                "&needNewCode=0" +
                "&w=" + URLEncoder.encode(s, "UTF-8");
        String json = HttpUtil.get(url);
        json = json.substring(9, json.length() - 2);
        System.out.println(json);

        MusicResponse response = JSONObject.parseObject(json, MusicResponse.class);
//        for (MusicResponse.DataBean.SongBean.ListBean song : response.getData().getSong().getList()) {
//            parseSong(song);
//            for (Grp item : song.getGrp()) {
//
//
//            }
//        }
        MusicResponse.DataBean.SongBean.ListBean song = response.getData().getSong().getList().get(0);
        search1(song);


    }

    private static void parseSong(MusicResponse.DataBean.SongBean.ListBean song) throws Exception {
        Item item = new Item();
        if (song.getFile().getSize_flac() > 0) {
            item.file_flac = "1";
        }
        if (song.getFile().getSize_320() > 0) {
            item.file_320 = "1";
        }
        if (song.getFile().getSize_128() > 0) {
            item.file_128 = "1";
        }

        item.mid = song.getMid();
        item.name = conv(song.getTitle());
    }

    private static String conv(String str) {
        return str.replaceAll("%?", " ? ").replaceAll("%*", " * ").replaceAll(":", " : ");
    }


    private static void search1(MusicResponse.DataBean.SongBean.ListBean song) throws Exception {
        String url = "https://u.y.qq.com/cgi-bin/musicu.fcg?data=";
        Random random = new Random();
        long i1 = random.nextInt(999999999) + 9000000000L;
        String guid = String.valueOf(i1);
        String mid = song.getMid();
        String s1 = "{\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"" + guid + "\",\"songmid\":[\"" + mid + "\"],\"songtype\":[0],\"uin\":\"0\",\"loginflag\":1,\"platform\":\"20\"}}}";
        String encode = URLEncoder.encode(s1, "UTF-8");
        url += encode;
        String json = HttpUtil.get(url);
        SongResponse response = JSONObject.parseObject(json, SongResponse.class);
        int vkey = response.getReq_0().getData().getTestfile2g().indexOf("vkey");
        String filename = response.getReq_0().getData().getMidurlinfo().get(0).getFilename();
        mid = filename.substring(4, filename.length() - 4);
        search2(guid, mid, vkey, song);
    }

    private static void search2(String guid, String mid, int vkey, MusicResponse.DataBean.SongBean.ListBean song) throws Exception {
        String url = "";
        if (song.getFile().getSize_flac() > 0) {
            url = "http://183.131.60.16/amobile.music.tc.qq.com/F000" + mid + ".flac?guid=" + guid + "&vkey=" + vkey + "&uin=0&fromtag=58";

        }
        if (song.getFile().getSize_320() > 0) {
            url = "http://183.131.60.16/amobile.music.tc.qq.com/M800" + mid + ".mp3?guid=" + guid + "&vkey=" + vkey + "&uin=0&fromtag=58";

        }
        if (song.getFile().getSize_128() > 0) {
            url = "http://183.131.60.16/amobile.music.tc.qq.com/M500" + mid + ".mp3?guid=" + guid + "&vkey=" + vkey + "&uin=0&fromtag=58";
        }
        System.out.println(url);
        String json = HttpUtil.get(url);
        System.out.println(json);

    }
}
//D9D1868B16219EC13AD4C0A4F0988EEC6F1205E2651649A45EA079D042DA67689DEC2515C9355CDE134B4E8833F084103D014A718E0AA34C
//C40000446Pbk2V0Cc7.m4a
