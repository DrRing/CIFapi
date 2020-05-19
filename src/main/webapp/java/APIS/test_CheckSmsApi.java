package APIS;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import function.OkHttpUtil;
import utils.*;


public class test_CheckSmsApi {
	@DataProvider
	private Iterator<Object[]> CheckSmsProvider() throws IOException {
//		List<Object[]> result = new ArrayList<Object[]>();
		String sheetname = "Case_newGift_checkSms";
//		String pathString = "C:\\Users\\Administrator\\Desktop\\0514.xlsx";
//		List<Map<String, Object>> cases_list = operateExcel.excel_re_map(pathString, sheetname);
//		Iterator it = cases_list.iterator();
//		while (it.hasNext()) {
//			result.add(new Object[] { it.next() });
//		}
//		return result.iterator();
		Iterator<Object[]> testIterator=custructProvider.custructProvider(sheetname);
		return testIterator;
		
		
	}
	@Test(dataProvider = "CheckSmsProvider")
	public void testCheckSms(Map<String, Object> casedemo) {
		//System.out.println(111111);

		String url = getProperty.getDepencyProperty("host") + getProperty.getDepencyProperty("checkSms");
		try {
			String para_captchString = casedemo.get("depency").toString();
//			System.out.println(para_captchString);
			String captchaCode = depencyOn.getSendSms(para_captchString);
//			System.out.println(captchaCode);
			Map<String, String> body = JSONObject.parseObject(casedemo.get("body").toString(), Map.class);
			// 插入验证码
			body.put("captchaCode", captchaCode);
			String param = JSON.toJSONString(body);
			String resopseString = OkHttpUtil.postJson(url, param);			
			JSONObject jsonObject = JSONObject.parseObject(resopseString);
			String codeString = jsonObject.getString("code");
			//System.out.println(codeString);
			String expected = casedemo.get("expected").toString();
			assertEquals(codeString, expected);
		} catch (Exception e) {
			System.out.println(e);

		}
	}
}
