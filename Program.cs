using System;

public class CuentaBancaria
{
    public string NombreDelTitular { get; set; }
    public decimal Balance { get; private set; }

    private string NumeroDeCuenta { get; set; }
    private int PIN { get; set; }

    public CuentaBancaria(string nombreDelTitular, string numeroDeCuenta, int pin)
    {
        NombreDelTitular = nombreDelTitular;
        NumeroDeCuenta = numeroDeCuenta;
        PIN = pin;
        Balance = 0m; // Inicializamos el balance a 0
    }

    public void Depositar(decimal monto)
    {
        Balance += monto;
    }

    public bool Retirar(decimal monto, int pin)
    {
        if (monto <= Balance && PIN == pin)
        {
            Balance -= monto;
            return true;
        }
        return false;
    }

    public decimal VerBalance()
    {
        return Balance;
    }

    public bool CambiarPIN(int pinActual, int nuevoPin)
    {
        if (PIN == pinActual)
        {
            PIN = nuevoPin;
            return true;
        }
        return false;
    }
}

class Program
{
    static void Main()
    {
        CuentaBancaria cuenta = new CuentaBancaria("Juan Perez", "1234567890", 1234);
        cuenta.Depositar(500m);
        Console.WriteLine($"Balance después de depositar: {cuenta.VerBalance()}");
        
        if (cuenta.Retirar(100m, 1234))
            Console.WriteLine($"Balance después de retirar: {cuenta.VerBalance()}");
    }
}
