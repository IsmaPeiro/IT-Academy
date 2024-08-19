package mementogame;

public class Memento {
    private String name;
    private int level;
    private int Kills;
    private static CareTaker careTaker =new CareTaker();
    
    public Memento() {
    }
    
    public Memento(String name) {
        this.name = name;
    }
    
    public Memento(String name, int level, int kills) {
        this.name = name;
        this.level = level;
        Kills = kills;
    }
    
    public void save () {
        careTaker.save(new Originator(this));
    }
    
    public void back () {
        Originator originator = careTaker.undo();
        setLevel(originator.getLevel());
        setKills(originator.getKills());
    }
    
    public void forward () {
        Originator originator = careTaker.redo();
        setLevel(originator.getLevel());
        setKills(originator.getKills());
    }
    
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public int getKills() {
        return Kills;
    }
    
    public void setKills(int kills) {
        Kills = kills;
    }
    
    @Override
    public String toString() {
        return "Memento{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", Kills=" + Kills +
                '}';
    }
}
