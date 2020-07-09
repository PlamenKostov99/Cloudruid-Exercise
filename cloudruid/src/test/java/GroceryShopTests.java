import org.junit.Assert;
import org.junit.Test;


public class GroceryShopTests {

    @Test
    public void ProductsShouldAddProductWithName(){

        Products products = new Products();

        products.setName("apple");
        Assert.assertEquals("apple", products.getName());

    }

    @Test
    public void ProductsShouldAddProductWithValue(){

        Products products = new Products();

        products.setPrice(50);
        Assert.assertEquals(50, (int) products.getPrice());

    }

    @Test(expected = IllegalArgumentException.class)
    public void ProductsWithNegativeValueShouldThrowException(){

        Products products = new Products();
        products.setPrice(-50);


    }

    @Test(expected = IllegalArgumentException.class)
    public void ProductsWithEmptyNameShouldThrowException(){

        Products products = new Products();
        products.setName("");

    }

}
