package netease_api.type;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Wentworth .
 * @date 2019/11/23 3:46 下午
 */
public enum SearchType {
    /**
     * type=1 单曲
     * type=10 专辑
     * type=100 歌手
     * type=1000 歌单
     * type=1002 用户
     * type=1004 MV
     * type=1006 歌词
     * type=1009 主播电台
     */
    SINGLE("单曲", "1"),
    ALBUM("专辑", "10"),
    SINGER("歌手", "100"),
    SONG_LIST("歌单", "1000"),
    USER("用户", "1002"),
    MV("MV", "1004"),
    LYRIC("歌词", "1006"),
    BROADCAST("主播电台", "1009");

    private final String name;
    private final String value;

    SearchType(String name, String value) {
        this.name = name;
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
