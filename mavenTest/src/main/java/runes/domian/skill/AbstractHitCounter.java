package runes.domian.skill;

/**
 * 攻击累加计数器
 *
 * @author Wentworth .
 * @date 2020/1/20 3:50 下午
 */
public abstract class AbstractHitCounter {
    /**
     * 初始攻击次数
     */
    public Integer hitCount = 0;

    /**
     * 对攻击次数累加 或者实现其他功能
     *
     * @return
     */
    public abstract Object count();
}
