package mementogame;

public class Originator {
    private int level;
    private int kills;
    
    public Originator(Memento memento) {
        level= memento.getLevel();
        kills= memento.getKills();
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public int getKills() {
        return kills;
    }
    
    public void setKills(int kills) {
        this.kills = kills;
    }
}
