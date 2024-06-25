package n3Exercise4;

import java.util.ArrayList;

public class ListOfObjects {
    private ArrayList<Object> list;
    
    public ListOfObjects() {
        this.list = new ArrayList<>();
    }
    
    public ArrayList<Object> getList() {
        return list;
    }
    
    public void setList(ArrayList<Object> list) {
        this.list = list;
    }
    
    public void addObject (Object o) {
        list.add(o);
    }
}
