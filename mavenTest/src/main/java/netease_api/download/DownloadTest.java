package netease_api.download;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Wentworth .
 * @date 2019/11/23 4:45 下午
 */
public class DownloadTest {
    private static final Logger LOGGER = Logger.getLogger(DownloadTest.class.getName());

    public static void main(String[] args) {
        String path = "/Users/wentworth/Downloads/小丑面具.mp3";
        String url = String.format("http://music.163.com/song/media/outer/url?id=%s.mp3", "406907069");
//        download1(url, path);
        long start = System.currentTimeMillis();
        download1(url, path);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }

    public static void download1(String url, String path) {
        new HttpDownloader(url, path).download(new HttpDownloader.Callback() {
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
                System.out.println("Download finished");
            }

            @Override
            public void onError(IOException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

        });
    }

    public static void download2(String url, String path) {
        new OkHttpDownloader(url, path).download(new OkHttpDownloader.Callback() {
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
                System.out.println("Download finished");
            }

            @Override
            public void onError(IOException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        });
    }
}
