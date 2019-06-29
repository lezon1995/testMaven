package com.design_pattern.bridge;

/**
 * 抽象毛笔类
 *
 * @author zhuliang
 * @date 2019/6/29 21:37
 */
public abstract class AbstractBrushPen {

    protected AbstractColor color;

    /**
     * 每种笔都有自己的实现
     */
    public abstract void draw();

    public void setColor(AbstractColor color) {
        this.color = color;
    }

}
