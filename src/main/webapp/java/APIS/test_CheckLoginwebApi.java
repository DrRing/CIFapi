package APIS;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import common.Log;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
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

		StringBuilder respon=new StringBuilder();
		try {
			Map<String, String> body = JSONObject.parseObject(casedemo.get("body").toString(), Map.class);
			String param = JSON.toJSONString(body);
			if( asserts.Assertion.assertNull(casedemo.get("depency"))) {
				String urlpath = utils.getProperty.getDepencyProperty("host") + utils.getProperty.getDepencyProperty("login_url");
				String login_String = casedemo.get("depency").toString();
				//获取cookies
				//String respose1 = OkHttpUtil.postJson(urlpath, login_String);

				String cookies = OkHttpUtil.GetSession(urlpath, login_String);
				String Cookie= "Set-Cookie:"+cookies.substring(1,cookies.length()-1);
				String response1 = OkHttpUtil.postJsonWithHeader(url, param, Cookie);
                Log.info(Cookie);
				respon.append(response1);
			}else {
				String response2 = OkHttpUtil.postJson(url,param);
				respon.append(response2);
			}

                JSONObject jsonObject = JSONObject.parseObject(respon.toString());
                String codeString = jsonObject.getString("code");
                String expected = casedemo.get("expected").toString();
                assertEquals(codeString, expected);



		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
