package com.htzhu.grpc.student;

import com.htzhu.protobuf.student.MyRequest;
import com.htzhu.protobuf.student.MyResponse;
import com.htzhu.protobuf.student.StudentServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

/**
 * StudentServer
 *
 * @author zhuhaitao
 * @date 2018/5/30 17:53
 **/
@Slf4j
public class StudentServer {

	private final int port = 8899;

	private Server server;

	public void start() throws IOException {
		this.server = ServerBuilder.forPort(port).addService(new StudentServiceImpl())
				.build().start();

		log.info("server start...");

		// 程序在正常或者非正常情况下关闭，都会调用此方法
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("关闭jvm");
			StudentServer.this.stop();
			System.out.println("服务关闭");
		}));

	}

	/**
	 * 停止
	 */
	public void stop() {
		if (this.server != null) {
			this.server.shutdown();
		}
	}

	/**
	 * 服务器阻塞
	 */
	public void blockUntilShutdown() throws InterruptedException {
		if (this.server != null) {
			this.server.awaitTermination();
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		StudentServer server = new StudentServer();
		server.start();
		server.blockUntilShutdown();
	}


	public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
		/**
		 * @param request 请求参数对象
		 * @param responseObserver 返回给客户端的结果对象
		 */
		@Override
		public void getRealNameByUsername(MyRequest request,
				StreamObserver<MyResponse> responseObserver) {
			log.info("接收到客户端信息：{}", request.getUsername());
			responseObserver.onNext(MyResponse.newBuilder().setRealname("耶稣").build());

			responseObserver.onCompleted();
		}
	}
}
