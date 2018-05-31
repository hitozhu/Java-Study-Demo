package com.htzhu.grpc.helloworld;

import com.htzhu.protobuf.helloword.GreeterGrpc;
import com.htzhu.protobuf.helloword.HelloReply;
import com.htzhu.protobuf.helloword.HelloRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

/**
 * HelloWorldServer
 *
 * @author zhuhaitao
 * @date 2018/5/30 17:41
 **/
@Slf4j
public class HelloWorldServer {

	private final int port = 50051;

	private Server server;

	private void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	private void blockUntioShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	private void start() throws IOException {
		server = ServerBuilder.forPort(port).addService(new GreeterImpl()).build().start();
		log.info("server started, listening on {}", port);
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			log.info("shutting down grpc server");
			HelloWorldServer.this.stop();
			log.info("server shut down");
		}));
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		HelloWorldServer server = new HelloWorldServer();
		server.start();
		server.blockUntioShutdown();
	}

	public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
		@Override
		public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
			log.info("server received msg:{}", request.getName());

			HelloReply helloReply = HelloReply.newBuilder().setMessage("hello " + request.getName())
					.build();

			responseObserver.onNext(helloReply);
			responseObserver.onCompleted();
		}
	}

}
