local dkjson = require("dkjson")
local tableUtil = require("tableUtil")

--lua对象到字符串  
local obj = {
    id = 1,
    name = "zhangsan",
    age = nil,
    is_male = false,
    hobby = { "film", "music", "read", a = "aaa" }
}

local str = dkjson.encode(obj, { indent = false })
print(str)

--字符串到lua对象
str = '{"hobby":["film","music","read"],"is_male":false,"name":"zhangsan","id":1,"age":null}'
local obj, pos, err = dkjson.decode(str, 1, nil)
print(obj, pos, err)
tableUtil.print(obj)