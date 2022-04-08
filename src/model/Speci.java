package model;

public class Speci{
    private String name;
    private String scientificName;
    private boolean migratorySpecies;
    //relaciones
    private FloraFauna type;
    public Speci(String name, String scientificName, boolean migratorySpecies, int ty) {
        this.name = name;
        this.scientificName = scientificName;
        this.migratorySpecies = migratorySpecies;
        switch(ty){
            case 1: setType(FloraFauna.MAMMAL);
            break;
            case 2: setType(FloraFauna.ACUATIC);
            break;
            case 3: setType(FloraFauna.BIRD);
            break;
            case 4: setType(FloraFauna.ACUATIC_FLORA);
            break;
            case 5: setType(FloraFauna.TERRESTRIAL_FLORA);
            break;
        }
    }
    public FloraFauna getType() {
        return type;
    }
    public void setType(FloraFauna type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public boolean isMigratorySpecies() {
        return migratorySpecies;
    }
    public void setMigratorySpecies(boolean migratorySpecies) {
        this.migratorySpecies = migratorySpecies;
    }
    public String getScientificName() {
        return scientificName;
    }
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }
    public void setName(String name) {
        this.name = name;
    }



}