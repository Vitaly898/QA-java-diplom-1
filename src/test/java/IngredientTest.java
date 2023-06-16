import org.junit.Assert;
import org.junit.Test;
import  praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;


public class IngredientTest {
    Ingredient ingredient = new Ingredient(FILLING, "МЯСО",20);

    @Test
    public void getIngredientPriceTest(){
        Assert.assertEquals(20,ingredient.getPrice(),0.00);
    }
    @Test
    public void getIngredientNameTest(){
        Assert.assertEquals("МЯСО",ingredient.getName());
    }
    @Test
    public void getIngredientTypeTest(){
        Assert.assertEquals(FILLING,ingredient.getType());
    }

}
