package runes.domian.rune;

import runes.domian.base.ResistanceBase;

/**
 * 符文卡槽 默认存放三个符文
 *
 * @author Wentworth .
 * @date 2020/1/20 12:00 下午
 */
public class RuneSlot {

    RuneBase rune1;

    RuneBase rune2;

    RuneBase rune3;

    public static RuneSlot new_() {
        return new RuneSlot();
    }

    public RuneSlot() {
    }
}
