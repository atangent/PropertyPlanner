import java.util.ArrayList;

/**
 * Test code for PropertyPlanner
 *
 * @author Amy Tang 20130856
 * @version 1.0
 * Aug 6, 2019
 */
public class Test {
    public static void main(String[] args) throws BadProperty {
        ArrayList<Property> propertyDB = new ArrayList<>();
        //create Property objects
        System.out.println("Testing toString() for objects of each concrete Class...");
        propertyDB.add(new House(300, 230, 5, 5, 90, 120, House.HouseType.DETACHED));
        propertyDB.add(new Cottage(245, 112, 3, 2, 60, 70, House.HouseType.WATERFRONT_HOME, 23));
        propertyDB.add(new Land(430, 526));
        propertyDB.add(new Farm(100, 120, "corn"));
        propertyDB.add(new ApartmentBuilding(500, 122, 99, false, 3240, 1000));
        propertyDB.add(new Office(200, 320, 117, true, Office.OfficeType.SALES));  //class.enum.enumType because not in direct class

        for (Property property : propertyDB) {
            System.out.println(property);
        }
        System.out.println("\n");

        //comparisons
        System.out.println("Testing compareTo method...");
        for (int i = 0; i < propertyDB.size(); i +=2) {  //index increments by 2 to compare pair by pair
            System.out.println(propertyDB.get(i).compareTo(propertyDB.get(i+1)));  //compares each adjacent pair in list
        }  //should give differences of $55000.0, $330000.0, $300000.0 in order
        System.out.println("\n");

        //getters and setters
        System.out.println("Testing accessors and mutators...");
        Cottage cotty = new Cottage(543, 109, 2, 1, 51, 56, House.HouseType.WATERFRONT_HOME, 5);
        System.out.println("Before: " + cotty);
        System.out.println("Set lake frontage to 3.14159 meters");
        cotty.setLakeFrontage(3.14159);
        System.out.println("After: " + cotty);
        System.out.println("Get floorspace of cottage: " + cotty.getFloorSpace() + " square meters ");  //109.0
        System.out.println("\n");

        //taxes
        System.out.println("Testing calculateTax method...");
        for (Property property : propertyDB) {
            System.out.println(property.getClass().getSimpleName() + " tax: $" + property.calculateTax());
        }
        System.out.println("\n");

        //tax discounts
        System.out.println("Testing tax discounts...\n All the following offices have the same listing price, floor space, and units: ");
        System.out.println("Yes elevators, Sales Office tax with NO discount: $" + new Office(890, 890, 87, true, Office.OfficeType.SALES).calculateTax());  //10690.0
        System.out.println("No elevators, Sales Office tax with NO discount: $" + new Office(890, 890, 87, false, Office.OfficeType.SALES).calculateTax());  //10640.0
        System.out.println("No elevators, Industrial Office tax with 15% discount: $" + new Office(890, 890, 87, false, Office.OfficeType.INDUSTRIAL).calculateTax());  //9044.0
        System.out.println("\n");

        //exceptions
        System.out.println("Testing BadProperty exceptions...");
        //Property listingPrice0 = new Farm(-90, 80, "food");
        //Property hectares0 = new Land(90, 0);
        //Property cropEmpty = new Farm(90, 90, "");
        //Property bedrooms0 = new House(90, 120, 0, 2, 80, 80, House.HouseType.TOWNHOUSE);
        //Property bathrooms0 = new House(90, 120, 3, 0, 80, 80, House.HouseType.TOWNHOUSE);
        //Property lakeFrontage0 = new Cottage(90, 120, 2, 2, 80, 80, House.HouseType.TOWNHOUSE, 0);
        //Property units0 = new Office(670, 670, 0, true, Office.OfficeType.SALES);
        //Property floorSpace0 = new ApartmentBuilding(670, 0, 90, true, 90);
        //Property unitSpace0 = new ApartmentBuilding(670, 79, 25, true, 2, 0);
        //Property invalidEnum = new Office(89, 253, 76, false, Office.OfficeType.DETACHED);
        System.out.println("\n");
    }  //end main

}  //end test program
