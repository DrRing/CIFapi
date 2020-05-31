package APIS;

import asserts.Assertion;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Log;
import function.OkHttpUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.custructProvider;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class test_UpdateMembersApi {
    @DataProvider
    private Iterator<Object[]> UpdateUserProvider() throws IOException {
        String sheetname = "Case_UpdateUsers";
        Iterator<Object[]> testIterator = custructProvider.custructProvider(sheetname);
        return testIterator;
    }
    @Test(dataProvider = "UpdateUserProvider")
    public void testUpdateUser(Map<String, Object> casedemo) {
        String url = utils.getProperty.getDepencyProperty("host") + utils.getProperty.getDepencyProperty("userupdate_url");
        try {
            Map<String, String> mapQ = JSONObject.parseObject(casedemo.get("body").toString(), Map.class);
            String param = JSON.toJSONString(mapQ);
            String resopseString = OkHttpUtil.postJson(url, param);
            JSONObject jsonObject = JSONObject.parseObject(resopseString);
            String codeString = jsonObject.getString("code");
            String expected = casedemo.get("expected").toString();
            Log.info("这是返回信息"+resopseString);
            //Assert.assertEquals(expected,codeString);
            Assertion.verifyEquals(codeString,expected);
//            if (Assertion.flag == false)
//                Log.info(resopseString);
        } catch (Exception e) {
            Log.info("好像出了点问题"+e);
        }
    }
}
