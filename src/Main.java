import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);

        HiloCliente hAndrea = new HiloCliente(semaforo, "Andrea", 5000);
        HiloCliente hLeonardo = new HiloCliente(semaforo, "Leonardo", 4000);
        HiloCliente hSanson = new HiloCliente(semaforo, "Sansón", 6000);
        HiloCliente hSara = new HiloCliente(semaforo, "Sara", 7000);

        hAndrea.start();
        hLeonardo.start();
        hSanson.start();
        hSara.start();
        try {
            hAndrea.join();
            hLeonardo.join();
            hSanson.join();
            hSara.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Cantidad total banco: " + HiloCliente.cantidadGlobalBanco);
    }
}