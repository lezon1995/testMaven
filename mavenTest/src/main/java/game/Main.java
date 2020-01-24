package game;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Wentworth .
 * @date 2020/1/15 11:24 上午
 */
public class Main {
    //初始化二维数组存放数字
    private static Unit[][] ints;
    //每次随机产生的基础数字集合
    private static int[] baseSet = new int[]{2, 4};
    //根据id管理全局的数字unit对象
    private static Map<Integer, Unit> map = new HashMap<>();

    //宽度
    private static int width = 5;
    //高度
    private static int height = 5;
    //分数
    private static int score = 0;
    //随机变量
    private static Random random = new Random();

    //每次移动之后的 列/行 数字队列
    private static Queue<Integer> afterMove = new LinkedList<>();

    //每次合并之后的 列/行 数字双端队列
    private static Deque<Integer> afterMerge = new LinkedList<>();

    public static void main(String[] args) {
        //初始化
        init(width, height, 16);
        //打印2048界面
        print();
        //初始化scanner对象
        initScanner();
//        calculateRight();
//        print();
//        calculateRight();
//        print();
//        move("up");
    }

    private static void initScanner() {
        System.out.println("请输入WSAD来控制移动方向:");
        Scanner scanner = new Scanner(System.in);
        String next;
        while ((next = scanner.next()) != null) {
            System.out.println("next = " + next);
            //根据输入参数移动数字
            move(next);
            //每次移动后 随机在剩余格子中插入基本数字
            try {
                randomInsert();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            //打印
            print();
        }

    }

    private static void move(String direction) {
        switch (direction) {
            case "w":
                calculateUp();
                break;
            case "s":
                calculateDown();
                break;
            case "a":
                calculateLeft();
                break;
            case "d":
                calculateRight();
                break;
            default:
                break;
        }
    }

    /**
     * id = i * width + j
     */
    private static void calculateUp() {

        clear();
        //第j列向上移动
        for (int j = 0; j < width; j++) {

            //第j列第i个元素
            //以上方向为 队列入口 依次插入该列 非0 数字
            for (int i = 0; i < width; i++) {
                Unit unit = unit(i * width + j);
                if (unit.value != 0) {
                    afterMove.offer(unit.value);
                }
            }

            //依次从afterMove取出数字
            while (!afterMove.isEmpty()) {
                afterMerge.offer(afterMove.poll());
                //在afterMerge加入第一个从afterMove取出的数字 并且判断afterMove中的下一个数字是否等于刚刚加入的数字
                //如果相等 则丢弃刚刚加入的数字 然后将afterMove中的下一个数字 乘以 2 后放入
                //为什么使用 双端队列 因为需要从尾取出 未合并的数字来判断
                if (afterMerge.peekLast().equals(afterMove.peek())) {
                    afterMerge.pollLast();
                    Integer s = afterMove.poll();
                    afterMerge.offerLast(s * 2);
                    score += s * 2;

                }
            }

            //然后从afterMerge双端队列中 从头取出数字 以输入的方向为开始方向 依次放入 该列或者该行中
            for (int i = 0; i < width; i++) {
                Integer value = afterMerge.poll();
                unit(i * width + j).value = value != null ? value : 0;
            }

        }

        System.out.println();

    }

    private static void clear() {
        afterMove.clear();
        afterMerge.clear();
    }

    private static void calculateDown() {
        clear();
        //第j列向下移动
        for (int j = 0; j < width; j++) {

            for (int i = width - 1; i >= 0; i--) {
                Unit unit = unit(i * width + j);
                if (unit.value != 0) {
                    afterMove.offer(unit.value);
                }
            }

            while (!afterMove.isEmpty()) {
                afterMerge.offer(afterMove.poll());
                if (afterMerge.peekLast().equals(afterMove.peek())) {
                    afterMerge.pollLast();
                    Integer s = afterMove.poll();
                    afterMerge.offerLast(s * 2);
                    score += s * 2;
                }
            }

            for (int i = width - 1; i >= 0; i--) {
                Integer value = afterMerge.poll();
                unit(i * width + j).value = value != null ? value : 0;
            }

        }

        System.out.println();


    }

    private static void calculateLeft() {
        clear();
        //第j行向左移动
        for (int j = 0; j < height; j++) {

            for (int i = 0; i < height; i++) {
                Unit unit = unit(j * width + i);
                if (unit.value != 0) {
                    afterMove.offer(unit.value);
                }
            }

            while (!afterMove.isEmpty()) {
                afterMerge.offer(afterMove.poll());
                if (afterMerge.peekLast().equals(afterMove.peek())) {
                    afterMerge.pollLast();
                    Integer s = afterMove.poll();
                    afterMerge.offerLast(s * 2);
                    score += s * 2;
                }
            }

            for (int i = 0; i < height; i++) {
                Integer value = afterMerge.poll();
                unit(j * width + i).value = value != null ? value : 0;
            }

        }

        System.out.println();


    }

    private static void calculateRight() {
        clear();
        //第j行向左移动
        for (int j = 0; j < height; j++) {

            for (int i = height - 1; i >= 0; i--) {
                Unit unit = unit(j * width + i);
                if (unit.value != 0) {
                    afterMove.offer(unit.value);
                }
            }

            while (!afterMove.isEmpty()) {
                afterMerge.offer(afterMove.poll());
                if (afterMerge.peekLast().equals(afterMove.peek())) {
                    afterMerge.pollLast();
                    Integer s = afterMove.poll();
                    afterMerge.offerLast(s * 2);
                    score += s * 2;
                }
            }

            for (int i = height - 1; i >= 0; i--) {
                Integer value = afterMerge.poll();
                unit(j * width + i).value = value != null ? value : 0;
            }

        }

        System.out.println();


    }

    private static Unit unit(int id) {
        return map.get(id);
    }

    private static void print() {
        System.out.println("-----------score = " + score + "-----------");
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
    }

    private static void init(int width, int height, int initNum) {
        ints = new Unit[width][height];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                Unit unit = new Unit(i * width + j);
                ints[i][j] = unit;
                map.put(unit.id, unit);
            }
        }

        //随机生成16个起始数字
        for (int i = 0; i < initNum; i++) {
            randomInsert();
        }
    }

    private static void randomInsert() {
        List<Integer> collect = map.keySet().stream().filter(i -> map.get(i).value == 0).collect(Collectors.toList());
        if (collect.isEmpty()) {
            throw new RuntimeException("游戏结束 ! ");
        }
        Integer id = collect.get(random.nextInt(collect.size()));
        map.get(id).value = baseSet[random.nextInt(2)];
    }

}

/**
 * 数字元素位置对象
 */
class Unit {
    public int id;
    public int value = 0;

    @Override
    public String toString() {
        return value == 0 ? " ____ " : String.format(" %4d ", value);
    }

    public Unit(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Unit) {
            return ((Unit) obj).value == this.value;
        } else {
            return false;
        }
    }
}


//-----------score = 25352-----------
//        2   256   512  2048    32
//        8    16     2   128  ____
//        4     2     4     8  ____
//        2     4  ____  ____  ____
//        ____  ____  ____  ____     2