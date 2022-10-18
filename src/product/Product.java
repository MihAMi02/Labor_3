package product;

import java.util.Comparator;

import static java.lang.Math.abs;

enum Demand{
    RISING,
    STAGNANT,
    FALLING
}

public class Product {
    private String name;
    private Demand demandTrend;
    private double[] unitsProduced;
    private double[] unitsSold;
    private int recommendedProduction;

    public Product(String name, double[] unitsProduced, double[] unitsSold) {
        this.name = name;
        this.unitsProduced = unitsProduced;
        this.unitsSold = unitsSold;
    }

    public double getDemandForYear1(){
        return unitsSold[0]/unitsProduced[0];
    }

    public double getDemandForYear2(){
        return unitsSold[1]/unitsProduced[1];
    }

    public void updateDemand() {
        double demandForYear1 = unitsSold[0]/unitsProduced[0];
        double demandForYear2 = unitsSold[1]/unitsProduced[1];
        if(abs(demandForYear1-demandForYear2) < 0.1) {
            this.demandTrend=Demand.STAGNANT;
        }
        else if(demandForYear1 < demandForYear2) {
            this.demandTrend = Demand.FALLING;
        }
        else {
            this.demandTrend = Demand.RISING;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Demand getDemandTrend() {
        return demandTrend;
    }

    public void setDemandTrend(Demand demandTrend) {
        this.demandTrend = demandTrend;
    }

    public double[] getUnitsProduced() {
        return unitsProduced;
    }

    public void setUnitsProduced(double[] unitsProduced) {
        this.unitsProduced = unitsProduced;
    }

    public double[] getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(double[] unitsSold) {
        this.unitsSold = unitsSold;
    }

    public int getRecommendedProduction() {
        return recommendedProduction;
    }

    public void setRecommendedProduction(int recommendedProduction) {
        this.recommendedProduction = recommendedProduction;
    }
}

class ProductDemandComparator implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getDemandForYear1(), o2.getDemandForYear2());
    }
}