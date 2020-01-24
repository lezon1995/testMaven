a = { 1, x = 10, "one", y = 45, "two", "three" }
print(a[1])
print(a[2])
print(a[3])

opnames = { ["+"] = "add", ["-"] = "sub", ["*"] = "mul", ["/"] = "div" }

function test()
    print("test")
    return 1, 2
end

a = test
a, b = a();
print(a .. b)