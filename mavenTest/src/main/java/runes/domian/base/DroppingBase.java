package runes.domian.base;

/**
 * 消灭对象后所掉落的物品/金币/经验/其他
 *
 * @author Wentworth .
 * @date 2020/1/20 11:48 上午
 */
public class DroppingBase {
    /**
     * 所掉落的金币
     */
    Integer coin = 5;
    /**
     * 所掉落的经验值
     */
    Integer experence = 5;
    /**
     * 所掉落的物品
     */
    Object[] items;

    public static DroppingBase new_(Integer coin, Integer experence, Object[] items) {
        return new DroppingBase(coin, experence, items);
    }

    public DroppingBase() {
    }

    public DroppingBase(Integer coin, Integer experence, Object[] items) {
        this.coin = coin;
        this.experence = experence;
        this.items = items;
    }
}
