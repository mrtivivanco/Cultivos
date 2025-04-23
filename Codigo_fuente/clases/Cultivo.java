package Codigo_fuente.clases;

public class Cultivo {
    
}

//Va a heredar de ElementoAgricola
// Esta línea le indica a Java que esta clase pertenece al paquete (carpeta) Codigo_fuente.clases
// Esto es importante para importar correctamente esta clase desde otros archivos.
package Codigo_fuente.clases;

// Declaramos una nueva clase llamada "Cultivo".
// La palabra "extends" significa que esta clase hereda de otra llamada "ElementoAgricola".
// Eso quiere decir que "Cultivo" va a tener todos los atributos y métodos que tiene "ElementoAgricola".
public class Cultivo extends ElementoAgricola {

    // Este es un nuevo atributo que solo pertenece a los cultivos.
    // Aquí vamos a guardar la variedad del cultivo (por ejemplo: "Cherry", "Premium").
    private String variedad;

    // Este atributo también es exclusivo de Cultivo.
    // Aquí guardamos la superficie sembrada en hectáreas (por ejemplo: 10.5).
    private double superficie;

    // Aquí guardamos el código de la parcela donde está sembrado el cultivo.
    // Por ejemplo: "PARCELA-A01"
    private String codigoParcela;

    // Este es el constructor de la clase Cultivo.
    // Se llama automáticamente cuando tú creas un nuevo cultivo desde otra parte del programa.
    // Ejemplo de uso: new Cultivo("Tomate", "2023-03-15", "EN_RIESGO", "Cherry", 10.0, "PARCELA-C02");
    public Cultivo(String nombre, String fecha, String estado, String variedad, double superficie, String codigoParcela) {
        // Esta línea llama al constructor de la clase padre (ElementoAgricola).
        // Así se inicializan los atributos que vienen de ElementoAgricola: nombre, fecha y estado.
        super(nombre, fecha, estado);

        // Aquí se guardan los datos específicos de la clase Cultivo.
        this.variedad = variedad;               // Guardamos la variedad entregada
        this.superficie = superficie;           // Guardamos la superficie entregada
        this.codigoParcela = codigoParcela;     // Guardamos el código de la parcela entregado
    }

    // Este es el método que debe existir obligatoriamente porque lo definimos como abstracto en ElementoAgricola.
    // Se encarga de mostrar toda la información de un cultivo en la consola.
    @Override  // Esto indica que estamos "reescribiendo" el método mostrarInfo() de la clase padre.
    public void mostrarInfo() {
        // Imprimimos cada dato con un mensaje explicativo.
        // Los atributos "nombre", "fecha" y "estado" son heredados de ElementoAgricola.
        System.out.println("=== Información del cultivo ===");
        System.out.println("Nombre: " + nombre);                      // Mostrar el nombre del cultivo
        System.out.println("Variedad: " + variedad);                 // Mostrar la variedad
        System.out.println("Superficie sembrada: " + superficie + " hectáreas");  // Mostrar superficie
        System.out.println("Parcela asignada: " + codigoParcela);    // Mostrar parcela
        System.out.println("Fecha de siembra: " + fecha);            // Mostrar la fecha
        System.out.println("Estado actual: " + estado);              // Mostrar el estado
    }

    // Estos son métodos llamados "getters".
    // Sirven para que otras clases puedan acceder a los datos del cultivo, sin modificarlos directamente.

    // Este método devuelve el valor de la variedad
    public String getVariedad() {
        return variedad;
    }

    // Este método devuelve el valor de la superficie
    public double getSuperficie() {
        return superficie;
    }

    // Este método devuelve el código de la parcela
    public String getCodigoParcela() {
        return codigoParcela;
    }
}

