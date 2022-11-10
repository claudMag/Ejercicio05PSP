import java.util.concurrent.Semaphore;

public class HiloCliente extends Thread{

    public static int cantidadGlobalBanco; //o private Dinero dinero.
    private Semaphore semaforo;
    private String nombre;
    private int cantidadDinero;

    public HiloCliente(Semaphore semaforo, String nombre, int cantidadDinero){
        this.semaforo = semaforo;
        this.nombre = nombre;
        this.cantidadDinero = cantidadDinero;
    }


    @Override
    public void run() {
       // for (int i = 0; i < 10000; i++) {
        //   int a = 0;
       // }
        System.out.println("El cliente "+nombre+" ha entrado al banco");
        System.out.println("El cliente "+nombre+" va a entrar en la cámara acorazada");
        try {
            semaforo.acquire();
            System.out.println("ha ENTRADO en la camara acorazada: CLIENTE "+nombre);
            cantidadGlobalBanco += cantidadDinero;
            cantidadGlobalBanco-= 1000;
            semaforo.release();
            System.out.println("Ha SALIDO de la camara acorazada: CLIENTE "+nombre);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
