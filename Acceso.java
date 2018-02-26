
/**
 * Write a description of class Acceso here.
 *
 * @author (David Rodriguez)
 * @version (24/02/2018)
 */
public class Acceso
{
    private int anno;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    /**
     * Constructor for objects of class Acceso
     */
    public Acceso(int anno, int mes, int dia, int hora, int minutos)
    {
        this.anno = anno;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
    }
    
    /**
     * Metodo que devuelve la hora
     */
    public int getHora(){
        return hora;
    }
}
