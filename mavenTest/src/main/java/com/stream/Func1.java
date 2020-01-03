package com.stream;

/**
 * @author Wentworth .
 * @date 2019/12/6 10:30 上午
 */
@FunctionalInterface
public interface Func1<T> {
    void consume(T t);
}
