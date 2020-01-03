a = 1

function printAndAdd(str)
    print(a .. "-" .. str)
    a = a + 1
end
function f1()
    local i = 1
    while i <= 10 do
        printAndAdd("-- f1 before")
        local res, v1, v2 = coroutine.resume(c2, 100, 300)
        printAndAdd("-- f1 after")
        print(v1, v2)
        i = i + 1
    end
end

c1 = coroutine.create(f1)
--c1 = coroutine.wrap(f1)
function f2()
    while true do
        printAndAdd("-- f2 before")
        local v1, v2 = coroutine.yield(1, 2)
        printAndAdd("-- f2 after")
        print(v1, v2)
    end
end

c2 = coroutine.create(f2)

--c1()
coroutine.resume(c1)