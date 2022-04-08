package model;

import java.time.LocalDate;
/**
 * Class Dagma
 * Package model
 */
public class Dagma {
    public static final int MAXWTLAND=80;
    //relaciones
    private static Wetland[] wetlands;
     //metodos
    public Dagma() {
        wetlands=new Wetland[MAXWTLAND];

    }
    public Wetland[] getWetlands() {
        return wetlands;
    }
    public void setWetlands(Wetland[] wetlands) {
        Dagma.wetlands = wetlands;
    }
    
    /** 
     * This method searchs in the array of wetlands a wetland with the same name, to check if its repeated
     * Name: existWetland 
     * @param name The name of the wetland, to know if its repeated
     * @return boolean true if its repeated, false if it´s not
     * 
     */
    public boolean existWetland(String name){
        boolean exist=false;
        for (int i=0;i<MAXWTLAND && exist==false;i++){
            if (wetlands[i]!=null){
                if(wetlands[i].getName().equals(name)){
                    exist=true;
                }
            }
        }
        return exist;
    }
    
    /** 
     * This method adds a wetland to the array of wetlands 
     * Name: addWetland
     * @param name The name of the wetland
     * @param ubication The ubication of the wetland
     * @param type the type of the wetland
     * @param km The square kilometers of the wetland
     * @param photo the url photo of the wetland
     * @param prot2 The wetland is protected or not 
     * @param location The name of the location of the wetland
     * @param likes 
     * @return String message of the state of the process
     */
    public String addWetland(String name, int ubication, int type, double km, String photo, boolean prot2, String location,int likes){
        String message="";
        boolean continuar=true;
        likes=0;
        boolean repeatedWetland=existWetland(name);
        if (repeatedWetland==true)
            message="The wetland already exist";
        else{   for (int i=0;i<80 && continuar==true;i++){
                if (wetlands[i]==null){
                    wetlands[i]=new Wetland(name,ubication,type,km,photo,prot2,location,likes);
                    continuar=false;
                    message="Registro de humedal exitoso";
                }
                if(continuar==true){
                    message="Array of wetlands is full, you cant add more";
                }
            }
        }
        return message;
    }
    
    /** 
     * This method validates that the wetland where the species is being added it´s the same that the user wants to add it, and sends the data to the class Wetland
     * Name: addSpecies
     * @param wetland The name of the wetland that the species is being added
     * @param name The name of the species
     * @param scientificName The scientific name of the species 
     * @param prot The species is migratory or not
     * @param type The animal kingdom ehre the species belong 
     * @return String message of the state of the process
     */
    public String addSpecies(String wetland,String name,String scientificName, boolean prot,int type){
        String message="No wetland found with that name";
        boolean continue1=false;
        for(int i=0;i<MAXWTLAND && continue1==false;i++){
            if (wetlands[i]!=null){
                if (wetlands[i].getName().equals(wetland)){
                    message=wetlands[i].addSpecies(name, scientificName, prot, type);
                    continue1=true;
                }
                else{message="Wetland not found, the species was not registered";}
            }
        }
        return message;
    }
    
    /** 
     * This method validates that the wetland where the event is being added it´s the same that the user wants to add it, and sends the data to the class Wetland
     * Name: addEvent
     * @param wetland The name of the wetland where the event is being added
     * @param name The name of the person that is going to do it 
     * @param description The type of the event 
     * @param value The value of the event 
     * @param date The date of the event 
     * @param descriptionEvent The description of the event 
     * @return String message of the state of the process
     */
    public String addEvent(String wetland,String name,int description,double value,LocalDate date,String descriptionEvent){
        String b="No wetland found with that name";
        boolean continue1=false;
        for (int i=0;i<MAXWTLAND && continue1==false;i++){
            if(wetlands[i]!=null){
                if (wetlands[i].getName().equals(wetland)){
                    b=wetlands[i].addEvent(name, description, value, date,descriptionEvent);
                    continue1=true;
                }
            }
        }
        return b;
    }
    
    /** 
     * This method travelr the array and calls another method in the class wetland, and sticks it to a String
     * Name: amountMainteinment
     * @param year The year that you want to check the amount of maintenances 
     * @return String result all the wetlands that exist with the amount of maintenmets for a year 
     */
    public String amountMainteinment(int year){
        String message="";
        String result="No maintenances found in that year";
        int a=0;
        for (int i=0;i<MAXWTLAND;i++){
            if(wetlands[i]!=null){
                a=wetlands[i].amountMainteinment(year);
                message="The wetland "+wetlands[i].getName()+" has "+a+" maintenments \n";
                result+=message;
            }
        }
        return result;
    }
    
    /**
     * This method compares the amount of animals that a wetland has and choose the hicher number 
     * Name: diverseWetland
     * @return String the wetland with the most animals
     */
    public String diverseWetland(){
        String message="Inexistent wetlands";
        int higher=wetlands[0].diverseWetland()-1;
        int actualNum=0;
        for (int i=0;i<MAXWTLAND;i++){
            if(wetlands[i]!=null){
                actualNum=wetlands[i].diverseWetland();
                    if(actualNum>higher){
                        higher=actualNum;
                        message="The most diverse wetland is "+wetlands[i].getName();
                    }
                }
        }
       
        return message;
    }
    
    /** 
     * This method comapres the amount of flora that a wetland has and choose the lowest number
     * Name: leastFlora
     * @return String The name of the wetland with the least species of flora
     */
    public String leastFlora(){
        String message="Inexistent wetlands";
        int currentNum=0;
        int lowest=wetlands[0].leastFlora()+1;
        for (int i=0;i<MAXWTLAND;i++){
            if (wetlands[i]!=null){
                currentNum=wetlands[i].leastFlora();
                    if(currentNum<lowest){
                        lowest=currentNum;
                        message="The Wetland with the least species of flora is "+wetlands[i].getName();
                    }
            }
        }
        return message;
    }
    
    /** 
     * This method deploys the information of all the wetlands registered in the array
     * Name: deployInfo
     * @return String All the information of the wetlands 
     */
    public String deployInfo(){
        String message="";
        String result="";
        String species="";
        for (int i=0;i<MAXWTLAND;i++){
            if (wetlands[i]!=null){
                species=wetlands[i].infoSpecies();
                message=" Wetland : "+wetlands[i].getName()+"\n Located in : "+wetlands[i].getAreaName()+", "+wetlands[i].getUbication()+"\n Is: "+wetlands[i].getType()+"\n Extension "+wetlands[i].getKm()+" square kilometers \n Photo : "+wetlands[i].getPhoto()+"\n "+species+" \n -----------------\n";
                result+=message;
            }
        }
        return result;
    }
    
    /** 
     * This method shows the wetland where a specific species is living
     * Name: findSpecies
     * @param name The name of the species that you want to search 
     * @return String message of the state of the process
     */
    public String findSpecies(String name){
        String message="";
        String result="No wetlands found with that speecies";
        for (int i=0;i<MAXWTLAND;i++){
             if (wetlands[i]!=null){
                 message=wetlands[i].findSpecies(name);
                 result+=message+" "+wetlands[i].getName()+"\n";
             }  
        }
        return result;
    }
    
}
