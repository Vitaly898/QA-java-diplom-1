import org.junit.*;
import praktikum.Bun;
import org.junit.Test;


public class BunTest {
    Bun bun;

    @Before
    public void setUp(){
        bun = new Bun("Кекс", 100);
    }

    @Test
    public void  getBunNameTest(){
        Assert.assertEquals("Кекс",bun.getName());
    }
    @Test
    public void getBunPriceTest(){
        Assert.assertEquals(100,bun.getPrice(),0.00);
    }
}
