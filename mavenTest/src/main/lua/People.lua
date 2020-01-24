CPeople = {
    name = "xxx",
    age = 18,
}

function CPeople:new(obj)
    obj = obj or {}
    setmetatable(obj, self)
    self.__index = self
    return obj
end

function CPeople:walk()
    print("walking")
end

function CPeople:say()
    print(self.name, self.age)
    CPeople.walk()
end

--local p1 = CPeople:new({ name = "zhangsan" })
--p1:say()

CMale = {
    name = "xxx",
    age = 18,
    sex = "male"
}

function CMale:extends(superClass)
    setmetatable(self, superClass)
    superClass.__index = superClass
end

function CMale:new(obj)
    obj = obj or {}
    setmetatable(obj, self)
    self.__index = self

    --setmetatable(self, CPeople)
    --CPeople.__index = CPeople

    return obj
end

function CMale:say()
    print(self.name, self.age, self.sex)
    self:walk()
end

--function CMale:walk()
--    print(self.name .. " " .. "walking")
--end
CMale:extends(CPeople);
local p2 = CMale:new({ name = "llili", age = 90 })
p2:say()


