/**
 * Concrete class Office inheriting Abstract class MultiUnitBuilding
 *
 * @author Amy Tang 20130856
 * @version 1.0
 * Aug 6, 2019
 */
public class Office extends MultiUnitBuilding {

    /** Unique attributes of Office from MultiBuilding */
    private OfficeType classification;

    /** Enum classification of types of offices */
    enum OfficeType {SERVICE, SALES, INDUSTRIAL};  //constant values

    /**
     * Constructor of an Office object
     *
     * @param listingPrice (required) asking price for property in thousands of dollars
     * @param floorSpace (required) square meters of each office
     * @param units (requireD) number of units in office building
     * @param elevator (required) true if elevator is present in elevator, false if not
     * @param classification (requireD) enum type of office purposes (SERVICE, SALES, INDUSTRIAL)
     * @throws BadProperty office type must be a valid enum type as named above
     */
    public Office(double listingPrice, double floorSpace, int units, boolean elevator, OfficeType classification) throws BadProperty {
        super(listingPrice, floorSpace, units, elevator);  //inherits attributes of a MultiUnitBuilding
        setOffice(classification);

        if (!isValidEnum(classification)) {  //if enum list does not contain classification input
            throw new BadProperty("Office classification must be one of the following: SERVICE, SALES, INDUSTRIAL.");
        }
    }  //end constructor

    /** Getters */
    public OfficeType getOffice() {
        return this.classification;
    }

    /** Setters */
    public void setOffice(OfficeType classification) {
        this.classification = classification;
    }

    /**
     * Method checks if Office param OfficeType classification is a legal enum OfficeType
     *
     * @param classification (required) office type of Office object
     * @return boolean if enum OfficeType contains Office param OfficeType, therefore if input is legal
     */
    private boolean isValidEnum(OfficeType classification) {
        OfficeType[] validEnums = OfficeType.values();
        for (OfficeType office : validEnums) {
            if (classification.equals(office)) {  //if param office type is a legal office type
                return true;
            }
        }  //end loop
        return false;
    }  //end method

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + ", " + getOffice() + " purpose, " + getUnits() + " units, " + getFloorSpace()
                + " square meter building, " + isElevator() + " elevator, asking price $" + getListingPrice());
    }  //end method

    @Override
    public double calculateTax() {
        double flatTax = 10 * getFloorSpace() + 20 * getUnits();  //tax of office without elevator and without discounts

        if (isElevator()) {  //if there is an elevator
            if (getOffice() == OfficeType.INDUSTRIAL) {
                return (flatTax + 50.0) * 0.85;  //15% discount, 100%-15% = 85%
            } else if (getOffice() == OfficeType.SERVICE) {
                return (flatTax + 50.0) * 0.95;  //5% discount, 100%-5% = 95%
            } else {
                return flatTax + 50.0;  //no discount for SALES office
            }
        } else {  //no elevator
            if (getOffice() == OfficeType.INDUSTRIAL) {
                return flatTax * 0.85;  //15% discount, 100%-15% = 85%
            } else if (getOffice() == OfficeType.SERVICE) {
                return flatTax * 0.95;  //5% discount, 100%-5% = 95%
            } else {
                return flatTax;  //no discount for SALES office
            }
        }
    }  //end method

}  //end program
