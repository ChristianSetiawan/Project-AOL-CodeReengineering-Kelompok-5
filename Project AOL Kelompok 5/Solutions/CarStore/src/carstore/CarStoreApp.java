package carstore;

/*
 * Smell Code: The comments
 * Reason: Ada comment yang diberikan untuk menjelaskan kode atau function yang kurang jelas karena adanya penamaan variabel yang tidak sesuai.
 * Soulution: Delete comments dan memperbaiki penamaan variabel
 */

/*
Authors:  All Group
partener and correction : the leader of team Wafaa Elsaeed
date : during studing at firstTerm and mid trem vacation
Summary of  Car Store App:
1- test all classes and recat with customer with buy method 
*/
import java.util.Scanner;
public class CarStoreApp {
    public static void main(String[] args) {

        CarStore newCarStore = new CarStore ("The Car Store","2520 N Salisbury Blvd", "(410) 334-3500","http://thecarstoreonline.com/",0);
        System.out.print(  newCarStore.toString() +"\n");
        printline();
            
             
        for(int i =1 ; i<=10 ;i++){
            Vehicle mac  = new NewCar( randomModel(randomMake()),randomMake(),  randomCountry(),
            randomColour(),  randomFuelType(),i,randomNumber(300,150), randomNumber(15,9),randomNumber(50000,17000),randomNumber(2017,1995) ,randomBoolean(),randomBoolean(),randomBoolean(),randomBoolean());

            newCarStore.insertCar(mac);
        }
          
        System.out.println("model \t\t\t make  \t madeIn  \tcolour  FuelType  \tYearIntroduced       "   
                + "\tspeed \t ID"
                + "\tpower \t price"
                + "\n");
        newCarStore.showInventory();
        printline() ;
        
        
         for(int i =1 ; i<=9 ;i++){
            Staff staff = new Staff(randomName(), randomCountry(),  randomNumber(23432525,23456721)+"", "employee"+i+"@carStore.com",i,
            randomPosition(),randomNumber(25532,20000),randomNumber
            (7000,3000));
            
            newCarStore.insertEmployee(staff);
        }
         
         System.out.println("Name\t Address     \t Contact Number            E-mail                  ID        "
                 + "        Position    "
                 + "                saraly      retire       ");
         
        newCarStore.showStaffDetails();
        printline() ;
       
        
       
      for(int i =1 ; i<=9 ;i++){
         Profile customer = new Profile(randomName(),randomCountry(),randomNumber(23432525,23456721)+"",
         "customer000"+i+"@gmail.com",i);
         
         newCarStore.insertCustomer(customer);}
      
         System.out.println("Name\t Address     \t Contact Number            E-mail                  ID "  );
         
         newCarStore.showCustomersDetails() ;
         printline() ;
         
     System.out.println(newCarStore.searseCar(6).toString());
             printline() ;
             
      System.out.print(buyCar(newCarStore));
      printline() ;

      
     System.out.println("test of search and delete of customer ,staff and cars ");
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Entr Id of items u want to delet or search " );
      int ID = scan.nextInt();
      
       System.out.println(newCarStore.searseCustomer(ID).toString());
       printline() ;

     System.out.println(  newCarStore.searseStaff(ID).toString());
     printline() ;

     
       newCarStore.deleteEmpoyee(ID);
       
      newCarStore.deleteCar(ID);
       
      newCarStore.deleteCustomer(ID);
      
      
    }
    
   
    
    
    

