package com.htzhu.grpc.student;

import com.htzhu.protobuf.student.MyRequest;
import com.htzhu.protobuf.student.MyResponse;
import com.htzhu.protobuf.student.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * StudentClient
 *
 * @author zhuhaitao
 * @date 2018/5/30 22:19
 **/
@Slf4j
public class StudentClient {

	private static final int port = 8899;

	public static void main(String[] args) throws InterruptedException {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
				// 使用 TLS 来连接服务器
				.usePlaintext(true).build();
		StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc
				.newBlockingStub(channel);

		MyResponse response = blockingStub
				.getRealNameByUsername(MyRequest.newBuilder().setUsername("Mr.zhu").build());

		log.info(response.getRealname());

		channel.awaitTermination(5, TimeUnit.SECONDS);
	}

}
