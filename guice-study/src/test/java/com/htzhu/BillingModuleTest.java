package com.htzhu;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.htzhu.manager.SessionManager;
import com.htzhu.module.BillingModule;
import com.htzhu.module.LoggedModule;
import com.htzhu.service.BillingService;
import com.htzhu.vo.PizzaOrder;
import com.htzhu.vo.Receipt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * BillingModuleTest
 *
 * @author zhuhaitao
 * @date 2018/6/4 15:08
 **/
public class BillingModuleTest {

	private Injector injector;

	@Before
	public void before() {
		injector = Guice.createInjector(new BillingModule(), new LoggedModule());
	}

	@Test
	public void sessionIdTest() throws InterruptedException {
		SessionManager sessionManager = injector.getInstance(SessionManager.class);

		Long session1 = sessionManager.getSessionIdProvider();
		Thread.sleep(1000);
		Long session2 = sessionManager.getSessionIdProvider();
		Assert.assertNotEquals(session1, session2);
	}

	@Test
	public void testChargeGuice() throws InterruptedException {
		PizzaOrder order = new PizzaOrder(100L);

		BillingService billingService = injector.getInstance(BillingService.class);
		Receipt receipt = billingService.chargeOrder(order);
		Assert.assertTrue(receipt.getResult());
	}

}
