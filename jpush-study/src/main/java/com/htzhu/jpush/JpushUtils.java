package com.htzhu.jpush;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * JpushUtils <p>https://github.com/jpush/jpush-api-java-client</p>
 *
 * @author zhuhaitao
 * @date 2018/6/11 11:05
 **/
public class JpushUtils {

	public static final String appKey = "da46c17acddc1ca54cf90554";

	public static final String masterSecret = "9f2d041e6d84ea86f1c3c5a5";

	/**
	 * 构建 推送 对象（支持 IOS、Android）
	 *
	 * @param alias 别名
	 * @param alert 信息
	 * @param apns 环境设置 true：生产环境；false：开发环境
	 */
	public static PushPayload buildPushObject_android_ios_alias_alert(Object alert,
			boolean apns, String... alias) {
		return PushPayload.newBuilder()
				// 推送平台
				.setPlatform(Platform.android_ios())
				// apns 环境设置（开发、生产）
				.setOptions(Options.newBuilder().setApnsProduction(apns).build())
				// 推送用户
				.setAudience(Audience.alias(alias))
				.setNotification(Notification.newBuilder()
						.addPlatformNotification(AndroidNotification.newBuilder()
								.addExtra("type", "infomation")
								.setAlert(alert)
								.build())
						.addPlatformNotification(IosNotification.newBuilder()
								.addExtra("type", "infomation")
								.setAlert(alert)
								.build())
						.build())
				.build();
	}

	/**
	 * 构建 推送 对象（支持 所有平台）
	 *
	 * @param alert 消息
	 * @param apns 环境设置 true：生产环境；false：开发环境
	 */
	public static PushPayload buildPushObject_all_alias_alert(Object alert, boolean apns) {
		return PushPayload.newBuilder()
				// 所有平台
				.setPlatform(Platform.all())
				// apns 环境设置（开发、生产）
				.setOptions(Options.newBuilder().setApnsProduction(apns).build())
				// Audience设置为all，说明采用广播方式推送，所有用户都可以接收到
				.setAudience(Audience.all())
				.setNotification(Notification.alert(alert))
				.build();
	}

	/**
	 * 推送
	 *
	 * @param alias 别名
	 * @param alert 信息
	 * @param apns 环境设置 true：生产环境；false：开发环境
	 * @return PushResult
	 */
	public static PushResult push(String appKey, String secret, String alert,
			boolean apns, String... alias) throws APIConnectionException, APIRequestException {
		ClientConfig clientConfig = ClientConfig.getInstance();
		// 信息保存时间，一天
		clientConfig.setTimeToLive(1 * 24 * 3600);
		JPushClient jpushClient = new JPushClient(secret, appKey, null, clientConfig);
		PushPayload payload = buildPushObject_android_ios_alias_alert(alert, apns, alias);

		return jpushClient.sendPush(payload);
	}
}
