public class Concurrencia {

    static class CuentaBancaria {
        private int saldo = 1000;

        public synchronized void retirar(int cantidad, String nombreCliente) {
            System.out.println(nombreCliente + " intente retirar " + cantidad + ". Saldo disponible: " + saldo);
            
            if (saldo >= cantidad) {
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                saldo -= cantidad;
                System.out.println("Retiro exitoso para " + nombreCliente + ". Nuevo saldo: " + saldo + "\n");
            } else {
                System.out.println("Fondos insuficientes para " + nombreCliente + ". Retiro denegado.\n");
            }
        }
    }

    static class Cliente implements Runnable {
        private CuentaBancaria cuenta;
        private String nombre;

        public Cliente(CuentaBancaria cuenta, String nombre) {
            this.cuenta = cuenta;
            this.nombre = nombre;
        }

        @Override
        public void run() {
            cuenta.retirar(400, nombre);
        }
    }

    public static void main(String[] args) {
        CuentaBancaria cuentaCompartida = new CuentaBancaria();

        Thread cliente1 = new Thread(new Cliente(cuentaCompartida, "Cliente 1"));
        Thread cliente2 = new Thread(new Cliente(cuentaCompartida, "Cliente 2"));
        Thread cliente3 = new Thread(new Cliente(cuentaCompartida, "Cliente 3"));

        cliente1.start();
        cliente2.start();
        cliente3.start();
    }
}