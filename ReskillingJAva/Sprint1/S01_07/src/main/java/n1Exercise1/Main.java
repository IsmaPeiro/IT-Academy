package n1Exercise1;
import n1Exercise1.workers.*;

public class Main {
    public static void main(String[] args) {
        Worker worker=new Worker ("Juan", "López", 10);
        InPersonWorker inPersonWorker=new InPersonWorker("Pedro", "Rámierz", 10);
        OnlineWorker onLineWorker=new OnlineWorker("Ana", "García", 10);
        
        System.out.println("Salary of worker with 160 hours:");
        System.out.println(worker.calculateSalary(160));
        System.out.println("Salary of in person worker with 160 hours:");
        System.out.println(inPersonWorker.calculateSalary(160));
        System.out.println("Salary of online worker with 160 hours:");
        System.out.println(onLineWorker.calculateSalary(160));
        
    }
}
