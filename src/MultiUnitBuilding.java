/**
 * Abstract class MultiUnitBuilding inheriting Abstract class Property
 *
 * @author Amy Tang 20130856
 * @version 1.0
 * Aug 6, 2019
 */
public abstract class MultiUnitBuilding extends Property {  ///abstract class because no direct use of calculateTax() from class Property

    /** Unique attributes of MultiUnitBuilding from Property */
    private double floorSpace;
    private int units;
    private boolean elevator;

    /**
     * Constructor of a MultiUnitBuilding object
     *
     * @param listingPrice (required) asking price for property in thousands of dollars
     * @param floorSpace (required) square meters of each multi-unit building
     * @param units (required) number of units in building
     * @param elevator (required) true if elevator is present in building, false if not
     * @throws BadProperty number of units and/or floor-space measurements cannot be less or equal to zero
     */
    public MultiUnitBuilding(double listingPrice, double floorSpace, int units, boolean elevator) throws BadProperty {
        super(listingPrice);  //inherits attributes from Property
        setFloorSpace(floorSpace);
        setUnits(units);
        setElevator(elevator);

        if (units <= 0) {
            throw new BadProperty("Number of units cannot be less or equal to 0.");
        }
        if (floorSpace <= 0) {
            throw new BadProperty("Floor-space cannot be less or equal to 0.");
        }  //end exception
    }  //end constructor

    /** Getters */
    public double getFloorSpace() {
        return this.floorSpace;
    }
    public int getUnits() {
        return this.units;
    }
    public boolean isElevator() {
        return this.elevator;
    }

    /** Setters */
    public void setFloorSpace(double floorSpace) {
        this.floorSpace = floorSpace;
    }
    public void setUnits(int units) {
        this.units = units;
    }
    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + ", " + getUnits() + " units, " + getFloorSpace()
                + " square meter building, " + isElevator() + " elevator, asking price $" + getListingPrice());
    }  //end toString

}  //end program
