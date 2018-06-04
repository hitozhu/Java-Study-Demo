package zookeeper;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * ZookeeperTest
 *
 * @author zhuhaitao
 * @date 2018/6/1 14:54
 **/
@Slf4j
public class ZookeeperTest {

	private static final String connectionStr = "localhost:2181";

	private static final int sessionTimeout = 5000;

	private static Watcher watcher = new MyWatcher();

	private static ZooKeeper zooKeeper;

	static {
		try {
			zooKeeper = new ZooKeeper(connectionStr, sessionTimeout, watcher);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws KeeperException, InterruptedException {
		ZookeeperTest test = new ZookeeperTest();

		System.out.println(watcher);
		// create node
		test.testCreate();

		// get data
		test.testGetData();

		// set data
		test.testSetData();

		// delete node
		test.testDeleteNode();

	}

	public void testCreate() throws KeeperException, InterruptedException {
		String path = zooKeeper
				.create("/app", "zookeeper".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		log.info(path);
	}

	public void testGetData() throws KeeperException, InterruptedException {
		byte[] data = zooKeeper.getData("/zookeeper", watcher, null);
		log.info("data: " + new String(data));
	}

	public void testSetData() throws KeeperException, InterruptedException {
		Stat stat = zooKeeper.setData("/zookeeper", "new zookeeper".getBytes(), -1);
		log.info("stat: {}", stat);
	}

	public void testDeleteNode() throws KeeperException, InterruptedException {
		zooKeeper.delete("/zookeeper", -1);
	}

	static class MyWatcher implements Watcher {

		@Override
		public void process(WatchedEvent event) {
			log.info("watch: " + event.getType().name() + " " + event.getPath());

			try {
				// 变动节点继续添加 watch 事件
				zooKeeper.exists(event.getPath(), true);
			} catch (KeeperException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
