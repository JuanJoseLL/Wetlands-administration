package model;

import java.time.LocalDate;
/**
 * Package model
 * Class Wetland
 */                
public class Wetland {
    public static final int MAXSPECIES=100;
    public static final int MAXEVENT=100;
    //atributes
    private String name;
    private double km;
    private String photo;
    private boolean protectedArea;
    private String areaName;
    private int likes;
    //relations
    private TypeWetland type;
    private WetlandUbication ubication;
    private Speci[] specie;
    private Event[] events;
    public Wetland(String name, int ubi, int ty, double km, String photo, boolean protectedArea,
            String areaName,int likes) {
        this.name = name;
        this.km = km;
        this.photo = photo;
        this.protectedArea = protectedArea;
        this.areaName = areaName;
        this.likes=likes;
        specie=new Speci[MAXSPECIES];
        events=new Event[MAXEVENT];
        switch(ubi){
            case 1: setUbication(WetlandUbication.RURAL);
            break;
            case 2:setUbication(WetlandUbication.URBAN);
        }
        switch(ty){
            case 1: type=TypeWetland.PUBLIC;
            break;
            case 2: type=TypeWetland.PRIVATE;
            break;
        }

    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public TypeWetland getType() {
        return type;
    }
    public void setType(TypeWetland type) {
        this.type = type;
    }
    public WetlandUbication getUbication() {
        return ubication;
    }
    public void setUbication(WetlandUbication ubication) {
        this.ubication = ubication;
    }
    public  Event[] getEvents() {
        return events;
    }
    public  void setEvents(Event[] events) {
        this.events = events;
    }
    public Speci[] getSpecie() {
        return specie;
    }
    public void setSpecie(Speci[] specie) {
        this.specie = specie;
    }
    public String getName() {
        return name;
    }
    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public boolean isProtectedArea() {
        return protectedArea;
    }
    public void setProtectedArea(boolean protectedArea) {
        this.protectedArea = protectedArea;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public double getKm() {
        return km;
    }
    public void setKm(double km) {
        this.km = km;
    }
 
    public void setName(String name) {
        this.name = name;
   }
   /**
    * This method adds the obj specie tho the position of the array where is null
    * Name: addSpecies
    * postCondition: The species is added correctly
    * @param name The name of the species
    * @param scientific The scientific name of the species
    * @param prot the species is migratory or not
    * @param type The animal kingdom ehre the species belong 
    * @return a The message of the procces being completed 
    */
   public String addSpecies(String name, String scientific,boolean prot,int type){
       String a="";
       boolean contineu=false;
       for (int i=0;i<MAXSPECIES && contineu==false;i++){
           if (specie[i]==null){
                specie[i]=new Speci(name,scientific,prot,type);
                a="Species added correctly";
                contineu=true;
           }
           if (contineu==false){
               a="Array of species is full, you cant add more";
           }
        }
       return a;
   }
   /**
    * This method adds the obj event to the array of events, in a position where is null
    * Name: addEvent
    * postCondition: The event is added correctly 
    * @param name
    * @param description
    * @param value
    * @param date
    * @param descriptionEvent
    * @return a message of the process being completed 
    */
   public String addEvent(String name,int description,double value,LocalDate date,String descriptionEvent){
       String a="";
        boolean contineu=false;
        for (int i=0;i<MAXEVENT && contineu==false;i++){
            if (events[i]==null){
                events[i]=new Event(name,description,value,date,descriptionEvent);
                a="Event added correctly";
                contineu=true;
            }
            if (contineu==false){
                a="Array of events is full, you cant add more";
            }
        }
       return a;
   }
   /**
    * This method gets the types of the events and year, when it matchs with the input it add 1 to the counter 
    * Name: amountMainteinment
    * @param year The year that you want to chec maintenances 
    * @return k the amount of maintenances in a year of a wetland
    */
   public int amountMainteinment(int year){
       int k=0;
       for (int i=0;i<MAXEVENT;i++){
           if (events[i]!=null){
               if (events[i].getDescription().equals(TypeEvent.MAINTENANCE) && events[i].getDate().getYear()==year){
                    k++;
               }
           } 
       }
       return k;
   }
   /**
    * This method search the type of species added in a position of the array, and when it found a match, adds 1 to the counter 
    * Name: leastFlora
    * @return cont the number of flora foud in a wetland 
    */
   public int leastFlora(){
       int cont=0;
       for (int i=0;i<MAXSPECIES;i++){
           if (specie[i]!=null){
             if(specie[i].getType().equals(FloraFauna.ACUATIC_FLORA)||(specie[i].getType().equals(FloraFauna.TERRESTRIAL_FLORA))){
                    cont++;
             }
           }
       }
      

       return cont;
   }
   /**
    * This method find a specific species in the array of species
    * Name: findSpecies
    * @param name The name of the species that you want to search
    * @return a The confirmation of the species found int the array
    */
   public String findSpecies(String name){
       String message="";
       String result="";
       String a="";
       for (int i=0;i<MAXSPECIES;i++){
           if(specie[i]!=null){
                if (specie[i].getName().equals(name)){
                    message="The species "+name+" is found in the wetland ";
                    a=result.concat(message);
                }
            }
       }
       return a;
   }
   /**
    * This method search the type of species added in a position of the array, and when it found a match, adds 1 to the counter
    * Name: diverseWetland
    * @return count the number of animals found in the array 
    */
   public int diverseWetland(){
       int count=0;
       for (int i=0;i<MAXSPECIES;i++){
           if (specie[i]!=null){
               if(specie[i].getType().equals(FloraFauna.ACUATIC)||specie[i].getType().equals(FloraFauna.BIRD)||specie[i].getType().equals(FloraFauna.MAMMAL))
                count++;
           }
       }
       return count;
   }
   /**
    * This method count the amount of types of species in the array of species 
    * Name: infoSpecies
    * @return message taht shows the amount of species per type in the aray
    */
   public String infoSpecies(){
       
       int acuatic=0;
       int bird=0;
       int mammal=0;
       int acuaticFlora=0;
       int terrestrialFlora=0;
       String message="";
       for(int i=0;i<MAXSPECIES;i++){
           if(specie[i]!=null){
               if (specie[i].getType().equals(FloraFauna.ACUATIC))
                   acuatic++;
               if (specie[i].getType().equals(FloraFauna.MAMMAL))
                   mammal++;
               if (specie[i].getType().equals(FloraFauna.BIRD))
                   bird++;
               if (specie[i].getType().equals(FloraFauna.ACUATIC_FLORA))
                  acuaticFlora++;
               if (specie[i].getType().equals(FloraFauna.TERRESTRIAL_FLORA))
                  terrestrialFlora++;
           }
       }
       message="Amount species :\n Acuatic : "+acuatic+"\n Mammal : "+mammal+"\n Bird : "+bird+"\n Acuatic flora : "+acuaticFlora+"\n Terrestrial flora : "+terrestrialFlora;
       return message;
   }

}
