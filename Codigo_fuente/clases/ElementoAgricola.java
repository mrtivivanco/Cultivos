// Clase abstracta, clase que NO se puede usar directamente, pero que sirve como base para otras clases.
// (Otras clases heredan de ella).
// Declaramos el paquete donde está esta clase.
// Esto ayuda a Java a saber dónde encontrarla.
package Codigo_fuente.clases;

// Creamos una clase abstracta llamada ElementoAgricola
// Las clases abstractas no se pueden usar directamente.
// Sirven como base para que otras clases hereden de ella.
public abstract class ElementoAgricola {

    // Estos son los atributos comunes que tendrán todos los elementos agrícolas.
    // Los marcamos como "protected" para que puedan ser usados por las clases hijas.
    protected String nombre; 
    protected String fecha;
    protected String estado;
    // Hasta ahora hemos creado la clase con sus atributos.

    // Este es el constructor.
    // Este método se ejecuta automáticamente cuando se crea un objeto hijo de esta clase.
    // Recibe 3 datos: nombre, fecha y estado, y los guarda dentro del objeto.
    public ElementoAgricola(String nombre, String fecha, String estado) {
        this.nombre = nombre;  // Guardar el nombre entregado en el atributo del objeto
        this.fecha = fecha;    // Guardar la fecha entregada en el atributo del objeto
        this.estado = estado;  // Guardar el estado entregado en el atributo del objeto
    }

    // Estamos creando métodos que nos permiten leer los datos privados o protegidos del objeto.

    // Método público que permite obtener el nombre desde fuera del objeto
    public String getNombre() {
        return nombre;  // Devuelve el valor del atributo "nombre"
    }

    // Método público que permite obtener la fecha desde fuera del objeto
    public String getFecha() {
        return fecha;  // Devuelve el valor del atributo "fecha"
    }

    // Método público que permite obtener el estado desde fuera del objeto
    public String getEstado() {
        return estado;  // Devuelve el valor del atributo "estado"
    }

    // Método abstracto: no tiene cuerpo aquí, solo se declara.
    // Obliga a las clases hijas a escribir su propia versión de este método.
    public abstract void mostrarInfo();  // Mostrar información detallada del elemento agrícola
}
