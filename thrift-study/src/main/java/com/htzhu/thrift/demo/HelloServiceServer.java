package com.htzhu.thrift.demo;

import com.htzhu.thrift.Hello;
import com.htzhu.thrift.Hello.Iface;
import com.htzhu.thrift.Hello.Processor;
import com.htzhu.thrift.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * HelloServiceServer
 *
 * @author zhuhaitao
 * @date 2018/5/31 16:26
 **/
@Slf4j
public class HelloServiceServer {

	private static final int port = 8899;

	public static void main(String[] args) throws TTransportException {
		log.info("thritf server start");
		Processor<Iface> processor = new Processor<>(new HelloServiceImpl());

		// 传输模式
		// TSocket: 阻塞式IO，用在客户端
		// TServerSocket: 非阻塞式，用在服务端，用于监听 TSocket
		// TNonblockingSocket: 非阻塞式IO
		// TMemoryInputTransport:
		// TFramedTransport:
		TServerSocket tServerSocket = new TServerSocket(port);
		TServer.Args tArgs = new Args(tServerSocket);
		tArgs.processor(processor);
		tArgs.protocolFactory(new TBinaryProtocol.Factory());

		// 支持的服务模型
		// TSimpleServer: 简单式，只有一个工作线程，循环监听传递过来的请求，是阻塞的，效率低
		// TNonblockingServer: 非阻塞，使用 nio，同时监听多个 socket，在业务处理上还是单线程模式
		// TThreadPoolServer: 使用线程池，主线程用于监听 socket 变化，请求过来，线程池中的线程负责处理请求
		// TThreadSelectorServer: 有一个负责监听 socket 变化的线程，有一个服务将请求分配给合适的线程（负载均衡），
		//                         还有线程池专门负责处理请求，
		TSimpleServer server = new TSimpleServer(tArgs);
		server.serve();

	}

}
