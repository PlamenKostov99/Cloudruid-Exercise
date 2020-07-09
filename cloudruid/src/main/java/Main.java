import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(Constants.GREETING);

        List<Products> allProducts = new ArrayList<>();

        Inventory inventory = new Inventory();
        inventory.addProducts(allProducts);
        Shopping shopping = new Shopping();
        System.out.println(shopping.Shopping(allProducts));

    }


}
