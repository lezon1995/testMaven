local a = { 1, x = 10, "one", y = 45, "two", "three", [4] = "five" }

--for i, v in pairs(a) do
--    print("index:" .. i .. " --- " .. v)
--end

for i, v in ipairs(a) do
    print("index:" .. i .. " --- " .. v)
end

function test()
    return 10, 11
end
print(string.find("hello lua", "lua"))
print(tonumber((test() .. 9.99)))
function unpack(t, i)
    i = i or 1
    if t[i] ~= nil then
        return t[i], unpack(t, i + 1)
    end
end
print(unpack(a))

_, r = string.find("hello lua", "lua")
print(_, r)

a = select(2, string.find("hello lua", "lua"))
print(a)