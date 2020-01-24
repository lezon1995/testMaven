local curl = require "lcurl.safe"
local json = require "cjson.safe"

script_info = {
    ["title"] = "QQ音乐",
    ["description"] = "QQ音乐搜索和歌曲下载\n输入【:config】进入设置页面\n设置里可以切换下载或者播放\n如果播放调用的播放器不正确，请修改m3u格式文件的默认打开方式",
    ["version"] = "0.1.0",
    ["color"] = "#31c27c",
}

function onSearch(key, page)
    if key == ":config" or key == "【:config】" then
        if page == 1 then
            local config = {}
            local click = pd.getConfig("QQMusic", "click")
            local quality = pd.getConfig("QQMusic", "quality")
            table.insert(config, { ["title"] = "点击列表操作", ["enabled"] = "false" })
            table.insert(config, createConfigItem("下载", "click", "download", #click == 0 or click == "download"))
            table.insert(config, createConfigItem("播放", "click", "play", click == "play"))
            table.insert(config, { ["title"] = "优先下载音质", ["enabled"] = "false" })
            table.insert(config, createConfigItem("无损音质 - FLAC", "quality", "super", #quality == 0 or quality == "super"))
            table.insert(config, createConfigItem("极高音质 - 320K", "quality", "high", quality == "high"))
            table.insert(config, createConfigItem("较高音质 - 192K", "quality", "higher", quality == "higher"))
            table.insert(config, createConfigItem("普通音质 - 128K", "quality", "standard", quality == "standard"))
            return config
        else
            return {}
        end
    end
    local data = get("https://c.y.qq.com/soso/fcgi-bin/client_search_cp?ct=24&qqmusic_ver=1298&new_json=1&remoteplace=txt.yqq.song&searchid=0&t=0&aggr=1&cr=1&catZhida=1&lossless=0&flag_qc=0&p=" .. page .. "&n=20&g_tk=5381&loginUin=0&hostUin=0&format=jsonp&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq&needNewCode=0&w=" .. urlEncode(key))
    data = string.gsub(data, "^.-%((.-)%)$", "%1", 1)
    return parse(data)
end

function onItemClick(item)
    if item.isConfig then
        if item.isSel == "1" then
            return ACT_NULL
        else
            pd.setConfig("QQMusic", item.key, item.val)
            return ACT_MESSAGE, "设置成功! (请手动刷新页面)"
        end
    end
    if item.time == "00:00" then
        return ACT_ERROR, "该歌曲暂无音频资源"
    end
    local filetype = ""
    local quality = pd.getConfig("QQMusic", "quality")
    if quality == "super" then
        quality = 999
        filetype = ".flac"
    elseif quality == "high" then
        quality = 320
        filetype = ".mp3"
    elseif quality == "higher" then
        quality = 192
        filetype = ".m4a"
    elseif quality == "standard" then
        quality = 128
        filetype = ".mp3"
    end
    local j = json.decode(get("http://host811205719.s493.pppf.com.cn/api.php?types=url&source=tencent&id=" .. item.mid .. "&br=" .. quality))
    local link = j.url
    if pd.getConfig("QQMusic", "click") == "play" then
        return ACT_PLAY, link
    else
        if pd.addUri then
            pd.addUri(link, { ["out"] = item.name .. " - " .. item.singer .. filetype })
            return ACT_MESSAGE, "已添加到下载列表"
        else
            return ACT_DOWNLOAD, link
        end
    end
end

function get(url)
    local r = ""
    local c = curl.easy {
        url = url,
        ssl_verifyhost = 0,
        ssl_verifypeer = 0,
        followlocation = 1,
        timeout = 30,
        proxy = pd.getProxy(),
        writefunction = function(buffer)
            r = r .. buffer
            return #buffer
        end,
    }
    c:perform()
    c:close()
    return r
end

function parse(data)
    local result = {}
    local j = json.decode(data)
    if j == nil or j.data == nil or j.data.song == nil or j.data.song.list == nil then
        return result
    end
    for _, song in ipairs(j.data.song.list) do
        table.insert(result, parseSong(song))
        for _, item in ipairs(song.grp) do
            table.insert(result, parseSong(item))
        end
    end
    return result
end

function parseSong(song)
    local item = {}
    local singer_name, singer_mid, album_name = "", "", ""
    for _, singer in ipairs(song.singer) do
        if #singer_mid == 0 then
            singer_mid = singer.mid
        end
        if #singer_name > 0 then
            singer_name = singer_name .. " / "
        end
        singer_name = singer_name .. singer.title
    end
    description = "歌手：" .. singer_name
    if #song.album.title > 0 and song.album.title ~= "   " then
        description = description .. "  专辑：" .. song.album.title
        item.image = "https://y.gtimg.cn/music/photo_new/T002R300x300M000" .. song.album.mid .. ".jpg"
    end
    if item.image == nil then
        item.image = "https://y.gtimg.cn/music/photo_new/T001R300x300M000" .. singer_mid .. ".jpg"
    end
    if song.file.size_flac > 0 then
        item.file_flac = "1"
    end
    if song.file.size_320 > 0 then
        item.file_320 = "1"
    end
    if song.file.size_128 > 0 then
        item.file_128 = "1"
    end
    if item.file_flac then
        item.title = song.title .. "  {f 9}{c #ff6600}SQ{/c}{/f}"
    elseif item.file_320 then
        item.title = song.title .. "  {f 9}{c #31c27c}HQ{/c}{/f}"
    else
        item.title = song.title
    end
    item.mid = song.mid
    item.name = conv(song.title)
    item.singer = conv((string.gsub(singer_name, " / ", ",")))
    item.icon_size = "55,55"
    item.description = description
    item.time = string.format("%02d:%02d", math.floor(song.interval / 60), song.interval % 60)
    item.tooltip = song.title
    item.showhtml = "true"
    return item
end

function createConfigItem(title, key, val, isSel)
    local item = {}
    item.title = title
    item.key = key
    item.val = val
    item.icon_size = "14,14"
    item.isConfig = "1"
    if isSel then
        item.image = "option/selected.png"
        item.isSel = "1"
    else
        item.image = "option/normal.png"
        item.isSel = "0"
    end
    return item
end

function urlEncode(s)
    return (string.gsub(
            s,
            "[^%w%-_%.!~%*'%(%)]",
            function(c)
                return string.format("%%%02X", string.byte(c))
            end
    ))
end

function conv(s)
    s = string.gsub(s, "%?", "？")
    s = string.gsub(s, "%*", "＊")
    s = string.gsub(s, ":", "：")
    return s
end