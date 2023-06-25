import praktikum.Bun;
import praktikum.Database;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;


public class DataBaseTest {
    Database database;

    @Test
    public void checkAvailableBunsTest(){
        database = new Database();
//          List <Bun> expected = new ArrayList<>();
//          expected.add(new Bun("black bun",100));
//          expected.add(new Bun("white bun",200));
//          expected.add(new Bun("red bun",300));
        Assert.assertEquals(3,database.availableBuns().size());

    }
    @Test
    public  void checkAvailableSaucesTest(){
        database = new Database();
        Assert.assertEquals(6,database.availableIngredients().size());
    }
}
