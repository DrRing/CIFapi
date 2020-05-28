package utils;

import function.OkHttpUtil;
import okhttp3.*;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class depencyOn {
    private static final MediaType jsonMediaType = MediaType.parse("application/json; charset=utf-8");
    private static final MediaType xmlMediaType = MediaType.parse("application/xml; charset=utf-8");

    private void construct_json(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

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

    public static String getSessionId(String json, String url) {
        RequestBody body = RequestBody.create(jsonMediaType, json);
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = new OkHttpClient().newCall(request).execute();
            Headers headers = response.headers();
            List<String> cookies = headers.values("Set-Cookie");
            String s = cookies.get(0);

            String session = s.substring(0, s.indexOf(";"));

            return session;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String url = utils.getProperty.getDepencyProperty("host") + utils.getProperty.getDepencyProperty("login_url");
        String path = "src/main/webapp/resource/properties/test.json";
        String bodyString = utils.getJson.getJson(path);
        System.out.println(url);
        System.out.println(bodyString);
        String session = getSessionId(bodyString, url);
        System.out.println(session);
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


}
