package com.design_pattern.bridge.pen;

import com.design_pattern.bridge.AbstractBrushPen;

/**
 * @author zhuliang
 * @date 2019/6/29 21:40
 */
public class MiddleBrushPen extends AbstractBrushPen {
    @Override
    public void draw() {
        System.out.println("MiddleBrushPen is drawing ["+this.color.paint()+"]");
    }
}
