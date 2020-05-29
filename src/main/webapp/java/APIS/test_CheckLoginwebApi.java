package APIS;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import function.OkHttpUtil;
import utils.custructProvider;
import utils.depencyOn;


public class test_CheckLoginwebApi {
	@DataProvider
	private Iterator<Object[]> CheckLoginProvider() throws IOException {
		String sheetname = "Case_checkLoginWeb";
		Iterator<Object[]> testIterator= custructProvider.custructProvider(sheetname);
		return testIterator;
	}
	@Test(dataProvider = "CheckLoginProvider")
	public void testcheckLogin_web_url(Map<String, Object> casedemo) {
		String url = utils.getProperty.getDepencyProperty("host") + utils.getProperty.getDepencyProperty("checkLogin_web_url");
		try {
			StringBuilder session=null;
			Map<String, String> body = JSONObject.parseObject(casedemo.get("body").toString(), Map.class);
			if (casedemo.get("depency").equals(null)){
				String urlpath = utils.getProperty.getDepencyProperty("host") + utils.getProperty.getDepencyProperty("login_url");
				String login_String = casedemo.get("depency").toString();
				String getsession = OkHttpUtil.GetSession(urlpath,login_String);
				session.append(getsession);
			}
			String param = JSON.toJSONString(body);
			String resopseString = OkHttpUtil.postJson(url, param);



			JSONObject jsonObject = JSONObject.parseObject(resopseString);
			String codeString = jsonObject.getString("code");
//			System.out.println(codeString);
			String expected = casedemo.get("expected").toString();
			assertEquals(codeString, expected);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
