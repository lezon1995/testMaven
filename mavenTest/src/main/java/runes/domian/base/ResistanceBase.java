package runes.domian.base;

/**
 * 防御力基类
 * <p>
 * 减伤公式：伤害减免 = 总魔法抗性 / (100+总魔法抗性)。
 * 比如说，一个拥有150点魔法抗性的英雄将会减免60%（=150 /（100+150））来自敌人的魔法攻击伤害。
 *
 * @author Wentworth .
 * @date 2020/1/20 11:04 上午
 */
public class ResistanceBase {
    /**
     * 护甲抗性
     */
    public Integer armorResistance = 10;
    /**
     * 魔法抗性
     */
    public Integer spellResistance = 10;

    public static ResistanceBase new_(Integer armorResistance, Integer spellResistance) {
        return new ResistanceBase(armorResistance, spellResistance);
    }

    public ResistanceBase() {
    }

    public ResistanceBase(Integer armorResistance, Integer spellResistance) {
        this.armorResistance = armorResistance;
        this.spellResistance = spellResistance;
    }
}
