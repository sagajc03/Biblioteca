public class Hoja {
    public double interlineado;
    public String texto;
    public int capitulo;

    public Hoja(double interlineado, String texto, int capitulo){

        this.interlineado = interlineado;
        this.texto = texto;
        this.capitulo = capitulo;
    }

    public Hoja(String texto, int capitulo){
        //puedes tener dos iniciadores, sabias? se usa sengun contexto
        this.interlineado = 1;
        this.texto = texto;
        this.capitulo = capitulo;
    }

}
