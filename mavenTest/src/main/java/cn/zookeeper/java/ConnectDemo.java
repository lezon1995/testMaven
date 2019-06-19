package cn.zookeeper.java;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.SortedSet;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhuliang
 * @date 2019/6/19 8:35
 */
public class ConnectDemo {
    public static void main(String[] args) throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 3000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState().equals(Event.KeeperState.SyncConnected)) {
                    countDownLatch.countDown();
                    System.out.println("watchedEvent:" + watchedEvent.getState());
                }
            }
        });
        countDownLatch.await();
        System.out.println(zooKeeper.getState());
        System.out.println("阿萨德");
    }
}
