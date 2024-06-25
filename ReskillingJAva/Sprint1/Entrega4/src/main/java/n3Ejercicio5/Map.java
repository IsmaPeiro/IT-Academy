package n3Ejercicio5;

import java.util.LinkedHashMap;

public class Map {
    private LinkedHashMap <Integer, String> map;
    
    public Map() {
        this.map = new LinkedHashMap<>();
    }
    
    public LinkedHashMap<Integer, String> getMap() {
        return map;
    }
    
    public void add (Integer k, String v) {
        map.put(k, v);
    }
}
