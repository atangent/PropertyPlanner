/**
 * Abstract class Property
 *
 * @author Amy Tang 20130856
 * @version 1.0
 */
public abstract class Property {

    /** Attribute */
    private double listingPrice;  //is not re-declared in any class

    /**
     * Constructor of a Property object
     *
     * @param listingPrice (required) asking price of property in thousands of dollars
     * @throws BadProperty listing price must be $0 or greater
     */
    public Property(double listingPrice) throws BadProperty {
        setListingPrice(listingPrice);

        if (listingPrice < 0) {  //do not need to call this exception again in another class that invokes this
            throw new BadProperty("Property listing price must be $0 or greater.");
        }  //end exception
    }  //end constructor

    /** Getters */
    public double getListingPrice() {
        return this.listingPrice;
    }  //end method

    /** Setters */
    public void setListingPrice(double listingPrice) {
        this.listingPrice = listingPrice*1000;
    }  //end method

    /**
     * Method compares the listing prices of 2 properties of any Property Type
     *
     * @param other (required) the other property being compared to the property to which the method is called on
     * @return the result of which property is more expensive and the differences between the listing prices.
     */
    public String compareTo(Property other) {
        if (this.getListingPrice() > other.getListingPrice()) {
            return ("The " + this.getClass().getSimpleName() + " is more expensive than the " + other.getClass().getSimpleName()
                    + ". Difference is $" + (this.getListingPrice() - other.getListingPrice()));  //calculation in brackets implicitly calls String.valueOf
        } else {
            return ("The " + other.getClass().getSimpleName() + " is more expensive than the " + this.getClass().getSimpleName()
                    + ". Difference is $" + (other.getListingPrice() - this.getListingPrice()));  //use getSimpleName() to get name of class without the word "class"
        }
    }  //end method

    /**
     * Abstract method calculates tax, which is calculated in different ways depending on derived Property Type
     *
     * @return tax in dollars of each property
     */
    public abstract double calculateTax();  //abstract methods don't have a body

}  //end program
