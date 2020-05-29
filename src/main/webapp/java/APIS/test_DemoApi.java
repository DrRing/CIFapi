package APIS;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.springframework.util.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import function.OkHttpUtil;
import utils.*;


public class test_DemoApi {
    @DataProvider
    private Iterator<Object[]> CheckLoginProvider() throws IOException {
        String sheetname = "Case_checkLoginWeb";
        Iterator<Object[]> testIterator = custructProvider.custructProvider(sheetname);
        return testIterator;
    }

    @Test(dataProvider = "CheckLoginProvider")
    public void testSession(Map<String, Object> casedemo) {
        String url = utils.getProperty.getDepencyProperty("host") + utils.getProperty.getDepencyProperty("login_url");
        try {
            String path = "src/main/webapp/resource/properties/test.json";

            String json = utils.getJson.getJson(path);
            String Session = OkHttpUtil.GetSession(url, json);
            Assert.notNull(Session);
        } catch (Exception e) {
            //System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String url = utils.getProperty.getDepencyProperty("host") + utils.getProperty.getDepencyProperty("login_url");

        String path = "src/main/webapp/resource/properties/test.json";

        String json = utils.getJson.getJson(path);
        String Session = OkHttpUtil.GetSession(url, json);
        System.out.println(Session);

    }
}
