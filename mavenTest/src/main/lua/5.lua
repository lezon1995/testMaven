function select_(n, ...)
    return arg.n
end

a={
    close = "any",
    text = "看到自己走在归乡路上。",
    bear = { img = "4.png", anchor = { 0.5, 0.5 } },
    box = { vertical = "center", offsetY = 50, horizontal = "right", offsetX = 46 }
}

tableUtil = require("tableUtil")
tableUtil(a)