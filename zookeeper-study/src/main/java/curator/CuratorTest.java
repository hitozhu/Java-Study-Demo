package curator;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.Stat;

/**
 * CuratorTest
 *
 * @author zhuhaitao
 * @date 2018/6/1 16:51
 **/
@Slf4j
public class CuratorTest {

	private static final String connectionStr = "localhost:2181";

	private static int baseSleepTimeMs = 100;
	private static int maxRetries = 5;

	private static final CuratorFramework framework = CuratorFrameworkFactory
			.newClient(connectionStr, new ExponentialBackoffRetry(baseSleepTimeMs, maxRetries));

	private static final CuratorListener listener = new NodeEventListener();

	public static void main(String[] args) throws Exception {
		framework.getCuratorListenable().addListener(listener);
		framework.start();

		// create node
		testCreateNode();

		// 和 zookeeper 原生一样，需要重新添加 watcher 事件
		framework.getData().watched().forPath("/curator");

		// get data
		testGetData();

		// set data
		testSetData();

		framework.getData().watched().forPath("/curator");

		// delete node
		testDeleteNode();

		Thread.sleep(3000);
	}

	public static void testCreateNode() throws Exception {
		Stat stat = framework.checkExists().forPath("/curator");
		if (stat == null) {
			String path = framework.create().creatingParentsIfNeeded().forPath("/curator");
			log.info("create node: {}", path);
		}
	}

	public static void testGetData() throws Exception {
		byte[] bytes = framework.getData().forPath("/curator");
		log.info("get data: {}", new String(bytes));
	}

	public static void testSetData() throws Exception {
		Stat stat = framework.setData().forPath("/curator", "new curator".getBytes());
		log.info("set data: {}", stat);
	}

	public static void testDeleteNode() throws Exception {
		Void aVoid = framework.delete().forPath("/curator");
	}


	// 监听器
	static class NodeEventListener implements CuratorListener {

		@Override
		public void eventReceived(CuratorFramework client, CuratorEvent event) {

			final WatchedEvent watchedEvent = event.getWatchedEvent();
			if (watchedEvent != null) {
				log.info("watcher: {} {}", watchedEvent.getPath(), watchedEvent.getType().name());

				if (watchedEvent.getState() == KeeperState.SyncConnected) {
					switch (watchedEvent.getType()) {
						case NodeChildrenChanged:
							// TODO
							break;
						case NodeDataChanged:
							// TODO
							break;
						default:
							break;
					}
				}
			}
		}
	}

}
