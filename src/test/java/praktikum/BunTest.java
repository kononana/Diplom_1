package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
   private final String name;
   private final float price;
   private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bunData(){
        return new Object[][] {
                {"Whole Wheat Bun", 10},
                {"Sesame Bun", 0},
                {null, 15},
                {"", 50}
        };
    }
    @Before
    public void setup() {
       bun = new Bun(name, price);
    }
    @Test
    public void checkBunName(){
        assertEquals("невалидное значение: имя", name, bun.getName());
    }
    @Test
    public void checkBunPrice(){
        assertEquals("невалидное значение: цена", price, bun.getPrice(), 0);
    }
}
