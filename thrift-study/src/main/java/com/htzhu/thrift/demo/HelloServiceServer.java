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

		TServerSocket tServerSocket = new TServerSocket(port);
		TServer.Args tArgs = new Args(tServerSocket);
		tArgs.processor(processor);
		tArgs.protocolFactory(new TBinaryProtocol.Factory());

		TSimpleServer server = new TSimpleServer(tArgs);
		server.serve();

	}

}
