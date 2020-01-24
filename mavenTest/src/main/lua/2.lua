a = {}
for i = 0, 10 do
    a[i] = i * 2
end
--a[5] = nil
for i, line in ipairs(a) do
    print(i .. "--" .. line)
end

--[[
for i, line in pairs(a) do
    print(i .. "---" .. line)
end]]

