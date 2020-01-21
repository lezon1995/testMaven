package runes.domian.base;

import runes.domian.skill.AbstractHitCounter;

/**
 * 物理攻击基类
 * 包含物理攻击力 攻击速度等 物理伤害属性
 *
 * @author Wentworth .
 * @date 2020/1/20 11:21 上午
 */
public class AttackDamageBase {
    /**
     * 物理攻击力
     */
    public Integer damage = 10;
    /**
     * 攻击速度 attackSpeed 次/秒
     */
    public Float attackSpeed = 0.5F;
    /**
     * 攻击时间间隔 1/attackSpeed   秒/次
     */
    public Float attackInterval = 1 / attackSpeed;
    /**
     * 攻击射程 单位米
     */
    public Float range = 5F;
    /**
     * 物理穿透
     */
    public Integer penetration = 0;
    /**
     * 物理暴击率
     */
    public Float criticalChance = 0.0F;
    /**
     * 攻击次数计数器
     */
    public AbstractHitCounter hitCounter;

    public static AttackDamageBase new_(Integer attackDamage, Float attackSpeed, Float range, Integer penetration, Float criticalChance) {
        return new AttackDamageBase(attackDamage, attackSpeed, range, penetration, criticalChance);
    }

    public AttackDamageBase() {
    }

    public AttackDamageBase(Integer attackDamage, Float attackSpeed, Float range, Integer penetration, Float criticalChance) {
        this.damage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.penetration = penetration;
        this.criticalChance = criticalChance;
    }

}
