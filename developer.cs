Developer JorgeSenior = new Developer("Jorge", 90);
Developer PedroMidSenior = new Developer("Pedro", 70);
Developer JuanJr = new Developer("Juan", 30);

List<Developer> listaDeveloper = new List<Developer>();

listaDeveloper.Add(JorgeSenior);
listaDeveloper.Add(PedroMidSenior);
listaDeveloper.Add(JuanJr);
int sumatoriaNivel = 0;
foreach(Developer developer in listaDeveloper){

    sumatoriaNivel += developer.getNivel();
    if(developer.getNivel() >= 80){
        Console.WriteLine($"El {developer.getNombre()} es Senior");
        continue;
    }

    if(developer.getNivel() < 80 && developer.getNivel() >= 50){
        Console.WriteLine($"El {developer.getNombre()} es MidSenior");
        continue;
    }

    Console.WriteLine($"El {developer.getNombre()} es Jr");
}

Console.WriteLine($"El promedio de nivel del equipo es: {(int) sumatoriaNivel/listaDeveloper.Count()}");
//nombrelista.Count();
public class Team
{
    private List<Developer> developers = new List<Developer>();

    public void addDeveloper(Developer developer){
        this.developers.Add(developer);
    }
}
public class Developer
{
    private string Nombre {get;set;}
    private int Nivel {get;set;}

    public Developer(string Nombre, int Nivel)
    {
        this.Nombre =  Nombre;
        this.Nivel =  Nivel;
    }

    public string getNombre()
    {
        return this.Nombre;
    }

    public int getNivel()
    {
        return this.Nivel;
    }
}
