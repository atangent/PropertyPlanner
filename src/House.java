/**
 * Concrete class House inheriting from Abstract class Property
 *
 * @author Amy Tang 20130856
 * @version 1.0
 * Aug 6, 2019
 */
public class House extends Property {

    /** Unique attributes of House from Property */
    private double depthLot;
    private double floorSpace;
    private double widthLot;
    private int bedrooms;
    private int bathrooms;

    private HouseType classification;

    /** Enum House types */
    enum HouseType {TOWNHOUSE, DETACHED, DUPLEX, WATERFRONT_HOME};

    /**
     *
     * @param listingPrice (required) asking price of property in thousands of dollars
     * @param floorSpace (requireD) square meters of each house
     * @param bedrooms (required) number of bedrooms in each house
     * @param bathrooms (required) number of bathrooms in house
     * @param widthLot (required) meters of width of property
     * @param depthLot (required) meters of depth of property
     * @param classification (required) type of enum house type (TOWNHOUSE, DETACHED, DUPLEX, WATERFRONT_HOME)
     * @throws BadProperty number of bedrooms and/or bathrooms cannot be less or equal to zero; house type must be valid enum type
     */
    public House(double listingPrice, double floorSpace, int bedrooms, int bathrooms, double widthLot, double depthLot, HouseType classification) throws BadProperty {
        super(listingPrice);  //inherit attributes of Property
        setFloorSpace(floorSpace);
        setBedrooms(bedrooms);
        setBathrooms(bathrooms);
        setWidthLot(widthLot);
        setDepthLot(depthLot);
        setHouse(classification);

        if (bedrooms == 0) {
            throw new BadProperty("Number of bedrooms cannot be 0.");
        }  else if (bathrooms == 0) {
            throw new BadProperty("Number of bathrooms cannot be 0.");
        }  else if (!isValidEnum(classification)) {  //if enum HouseType does not contain House param HouseType
            throw new BadProperty("House Type must be one of the following: TOWNHOUSE, DETACHED, DUPLEX, WATERFRONT_HOME");
        }  //end exceptions

    }  //end constructor

    /** Getters */
    public double getFloorSpace() {
        return this.floorSpace;
    }
    public int getBedrooms() {
        return this.bedrooms;
    }
    public int getBathrooms() {
        return this.bathrooms;
    }
    public double getWidthLot() {
        return this.widthLot;
    }
    public double getDepthLot() {
        return this.depthLot;
    }
    public HouseType getHouse() {
        return this.classification;
    }

    /** Setters */
    public void setFloorSpace(double floorSpace) {
        this.floorSpace = floorSpace;
    }
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }
    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }
    public void setWidthLot(double widthLot) {
        this.widthLot = widthLot;
    }
    public void setDepthLot(double depthLot) {
        this.depthLot = depthLot;
    }
    public void setHouse(HouseType house) {
        this.classification = house;
    }

    /**
     * Method checks if Office param HouseType classification is a valid enum HouseType
     *
     * @param classification (required) office type of House object
     * @return boolean if enum HouseType contains House param HouseType, therefore if input is valid
     */
    private boolean isValidEnum(HouseType classification) {
        HouseType[] validHouseType = HouseType.values();  //all the enum types in enum HouseType
        for (HouseType house : validHouseType) {
            if (house.equals(classification)) {  //if House param HouseType exists in enum HouseType
                return true;
            }
        }
        return false;
    }  //end method

    @Override
    public String toString() {
        return (getHouse() + " " + this.getClass().getSimpleName() + ", " + getWidthLot() + " m width by " + getDepthLot() + " m deep lot, " + getBedrooms()
                + " bedrooms, " + getBathrooms() + " bathrooms, " + getFloorSpace() + " square meter building, asking price $" + getListingPrice());
    }

    @Override
    public double calculateTax() {
        return (1000 + 50*getBedrooms() + 10*getFloorSpace());  //$1000 initially + $50/bedrooms + $10/square meter floor space
    }
}  //end program
