public class Vehicle { 
   public String brandname; 
   public String modelname; 
   public java.time.Year yearofmfg; 
   public String color; 
   public char fueltype; // P=petrol,E=electric,D=diesel,C=cng 
   public float price; 
   public int seats; 
   private String mfgcode; 
   private int noofservices; 
   // Setters & Getters 
   public void setMfgCode(String mCode) { 
       mfgcode = mCode; 
   } 
   public String getMfgCode() { 
       return mfgcode; 
   } 
   public void setnoofservices(int n) { 
       noofservices = n; 
   } 
   public int getnoofservices() { 
       return noofservices; 
   } 
   // Constructors 
   public Vehicle() { 
       brandname = "MG"; 
       modelname = "Hector"; 
       yearofmfg = java.time.Year.of(2025); 
       color = "Red"; 
       fueltype = 'P'; 
       seats = 5; 
       price = 115000.45f; 
   } 
   public Vehicle(String brandname, String modelName, float price, String 
color) { 
       this.brandname = brandname; 
       this.modelname = modelName; 
       this.price = price; 
       this.color = color; 
       this.yearofmfg = java.time.Year.now(); 
       this.fueltype = 'P'; 
       this.seats = 5; 
   } 
   public Vehicle(char fueltype, float price, String mfgcode) { 
       this.fueltype = Character.toUpperCase(fueltype); 
       this.price = price; 
       this.mfgcode = mfgcode; 
       this.yearofmfg = java.time.Year.now(); 
       this.brandname = "Generic"; 
       this.modelname = "ModelX"; 
       this.color = "Black"; 
       this.seats = 5; 
   } 
   // Methods 
   public void start() { 
       System.out.println("Start Ignition by pressing the button"); 
       System.out.println("Your initial Speed is 10 kmph"); 
   } 
   public void drive() { 
       System.out.println("Let's Go!"); 
   } 
   public void accelerate(int initSp) { 
       int speed = initSp + 20; 
   } 
   public void stop() { 
       System.out.println("Stop Ignition by pressing the button"); 
       System.out.println("Your Vehicle is stopped!"); 
   } 
   public float calcMileage(float fuelAmt, float distance) { 
       if (fuelAmt <= 0) return 0; 
       return distance / fuelAmt; 
   } 
   public static void vehicleDetails(Vehicle ve) { 
       System.out.println("------------------------------------------"); 
       System.out.println("Vehicle Details:"); 
       System.out.println("Brand Name: " + ve.brandname); 
       System.out.println("Model: " + ve.modelname); 
       System.out.println("Year of Manufacturing: " + ve.yearofmfg); 
       System.out.println("Fuel Type: " + ve.fueltype); 
       System.out.println("Price: " + ve.price); 
       System.out.println("Seating Capacity: " + ve.seats); 
       System.out.println("------------------------------------------"); 
   } 
   public static void printTabular(Vehicle v, double m) { 
       System.out.println( 
           v.brandname + "\t" + 
           v.modelname + "\t" + 
           v.yearofmfg + "\t" + 
           v.color + "\t" + 
           v.fueltype + "\t" + 
           v.seats + "\t" + 
           v.price + "\t" + 
           m + "\t" + 
           v.getMfgCode() + "\t" + 
           v.getnoofservices() 
       ); 
   }
}