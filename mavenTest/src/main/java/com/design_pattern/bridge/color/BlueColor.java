package com.design_pattern.bridge.color;

import com.design_pattern.bridge.AbstractColor;

/**
 * @author zhuliang
 * @date 2019/6/29 21:42
 */
public class BlueColor extends AbstractColor {
    @Override
    public String paint() {
        return "blue";
    }
}
