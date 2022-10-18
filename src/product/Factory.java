package product;

import java.util.List;

public class Factory {
    private List<Product> productLineup;

    public Factory(List<Product> productLineup) {
        this.productLineup = productLineup;
    }

    public List<Product> getProductLineup() {
        return productLineup;
    }

    public void setProductLineup(List<Product> productLineup) {
        this.productLineup = productLineup;
    }

    public List<Product> sortByDemand(){
        productLineup.sort(new ProductDemandComparator());
        return productLineup;
    }

    public void updateCategories(){
        for(Product product : productLineup){
            product.updateDemand();
        }
    }

    public void makeRecommendations(){
        for(Product product : productLineup){
            switch (product.getDemandTrend()) {
                case FALLING -> product.setRecommendedProduction((int) (product.getUnitsSold()[0] * 1.5));
                case STAGNANT -> product.setRecommendedProduction((int) (product.getUnitsSold()[0] * 1.1));
                case RISING -> product.setRecommendedProduction((int) (product.getUnitsSold()[0] * 0.9));
                default -> product.setRecommendedProduction((int) (product.getUnitsProduced()[0]));
            }
        }
    }
}
