package APIS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import asserts.Assertion;
import common.Log;
import function.OkHttpUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import listeners.AssertListener;
import utils.custructProvider;
import utils.getProperty;


@Listeners(AssertListener.class)
public class test_SendsmsApi {
    public void before() {
        System.out.println("测试开始");
    }

    @DataProvider
    private Iterator<Object[]> SendSmsProvider() throws IOException {
        String sheetname = "Case_sendsms";
        Iterator<Object[]> testIterator= custructProvider.custructProvider(sheetname);
        return testIterator;
    }

    @Test(dataProvider = "SendSmsProvider", groups = {"test1", "test2"})
    public void testSend(Map<String, Object> casedemo) {

        String url = getProperty.getDepencyProperty("host") + getProperty.getDepencyProperty("captcha_url");
        if (casedemo.get("body") != null && casedemo.get("expected") != null) {
            Map<String, String> mapQ = JSONObject.parseObject(casedemo.get("body").toString(), Map.class);
            String param = JSON.toJSONString(mapQ);
            String resopseString = OkHttpUtil.postJson(url, param);
            JSONObject jsonObject = JSONObject.parseObject(resopseString);
            String codeString = jsonObject.getString("code");
            String expected = casedemo.get("expected").toString();
            Assertion.verifyEquals(codeString,expected);
            if(Assertion.flag==false)
                Log.info(resopseString);


        }
    }


}
