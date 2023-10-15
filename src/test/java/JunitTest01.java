import org.junit.Assert;
import org.junit.Test;

public class JunitTest01 {

    @Test
    public void test01(){
        String expectedData="Hello";
        String actualData="Hello";

        Assert.assertEquals(expectedData,actualData);
        Assert.assertTrue(actualData.contains("lo"));


    }
}
