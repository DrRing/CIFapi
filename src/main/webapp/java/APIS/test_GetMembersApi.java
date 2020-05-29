package APIS;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import function.OkHttpUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import utils.*;

public class test_GetMembersApi {
    @DataProvider
    private Iterator<Object[]> GetMembersProvider() throws IOException {
        //	List<Object[]> result = new ArrayList<Object[]>();
        String sheetname = "Case_getUsers";
//		String pathString = "C:\\Users\\Administrator\\Desktop\\0514.xlsx";
//		List<Map<String, Object>> cases_list = operateExcel.excel_re_map(pathString, sheetname);
//		Iterator it = cases_list.iterator();
//		while (it.hasNext()) {
//			result.add(new Object[] { it.next() });
//		}
//		return result.iterator();
        Iterator<Object[]> testIterator = custructProvider.custructProvider(sheetname);
        return testIterator;
    }

    @Test(dataProvider = "GetMembersProvider")
    public void testGetMembers(Map<String, Object> casedemo) {
        String url = getProperty.getDepencyProperty("host") + getProperty.getDepencyProperty("getMemberList_url");
        try {
            Map<String, String> body = JSONObject.parseObject(casedemo.get("body").toString(), Map.class);

            String param = JSON.toJSONString(body);
            String resopseString = OkHttpUtil.postJson(url, param);
            JSONObject jsonObject = JSONObject.parseObject(resopseString);

            String codeString = jsonObject.getString("code");
            System.out.println(codeString);

            String expected = casedemo.get("expected").toString();
            assertEquals(codeString, expected);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
