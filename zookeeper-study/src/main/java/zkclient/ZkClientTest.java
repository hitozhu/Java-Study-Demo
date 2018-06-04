package zkclient;

import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.Stat;

/**
 * ZkClientTest
 *
 * @author zhuhaitao
 * @date 2018/6/1 15:34
 **/
@Slf4j
public class ZkClientTest {

	private static final String connectionStr = "localhost:2181";

	private static final int sessionTimeout = 5000;

	private static final ZkClient zkClient = new ZkClient(connectionStr, sessionTimeout);

	public static void main(String[] args) throws InterruptedException {

//		subscribeChildChanges   //订阅子节点变化的事件
//		unsubscribeChildChanges //取消订阅子节点变化的事件

//		subscribeDataChanges    //订阅节点数据变化的事件
//		unsubscribeDataChanges  //取消订阅节点数据变化的事件

//		subscribeStateChanges   //订阅节点状态变化的事件
//		unsubscribeStateChanges //取消订阅节点状态变化的事件

//		unsubscribeAll          //取消订阅所有事件
//		zkClient.subscribeStateChanges(new MyIZkStateListener());
		zkClient.subscribeDataChanges("/zkclient", new MyIZkDataListener());

		String path = zkClient.create("/zkclient", "zkclient".getBytes(), CreateMode.PERSISTENT);
		log.info("path: {}", path);

		byte[] data = zkClient.readData("/zkclient");
		log.info("node data: {}", new String(data));

		Stat stat = zkClient.writeData("/zkclient", "new zkclient".getBytes());
		log.info("set data: {}", stat);

		boolean delete = zkClient.delete("/zkclient");
		log.info("delete node: {}", delete);

		Thread.sleep(3000);
	}


	static class MyIZkStateListener implements IZkStateListener {

		@Override
		public void handleStateChanged(KeeperState state) {
			log.info("watch[handleStateChanged] -- state: {}", state);
		}

		@Override
		public void handleNewSession() {
			log.info("watch[handleNewSession]");
		}
	}

	static class MyIZkDataListener implements IZkDataListener {

		@Override
		public void handleDataChange(String dataPath, Object data) {
			log.info("watch[handleDataChange] -- node: {}, data: {}", dataPath,
					new String((byte[]) data));
		}

		@Override
		public void handleDataDeleted(String dataPath) {
			log.info("watch[handleDataDeleted] -- node: {}", dataPath);
		}
	}

}
