list = nil
file = '/Users/wentworth/Documents/12306.log'
file = '/Users/wentworth/Documents/github/lua-test/src/1.sql'
for line in io.lines(file) do
    list = { next = list, value = line }
end

--while list do
--    print(list.value)
--    list = list.next
--end

function prints(list)
    if list.next then
        prints(list.next)
    end
    print(list.value)
end

prints(list)
