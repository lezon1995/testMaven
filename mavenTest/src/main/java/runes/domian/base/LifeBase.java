package runes.domian.base;

/**
 * 生命值 法力值 基本属性
 *
 * @author Wentworth .
 * @date 2020/1/20 11:17 上午
 */
public class LifeBase {
    /**
     * 生命值(hp)
     */
    public Integer healthPoint = 100;
    /**
     * 法力值(mp)
     */
    public Integer manaPoint = 100;

    public static LifeBase new_(Integer healthPoint, Integer manaPoint) {
        return new LifeBase(healthPoint, manaPoint);
    }

    public LifeBase() {
    }

    public LifeBase(Integer healthPoint, Integer manaPoint) {
        this.healthPoint = healthPoint;
        this.manaPoint = manaPoint;
    }
}
