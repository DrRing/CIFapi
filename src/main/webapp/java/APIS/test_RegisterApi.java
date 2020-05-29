package APIS;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import function.OkHttpUtil;
import utils.*;

public class test_RegisterApi {
    static Map<String, Object> casese;

    public static Map<String, Object> getName() {
        return casese;
    }

    public  static void setName(Map<String, Object> casedemo) {
        test_RegisterApi.casese = casedemo;
    }
    @BeforeMethod
    private static void checkMember(){
        System.out.println("检查用户是否删除");

    }
    @AfterMethod
    private static void deleteMember(){
        Map<String, Object> casedemo=test_RegisterApi.getName();
        try {
            System.out.println(casedemo.get("body").toString());
        }catch (Exception e){
            System.out.println("用户不存在");
        }
        System.out.println("删除用户");
    }
    @DataProvider
    private Iterator<Object[]> RegisterProvider() throws IOException {
        String sheetname = "Case_regist";
        Iterator<Object[]> testIterator = custructProvider.custructProvider(sheetname);
        return testIterator;
    }
    @Test(dataProvider = "RegisterProvider")
    public void testRegister(Map<String, Object> casedemo) {
        String url = getProperty.getDepencyProperty("host") + getProperty.getDepencyProperty("register_url");
        try {
            Map<String, String> body = JSONObject.parseObject(casedemo.get("body").toString(), Map.class);
            if (casedemo.get("depency").equals(null)) {
                body.put("captchaCode", null);
            } else {
                String login_String = casedemo.get("depency").toString();
                String captchaCode = depencyOn.getSendSms(login_String);
                body.put("captchaCode", captchaCode);
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
//        test_RegisterApi.setName(casedemo);

    }
}
