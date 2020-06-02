package APIS;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import asserts.Assertion;
import common.Log;
import function.OkHttpUtil;
import org.testng.Assert;
import org.testng.annotations.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import utils.custructProvider;
import utils.getProperty;
import utils.depencyOn;

@Listeners({listeners.AssertListener.class})

public class test_LoginApi {

	@DataProvider
	private Iterator<Object[]> CheckSmsProvider() throws IOException {
		String sheetname = "Case_login";
		Iterator<Object[]> testIterator= custructProvider.custructProvider(sheetname);
		return testIterator;
	}

	@Test(dataProvider = "CheckSmsProvider")
	public void testLogin(Map<String, Object> casedemo) {

		String url = getProperty.getDepencyProperty("host") + getProperty.getDepencyProperty("login_url");

		try {
			Map<String, String> body = JSONObject.parseObject(casedemo.get("body").toString(), Map.class);

			if (Assertion.assertNull(casedemo.get("depency"))) {
				String login_String = casedemo.get("depency").toString();
				String captchaCode = depencyOn.getSendSms(login_String);
				body.put("captcha", captchaCode);
			}
			// 将对象转化为Json字符串
			String param = JSON.toJSONString(body);
			String resopseString = OkHttpUtil.postJson(url, param);
			JSONObject jsonObject = JSONObject.parseObject(resopseString);
			String codeString = jsonObject.getString("code");
			String expected = casedemo.get("expected").toString();
			Assertion.verifyEquals(codeString, expected);
			Assertion.verifyEquals(1,2);
			Assertion.verifyEquals(3,3);
		}catch (Exception e){
			Log.info(e);
		}


	}

	@AfterMethod
	public void afterMethod() {
	}
}
