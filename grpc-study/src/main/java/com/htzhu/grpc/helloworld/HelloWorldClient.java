package com.htzhu.grpc.helloworld;

import com.htzhu.protobuf.helloword.GreeterGrpc;
import com.htzhu.protobuf.helloword.HelloReply;
import com.htzhu.protobuf.helloword.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * HelloWorldClient
 *
 * @author zhuhaitao
 * @date 2018/5/30 17:35
 **/
@Slf4j
public class HelloWorldClient {

	private static final int port = 50051;

	public static void main(String[] args) throws InterruptedException {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
				// 使用 TLS 来连接服务器
				.usePlaintext(true).build();

		GreeterGrpc.GreeterBlockingStub blockingStub = GreeterGrpc.newBlockingStub(channel);

		HelloReply reply = blockingStub
				.sayHello(HelloRequest.newBuilder().setName("Mr.zhu").build());

		log.info("client response: {}", reply.getMessage());

		channel.awaitTermination(5, TimeUnit.SECONDS);
	}

}
