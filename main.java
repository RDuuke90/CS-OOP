public class CuentaBancaria {
    public String NombreDelTitular;
    private String NumeroDeCuenta;
    private int PIN;
    private double Balance;

    public CuentaBancaria(String nombreDelTitular, String numeroDeCuenta, int pin) {
        this.NombreDelTitular = nombreDelTitular;
        this.NumeroDeCuenta = numeroDeCuenta;
        this.PIN = pin;
        this.Balance = 0;  // Inicializamos el balance a 0
    }

    public void Depositar(double monto) {
        this.Balance += monto;
    }

    public boolean Retirar(double monto, int pin) {
        if (monto <= this.Balance && this.PIN == pin) {
            this.Balance -= monto;
            return true;
        }
        return false;
    }

    public double VerBalance() {
        return this.Balance;
    }

    public boolean CambiarPIN(int pinActual, int nuevoPin) {
        if (this.PIN == pinActual) {
            this.PIN = nuevoPin;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Juan Perez", "1234567890", 1234);
        cuenta.Depositar(500);
        System.out.println("Balance después de depositar: " + cuenta.VerBalance());

        if (cuenta.Retirar(100, 1234)) {
            System.out.println("Balance después de retirar: " + cuenta.VerBalance());
        }
    }
}
