package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;


    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
        public static Object[][] getData () {
            return new Object[][]{
                    {IngredientType.SAUCE, "chilli", 50},
                    {IngredientType.FILLING, "meat", 100},
                    {IngredientType.FILLING, "", 10},
                    {null, "beans", 210},
                    {IngredientType.SAUCE, null, 0.5f}
            };
        }
@Before
public void setup(){
   ingredient = new Ingredient(type, name, price);
}
        @Test
    public void checkName(){
        assertEquals("невалидное значение: name", name, ingredient.getName());
        }
        @Test
        public void checkPrice(){
            assertEquals("невалидное значение: price", price, ingredient.getPrice(), 0);
        }
    @Test
    public void checkType(){
        assertEquals("невалидное значение: type", type, ingredient.getType());
    }
    }
