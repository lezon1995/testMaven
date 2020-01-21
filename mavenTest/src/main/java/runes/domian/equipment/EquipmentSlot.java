package runes.domian.equipment;

import runes.domian.rune.RuneSlot;

/**
 * 装备卡槽
 *
 * @author Wentworth .
 * @date 2020/1/20 3:03 下午
 */
public class EquipmentSlot {
    /**
     * 装备1
     */
    EquipmentBase equipment1;
    /**
     * 装备2
     */
    EquipmentBase equipment2;
    /**
     * 装备3
     */
    EquipmentBase equipment3;

    public static EquipmentSlot new_() {
        return new EquipmentSlot();
    }

    public EquipmentSlot() {
    }
}
