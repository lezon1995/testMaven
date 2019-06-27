package com.thread.java7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author zhuliang
 * @date 2019/5/27 1:04
 */
public class ForkJoinDemo {

    public static void main(String[] args) throws Exception {

        System.out.printf("当前公用ForkJoin 线程池 并行数量: %d\n", ForkJoinPool.getCommonPoolParallelism());
        System.out.printf("当前CPU 处理器数量: %d\n", Runtime.getRuntime().availableProcessors());
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        LongAdder longAdder = new LongAdder();

        AddTask addTask = new AddTask(list, longAdder);

        forkJoinPool.invoke(addTask);

        forkJoinPool.shutdown();

        System.out.println(longAdder);

    }


    /**
     * {@link RecursiveAction}
     */
    private static class AddTask extends RecursiveAction {

        List<Integer> list;

        LongAdder longAdder;


        private AddTask(List<Integer> list, LongAdder longAdder) {
            this.list = list;
            this.longAdder = longAdder;
        }


        @Override
        protected void compute() {
            int size = list.size();
            if (size > 1) {
                int mid = size / 2;

                List<Integer> left = this.list.subList(0, mid);

                AddTask leftTask = new AddTask(left, longAdder);

                List<Integer> right = this.list.subList(mid, size);

                AddTask rightTask = new AddTask(right, longAdder);

                invokeAll(leftTask, rightTask);
            } else {

                if (size == 0) {
                    return;
                }

                longAdder.add(list.get(0));
            }

        }
    }

}
