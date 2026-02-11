public class VehicleMain {
    // Main Method 
   public static void main(String[] args) { 
       Vehicle v = new Vehicle(); 
       v.brandname = "Hector"; 
       v.modelname = "MG"; 
       v.yearofmfg = java.time.Year.of(2025); 
       v.color = "Navy"; 
       v.fueltype = 'D'; 
       v.price = 6500000; 
       v.seats = 5; 
       Vehicle.vehicleDetails(v); 
       Vehicle v1 = new Vehicle("KIA", "Carens", 1200000, "Silver"); 
       Vehicle.vehicleDetails(v1); 
       Vehicle v2 = new Vehicle('P', 2000000, "H12qwe23"); 
       Vehicle.vehicleDetails(v2); 
       System.out.println("The mileage of v1 is: " + v1.calcMileage(35.5f, 200)); 
       Vehicle[] garage = { v, v1, v2 }; 
       System.out.println("\nBrand\tModel\tYear\tColor\tFuel\tSeats\tPrice\tMileage\tMfgCode\tServices"); 
       for (Vehicle g : garage) { 
           g.accelerate(20); 
           double m; 
           if (g.fueltype == 'D') { 
               m = g.calcMileage(50, 500); 
           } else if (g.fueltype == 'P' || g.fueltype == 'C') { 
               m = g.calcMileage(40, 500); 
           } else { 
               m = 0;
                } 
           Vehicle.printTabular(g, m); 
       } 
   }
}