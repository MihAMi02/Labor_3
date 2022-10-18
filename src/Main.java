import product.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double[] aProduced = new double[2];
        aProduced[0] = 100000;
        aProduced[1] = 100000;
        double[] aSold = new double[2];
        aSold[0] = 100000;
        aSold[1] = 100000;
        Product a = new Product("Water", aProduced, aSold);

        double[] bProduced = new double[2];
        bProduced[0] = 100000;
        bProduced[1] = 90000;
        double[] bSold = new double[2];
        bSold[0] = 100000;
        bSold[1] = 50000;
        Product b = new Product("Fanta", bProduced, bSold);

        double[] cProduced = new double[2];
        cProduced[0] = 100000;
        cProduced[1] = 100000;
        double[] cSold = new double[2];
        cSold[0] = 50000;
        cSold[1] = 100000;
        Product c = new Product("Sprite", cProduced, cSold);

        List<Product> productList = new ArrayList<Product>();
        productList.add(a);
        productList.add(b);
        productList.add(c);

        Factory factory = new Factory(productList);
        List<Product> sortedProducts = factory.sortByDemand();
        System.out.println("\nSorted products by demand in last year:");
        for(Product product : sortedProducts){
            System.out.println(product.getName() + " " + product.getDemandForYear1());
        }

        factory.updateCategories();

        System.out.println("\nWhat demand trend do the products have:");
        for(Product product : sortedProducts){
            System.out.println(product.getName() + " " + product.getDemandTrend());
        }

        System.out.println("\nRecommendations:");
        factory.makeRecommendations();
        for(Product product : sortedProducts){
            System.out.println(product.getName() + " " + product.getRecommendedProduction());
        }
    }
}