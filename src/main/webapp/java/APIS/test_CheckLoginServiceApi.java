package APIS;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import function.OkHttpUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.custructProvider;
import utils.depencyOn;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class test_CheckLoginServiceApi {
    @DataProvider
    private Iterator<Object[]> CheckLoginSerProvider() throws IOException {
        String sheetname = "Case_checkLoginService";
        Iterator<Object[]> testIterator= custructProvider.custructProvider(sheetname);
        return testIterator;

    }
    @Test(dataProvider = "CheckLoginSerProvider")
    public void testcheckLogin_service(Map<String, Object> casedemo) {
        String url = utils.getProperty.getDepencyProperty("host") + utils.getProperty.getDepencyProperty("checkLogin_service_url");
        try {
            Map<String, String> body = JSONObject.parseObject(casedemo.get("body").toString(), Map.class);

            if (casedemo.get("depency").equals(null)) {
                body.put("loginId", null);
            } else {
                String login_String = casedemo.get("depency").toString();
                String loginID = depencyOn.getLoginId(login_String);
//                System.out.println("1111111");
                body.put("loginId", loginID);
            }

            String param = JSON.toJSONString(body);
            String resopseString = OkHttpUtil.postJson(url, param);
            JSONObject jsonObject = JSONObject.parseObject(resopseString);
            String codeString = jsonObject.getString("code");

            String expected = casedemo.get("expected").toString();
            assertEquals(codeString, expected);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
