-------------------------------------------------------------------
-----递归删除文件夹 By only(慎用-)----------------------------
----------------------------------------------------------------------


local lfs = require("lfs")
function deletePath (path)
    for file in lfs.dir(path) do
        if file ~= "." and file ~= ".." then
            local f = path .. '/' .. file
            local attr = lfs.attributes(f)
            assert(type(attr) == "table")
            if attr.mode == "directory" then
                deletePath(f)
                --print("delete " .. f .. " directory")
                --os.remove(f)
            elseif attr.mode == "file" then
                print("delete " .. f .. " file")
                os.remove(f)
            end
        end
    end
    print("delete " .. path .. " directory")
    os.remove(path)
end
deletePath("/Users/wentworth/Documents/cocos/cocos/lua/11-21/test_delete")
print("delete complete")
-------------------------------------------------------------------
-----递归删除文件夹 By only(慎用-)----------------------------
----------------------------------------------------------------------