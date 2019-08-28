/**
 * Concrete class Land inheriting abstract class Property
 *
 * @author Amy Tang 20130856
 * @version 1.0
 * Aug 6, 2019
 */
public class Land extends Property {

    /** Unique attribute of Land from Property */
    private double hectares;

    /**
     * Constructor of a Land object
     *
     * @param listingPrice (required) asking price of property in thousands of dollars
     * @param hectares (required) number of hectares of property
     * @throws BadProperty number of hectares cannot be less or equal to zero
     */
    public Land(double listingPrice, double hectares) throws BadProperty {
        super(listingPrice);  //inherit attributes of Property
        setHectares(hectares);

        if (hectares <= 0) {
            throw new BadProperty("Number of hectares cannot be less or equal to 0.");
        }  //end exception
    }  //end constructor

    /** Getters */
    public double getHectares() {
        return this.hectares;
    }

    /** Setters */
    public void setHectares(double hectares) {
        this.hectares = hectares;
    }

    @Override
    public String toString() {
        return(this.getClass().getSimpleName() + ", " + getHectares() + " hectares of land, asking price $" + getListingPrice());
    }

    @Override
    public double calculateTax() {
        return 100*getHectares();  //$100/hectare of land
    }

}  //end program
