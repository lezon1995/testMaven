package cn.zookeeper.java.distributed_lock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * zk实现分布式锁
 *
 * @author zhuliang
 * @date 2019/6/19 12:17
 */
public class DistributedLock {

    private ZooKeeper zooKeeper;
    private String root = "/LOCKS";
    private String lockId;
    private int sessionTimeout;
    private byte[] data = {1, 2};
    private CountDownLatch latch = new CountDownLatch(1);

    public DistributedLock() throws Exception {
        this.zooKeeper = ZookeeperFactory.getInstance();
        this.sessionTimeout = ZookeeperFactory.getSessionTimeout();
    }

    public boolean lock() {
        //创建新的临时有序节点 将其自动生成的序号返回值作为 锁id
        try {
            lockId = zooKeeper.create(root + "/", data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(Thread.currentThread().getName() + "-> 成功创建的lock节点[" + lockId + "] 开始竞争锁");
            //获取root下所有的子节点
            List<String> children = zooKeeper.getChildren(root, true);
            //利用treeSet排序特性将其排序
            SortedSet<String> sortedSet = new TreeSet<>();
            //并将其元素前面拼接上父节点路径
            for (String s : children) {
                sortedSet.add(root + "/" + s);
            }
            //获取最小的节点 如果最小的节点存在 且等于lockId 则可以获取锁
            if (sortedSet.first().equals(lockId)) {
                System.out.println(Thread.currentThread().getName() + "-> 成功获得锁 lock节点[" + lockId + "]");
                return true;
            }
            //如果不等于lockId
            SortedSet<String> lessThanLockId = sortedSet.headSet(lockId);
            if (!lessThanLockId.isEmpty()) {
                //获取比当前lockId小的上一个节点
                String preLockId = lessThanLockId.last();
                zooKeeper.exists(preLockId, new LockWatcher(latch));
//                latch.await(sessionTimeout, TimeUnit.MILLISECONDS);
                latch.await();
                //上面这段代码意味着如果会话超时或者节点被删除了
                System.out.println(Thread.currentThread().getName() + "-> 成功获得锁[" + lockId + "]");
            }
            return true;
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean unlock() {
        System.out.println(Thread.currentThread().getName() + "-> 开始施放锁[" + lockId + "]");
        try {
            System.out.println("节点[" + lockId + "]成功被删除");
            zooKeeper.delete(lockId, -1);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                DistributedLock lock = null;
                try {
                    lock = new DistributedLock();
                    latch.countDown();
                    latch.await();
                    lock.lock();
                    Thread.sleep(random.nextInt(3000));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }).start();
        }
    }
}
/*
* 最终结果 获得锁->释放锁 是按顺序进行的
*
Thread-3-> 成功创建的lock节点[/LOCKS/0000000090] 开始竞争锁
Thread-2-> 成功创建的lock节点[/LOCKS/0000000091] 开始竞争锁
Thread-7-> 成功创建的lock节点[/LOCKS/0000000093] 开始竞争锁
Thread-6-> 成功创建的lock节点[/LOCKS/0000000094] 开始竞争锁
Thread-0-> 成功创建的lock节点[/LOCKS/0000000092] 开始竞争锁
Thread-4-> 成功创建的lock节点[/LOCKS/0000000095] 开始竞争锁
Thread-1-> 成功创建的lock节点[/LOCKS/0000000096] 开始竞争锁
Thread-8-> 成功创建的lock节点[/LOCKS/0000000097] 开始竞争锁
Thread-9-> 成功创建的lock节点[/LOCKS/0000000098] 开始竞争锁
Thread-5-> 成功创建的lock节点[/LOCKS/0000000099] 开始竞争锁
Thread-3-> 成功获得锁 lock节点[/LOCKS/0000000090]
Thread-3-> 开始施放锁[/LOCKS/0000000090]
节点[/LOCKS/0000000090]成功被删除
Thread-2-> 成功获得锁[/LOCKS/0000000091]
Thread-2-> 开始施放锁[/LOCKS/0000000091]
节点[/LOCKS/0000000091]成功被删除
Thread-0-> 成功获得锁[/LOCKS/0000000092]
Thread-0-> 开始施放锁[/LOCKS/0000000092]
节点[/LOCKS/0000000092]成功被删除
Thread-7-> 成功获得锁[/LOCKS/0000000093]
Thread-7-> 开始施放锁[/LOCKS/0000000093]
节点[/LOCKS/0000000093]成功被删除
Thread-6-> 成功获得锁[/LOCKS/0000000094]
Thread-6-> 开始施放锁[/LOCKS/0000000094]
节点[/LOCKS/0000000094]成功被删除
Thread-4-> 成功获得锁[/LOCKS/0000000095]
Thread-4-> 开始施放锁[/LOCKS/0000000095]
节点[/LOCKS/0000000095]成功被删除
Thread-1-> 成功获得锁[/LOCKS/0000000096]
Thread-1-> 开始施放锁[/LOCKS/0000000096]
节点[/LOCKS/0000000096]成功被删除
Thread-8-> 成功获得锁[/LOCKS/0000000097]
Thread-8-> 开始施放锁[/LOCKS/0000000097]
节点[/LOCKS/0000000097]成功被删除
Thread-9-> 成功获得锁[/LOCKS/0000000098]
Thread-9-> 开始施放锁[/LOCKS/0000000098]
节点[/LOCKS/0000000098]成功被删除
Thread-5-> 成功获得锁[/LOCKS/0000000099]
Thread-5-> 开始施放锁[/LOCKS/0000000099]
节点[/LOCKS/0000000099]成功被删除
*/