public class Paralelismo {

    static class Sumador extends Thread {
        private long inicio;
        private long fin;
        private long sumaParcial = 0;

        public Sumador(long inicio, long fin) {
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        public void run() {
            for (long i = inicio; i <= fin; i++) {
                sumaParcial += i;
            }
        }

        public long getSumaParcial() {
            return sumaParcial;
        }
    }

    public static void main(String[] args) {
        Sumador hilo1 = new Sumador(1, 250000);
        Sumador hilo2 = new Sumador(250001, 500000);
        Sumador hilo3 = new Sumador(500001, 750000);
        Sumador hilo4 = new Sumador(750001, 1000000);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException e) {
            System.out.println("Un hilo fue interrumpido.");
            e.printStackTrace();
        }

        long sumaTotal = hilo1.getSumaParcial() + 
                         hilo2.getSumaParcial() + 
                         hilo3.getSumaParcial() + 
                         hilo4.getSumaParcial();

        System.out.println("La suma total de 1 a 1,000,000 es: " + sumaTotal);
    }
}