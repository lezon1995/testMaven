package runes.domian.base;

/**
 * 法术攻击基类
 * 包含法术强度 法术穿透
 *
 * @author Wentworth .
 * @date 2020/1/20 11:21 上午
 */
public class PowerDamageBase {
    /**
     * 法术攻击力
     */
    Integer PowerDamage = 10;

    /**
     * 法术穿透
     */
    Integer penetration = 0;
    /**
     * 攻击射程 单位米
     */
    Float range = 5F;
    /**
     * 法术暴击率
     */
    Float criticalChance = 0.0F;
}
