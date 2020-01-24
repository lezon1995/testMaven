package netease_api.netease;

import netease_api.download.HttpDownloader;
import netease_api.type.SearchType;
import work.interfaces.HttpUtil;

import java.io.IOException;
import java.util.logging.Level;

public class Api {
    private final static String BaseURL = "http://music.163.com/";

    /**
     * 获取用户歌单
     *
     * @param uid
     * @return
     */
    public static UrlParamPair getPlaylistOfUser(String uid) {
        UrlParamPair upp = new UrlParamPair();
        upp.setUrl(BaseURL + "weapi/user/playlist?csrf_token=");
        upp.addPara("offset", 0);
        upp.addPara("uid", uid);
        upp.addPara("limit", 20);
        upp.addPara("csrf_token", "nothing");
        return upp;
    }

    /**
     * 获取歌单详情
     *
     * @param playlist_id
     * @return
     */
    public static UrlParamPair getDetailOfPlaylist(String playlist_id) {
        UrlParamPair upp = new UrlParamPair();
        //upp.setUrl(BaseURL + "weapi/v3/playlist/detail?csrf_token=");
        upp.addPara("id", playlist_id);
        upp.addPara("offset", 0);
        upp.addPara("total", "True");
        upp.addPara("limit", 100);
        upp.addPara("n", 1000);
        upp.addPara("csrf_token", "nothing");
        return upp;
    }
    //todo:analyse more api

    /**
     * 搜索歌曲
     *
     * @param s;
     * @return
     */
    public static UrlParamPair SearchMusicList(String s, SearchType type) {
        UrlParamPair upp = new UrlParamPair();
        upp.addPara("s", s);
        upp.addPara("type", type.toString());
        upp.addPara("offset", 0);
        upp.addPara("total", "True");
        upp.addPara("limit", 20);
        upp.addPara("n", 1000);
        upp.addPara("csrf_token", "nothing");
        return upp;
    }

    public static String download(String id, String songName, String author, String downloadPath) {
        String url = "http://music.163.com/song/media/outer/url?id=%s.mp3";
        new HttpDownloader(url, downloadPath + "/" + songName + author + ".mp3").download(new HttpDownloader.Callback() {
            long currentProgress = 0;

            @Override
            public void onProgress(double progress) {
                String format = String.format("%.2f", progress);
                System.out.print("\b");
                for (int j = 0; j <= format.length(); j++) {
                    System.out.print("\b");
                }
//                long delta = progress - currentProgress;
//                for (long i = 0; i < delta; i++) {
//                    System.out.print("-");
//                }
//                currentProgress = progress;
                System.out.print(format + "%");
            }

            @Override
            public void onFinish() {
                System.out.println();
                System.out.println("Download finished");
            }

            @Override
            public void onError(IOException ex) {
            }

        });
        return HttpUtil.download(String.format(url, id), songName, author, downloadPath);
    }


}
