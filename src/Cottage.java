/**
 * Concrete class Cottage inheriting from Concrete class House
 *
 * @author Amy Tang 20130856
 * @version 1.0
 * Aug 6, 2019
 */
public class Cottage extends House {

    /** Unique attribute of Cottage from House */
    private double lakeFrontage;

    /**
     * Constructor of Cottage object
     *
     * @param listingPrice (required) asking price of property in thousands of dollars
     * @param floorSpace (required) square meters of each cottage
     * @param bedrooms (required) numbers of bedrooms in cottage
     * @param bathrooms (required) number of bathrooms in cottage
     * @param widthLot (required) meters of width of property
     * @param depthLot (required) meters of depth of property
     * @param house (required) type of house of enum type (TOWNHOUSE, DETACHED, DUPLEX, WATERFRONT_HOME)
     * @param lakeFrontage (required) lake frontage of cottage
     * @throws BadProperty if lake frontage is less or equal to zero
     */
    public Cottage(double listingPrice, double floorSpace, int bedrooms, int bathrooms, double widthLot, double depthLot, HouseType house, double lakeFrontage) throws BadProperty {
        super(listingPrice, floorSpace, bedrooms, bathrooms, widthLot, depthLot, house);  //inherit attributes from House
        setHouse(HouseType.WATERFRONT_HOME);  //all Cottages are House objects with enum type WATERFRONT_HOME
        setLakeFrontage(lakeFrontage);

        if (lakeFrontage <= 0) {
            throw new BadProperty("Lake Frontage cannot be less or equal to 0.");
        }
    }  //end constructor

    /** Getter */
    public double getLakeFrontage() {
        return this.lakeFrontage;
    }

    /** Setter */
    public void setLakeFrontage(double lakeFrontage) {
        this.lakeFrontage = lakeFrontage;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + ", " + getWidthLot() + " m width by " + getDepthLot() + " m deep lot, " + getBedrooms() + " bedrooms, " + getBathrooms()
                + " bathrooms, " + getLakeFrontage() + " meter lake frontage, " + getFloorSpace() + " square meter building, asking price $" + getListingPrice());
    }

    @Override
    public double calculateTax() {
        return (2000 + 2*getLakeFrontage());  //$2000 initially and $2/meter lake frontage
    }

}  //end program
