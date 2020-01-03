function newCounter()
    local i = 0
    return function()
        i = i + 1
        return i
    end
end
c1 = newCounter()
print(c1())
print(c1())
c2 = newCounter()
print(c2())
print(c1())

local fact
fact = function(n)

    if n == 0 then
        return 1
    else
        return n * fact(n - 1)
    end
end

print(fact(10))

print(load("i=123 return i"))


