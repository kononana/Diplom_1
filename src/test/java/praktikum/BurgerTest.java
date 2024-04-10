package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    private Burger burger;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void checkSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddIngredient(){
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void checkRemoveIngredient(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }
    @Test
    public void checkMoveIngredients(){
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        List<Ingredient> exoectedList = new ArrayList<>();
        exoectedList.add(ingredient2);
        exoectedList.add(ingredient1);
        assertEquals(exoectedList, burger.ingredients);
    }

    @Test
    public void checkGetPrice(){
        when(bun.getPrice()).thenReturn(10.0f);
        when(ingredient.getPrice()).thenReturn(5.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(25.0f, burger.getPrice(), 0.f);
    }

    @Test
    public void checkGetReceipt() {
        when(bun.getName()).thenReturn("Wheat Bun");
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient.getName()).thenReturn("acid fish");
        when(bun.getPrice()).thenReturn(10f);
        when(ingredient.getPrice()).thenReturn(20f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String expectedReceipt = "(==== Wheat Bun ====)\n" +
                "= filling acid fish =\n" +
                "(==== Wheat Bun ====)\n" +
                "\n" +
                "Price: 40,000000\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }


}

