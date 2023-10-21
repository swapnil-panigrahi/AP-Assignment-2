public abstract class Animal {
    protected String species;
    protected String sound;
    protected String description;
    protected Integer id;

    public Animal(String species, String sound, String description, Integer id) {
        this.species = species;
        this.sound = sound;
        this.description = description;
        this.id = id;
    }
    public abstract void feed();
    public abstract void read();

    public Integer getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    public void setSound(String sound) {
        this.sound = sound;
    }
    public void setDesc(String desc) {
        this.description = desc;
    }

}