/**
 * Concrete class ApartmentBuilding inheriting from Abstract class MultiUnitBuilding
 *
 * @author Amy Tang 20130856
 * @version 1.0
 * Aug 6, 2019
 */
public class ApartmentBuilding extends MultiUnitBuilding {

    /** Unique attributes of ApartmentBuilding from MultiUnitBuilding */
    private int tenants;
    private double unitSpace;

    /**
     * Constructor of an ApartmentBuilding object
     *
     * @param listingPrice (required) asking price of property in thousands of dollars
     * @param floorSpace (required) square meters of each apartment
     * @param units (required) number of units in the building
     * @param elevator (required) true if elevator is present in building, false if not
     * @param tenants (required) number of tenants in the building
     * @param unitSpace (required) square meters of floor-space of each apartment unit
     * @throws BadProperty floor-space and/or units cannot be less or equal to zero
     */
    public ApartmentBuilding(double listingPrice, double floorSpace, int units, boolean elevator, int tenants, double unitSpace) throws BadProperty {
        super(listingPrice, floorSpace, units, elevator);  //inherit attributes from MultiUnitBuilding
        setElevator(true);  //all apartment buildings have elevators
        setTenants(tenants);
        setUnitSpace(unitSpace);

        if (unitSpace <= 0) {
            throw new BadProperty("The floor-space of each unit cannot be less or equal to 0.");
        }
    }  //end constructor

    /** Accessors */
    public int getTenants() {
        return this.tenants;
    }
    public double getUnitSpace() {
        return this.unitSpace;
    }

    /** Mutators */
    public void setTenants(int tenants) {
        this.tenants = tenants;
    }
    public void setUnitSpace(double unitSpace) {
        this.unitSpace = unitSpace;
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + ", " + getUnits() + " units, " + getUnitSpace() + " square meters in each unit, " + getTenants()
                + " tenants, " + getFloorSpace() + " square meters overall, " + isElevator() + " elevator, asking price $" + getListingPrice());
    }

    @Override
    public double calculateTax() {
        return(35*(getUnitSpace()*3.28084));  //$35/square foot floor-space of each unit, unitSpace is in meters so 1m = 3.28084ft
    }

}  //end program
