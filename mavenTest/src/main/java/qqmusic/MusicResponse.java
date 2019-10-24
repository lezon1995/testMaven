package qqmusic;

import java.util.List;

/**
 * @author Wentworth .
 * @date 2019-10-11 17:53
 */
public class MusicResponse {

    /**
     * code : 0
     * message :
     * notice :
     * subcode : 0
     * time : 1570787587
     * tips :
     */

    private int code;
    private DataBean data;
    private String message;
    private String notice;
    private int subcode;
    private int time;
    private String tips;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public int getSubcode() {
        return subcode;
    }

    public void setSubcode(int subcode) {
        this.subcode = subcode;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public static class DataBean {
        /**
         * keyword : 断了的弦
         * priority : 0
         * qc : []
         * semantic : {"curnum":0,"curpage":1,"list":[],"totalnum":0}
         * tab : 0
         * taglist : []
         * totaltime : 0
         * zhida : {"type":1,"zhida_singer":{"albumNum":32,"hotalbum":[{"albumID":1458791,"albumMID":"003RMaRI1iFoYd","albumName":"周杰伦的床边故事","albumname_hilight":"周杰伦的床边故事"},{"albumID":33021,"albumMID":"002eFUFm2XYZ7z","albumName":"我很忙","albumname_hilight":"我很忙"},{"albumID":852856,"albumMID":"001uqejs3d6EID","albumName":"哎呦，不错哦","albumname_hilight":"哎呦，不错哦"},{"albumID":194021,"albumMID":"003Ow85E3pnoqi","albumName":"十二新作","albumname_hilight":"十二新作"},{"albumID":36062,"albumMID":"002Neh8l0uciQZ","albumName":"魔杰座","albumname_hilight":"魔杰座"},{"albumID":8218,"albumMID":"000f01724fd7TH","albumName":"Jay","albumname_hilight":"Jay"},{"albumID":56705,"albumMID":"000bviBl4FjTpO","albumName":"跨时代","albumname_hilight":"跨时代"},{"albumID":60671,"albumMID":"0024bjiL2aocxT","albumName":"十一月的萧邦","albumname_hilight":"十一月的萧邦"},{"albumID":8220,"albumMID":"000MkMni19ClKG","albumName":"叶惠美","albumname_hilight":"叶惠美"},{"albumID":8217,"albumMID":"000I5jJB3blWeN","albumName":"范特西","albumname_hilight":"范特西"}],"hotsong":[{"f":"237773700|说好不哭（with 五月天阿信）|4558|周杰伦|7876962|说好不哭（with 五月天阿信）|0|222|0|1|0|8896459|3558702|0|0|0|43879570|4800957|5352990|0|001qvvgF38HVc4|0025NhlN2yWrP4|002gBTVk4JEE2T|0|4009","songID":237773700,"songMID":"001qvvgF38HVc4","songName":"说好不哭（with 五月天阿信）","songname_hilight":"说好不哭（with 五月天阿信）"},{"f":"97773|晴天|4558|周杰伦|8220|叶惠美|2186317|269|9|1|0|10793267|4319991|0|0|30143423|31518872|5871273|6308305|0|0039MnYb0qxYhV|0025NhlN2yWrP4|000MkMni19ClKG|0|4009","songID":97773,"songMID":"0039MnYb0qxYhV","songName":"晴天","songname_hilight":"晴天"},{"f":"107192078|告白气球|4558|周杰伦|1458791|周杰伦的床边故事|0|215|1|1|0|8608859|3443771|0|0|0|43845959|5007453|5180289|0|003OUlho2HcRHC|0025NhlN2yWrP4|003RMaRI1iFoYd|0|4009","songID":107192078,"songMID":"003OUlho2HcRHC","songName":"告白气球","songname_hilight":"告白气球"},{"f":"5105986|一路向北|4558|周杰伦|14311|J III MP3 Player|0|295|1|1|0|11830556|4732355|0|0|0|35323866|6667274|7159409|0|001xd0HI0X9GNq|0025NhlN2yWrP4|002MAeob3zLXwZ|0|4009","songID":5105986,"songMID":"001xd0HI0X9GNq","songName":"一路向北","songname_hilight":"一路向北"},{"f":"212877900|等你下课(with 杨瑞代)|4558|周杰伦|3883404|等你下课|0|270|4|1|0|10802373|4321080|0|0|0|57812617|6043248|6529323|0|001J5QJL1pRQYB|0025NhlN2yWrP4|003bSL0v4bpKAx|0|4009","songID":212877900,"songMID":"001J5QJL1pRQYB","songName":"等你下课(with 杨瑞代)","songname_hilight":"等你下课(with 杨瑞代)"},{"f":"102065756|七里香|4558|周杰伦|20612|七里香|0|299|2|1|0|11970297|4788294|0|0|0|35845646|7078399|7214942|0|004Z8Ihr0JIu5s|0025NhlN2yWrP4|003DFRzD192KKD|0|4009","songID":102065756,"songMID":"004Z8Ihr0JIu5s","songName":"七里香","songname_hilight":"七里香"},{"f":"449205|稻香|4558|周杰伦|36062|魔杰座|1813383|223|9|1|0|8929849|3581117|0|0|25245000|26093502|5156630|5354369|0|003aAYrm3GE0Ac|0025NhlN2yWrP4|002Neh8l0uciQZ|0|4009","songID":449205,"songMID":"003aAYrm3GE0Ac","songName":"稻香","songname_hilight":"稻香"},{"f":"718477|夜曲|4558|周杰伦|60671|十一月的萧邦|1840421|226|7|1|0|9069409|3634616|0|0|25655984|26842143|5614538|5659229|0|001zMQr71F1Qo8|0025NhlN2yWrP4|0024bjiL2aocxT|0|4009","songID":718477,"songMID":"001zMQr71F1Qo8","songName":"夜曲","songname_hilight":"夜曲"},{"f":"102065750|搁浅|4558|周杰伦|20612|七里香|0|240|2|1|0|9607864|3843167|0|0|0|26174554|5218730|5785073|0|001Bbywq2gicae|0025NhlN2yWrP4|003DFRzD192KKD|0|4009","songID":102065750,"songMID":"001Bbywq2gicae","songName":"搁浅","songname_hilight":"搁浅"},{"f":"680285|爱的飞行日记|4558|周杰伦|56705|跨时代|2068725|254|6|1|0|10198382|4083086|0|0|30283480|31195399|5750121|6166343|0|003CxS6w14OQyM|0025NhlN2yWrP4|000bviBl4FjTpO|0|4009","songID":680285,"songMID":"003CxS6w14OQyM","songName":"爱的飞行日记","songname_hilight":"爱的飞行日记"}],"mvNum":1287,"singerID":4558,"singerMID":"0025NhlN2yWrP4","singerName":"周杰伦","singerPic":"http://y.gtimg.cn/music/photo_new/T001R150x150M0000025NhlN2yWrP4.jpg","singername_hilight":"周杰伦","songNum":979}}
         */

        private String keyword;
        private int priority;
        private SemanticBean semantic;
        private SongBean song;
        private int tab;
        private int totaltime;
        private ZhidaBean zhida;
        private List<?> qc;
        private List<?> taglist;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public SemanticBean getSemantic() {
            return semantic;
        }

        public void setSemantic(SemanticBean semantic) {
            this.semantic = semantic;
        }

        public SongBean getSong() {
            return song;
        }

        public void setSong(SongBean song) {
            this.song = song;
        }

        public int getTab() {
            return tab;
        }

        public void setTab(int tab) {
            this.tab = tab;
        }

        public int getTotaltime() {
            return totaltime;
        }

        public void setTotaltime(int totaltime) {
            this.totaltime = totaltime;
        }

        public ZhidaBean getZhida() {
            return zhida;
        }

        public void setZhida(ZhidaBean zhida) {
            this.zhida = zhida;
        }

        public List<?> getQc() {
            return qc;
        }

        public void setQc(List<?> qc) {
            this.qc = qc;
        }

        public List<?> getTaglist() {
            return taglist;
        }

        public void setTaglist(List<?> taglist) {
            this.taglist = taglist;
        }

        public static class SemanticBean {
            /**
             * curnum : 0
             * curpage : 1
             * list : []
             * totalnum : 0
             */

            private int curnum;
            private int curpage;
            private int totalnum;
            private List<?> list;

            public int getCurnum() {
                return curnum;
            }

            public void setCurnum(int curnum) {
                this.curnum = curnum;
            }

            public int getCurpage() {
                return curpage;
            }

            public void setCurpage(int curpage) {
                this.curpage = curpage;
            }

            public int getTotalnum() {
                return totalnum;
            }

            public void setTotalnum(int totalnum) {
                this.totalnum = totalnum;
            }

            public List<?> getList() {
                return list;
            }

            public void setList(List<?> list) {
                this.list = list;
            }
        }

        public static class SongBean {
            /**
             * curnum : 35
             * curpage : 1
             * totalnum : 77
             */

            private int curnum;
            private int curpage;
            private int totalnum;
            private List<ListBean> list;

            public int getCurnum() {
                return curnum;
            }

            public void setCurnum(int curnum) {
                this.curnum = curnum;
            }

            public int getCurpage() {
                return curpage;
            }

            public void setCurpage(int curpage) {
                this.curpage = curpage;
            }

            public int getTotalnum() {
                return totalnum;
            }

            public void setTotalnum(int totalnum) {
                this.totalnum = totalnum;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * action : {"alert":41,"icons":12992380,"msg":13,"switch":17405185}
                 * album : {"id":8221,"mid":"001BGzMs369FzU","name":"寻找周杰伦","pmid":"001BGzMs369FzU_1","subtitle":"《寻找周杰伦》电影插曲","title":"寻找周杰伦","title_hilight":"寻找周杰伦"}
                 * chinesesinger : 0
                 * desc :
                 * desc_hilight :
                 * docid : 2690403057583679707
                 * file : {"b_30s":0,"e_30s":60000,"media_mid":"003ZdxP61ClQZ5","size_128":4763445,"size_128mp3":4763445,"size_320":11895634,"size_320mp3":11895634,"size_aac":6984540,"size_ape":31653329,"size_dts":0,"size_flac":33029764,"size_ogg":6553270,"size_try":960887,"strMediaMid":"003ZdxP61ClQZ5","try_begin":18620,"try_end":40079}
                 * fnote : 4009
                 * genre : 1
                 * grp : []
                 * id : 97782
                 * index_album : 2
                 * index_cd : 0
                 * interval : 297
                 * isonly : 1
                 * ksong : {"id":50005,"mid":"0048qJM60fA2RA"}
                 * language : 0
                 * lyric : 《寻找周杰伦》电影插曲
                 * lyric_hilight : 《寻找周杰伦》电影插曲
                 * mid : 003ZdxP61ClQZ5
                 * mv : {"id":37865,"vid":"r0013wcyzl4"}
                 * name : 断了的弦
                 * newStatus : 2
                 * pay : {"pay_down":1,"pay_month":1,"pay_play":1,"pay_status":0,"price_album":0,"price_track":200,"time_free":0}
                 * pure : 0
                 * singer : [{"id":4558,"mid":"0025NhlN2yWrP4","name":"周杰伦","title":"周杰伦","title_hilight":"周杰伦","type":0,"uin":0}]
                 * status : 0
                 * subtitle : 《寻找周杰伦》电影插曲
                 * t : 1
                 * tag : 11
                 * time_public : 2003-11-01
                 * title : 断了的弦
                 * title_hilight : <em>断了的弦</em>
                 * type : 0
                 * url : http://stream10.qqmusic.qq.com/97782.wma
                 * ver : 0
                 * volume : {"gain":-7.901999950408936,"lra":6.692999839782715,"peak":1}
                 * format :
                 */

                private ActionBean action;
                private AlbumBean album;
                private int chinesesinger;
                private String desc;
                private String desc_hilight;
                private String docid;
                private FileBean file;
                private int fnote;
                private int genre;
                private int id;
                private int index_album;
                private int index_cd;
                private int interval;
                private int isonly;
                private KsongBean ksong;
                private int language;
                private String lyric;
                private String lyric_hilight;
                private String mid;
                private MvBean mv;
                private String name;
                private int newStatus;
                private long nt;
                private PayBean pay;
                private int pure;
                private int status;
                private String subtitle;
                private int t;
                private int tag;
                private String time_public;
                private String title;
                private String title_hilight;
                private int type;
                private String url;
                private int ver;
                private VolumeBean volume;
                private String format;
                private List<Grp> grp;
                private List<SingerBean> singer;

                public ActionBean getAction() {
                    return action;
                }

                public void setAction(ActionBean action) {
                    this.action = action;
                }

                public AlbumBean getAlbum() {
                    return album;
                }

                public void setAlbum(AlbumBean album) {
                    this.album = album;
                }

                public int getChinesesinger() {
                    return chinesesinger;
                }

                public void setChinesesinger(int chinesesinger) {
                    this.chinesesinger = chinesesinger;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDesc_hilight() {
                    return desc_hilight;
                }

                public void setDesc_hilight(String desc_hilight) {
                    this.desc_hilight = desc_hilight;
                }

                public String getDocid() {
                    return docid;
                }

                public void setDocid(String docid) {
                    this.docid = docid;
                }

                public FileBean getFile() {
                    return file;
                }

                public void setFile(FileBean file) {
                    this.file = file;
                }

                public int getFnote() {
                    return fnote;
                }

                public void setFnote(int fnote) {
                    this.fnote = fnote;
                }

                public int getGenre() {
                    return genre;
                }

                public void setGenre(int genre) {
                    this.genre = genre;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getIndex_album() {
                    return index_album;
                }

                public void setIndex_album(int index_album) {
                    this.index_album = index_album;
                }

                public int getIndex_cd() {
                    return index_cd;
                }

                public void setIndex_cd(int index_cd) {
                    this.index_cd = index_cd;
                }

                public int getInterval() {
                    return interval;
                }

                public void setInterval(int interval) {
                    this.interval = interval;
                }

                public int getIsonly() {
                    return isonly;
                }

                public void setIsonly(int isonly) {
                    this.isonly = isonly;
                }

                public KsongBean getKsong() {
                    return ksong;
                }

                public void setKsong(KsongBean ksong) {
                    this.ksong = ksong;
                }

                public int getLanguage() {
                    return language;
                }

                public void setLanguage(int language) {
                    this.language = language;
                }

                public String getLyric() {
                    return lyric;
                }

                public void setLyric(String lyric) {
                    this.lyric = lyric;
                }

                public String getLyric_hilight() {
                    return lyric_hilight;
                }

                public void setLyric_hilight(String lyric_hilight) {
                    this.lyric_hilight = lyric_hilight;
                }

                public String getMid() {
                    return mid;
                }

                public void setMid(String mid) {
                    this.mid = mid;
                }

                public MvBean getMv() {
                    return mv;
                }

                public void setMv(MvBean mv) {
                    this.mv = mv;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getNewStatus() {
                    return newStatus;
                }

                public void setNewStatus(int newStatus) {
                    this.newStatus = newStatus;
                }

                public long getNt() {
                    return nt;
                }

                public void setNt(long nt) {
                    this.nt = nt;
                }

                public PayBean getPay() {
                    return pay;
                }

                public void setPay(PayBean pay) {
                    this.pay = pay;
                }

                public int getPure() {
                    return pure;
                }

                public void setPure(int pure) {
                    this.pure = pure;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getSubtitle() {
                    return subtitle;
                }

                public void setSubtitle(String subtitle) {
                    this.subtitle = subtitle;
                }

                public int getT() {
                    return t;
                }

                public void setT(int t) {
                    this.t = t;
                }

                public int getTag() {
                    return tag;
                }

                public void setTag(int tag) {
                    this.tag = tag;
                }

                public String getTime_public() {
                    return time_public;
                }

                public void setTime_public(String time_public) {
                    this.time_public = time_public;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTitle_hilight() {
                    return title_hilight;
                }

                public void setTitle_hilight(String title_hilight) {
                    this.title_hilight = title_hilight;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getVer() {
                    return ver;
                }

                public void setVer(int ver) {
                    this.ver = ver;
                }

                public VolumeBean getVolume() {
                    return volume;
                }

                public void setVolume(VolumeBean volume) {
                    this.volume = volume;
                }

                public String getFormat() {
                    return format;
                }

                public void setFormat(String format) {
                    this.format = format;
                }

                public List<Grp> getGrp() {
                    return grp;
                }

                public void setGrp(List<Grp> grp) {
                    this.grp = grp;
                }

                public List<SingerBean> getSinger() {
                    return singer;
                }

                public void setSinger(List<SingerBean> singer) {
                    this.singer = singer;
                }

                public static class ActionBean {
                    /**
                     * alert : 41
                     * icons : 12992380
                     * msg : 13
                     * switch : 17405185
                     */

                    private int alert;
                    private int icons;
                    private int msg;
                    private int switchX;

                    public int getAlert() {
                        return alert;
                    }

                    public void setAlert(int alert) {
                        this.alert = alert;
                    }

                    public int getIcons() {
                        return icons;
                    }

                    public void setIcons(int icons) {
                        this.icons = icons;
                    }

                    public int getMsg() {
                        return msg;
                    }

                    public void setMsg(int msg) {
                        this.msg = msg;
                    }

                    public int getSwitchX() {
                        return switchX;
                    }

                    public void setSwitchX(int switchX) {
                        this.switchX = switchX;
                    }
                }

                public static class AlbumBean {
                    /**
                     * id : 8221
                     * mid : 001BGzMs369FzU
                     * name : 寻找周杰伦
                     * pmid : 001BGzMs369FzU_1
                     * subtitle : 《寻找周杰伦》电影插曲
                     * title : 寻找周杰伦
                     * title_hilight : 寻找周杰伦
                     */

                    private int id;
                    private String mid;
                    private String name;
                    private String pmid;
                    private String subtitle;
                    private String title;
                    private String title_hilight;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getMid() {
                        return mid;
                    }

                    public void setMid(String mid) {
                        this.mid = mid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getPmid() {
                        return pmid;
                    }

                    public void setPmid(String pmid) {
                        this.pmid = pmid;
                    }

                    public String getSubtitle() {
                        return subtitle;
                    }

                    public void setSubtitle(String subtitle) {
                        this.subtitle = subtitle;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getTitle_hilight() {
                        return title_hilight;
                    }

                    public void setTitle_hilight(String title_hilight) {
                        this.title_hilight = title_hilight;
                    }
                }

                public static class FileBean {
                    /**
                     * b_30s : 0
                     * e_30s : 60000
                     * media_mid : 003ZdxP61ClQZ5
                     * size_128 : 4763445
                     * size_128mp3 : 4763445
                     * size_320 : 11895634
                     * size_320mp3 : 11895634
                     * size_aac : 6984540
                     * size_ape : 31653329
                     * size_dts : 0
                     * size_flac : 33029764
                     * size_ogg : 6553270
                     * size_try : 960887
                     * strMediaMid : 003ZdxP61ClQZ5
                     * try_begin : 18620
                     * try_end : 40079
                     */

                    private int b_30s;
                    private int e_30s;
                    private String media_mid;
                    private int size_128;
                    private int size_128mp3;
                    private int size_320;
                    private int size_320mp3;
                    private int size_aac;
                    private int size_ape;
                    private int size_dts;
                    private int size_flac;
                    private int size_ogg;
                    private int size_try;
                    private String strMediaMid;
                    private int try_begin;
                    private int try_end;

                    public int getB_30s() {
                        return b_30s;
                    }

                    public void setB_30s(int b_30s) {
                        this.b_30s = b_30s;
                    }

                    public int getE_30s() {
                        return e_30s;
                    }

                    public void setE_30s(int e_30s) {
                        this.e_30s = e_30s;
                    }

                    public String getMedia_mid() {
                        return media_mid;
                    }

                    public void setMedia_mid(String media_mid) {
                        this.media_mid = media_mid;
                    }

                    public int getSize_128() {
                        return size_128;
                    }

                    public void setSize_128(int size_128) {
                        this.size_128 = size_128;
                    }

                    public int getSize_128mp3() {
                        return size_128mp3;
                    }

                    public void setSize_128mp3(int size_128mp3) {
                        this.size_128mp3 = size_128mp3;
                    }

                    public int getSize_320() {
                        return size_320;
                    }

                    public void setSize_320(int size_320) {
                        this.size_320 = size_320;
                    }

                    public int getSize_320mp3() {
                        return size_320mp3;
                    }

                    public void setSize_320mp3(int size_320mp3) {
                        this.size_320mp3 = size_320mp3;
                    }

                    public int getSize_aac() {
                        return size_aac;
                    }

                    public void setSize_aac(int size_aac) {
                        this.size_aac = size_aac;
                    }

                    public int getSize_ape() {
                        return size_ape;
                    }

                    public void setSize_ape(int size_ape) {
                        this.size_ape = size_ape;
                    }

                    public int getSize_dts() {
                        return size_dts;
                    }

                    public void setSize_dts(int size_dts) {
                        this.size_dts = size_dts;
                    }

                    public int getSize_flac() {
                        return size_flac;
                    }

                    public void setSize_flac(int size_flac) {
                        this.size_flac = size_flac;
                    }

                    public int getSize_ogg() {
                        return size_ogg;
                    }

                    public void setSize_ogg(int size_ogg) {
                        this.size_ogg = size_ogg;
                    }

                    public int getSize_try() {
                        return size_try;
                    }

                    public void setSize_try(int size_try) {
                        this.size_try = size_try;
                    }

                    public String getStrMediaMid() {
                        return strMediaMid;
                    }

                    public void setStrMediaMid(String strMediaMid) {
                        this.strMediaMid = strMediaMid;
                    }

                    public int getTry_begin() {
                        return try_begin;
                    }

                    public void setTry_begin(int try_begin) {
                        this.try_begin = try_begin;
                    }

                    public int getTry_end() {
                        return try_end;
                    }

                    public void setTry_end(int try_end) {
                        this.try_end = try_end;
                    }
                }

                public static class KsongBean {
                    /**
                     * id : 50005
                     * mid : 0048qJM60fA2RA
                     */

                    private int id;
                    private String mid;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getMid() {
                        return mid;
                    }

                    public void setMid(String mid) {
                        this.mid = mid;
                    }
                }

                public static class MvBean {
                    /**
                     * id : 37865
                     * vid : r0013wcyzl4
                     */

                    private int id;
                    private String vid;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getVid() {
                        return vid;
                    }

                    public void setVid(String vid) {
                        this.vid = vid;
                    }
                }

                public static class PayBean {
                    /**
                     * pay_down : 1
                     * pay_month : 1
                     * pay_play : 1
                     * pay_status : 0
                     * price_album : 0
                     * price_track : 200
                     * time_free : 0
                     */

                    private int pay_down;
                    private int pay_month;
                    private int pay_play;
                    private int pay_status;
                    private int price_album;
                    private int price_track;
                    private int time_free;

                    public int getPay_down() {
                        return pay_down;
                    }

                    public void setPay_down(int pay_down) {
                        this.pay_down = pay_down;
                    }

                    public int getPay_month() {
                        return pay_month;
                    }

                    public void setPay_month(int pay_month) {
                        this.pay_month = pay_month;
                    }

                    public int getPay_play() {
                        return pay_play;
                    }

                    public void setPay_play(int pay_play) {
                        this.pay_play = pay_play;
                    }

                    public int getPay_status() {
                        return pay_status;
                    }

                    public void setPay_status(int pay_status) {
                        this.pay_status = pay_status;
                    }

                    public int getPrice_album() {
                        return price_album;
                    }

                    public void setPrice_album(int price_album) {
                        this.price_album = price_album;
                    }

                    public int getPrice_track() {
                        return price_track;
                    }

                    public void setPrice_track(int price_track) {
                        this.price_track = price_track;
                    }

                    public int getTime_free() {
                        return time_free;
                    }

                    public void setTime_free(int time_free) {
                        this.time_free = time_free;
                    }
                }

                public static class VolumeBean {
                    /**
                     * gain : -7.901999950408936
                     * lra : 6.692999839782715
                     * peak : 1.0
                     */

                    private double gain;
                    private double lra;
                    private double peak;

                    public double getGain() {
                        return gain;
                    }

                    public void setGain(double gain) {
                        this.gain = gain;
                    }

                    public double getLra() {
                        return lra;
                    }

                    public void setLra(double lra) {
                        this.lra = lra;
                    }

                    public double getPeak() {
                        return peak;
                    }

                    public void setPeak(double peak) {
                        this.peak = peak;
                    }
                }

                public static class SingerBean {
                    /**
                     * id : 4558
                     * mid : 0025NhlN2yWrP4
                     * name : 周杰伦
                     * title : 周杰伦
                     * title_hilight : 周杰伦
                     * type : 0
                     * uin : 0
                     */

                    private int id;
                    private String mid;
                    private String name;
                    private String title;
                    private String title_hilight;
                    private int type;
                    private long uin;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getMid() {
                        return mid;
                    }

                    public void setMid(String mid) {
                        this.mid = mid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getTitle_hilight() {
                        return title_hilight;
                    }

                    public void setTitle_hilight(String title_hilight) {
                        this.title_hilight = title_hilight;
                    }

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public long getUin() {
                        return uin;
                    }

                    public void setUin(long uin) {
                        this.uin = uin;
                    }
                }
            }
        }

        public static class ZhidaBean {
            /**
             * type : 1
             * zhida_singer : {"albumNum":32,"hotalbum":[{"albumID":1458791,"albumMID":"003RMaRI1iFoYd","albumName":"周杰伦的床边故事","albumname_hilight":"周杰伦的床边故事"},{"albumID":33021,"albumMID":"002eFUFm2XYZ7z","albumName":"我很忙","albumname_hilight":"我很忙"},{"albumID":852856,"albumMID":"001uqejs3d6EID","albumName":"哎呦，不错哦","albumname_hilight":"哎呦，不错哦"},{"albumID":194021,"albumMID":"003Ow85E3pnoqi","albumName":"十二新作","albumname_hilight":"十二新作"},{"albumID":36062,"albumMID":"002Neh8l0uciQZ","albumName":"魔杰座","albumname_hilight":"魔杰座"},{"albumID":8218,"albumMID":"000f01724fd7TH","albumName":"Jay","albumname_hilight":"Jay"},{"albumID":56705,"albumMID":"000bviBl4FjTpO","albumName":"跨时代","albumname_hilight":"跨时代"},{"albumID":60671,"albumMID":"0024bjiL2aocxT","albumName":"十一月的萧邦","albumname_hilight":"十一月的萧邦"},{"albumID":8220,"albumMID":"000MkMni19ClKG","albumName":"叶惠美","albumname_hilight":"叶惠美"},{"albumID":8217,"albumMID":"000I5jJB3blWeN","albumName":"范特西","albumname_hilight":"范特西"}],"hotsong":[{"f":"237773700|说好不哭（with 五月天阿信）|4558|周杰伦|7876962|说好不哭（with 五月天阿信）|0|222|0|1|0|8896459|3558702|0|0|0|43879570|4800957|5352990|0|001qvvgF38HVc4|0025NhlN2yWrP4|002gBTVk4JEE2T|0|4009","songID":237773700,"songMID":"001qvvgF38HVc4","songName":"说好不哭（with 五月天阿信）","songname_hilight":"说好不哭（with 五月天阿信）"},{"f":"97773|晴天|4558|周杰伦|8220|叶惠美|2186317|269|9|1|0|10793267|4319991|0|0|30143423|31518872|5871273|6308305|0|0039MnYb0qxYhV|0025NhlN2yWrP4|000MkMni19ClKG|0|4009","songID":97773,"songMID":"0039MnYb0qxYhV","songName":"晴天","songname_hilight":"晴天"},{"f":"107192078|告白气球|4558|周杰伦|1458791|周杰伦的床边故事|0|215|1|1|0|8608859|3443771|0|0|0|43845959|5007453|5180289|0|003OUlho2HcRHC|0025NhlN2yWrP4|003RMaRI1iFoYd|0|4009","songID":107192078,"songMID":"003OUlho2HcRHC","songName":"告白气球","songname_hilight":"告白气球"},{"f":"5105986|一路向北|4558|周杰伦|14311|J III MP3 Player|0|295|1|1|0|11830556|4732355|0|0|0|35323866|6667274|7159409|0|001xd0HI0X9GNq|0025NhlN2yWrP4|002MAeob3zLXwZ|0|4009","songID":5105986,"songMID":"001xd0HI0X9GNq","songName":"一路向北","songname_hilight":"一路向北"},{"f":"212877900|等你下课(with 杨瑞代)|4558|周杰伦|3883404|等你下课|0|270|4|1|0|10802373|4321080|0|0|0|57812617|6043248|6529323|0|001J5QJL1pRQYB|0025NhlN2yWrP4|003bSL0v4bpKAx|0|4009","songID":212877900,"songMID":"001J5QJL1pRQYB","songName":"等你下课(with 杨瑞代)","songname_hilight":"等你下课(with 杨瑞代)"},{"f":"102065756|七里香|4558|周杰伦|20612|七里香|0|299|2|1|0|11970297|4788294|0|0|0|35845646|7078399|7214942|0|004Z8Ihr0JIu5s|0025NhlN2yWrP4|003DFRzD192KKD|0|4009","songID":102065756,"songMID":"004Z8Ihr0JIu5s","songName":"七里香","songname_hilight":"七里香"},{"f":"449205|稻香|4558|周杰伦|36062|魔杰座|1813383|223|9|1|0|8929849|3581117|0|0|25245000|26093502|5156630|5354369|0|003aAYrm3GE0Ac|0025NhlN2yWrP4|002Neh8l0uciQZ|0|4009","songID":449205,"songMID":"003aAYrm3GE0Ac","songName":"稻香","songname_hilight":"稻香"},{"f":"718477|夜曲|4558|周杰伦|60671|十一月的萧邦|1840421|226|7|1|0|9069409|3634616|0|0|25655984|26842143|5614538|5659229|0|001zMQr71F1Qo8|0025NhlN2yWrP4|0024bjiL2aocxT|0|4009","songID":718477,"songMID":"001zMQr71F1Qo8","songName":"夜曲","songname_hilight":"夜曲"},{"f":"102065750|搁浅|4558|周杰伦|20612|七里香|0|240|2|1|0|9607864|3843167|0|0|0|26174554|5218730|5785073|0|001Bbywq2gicae|0025NhlN2yWrP4|003DFRzD192KKD|0|4009","songID":102065750,"songMID":"001Bbywq2gicae","songName":"搁浅","songname_hilight":"搁浅"},{"f":"680285|爱的飞行日记|4558|周杰伦|56705|跨时代|2068725|254|6|1|0|10198382|4083086|0|0|30283480|31195399|5750121|6166343|0|003CxS6w14OQyM|0025NhlN2yWrP4|000bviBl4FjTpO|0|4009","songID":680285,"songMID":"003CxS6w14OQyM","songName":"爱的飞行日记","songname_hilight":"爱的飞行日记"}],"mvNum":1287,"singerID":4558,"singerMID":"0025NhlN2yWrP4","singerName":"周杰伦","singerPic":"http://y.gtimg.cn/music/photo_new/T001R150x150M0000025NhlN2yWrP4.jpg","singername_hilight":"周杰伦","songNum":979}
             */

            private int type;
            private ZhidaSingerBean zhida_singer;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public ZhidaSingerBean getZhida_singer() {
                return zhida_singer;
            }

            public void setZhida_singer(ZhidaSingerBean zhida_singer) {
                this.zhida_singer = zhida_singer;
            }

            public static class ZhidaSingerBean {
                /**
                 * albumNum : 32
                 * hotalbum : [{"albumID":1458791,"albumMID":"003RMaRI1iFoYd","albumName":"周杰伦的床边故事","albumname_hilight":"周杰伦的床边故事"},{"albumID":33021,"albumMID":"002eFUFm2XYZ7z","albumName":"我很忙","albumname_hilight":"我很忙"},{"albumID":852856,"albumMID":"001uqejs3d6EID","albumName":"哎呦，不错哦","albumname_hilight":"哎呦，不错哦"},{"albumID":194021,"albumMID":"003Ow85E3pnoqi","albumName":"十二新作","albumname_hilight":"十二新作"},{"albumID":36062,"albumMID":"002Neh8l0uciQZ","albumName":"魔杰座","albumname_hilight":"魔杰座"},{"albumID":8218,"albumMID":"000f01724fd7TH","albumName":"Jay","albumname_hilight":"Jay"},{"albumID":56705,"albumMID":"000bviBl4FjTpO","albumName":"跨时代","albumname_hilight":"跨时代"},{"albumID":60671,"albumMID":"0024bjiL2aocxT","albumName":"十一月的萧邦","albumname_hilight":"十一月的萧邦"},{"albumID":8220,"albumMID":"000MkMni19ClKG","albumName":"叶惠美","albumname_hilight":"叶惠美"},{"albumID":8217,"albumMID":"000I5jJB3blWeN","albumName":"范特西","albumname_hilight":"范特西"}]
                 * hotsong : [{"f":"237773700|说好不哭（with 五月天阿信）|4558|周杰伦|7876962|说好不哭（with 五月天阿信）|0|222|0|1|0|8896459|3558702|0|0|0|43879570|4800957|5352990|0|001qvvgF38HVc4|0025NhlN2yWrP4|002gBTVk4JEE2T|0|4009","songID":237773700,"songMID":"001qvvgF38HVc4","songName":"说好不哭（with 五月天阿信）","songname_hilight":"说好不哭（with 五月天阿信）"},{"f":"97773|晴天|4558|周杰伦|8220|叶惠美|2186317|269|9|1|0|10793267|4319991|0|0|30143423|31518872|5871273|6308305|0|0039MnYb0qxYhV|0025NhlN2yWrP4|000MkMni19ClKG|0|4009","songID":97773,"songMID":"0039MnYb0qxYhV","songName":"晴天","songname_hilight":"晴天"},{"f":"107192078|告白气球|4558|周杰伦|1458791|周杰伦的床边故事|0|215|1|1|0|8608859|3443771|0|0|0|43845959|5007453|5180289|0|003OUlho2HcRHC|0025NhlN2yWrP4|003RMaRI1iFoYd|0|4009","songID":107192078,"songMID":"003OUlho2HcRHC","songName":"告白气球","songname_hilight":"告白气球"},{"f":"5105986|一路向北|4558|周杰伦|14311|J III MP3 Player|0|295|1|1|0|11830556|4732355|0|0|0|35323866|6667274|7159409|0|001xd0HI0X9GNq|0025NhlN2yWrP4|002MAeob3zLXwZ|0|4009","songID":5105986,"songMID":"001xd0HI0X9GNq","songName":"一路向北","songname_hilight":"一路向北"},{"f":"212877900|等你下课(with 杨瑞代)|4558|周杰伦|3883404|等你下课|0|270|4|1|0|10802373|4321080|0|0|0|57812617|6043248|6529323|0|001J5QJL1pRQYB|0025NhlN2yWrP4|003bSL0v4bpKAx|0|4009","songID":212877900,"songMID":"001J5QJL1pRQYB","songName":"等你下课(with 杨瑞代)","songname_hilight":"等你下课(with 杨瑞代)"},{"f":"102065756|七里香|4558|周杰伦|20612|七里香|0|299|2|1|0|11970297|4788294|0|0|0|35845646|7078399|7214942|0|004Z8Ihr0JIu5s|0025NhlN2yWrP4|003DFRzD192KKD|0|4009","songID":102065756,"songMID":"004Z8Ihr0JIu5s","songName":"七里香","songname_hilight":"七里香"},{"f":"449205|稻香|4558|周杰伦|36062|魔杰座|1813383|223|9|1|0|8929849|3581117|0|0|25245000|26093502|5156630|5354369|0|003aAYrm3GE0Ac|0025NhlN2yWrP4|002Neh8l0uciQZ|0|4009","songID":449205,"songMID":"003aAYrm3GE0Ac","songName":"稻香","songname_hilight":"稻香"},{"f":"718477|夜曲|4558|周杰伦|60671|十一月的萧邦|1840421|226|7|1|0|9069409|3634616|0|0|25655984|26842143|5614538|5659229|0|001zMQr71F1Qo8|0025NhlN2yWrP4|0024bjiL2aocxT|0|4009","songID":718477,"songMID":"001zMQr71F1Qo8","songName":"夜曲","songname_hilight":"夜曲"},{"f":"102065750|搁浅|4558|周杰伦|20612|七里香|0|240|2|1|0|9607864|3843167|0|0|0|26174554|5218730|5785073|0|001Bbywq2gicae|0025NhlN2yWrP4|003DFRzD192KKD|0|4009","songID":102065750,"songMID":"001Bbywq2gicae","songName":"搁浅","songname_hilight":"搁浅"},{"f":"680285|爱的飞行日记|4558|周杰伦|56705|跨时代|2068725|254|6|1|0|10198382|4083086|0|0|30283480|31195399|5750121|6166343|0|003CxS6w14OQyM|0025NhlN2yWrP4|000bviBl4FjTpO|0|4009","songID":680285,"songMID":"003CxS6w14OQyM","songName":"爱的飞行日记","songname_hilight":"爱的飞行日记"}]
                 * mvNum : 1287
                 * singerID : 4558
                 * singerMID : 0025NhlN2yWrP4
                 * singerName : 周杰伦
                 * singerPic : http://y.gtimg.cn/music/photo_new/T001R150x150M0000025NhlN2yWrP4.jpg
                 * singername_hilight : 周杰伦
                 * songNum : 979
                 */

                private int albumNum;
                private int mvNum;
                private int singerID;
                private String singerMID;
                private String singerName;
                private String singerPic;
                private String singername_hilight;
                private int songNum;
                private List<HotalbumBean> hotalbum;
                private List<HotsongBean> hotsong;

                public int getAlbumNum() {
                    return albumNum;
                }

                public void setAlbumNum(int albumNum) {
                    this.albumNum = albumNum;
                }

                public int getMvNum() {
                    return mvNum;
                }

                public void setMvNum(int mvNum) {
                    this.mvNum = mvNum;
                }

                public int getSingerID() {
                    return singerID;
                }

                public void setSingerID(int singerID) {
                    this.singerID = singerID;
                }

                public String getSingerMID() {
                    return singerMID;
                }

                public void setSingerMID(String singerMID) {
                    this.singerMID = singerMID;
                }

                public String getSingerName() {
                    return singerName;
                }

                public void setSingerName(String singerName) {
                    this.singerName = singerName;
                }

                public String getSingerPic() {
                    return singerPic;
                }

                public void setSingerPic(String singerPic) {
                    this.singerPic = singerPic;
                }

                public String getSingername_hilight() {
                    return singername_hilight;
                }

                public void setSingername_hilight(String singername_hilight) {
                    this.singername_hilight = singername_hilight;
                }

                public int getSongNum() {
                    return songNum;
                }

                public void setSongNum(int songNum) {
                    this.songNum = songNum;
                }

                public List<HotalbumBean> getHotalbum() {
                    return hotalbum;
                }

                public void setHotalbum(List<HotalbumBean> hotalbum) {
                    this.hotalbum = hotalbum;
                }

                public List<HotsongBean> getHotsong() {
                    return hotsong;
                }

                public void setHotsong(List<HotsongBean> hotsong) {
                    this.hotsong = hotsong;
                }

                public static class HotalbumBean {
                    /**
                     * albumID : 1458791
                     * albumMID : 003RMaRI1iFoYd
                     * albumName : 周杰伦的床边故事
                     * albumname_hilight : 周杰伦的床边故事
                     */

                    private int albumID;
                    private String albumMID;
                    private String albumName;
                    private String albumname_hilight;

                    public int getAlbumID() {
                        return albumID;
                    }

                    public void setAlbumID(int albumID) {
                        this.albumID = albumID;
                    }

                    public String getAlbumMID() {
                        return albumMID;
                    }

                    public void setAlbumMID(String albumMID) {
                        this.albumMID = albumMID;
                    }

                    public String getAlbumName() {
                        return albumName;
                    }

                    public void setAlbumName(String albumName) {
                        this.albumName = albumName;
                    }

                    public String getAlbumname_hilight() {
                        return albumname_hilight;
                    }

                    public void setAlbumname_hilight(String albumname_hilight) {
                        this.albumname_hilight = albumname_hilight;
                    }
                }

                public static class HotsongBean {
                    /**
                     * f : 237773700|说好不哭（with 五月天阿信）|4558|周杰伦|7876962|说好不哭（with 五月天阿信）|0|222|0|1|0|8896459|3558702|0|0|0|43879570|4800957|5352990|0|001qvvgF38HVc4|0025NhlN2yWrP4|002gBTVk4JEE2T|0|4009
                     * songID : 237773700
                     * songMID : 001qvvgF38HVc4
                     * songName : 说好不哭（with 五月天阿信）
                     * songname_hilight : 说好不哭（with 五月天阿信）
                     */

                    private String f;
                    private int songID;
                    private String songMID;
                    private String songName;
                    private String songname_hilight;

                    public String getF() {
                        return f;
                    }

                    public void setF(String f) {
                        this.f = f;
                    }

                    public int getSongID() {
                        return songID;
                    }

                    public void setSongID(int songID) {
                        this.songID = songID;
                    }

                    public String getSongMID() {
                        return songMID;
                    }

                    public void setSongMID(String songMID) {
                        this.songMID = songMID;
                    }

                    public String getSongName() {
                        return songName;
                    }

                    public void setSongName(String songName) {
                        this.songName = songName;
                    }

                    public String getSongname_hilight() {
                        return songname_hilight;
                    }

                    public void setSongname_hilight(String songname_hilight) {
                        this.songname_hilight = songname_hilight;
                    }
                }
            }
        }
    }
}
