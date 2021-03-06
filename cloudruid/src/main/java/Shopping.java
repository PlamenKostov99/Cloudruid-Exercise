import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Shopping {

    private Scanner scanner;

    public Shopping(Scanner scanner) {
        this.scanner = scanner;
    }

    public String Shopping(List<Products> allProducts) {

        List<String> productNames = new ArrayList<>();

        for (Products product : allProducts) {
            System.out.println("Product " + product.getName());
            String name = product.getName();
            productNames.add(name);
        }

        System.out.println(Constants.SELECTING_PRODUCTS);
        System.out.println(Constants.FINISHING_BILL);

        String input = scanner.nextLine();


        List<Products> productsList = new ArrayList<>();

        while (true) {

            if (input.equals("bill")) {

                return getTheBill(productsList);

            } else {

                String[] splitInput = input.split(" ");

                Arrays.stream(splitInput).forEach(x -> {

                    if (productNames.contains(x)) {

                        Products products = allProducts.stream()
                                .filter(n -> n.name.equals(x)).findFirst().orElseThrow();
                        productsList.add(products);
                    }
                    ;

                });

                input = scanner.nextLine();
            }
        }
    }

    private static String getTheBill(List<Products> productsList) {

        double bill = 0.0;

        int productsCount = productsList.size();

        for (Products product : productsList) {

            bill += product.price;
        }

        if (productsCount > 3) {

            List<Products> products = new ArrayList<>();

            for (int i = 0; i < 3; i++) {

                products.add(productsList.get(i));
            }

            productsList.remove(0);
            productsList.remove(0);
            productsList.remove(0);

            double discount2for3 = products.stream().mapToDouble(Products::getPrice).min().orElseThrow();

            bill = bill - discount2for3;

            productsCount -= 3;
        }

        for (int i = 0; i < productsList.size() - 1; i++) {
            for (int j = i + 1; j <= productsList.size() - 1; j++) {

                if (productsList.get(i) == productsList.get(j)) {
                    bill = bill - productsList.get(i).getPrice() * 0.5;
                    productsList.remove(productsList.get(j));
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if (bill > 100) {

            int aws = (int) bill / 100;
            int clouds = (int) bill % 100;

            sb.append(String.format("%d aws and %d clouds.", aws, clouds));
        } else {
            int cloudsOnly = (int) bill % 100;

            sb.append(String.format("%d clouds.", cloudsOnly));
        }

        return sb.toString();

    }

}