     /* 
     summary of buyCar
     parameters : car store object
     Return : string
     Description :- methed  that inteact with customer to buy car and make this process easy 
     */
     public  static String buyCar(CarStore carStore){
         String result =null ;
        System.out.println("welcome  to The Car store :)\n "
                + "for veiw inventory enter 1 \n"
                + "for search by price enter 2 \n "
                + "for search by model enter 3 \n"
                + "for search by make entre  4 \n");
        
        Scanner scan =new Scanner(System.in);
        int choise =scan.nextInt();
        
        switch(choise){
            case 1:{ carStore.showInventory();}break;
            
            case 2:{ 
                 System.out.println("Enter from and to price plz :)");
                 double from= scan.nextDouble() ;double to =scan.nextDouble();
                 carStore.searchByPrice(from, to); }break;
            
            case 3:{               
                 System.out.println("Enter model plz :)");
                 String model =scan.nextLine();
                 carStore.searchByModel(model);}break;
            case 4:{   
                 System.out.println("Enter model plz :)");
                 String make =scan.nextLine();
                 carStore.searchByMake(make);}break;}
        System.out.println("then is there any car u liked it :D plz enter 1 if u want to buy it entre any 0 if there dont");
        int choise2 =scan.nextInt();
        if(choise2==1){ 
            System.out.println("then entre it ID ");
            int ID = scan.nextInt();
             Vehicle car =carStore.searseCar(ID);
             System.out.print("here is it all details  ");
            System.out.println( car.toString());
            System.out.print( "sure u want it then go to fainlize put it price");
                double price = scan.nextDouble();
                while(checkPrice(price,car.price)!=true){
                    System.out.println("plz reput price as it lass than car price");
                    price =scan.nextInt();
                }
           System.out.print(  "  Enter this details ur name address cintact number email ");
           String name = scan.nextLine();
           String address = scan.nextLine();
           String  contactNumber = scan.nextLine();
           String email = scan.nextLine();
           Profile l = new Profile(name, address, contactNumber, email, 0);
        carStore.insertCustomer(l);

           result="name of customer :"+l.getName()+
                  "\nname of store    :  "+carStore.name
                 +"\ncar model        :" + car.model+
                  "\npaid price       :"+car.price
                + "\n remain          :"+ (price-car.price);}
          else if(choise2==2){result="thank u for visiting us :)";}
          return result;}
     
     /* 
     summary of checkPrice
     parameters :2 doubles 
     Return : boolean
     Description :-check price of car that customer put it is the same as care price or not 
     */
     public static boolean checkPrice(double price ,double carPrice){
                 return (price>=carPrice) ;}
     
     
        
     /* 
     summary of print line
     parameters : no thing
     Return : string
     Description :-print linte to seprate out in run  to make out look obvouis
     */
     public  static void printline(){System.out.println("\n---------------------------------------------------"
             + "--------------------------------------------"
             + "-------------------------------------------------------------------------------------------------\n");}
     
     /*
     summary of all following methed
     parameters : no thing
     Return : double ,string
    Description :-genrate random strings and numbers to make out look as we wanted and make it easy for run project 
     */
     
     
     
    public static int randomNumber(int up,int lower){
        return (int)(Math.random()*(up-lower)+lower);
    }

     
     
    public static boolean randomBoolean(){
        return Math.random() < 0.5;
    }
     
     
      public static String randomName(){
           int random= (int)(Math.random()*11);
       switch(random){
           case 0:return "Ahmed  ";
           case 1:return "mai    ";
           case 2:return "mahmoud";
           case 3:return "mona   ";
           case 4:return "wafaa  ";
           case 5 :return"eman   ";
           case 6 :return"fatema ";
           case 7 :return"somaya ";
           case 8:return "abeer  ";
           case 9 :return"Ayda   ";
           case 10:return"Esraa  ";
           case 11:return"salma  ";
           default:return "UN RECHABLE CODE!";
       }}
      
