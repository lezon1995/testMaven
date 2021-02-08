package interview.algorithm;

import java.util.Arrays;

/**
 * @link https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247484505&idx=1&sn=4c1c056dd4852c3b4b1ead51c90a9b2d&chksm=fa0e6bd8cd79e2ce8188dcdd8843a5d071248906bfb8971c62d513dbd69b816acc191a78e4b2&scene=21#wechat_redirect
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Algorithm01 {

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 2, 4, 3, 5, 3, 5, 8, 6};
        for (int i : array) {
            System.out.println(Integer.toBinaryString(i));
        }
        System.out.println();
//        int result = array[0];
//        for (int i = 1; i < array.length; i++) {
//            result ^= array[i];
//        }
//
//        System.out.println(result);
        int[] numsAppearOnce2 = findNumsAppearOnce2(array);
        System.out.println(Arrays.toString(numsAppearOnce2));

    }

    public static int[] findNumsAppearOnce2(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        int[] result = new int[2];  //要返回的结果

        int res = arr[0];  //第一次对所有元素进行亦或操作结果
        for (int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }

        System.out.println(Integer.toBinaryString(res));

        int bitIndex = 0;
        for (int i = 0; i < 32; i++) {  //找出异或结果为1的位。
            if ((res >> i & 1) == 1) {
                bitIndex = i;
                System.out.println(bitIndex);
                break;
            }
        }

        System.out.println("-----");
        for (int i = 0; i < arr.length; i++) { //根据bitIndex为1，将元素分为两组
            System.out.println(Integer.toBinaryString(arr[i] >> bitIndex));
            if ((arr[i] >> bitIndex & 1) == 1) {
                result[0] ^= arr[i];   //对应位为1，亦或得到的结果
            } else {
                result[1] ^= arr[i];   //对应位为0，亦或得到的结果
            }
        }
        System.out.println("-----");

        return result;
    }
}
