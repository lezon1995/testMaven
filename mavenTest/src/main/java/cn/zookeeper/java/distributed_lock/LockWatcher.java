package cn.zookeeper.java.distributed_lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhuliang
 * @date 2019/6/19 12:55
 */
public class LockWatcher implements Watcher {
    private CountDownLatch latch;

    public LockWatcher(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getState().equals(Event.KeeperState.SyncConnected)) {
            latch.countDown();
        }
    }
}
