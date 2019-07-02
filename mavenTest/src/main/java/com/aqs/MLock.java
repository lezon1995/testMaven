package com.aqs;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * @author zhuliang
 * @date 2019/7/2 15:25
 */
public class MLock implements Lock {

    /**
     * AQS实例
     */
    private Sync sync = new Sync();

    /**
     * 对外暴露的加锁方法
     */
    @Override
    public void lock() {
        /**
         * 为什么在这里不使用下面重写过的{@link Sync#tryAcquire(int)}方法
         * 而去调用父类{@link AbstractQueuedSynchronizer#acquire(int)}方法
         *
         * 因为在AQS中获取锁的过程比较复杂
         * 需要去做一些其他操作
         * 比如判断当前线程是否为独占拥有者线程
         * 如果不是就要把当前线程加入到一个等待的双向队列当中并且让它等待
         * 或者去从双向队列中获取线程
         * @see AbstractQueuedSynchronizer.Node.prev
         * @see AbstractQueuedSynchronizer.Node.next
         * @see AbstractQueuedSynchronizer.Node#acquireQueued
         * @see AbstractQueuedSynchronizer.Node#addWaiter(AbstractQueuedSynchronizer.Node)
         *
         * 此处用到了设计模式中的 模版模式(下面描述是打个比方 AQS并不是真的这么实现)
         * sync.acquire(1)
         *      -> {
         *              a();                        //由AQS实现
         *              tryAcquire();        //由调用者自己实现
         *              b();                       //由AQS实现
         *           }
         *
         *  下面的{@link MLock#unlock()}方法同理
         */
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

}

/**
 * 自定义实现AQS锁的机制
 *
 * @author zhuliang
 * @date 2019/7/2 15:25
 */
class Sync extends AbstractQueuedSynchronizer {
    /**
     * 尝试获取锁
     *
     * @param arg 1
     * @return 是否获取成功
     */
    @Override
    protected boolean tryAcquire(int arg) {
        /**
         * 由于{@link AbstractQueuedSynchronizer#tryAcquire(int)}
         * 是由{@link AbstractQueuedSynchronizer#acquire(int)} }方法调用
         * 而且acquire方法是由具体实现了AQS的类来调用
         * 比如
         * {@link ReentrantLock#lock()}
         * {@link ReentrantReadWriteLock}
         * 他们底层调用都会主动传入1进去 这里只是模拟它们的实现
         */
        assert arg == 1;
        /**
         * 利用CAS比较AQS中的volatile变量state
         * 默认0代表未被线程占有 1代表已经被线程占有
         * 具体含义由实现类自己定义
         * 这里我按照默认的来
         */
        if (compareAndSetState(0, 1)) {
            //如果state为0 则调用父类的抽象方法将当前线程设置为 独占拥有者线程 代表该线程已经获取到锁
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    /**
     * 尝试施放锁
     *
     * @param arg 1
     * @return
     */
    @Override
    protected boolean tryRelease(int arg) {
        //同上
        assert arg == 1;
        /**
         * 判断当前线程是否为 独占拥有者线程
         * 如果不是就直接抛出{@link IllegalMonitorStateException}
         * 该异常场景出现在非占有锁的线程当中尝试释放锁
         * @see  ReentrantLock#unlock()
         */
        if (!isHeldExclusively()) {
            throw new IllegalMonitorStateException("当前线程不是持有锁的线程");
        }

        //如果当前线程是 独占拥有者线程 则代表当前线程具有释放锁的资格
        //设置 独占拥有者线程 为null
        setExclusiveOwnerThread(null);
        //设置 当前state状态为0 代表未被线程占有
        setState(0);
        return true;
    }

    /**
     * 判断当前线程是否为 独占拥有者线程
     *
     * @return
     */
    @Override
    protected boolean isHeldExclusively() {
        return getExclusiveOwnerThread() == Thread.currentThread();
    }
}
