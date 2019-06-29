package com.design_pattern.bridge;

import com.design_pattern.bridge.color.RedColor;
import com.design_pattern.bridge.pen.BigBrushPen;
import com.design_pattern.bridge.pen.SmallBrushPen;

/**
 * @author zhuliang
 * @date 2019/6/29 21:44
 */
public class DemoTest {
    public static void main(String[] args) {
        /**
         * 假如现在需要三种尺寸的笔 [大 中 小]
         * 而且需要每种尺寸的笔各有三种颜色 [红 蓝 绿]
         * 那么就需要3 * 3 = 9 种具体实现类
         *
         * 桥梁模式的目的在于分离这种耦合性
         * 让组合/聚合来解决这种需求
         *
         * 抽象尺寸和颜色
         * 让尺寸抽象类中 保留 颜色抽象类的实例
         * 让子类自己去组合
         *
         * 这样一来 就只需要3 + 3 = 6种实现类了
         *
         */
        AbstractBrushPen bigPen = new BigBrushPen();
        bigPen.setColor(new RedColor());
        bigPen.draw();

        AbstractBrushPen smallPen = new SmallBrushPen();
        smallPen.setColor(new RedColor());
        smallPen.draw();


        //.....
    }
}
