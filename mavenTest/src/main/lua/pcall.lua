function foo()
    print(1)
    error({ a = 3, b = { c = { d = { 11, 22, 33 } } } }, 2)
    if unexpected_condition then
        print(2)
        error({ code = 456 })
    end
    print(3)
    print(a[i])
    print(4)
    return 123
end
flag, tab = pcall(foo)
print(flag)
print(tab.b['c']['d'][1])

