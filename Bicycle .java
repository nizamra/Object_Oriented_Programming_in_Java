public class Bicycle {
    String brand = "";
    String model = "";
    double listPrice = 0.0;
    int tireSize = 24;
    boolean isSold = false;
    double salePrice = 0.0;
    }

// returns a String with basic information about
// the bicycle
public String getInfo() {
    return brand + " " + model + " $" + price;
}

// marks the bicycle as sold and returns
// the asking price for the customer
public double makeFullPriceSale() {
    isSold = true;
    return listPrice;
}

// marks the bicycle as sold and returns
// the asking price for the customer
// during a sale
public double makeReducedPriceSale() {
    isSold = true;
    return salePrice;
}

public Bicycle (String brand, String model, double price, boolean isSold, double salePrice) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.isSold = isSold;
        this.salePrice = salePrice;
    }
}

// this uses the default values of 28 for the tireSize
// false for isSold and set the salePrice to the listPrice
public Bicycle(String brand, String model, double listPrice) {
    this(brand, model, listPrice, 28, false, listPrice);
}

// this uses all default values for a new Bicycle
public Bicycle() {
    this("", "", 0.0, 28, false, 0.0);
}

