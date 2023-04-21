
import javax.swing.JOptionPane;// Importando el paquete JOptionPane

class Main {

    public static void main(String[] args) {
        String NombreCuenta = JOptionPane.showInputDialog("Ingrese el nombre de la cuenta Colombiana");// Pedir datos tipo String

        CuentaColombia cuentaColombia = new CuentaColombia(NombreCuenta);// Instanciar un bojeto de la clase CuentaColombia enviando un parametro al constructor

        cuentaColombia.AsignarSaldo(5000);// Usar un metodo de la clase con un parametro predefinido

        JOptionPane.showMessageDialog(null, "Retire 2000 y mi nuevo saldo es: " + cuentaColombia.RetirarSaldo(2000));//Imprimir algo que retorna un metodo de la clase, en este caso un numero entero.

        CuentaArgentina cuentaArgentina = new CuentaArgentina();// Instanciar un objeto de la clase CuentaArgentina sin ningun parametro en el constructor

        int saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de saldo asignar")); // Solictar información que se trnasforma a un entero porque todo lo que viene desde afuera es un String

        cuentaArgentina.AsignarSaldo(saldo);// Usamos metodo de la clase CuentaArgentina enviandole un parametro dinamico que se solicita al usuario

        JOptionPane.showMessageDialog(null, "Nuevo saldo es: " + cuentaArgentina.Saldo);// Imprimir una propiedad de la clase cuentaArgentia (porque es publica sino toca hacer un getter)

        //Generar randon de 1 a 4;

        Random randon = new Random();
        int valorDado = randon.nextInt(4)+1;

        JOptionPane.showMessageDialog(null, "Numero random 1 y 4: " + valorDado);

    }
}

interface ICuentaBancaria
{
    public int RetirarSaldo(int Cantidad);
    public void AsignarSaldo(int Cantidad);
}

abstract class CuentaBancaria implements ICuentaBancaria
{
    protected int Saldo = 10000;

    public int RetirarSaldo(int Cantidad)
    {
        this.Saldo -= Cantidad;

        return this.Saldo;
    }

    public void AsignarSaldo(int Cantidad)
    {
        this.Saldo += Cantidad;
    }
}

public class CuentaColombia extends CuentaBancaria
{
    private String Nombre;

    public CuentaColombia(String Nombre) // Creando metodo constructor para solictar la propiedad Nombre cada vez que se instancia la clase 
    {
        this.Nombre = Nombre;
    }
}

public class CuentaArgentina extends CuentaBancaria
{
    public int Saldo = 15000;// Sobreescribiendo la propiedad Saldo de la clase padre

    @Override //Sobreescribiendo el metodo AsignarSaldo de la clase padre
    public void AsignarSaldo(int Cantidad)
    {
        this.Saldo += Cantidad + (int)(Cantidad*.05);
    }
}