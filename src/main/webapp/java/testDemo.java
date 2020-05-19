import org.testng.Assert;
import org.testng.annotations.Test;

public class testDemo {
    @Test
    public void testcase1(){
        Assert.assertEquals(1+1,2);
        System.out.println("testcase1");
    }
}
