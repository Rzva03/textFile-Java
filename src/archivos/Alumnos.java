
package archivos;

public class Alumnos {
    private int Codigo;
    private String Nombre;
    private String Carrera;
    
    public Alumnos(){
        
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        this.Carrera = carrera;
    }
    public String toString(){
    String valor="";
    valor=this.Codigo +","+ this.Nombre+ ","+ this.Carrera;
    return valor;
    }
    
   
    
}
