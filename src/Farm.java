/**
 * Concrete class Farm inheriting from Concrete class Land
 *
 * @author Amy Tang 20130856
 * @version 1.0
 *  Aug 6, 2019
 */
public class Farm extends Land {

    /** Unique attribute of Farm that is different from Land */
    private String crop;

    /**
     * Constructor of a Farm object
     *
     * @param listingPrice (required) asking price of property in thousands of dollars
     * @param hectares (required) number of hectares of property
     * @param crop (required) indicates the crop that is grown on farm
     * @throws BadProperty the number of hectares cannot be less or equal to zero
     */
    public Farm (double listingPrice, double hectares, String crop) throws BadProperty {
        super(listingPrice, hectares);  //inherits all attributes from Land
        setCrop(crop);

        if (crop.equals("")) {
            throw new BadProperty("Crop entry cannot be an empty string or null.");
        }
        //end exception
    }  //end constructor

    /** Getters */
    public String getCrop() {
        return crop;
    }

    /** Setters */
    public void setCrop(String crop) {
        this.crop = crop;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + ", " + getHectares() + " hectares of land, " + getCrop() + " grown, asking price $" + getListingPrice());
    }

    @Override
    public double calculateTax() {
        return (50*getHectares());  //$50/hectare of land
    }

}  //end program
