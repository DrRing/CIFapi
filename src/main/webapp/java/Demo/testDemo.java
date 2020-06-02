package Demo;

import asserts.Assertion;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({listeners.AssertListener.class})

public class testDemo {


    @Test
    public void testAssert3() {
        Assert.assertEquals(2, 3, "比较两个数是否相等：");
        Assertion.verifyEquals(2, 3, "比较两个数是否相等：");
        Assertion.verifyEquals(1, 2, "比较两个数是否相等：");
    }

    @Test
    public void testAssert4() {
        Assertion.verifyEquals(4, 3, "比较两个数是否相等：");
        Assertion.verifyEquals(2, 2, "比较两个数是否相等：");
    }

}

