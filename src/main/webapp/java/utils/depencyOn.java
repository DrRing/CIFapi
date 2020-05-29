package utils;

import org.testng.annotations.Test;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
public class depencyOn {


//获取loginId

    public static String getLoginId(String json) {
        String url = getProperty.getDepencyProperty("host") + getProperty.getDepencyProperty("login_url");
        String responseString = function.OkHttpUtil.postJson(url, json);
        JSONObject jsonObject = JSONObject.parseObject(responseString);
        String dataObject = jsonObject.getString("data");
        JSONObject data = JSONObject.parseObject(dataObject);
        try {
            String captchaCode = data.getString("loginId");
            return captchaCode;
        } catch (Exception e) {
            System.out.print(e);
            return null;
        }
    }

    //执行登录操作
    public static void doLogin(String json) {
        String url = getProperty.getDepencyProperty("testhost") + getProperty.getDepencyProperty("login");
        String responseString = function.OkHttpUtil.postJson(url, json);
        JSONObject jsonObject = JSONObject.parseObject(responseString);
        String dataObject = jsonObject.getString("data");
        JSONObject data = JSONObject.parseObject(dataObject);
        try {
            String captchaCode = data.getString("code");
            if (captchaCode.equals("SUCCESS") == false) {
                System.out.print("好像登录没有成功");
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    //获取验证码
    public static String getSendSms(String json) {
        String url = getProperty.getDepencyProperty("host") + getProperty.getDepencyProperty("captcha_url");
        String responseString = function.OkHttpUtil.postJson(url, json);
        JSONObject jsonObject = JSONObject.parseObject(responseString);
        try {
            String dataString = jsonObject.getString("data");
            JSONObject data = JSONObject.parseObject(dataString);
            String codeString = data.getString("captchaCode");
            return codeString;
        } catch (Exception e) {
            //System.out.println(jsonObject.getString("msg"));
            return null;
        }
    }

    //获取session


    @Test
    public void register() {
    }

}
