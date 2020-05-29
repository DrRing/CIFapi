package Demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testDemo {
    @Test
    private void testcase1(){
        Assert.assertEquals(1+1,2);
        System.out.println("testcase1");
    }
}
