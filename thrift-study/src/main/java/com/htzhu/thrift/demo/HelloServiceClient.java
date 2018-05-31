package com.htzhu.thrift.demo;

import com.htzhu.thrift.Hello;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;

/**
 * HelloServiceClient
 *
 * @author zhuhaitao
 * @date 2018/5/31 16:32
 **/
@Slf4j
public class HelloServiceClient {

	private static final int port = 8899;

	public static void main(String[] args) throws TException {
		log.info("thrift client start");

		TSocket tSocket = new TSocket("localhost", port, 30000);

		// 传输协议
		// TBinaryProtocol:二进制协议
		// TCompactProtocol:压缩格式
		// TJSONProtocol:json 格式
		// TDebugProtocol:易读的文本格式，便于debug
		// TSimpleJSONProtocol:json 只写
		TBinaryProtocol protocol = new TBinaryProtocol(tSocket);
		Hello.Client client = new Hello.Client(protocol);

		tSocket.open();
		String result = client.helloString("Mr.zhu");
		log.info("response: {}", result);
	}

}
