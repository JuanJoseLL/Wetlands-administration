package ui;
import java.util.Scanner;
import java.time.LocalDate;
import model.*;
/** 
*Class Main
*package ui
*@author Juan José López 
*@date 7/04/2022
*/
public class Main{
public static Scanner lt=new Scanner(System.in);
    public static void main(String[] args) {

        Dagma objDagma=new Dagma();
        int option=0;
        boolean continue1=false;
        while (continue1==false){
            System.out.println(" 1. Register wetland \n 2. Add species \n 3. Register event \n 4. Amount maintenment \n 5. Deploy wetlands info \n 6. Show the wetland with most animals \n 7. Show the wetland with least flora  \n 8. Show the wetlands where a species is located \n 0. Exit");
            option=lt.nextInt();
            lt.nextLine();
            switch (option){
                    case 1: {String u=registerWetland(objDagma);
                        System.out.println(u);}
                    break;
                    case 2: {String o=addSpecies(objDagma);
                        System.out.println(o);
                    break;}
                    case 3: {String c=registerEvent(objDagma);
                        System.out.println(c);
                    break;}
                    case 4: {String a=amountMainteinment(objDagma);
                        System.out.println(a);
                    break;}
                    case 5: {String b=deployInformation(objDagma);
                        System.out.println(b);
                    break;}
                    case 6: {String h=mostDiverseWetland(objDagma);
                        System.out.println(h);
                    break;}
                    case 7: {String q=leastFloraSpecies(objDagma);
                        System.out.println(q);
                    break; }
                    case 8: {String j=findSpecies(objDagma);
                        System.out.println(j);
                    break;}
                    case 9:{}
                    case 0:{continue1=true;
                    break;}
                
             }
        }
    }
     /** 
     * This method collect the data necesary to create a wetland and sends them to the class Dagma
     * Name: registerWetland
     * postCondition: The wetland is registered succesfully. 
     * @param objDagma The object of the controller class, where the array of wetlands is located
     * @return message The message that says if the procces was completed or if wasn`t
     */
    public static String registerWetland(Dagma objDagma){
        boolean prot2;
        System.out.println("Type the name of the wetland");
        String name=lt.nextLine();
        System.out.println("Type the zone where the wetland its located 1. rural 2. urban )");
        int ubication=lt.nextInt();
        lt.nextLine();
        System.out.println("Type if the wetland its 1. public or 2. private");
        int type=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the square kilometers of the wetland");
        double km=lt.nextDouble();
        lt.nextLine();
        System.out.println("Put the url of the photo");
        String photo=lt.nextLine();
        System.out.println("Is the wetland a protected area?, 1. yes 2. no");
        int prot=lt.nextInt();
        lt.nextLine();
        if (prot==1){
            prot2=true;
        }
        else{prot2=false;}
        System.out.println("Type the name of the zone where the wetland its located");
        String location=lt.nextLine();
        int likes=0;
        String message=objDagma.addWetland(name,ubication,type,km,photo,prot2,location,likes);
        return message;

    }
    /**
     * This method collects the data of the new species and sends them to the class Dagma
     * Name: addSpecies
     * postCondition: A species is registerd succesfully
     * @param a The object of the controller class, where the array of wetlands is located
     * @return message The message that says if the procces was completed or if wasn`t
     */

    public static String addSpecies(Dagma a){
        boolean prot;
        System.out.println("Type the name of Wetland that you want to add the species");
        String wetland=lt.nextLine();
        System.out.println("Type the name of the species");
        String name=lt.nextLine();
        System.out.println("Type the scientific name of the spcies");
        String scientificName=lt.nextLine();
        System.out.println("The species, its migratory? 1. yes 2. no ");
        int migratory=lt.nextInt();
        lt.nextLine();
        if (migratory==1){
            prot=true;
        }
        else{prot=false;}
        System.out.println("Put the type of the spcecies 1. Mammal 2. Acuatic 3. Bird 4. Acuatic flora 5. Terrestrial flora ");
        int type=lt.nextInt();
        lt.nextLine();
        String message=a.addSpecies(wetland,name,scientificName,prot,type);
        return message;

    }
    /**
     * This method collects the data of the new event and sends them to the class Dagma 
     * Name: registerEvent
     * postCondition: An event is registered succesfully
     * @param a The object of the controller class, where the array of wetlands is located
     * @return message The message that says if the procces was completed or if wasn`t
     */
    public static String registerEvent(Dagma a){
        System.out.println("Type the name of the Wetland where the event is going to be done");
        String wetland=lt.nextLine();
        System.out.println("Who does the event?");
        String name=lt.nextLine();
        System.out.println("Enter the type of the event \n 1. Maintenance \n 2. School visit \n 3. Improvement activities \n 4. Celebrations");
        int description=lt.nextInt();
        lt.nextLine();
        System.out.println("Introduce the value of the event");
        double value=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the description of the event ");
        String descriptionEvent=lt.nextLine();
        System.out.println("Type the day wich the event is going to be done");
        int day=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the month ");
        int month=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the year ");
        int year=lt.nextInt();
        lt.nextLine();
        LocalDate fecha=LocalDate.of(year,month,day);
        String message=a.addEvent(wetland,name,description,value,fecha,descriptionEvent);
        return message;
    }
    /**
     * This method asks the year that you want to chekck the maintenances and calls other method in class Dagma
     * Name: amountMainteinment
     * @param a The object of the controller class, where the array of wetlands is located
     * @return message The message that says if the procces was completed or if wasn`t
     */
    public static String amountMainteinment(Dagma a){
        System.out.println("Type the year that you want to know the amount of maintenments");
        int year=lt.nextInt();
        lt.nextLine();
        String b=a.amountMainteinment(year);

        return b;
    }
    /**
     * 
     * Name: leastFloraSpecies
     * @param a The object of the controller class, where the array of wetlands is located
     * @return message The message that says if the procces was completed or if wasn`t
     */
    public static String leastFloraSpecies(Dagma a){
        String b="";
        b=a.leastFlora();
        return b;
    }
    /**
     * Name: deployInformation
     * @param b The object of the controller class, where the array of wetlands is located
     * @return message The message that says if the procces was completed or if wasn`t
     */
    public static String deployInformation(Dagma b){
        String a=b.deployInfo();
        return a;
    }
    /**
     * Name: findSpecies
     * @param b The object of the controller class, where the array of wetlands is located
     * @return message The message that says if the procces was completed or if wasn`t
     */
    public static String findSpecies(Dagma b){
        System.out.println("Type the name of the species that you want to know in wich wetlands is located ");
        String name=lt.nextLine();
        String a=b.findSpecies(name);
        return a;
    }
    /**
     * Name: mostDiverseWetland
     * @param a The object of the controller class, where the array of wetlands is located
     * @return message The message that says if the procces was completed or if wasn`t
     */
    public static String mostDiverseWetland(Dagma a){
        String message=a.diverseWetland();
        return message;
    }
   
}