      public static String randomPosition(){
           int random= (int)(Math.random()*10);
       switch(random){
           case 0:return "Office Manager               " ;
           case 1:return "Title Department Laurel      " ;
           case 2:return "Title Department Salisbury   " ;
           case 3:return "Finance Manager              " ;
           case 4:return "Sales Consultant             " ;
           case 5 :return"Business Development         " ;
           case 6 :return"Business Development Manager " ;
           case 7 :return"Sales Manager                " ;
           case 8:return "Service Advisor              " ;
           case 9 :return"Service Writer               " ;
           case 10:return"Service Manager              " ;
           default:return "UN RECHABLE CODE!";
       }}
      
      
      public static String randomColour(){
           int random= (int)(Math.random()*11);
       switch(random){
           case 0:return "red    ";
           case 1:return "pink   ";
           case 2:return "thistle";
           case 3:return "violet ";
           case 4:return "purple ";
           case 5 :return"blue   ";
           case 6 :return"steelb ";
           case 7 :return"green  ";
           case 8:return "ivory  ";
           case 9:return "yellow ";
           case 10:return"wheat  ";
           case 11:return"black  ";
           default:return "UN RECHABLE CODE!";
       }}
      
      
      public static String randomMake(){
           int random= (int)(Math.random()*5);
       switch(random){
           case 0:return "Hyundai ";
           case 1:return "BMW     ";
           case 2 :return"Ferrari ";
           case 3 :return"Kia     ";
           case 4 :return"Smart   ";
           case 5 :return"Ford    ";
           default:return "UN RECHABLE CODE!";
       }
    } 
      
      
       public static String randomModel(String make){
           String model = null ;
           int random= (int)(Math.random()*2);
       switch(make){
           case "Ferrari " :{
       switch(random){
           case 0:{model = "Daytona                ";break;}
           case 1:{model = "250 GTO                ";break;}
           case 2:{model = "275                    ";break;}
           default:model = "UN RECHABLE CODE!";
       }} break;
          case "BMW     " :{ switch(random){
           case 0: model = "2017 -330 Gran Turismo "; break;
           case 1: model = "2017 BMW 328d          ";break;
           case 2: model = "2017 BMW 230           " ;break;
           default:model = "UN RECHABLE CODE!";break;
       }} break; 
      case "Kia     ":{ switch(random){
           case 0: model = "2017 Kia Cadenza       ";break;
           case 1: model = "2016 Kia Sorento       ";break;
           case 2: model = "2016 Kia Optima        ";break;
           default:model = "UN RECHABLE CODE!";break;
      }} break;
       case"Hyundai ":{ switch(random){
           case 0:model =  "2017 Hyundai           ";break;
           case 1:model =  "2016 Hyundai Accent    ";break;
           case 2:model =  "2016 Hyundai Genes Cope";break;
          default:model="UN RECHABLE CODE!";break;
       }} break;
     case "Smart   " :{ switch(random){
           case 0 :model = "2016 smart fortwo      ";break;
           case 1: model = "2016 F2 Electric D     ";break;
           case 2: model = "2017 smart fortwo      ";break;
           default:model = "UN RECHABLE CODE!";break;
     }}break;
            case  "Ford    ":{ switch(random){
           case 0: model = "2016 Ford Flex         ";break;
           case 1: model = "2016 Ford C-Max Hybrid ";break;
           default:model = "UN RECHABLE CODE!";break;
           }} break;
       } return model;}
       
       
       
        
        public static String randomCountry(){
           int random= (int)(Math.random()*11);
       switch(random){
           case 0:return "China        ";
           case 1:return "United States";
           case 2:return "Japan        ";
           case 3:return "Germany      ";
           case 4:return "egypt        ";
           case 5 :return"India        ";
           case 6 :return"Turkey       ";
           case 7 :return"Iran         ";
           case 8:return "Portugal     ";
           case 9 :return"Kenya        ";
          case 10 :return"Belgium      ";
          case 11 :return"Peru         ";
           default:return "UN RECHABLE CODE!";
       }
    } 
        
        
         public static String randomFuelType(){
           int random= (int)(Math.random()*4);
       switch(random){
           case 0:return "Petrol  ";
           case 1:return "Diesel  ";
           case 2:return "LPG     ";
           case 3:return "gas     ";
           case 4:return "Biofuels";
           default:return "UN RECHABLE CODE!";
       }}
         
         
        
  
}
