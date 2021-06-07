package tests.com.wheelsUp.api;

import api.APITest;
import engine.PropertiesReader;
import io.restassured.common.mapper.TypeRef;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class Task3 extends APITest {

    @Test
    public void Task3(){
        response = get(PropertiesReader.URL.getProperty("wheelsUpApi"));

        verifySocialAccounts("https://twitter.com/WheelsUp", "http://instagram.com/wheelsup");
        displayEditedKeys();
    }

    public void verifySocialAccounts(String twitter, String instagram) {
        Map<String,Object> map = response.getBody().as(new TypeRef<Map<String,Object>>() {
        });

        Map<String, String> keys = (Map<String, String>) map.get("keys");

        Assert.assertEquals(keys.get("twitter"), twitter);
        Assert.assertEquals(keys.get("instagram"), instagram);
    }

    public void displayEditedKeys(){
        Map<String,Object> map = response.getBody().as(new TypeRef<Map<String,Object>>() {
        });

        Map<String, String> keys = (Map<String, String>) map.get("keys");

        System.out.println("Keys size: " + keys.size());

        keys.remove("google_tag_manager");
        keys.remove("mapbox_accesstoken");
        keys.remove("footer_disclaimer");

        keys.put("email", "myEmail");

        keys.keySet().stream().map(key-> key+": "+keys.get(key)).forEach(System.out::println);
    }

}
