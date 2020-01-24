local a = 1
function test(str)
    local a = 2
    print(a, str)

    return str .. b
end
print(pcall(test, "你好"))


--repeat
--    print(a)
--    a = a + 1
--until a == 10
function Closure(time)
    local i = 1
    return function()
        i = i + 1
        i = i * time
        return i
    end

end

cl1 = Closure '3'
cl2 = Closure(39)
--for i = 1, 10 do
--    print(cl1())
--end
--for i = 1, 10 do
--    print(cl2())
--end

function callFunc(func)
    return func()
end

print(callFunc(cl2))
print(callFunc(cl2))