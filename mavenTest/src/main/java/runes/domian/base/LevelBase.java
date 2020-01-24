package runes.domian.base;

/**
 * 等级基类
 * 用于描述塔或敌人的等级
 *
 * @author Wentworth .
 * @date 2020/1/20 11:39 上午
 */
public class LevelBase {
    /**
     * 等级数值
     */
    Integer level = 1;
    /**
     * 拥有该等级的物体
     */
    Object object;


    public LevelBase() {
    }

    public LevelBase(Integer level, Object object) {
        this.level = level;
        this.object = object;
    }

    public static LevelBase new_(Integer level, Object object) {
        return new LevelBase(level, object);
    }
}
