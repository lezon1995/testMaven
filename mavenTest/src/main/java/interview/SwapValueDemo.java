package interview;

import java.lang.reflect.Field;

/**
 * 通过方法传参 如何交换两个数的值
 *
 * @author zhuliang
 * @date 2019/7/14 10:39
 */
public class SwapValueDemo {

    public static void main(String[] args) throws Exception {
        Integer a = 1;
        Integer b = 2;
        System.out.println("交换前  a = " + a + "，b = " + b);
        swap(a, b);
        System.out.println("交换后  a = " + a + "，b = " + b);
    }

    /**
     * 交换两个数 错误示范
     *
     * @param a
     * @param b
     */
    private static void falseSwap(Integer a, Integer b) {
        int temp = a;
        a = b;
        b = temp;
    }

    /**
     * 通过反射 交换两个数的值
     * 结果是
     * 交换前  a = 1，b = 2
     * 交换后  a = 2，b = 2
     * 为什么会这样呢？
     * <p>
     * 因为integer中有缓存机制
     * {@link Integer.IntegerCache.low=-128}
     * {@link Integer.IntegerCache.high=127}
     * 由于a=1，b=2
     * 在int temp = a.intValue();这行代码中，获取到的是值是1，存在于缓存中
     * 而在value.set(a, b);这行代码之后，将a的值设置为了2
     * 因为a.intValue是基本数据类型，地址本身就可以表示值，所以导致刚刚temp的值也变为了2
     * 再调用value.set(b, temp);的时候，将2赋值给了b
     * 所以最终结果是a = 2，b = 2
     * <p>
     * 解决这个问题的方式有两点
     * 1 将a，b的值换为大于127或者小于-128的数，因为这样一来就不会使用Integer的缓存机制
     * 2 在给temp赋值的时候使用new Integer的方式，获取一个新的地址
     *
     * @param a
     * @param b
     */
    private static void swap(Integer a, Integer b) throws Exception {
        Field value = Integer.class.getDeclaredField("value");
        value.setAccessible(true);
//        int temp = a.intValue();
        Integer temp = new Integer(a.intValue());
        value.set(a, b);
        value.set(b, temp);
    }

}
