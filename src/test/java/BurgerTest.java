import org.junit.*;
import praktikum.Bun;
import org.junit.Test;
import org.mockito.*;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.SAUCE;


public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;
    Burger burger = new Burger();
    List <Ingredient> ingredients ;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        burger.ingredients = new ArrayList<>();
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.setBuns(bun);
    }

    @Test
    public void addIngredientTest(){
        Assert.assertEquals(2,burger.ingredients.size());
    }
    @Test
    public void removeIngredientTest(){
        burger.removeIngredient(1);
        Assert.assertEquals(1,burger.ingredients.size());
    }
    @Test
    public void moveIngredientTest(){
    Ingredient ingredient3 = new Ingredient(SAUCE,"MAYO",100f);
    burger.addIngredient(ingredient3);
    burger.moveIngredient(2,1);
    Assert.assertEquals(ingredient3,burger.ingredients.get(1));


    }

    @Test
    public void getBurgerPriceTest(){
    Mockito.when(bun.getPrice()).thenReturn(100f);
    Mockito.when(ingredient1.getPrice()).thenReturn(10f);
    Mockito.when(ingredient2.getPrice()).thenReturn(10f);
    Assert.assertEquals(220f,burger.getPrice(),0.00);
    }

    @Test
    public  void getBurgerReceiptTest(){

            when(bun.getName()).thenReturn("Bun");
            when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
            when(ingredient1.getName()).thenReturn("ingredientSauce");
            when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
            when(ingredient2.getName()).thenReturn("ingredientFilling");
            String expected = "(==== Bun ====)\n" +
                    "= filling ingredientSauce =\n" +
                    "= sauce ingredientFilling =\n" +
                    "(==== Bun ====)\n" +
                    "\nPrice: 0,000000\n";
            String actual = burger.getReceipt();
            Assert.assertEquals(expected, actual);

    }

    @After
    public void shutDown(){
        for (int i=burger.ingredients.size()-1; i>=0; i-- ){
            burger.removeIngredient(i);

        }
    }
}
