public class Mammal extends Animal{

    public Mammal(String species, String sound, String description, Integer id) {
        super(species, sound, description, id);
    }
    public void feed() {
        System.out.println(species+" "+sound);
    }
    public void read() {
        System.out.println(description);
    }

    @Override
    public Integer getId() {
        return super.getId();
    }
}