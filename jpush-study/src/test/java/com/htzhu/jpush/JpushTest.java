package com.htzhu.jpush;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

/**
 * JpushTest
 *
 * @author zhuhaitao
 * @date 2018/6/11 11:31
 **/
public class JpushTest {

	private static Gson gson = new GsonBuilder().create();

	@Test
	public void testPush() throws APIConnectionException, APIRequestException {
		PushResult hello = JpushUtils
				.push(JpushUtils.appKey, JpushUtils.masterSecret, "hello hito", false,
//						"15712935439",
						"15156020139");

		System.out.println(gson.toJson(hello));
	}

}
