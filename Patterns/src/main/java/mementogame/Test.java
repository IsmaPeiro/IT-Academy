package mementogame;

public class Test {
    public static void main(String[] args) {
        Memento memento =new Memento("game1", 1, 0);
        memento.save();
        System.out.println("Save 1: "+ memento);
        memento =new Memento("game1", 2, 10);
        memento.save();
        System.out.println("Save 2: "+ memento);
        memento =new Memento("game1", 3, 20);
        memento.save();
        System.out.println("Save 3: "+ memento);
        System.out.println("========================");
        memento =new Memento("game1");
        memento.back();
        System.out.println("Undo1: "+ memento);
        System.out.println("========================");
        memento =new Memento("game1");
        memento.forward();
        System.out.println("Redo1: "+ memento);
    }
}
