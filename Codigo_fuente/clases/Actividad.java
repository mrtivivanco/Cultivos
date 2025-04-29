// Esta línea indica en qué carpeta está guardada la clase.
// Debe coincidir con la carpeta real donde está este archivo (Codigo_fuente/clases)
package Codigo_fuente.clases;

// Declaramos una clase llamada Actividad.
// "extends ElementoAgricola" indica que esta clase hereda de la clase abstracta ElementoAgricola.
// Esto significa que Actividad va a tener nombre, fecha y estado, sin tener que volver a escribirlos aquí.
public class Actividad extends ElementoAgricola {

    // Constructor de la clase Actividad.
    // Este constructor recibe tres datos: nombre de la actividad, fecha y estado.
    public Actividad(String nombre, String fecha, String estado) {
        // Llamamos al constructor de la clase padre (ElementoAgricola) usando "super".
        // Esto sirve para que se guarden correctamente los datos en los atributos heredados.
        super(nombre, fecha, estado);
    }

    // Este método está sobreescribiendo (implementando) el método abstracto mostrarInfo()
    // que está declarado en la clase ElementoAgricola.
    // Aquí le damos nuestra propia forma de mostrar la información para una actividad.
    @Override
    public void mostrarInfo() {
        System.out.println("=== Información de la actividad ===");
        System.out.println("Actividad: " + nombre);    // nombre heredado
        System.out.println("Fecha: " + fecha);         // fecha heredada
        System.out.println("Estado: " + estado);   // estado heredado 
        }    
    
}

