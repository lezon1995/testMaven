package cn.zookeeper.java.distributed_lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhuliang
 * @date 2019/6/19 12:12
 */
public class ZookeeperFactory {
    private static String connectString = "localhost:2181";
    private static int sessionTimeout = 5000;
    private static CountDownLatch latch = new CountDownLatch(1);

    public static int getSessionTimeout() {
        return sessionTimeout;
    }

    public static ZooKeeper getInstance() throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            public void process(WatchedEvent event) {
                if (event.getState().equals(Event.KeeperState.SyncConnected)) {
                    latch.countDown();
                }
            }
        });
        //保证zookeeper确认连接上才返回实例
        latch.await();
        return zooKeeper;
    }
}
