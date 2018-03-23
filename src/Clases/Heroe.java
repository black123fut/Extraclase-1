package Clases;

/**
 * Esta Clase es abstracta porque Heroe no es nada en especifico.
 * ES una clase porque es un modelo que define un conjunto de variables y metodos.
 */
public abstract class Heroe {
    //Atributos
    //Son private  para solo esta clase tenga acceso a ellos.
    private int vida;
    private boolean condicion;
    private String nombre;
    //Protected para que los Hijos le den el valor que deseen.
    protected int ataque;
    protected int defensa;

    //Metodos

    /**
     * Constuctor
     * @param nombre establece una identificar al Heroe
     */
    public Heroe(String nombre){
        super();
        this.nombre = nombre;
        condicion = true;
        vida = 50;
    }

    /**
     * Metodo abstracto para bajar vida al oponente.
     * Es Abstracta para obligar a las clases hijas a hacer su metodo hacerAtaque()
     * @param enemigo Heroe al que se va atacar
     */
    public abstract void hacerAtaque(Heroe enemigo);

    
    /**
     * Metodo que cambia la condicion del Heroe cuando su vida llega a 0.
     * @param estado si esta vivo o no.
     */
    private void muerto(boolean estado){
        if (!estado){
            System.out.print("");
        }
        else {
            condicion = false;
            System.out.println(nombre + " ha muerto");
        }
    }

    /**
     * Metodo que sube la vida del Heroe
     */
    public void pocion(){
        setVida(10 + getVida());
    }

    /**
     * Metodo que sube la vida del Heroe con un bonus.
     * El metodo aplica sobre-carga ya que exiset otro metodo con el mismo nombre sin parametros.
     * @param potenciador la cantidad de vida extra que se multiplicara a la pocion
     */
    public void pocion(double potenciador) {
        if (potenciador > 4) {
            System.out.println("Ingrese un potenciador mas pequeno");
        } else {
            System.out.println("Has recibido una pocion bonificada");
            setVida((int) (potenciador * 7.0 + getVida()));
        }
    }

    /**
     *Metodo que establece la vida con un limite de 50
     * @param vida el valor que se le dara a vida
     */
    protected void setVida(int vida){
        if (vida < 0){
            muerto(condicion);
        }
        else if (vida > 50){
            this.vida = 50;
            System.out.println(nombre + " hp: " + this.vida + "\n");
        }
        else {
            this.vida = vida;
            System.out.println(nombre + " hp: " + this.vida + "\n");
        }
    }

    protected int getVida(){
        return vida;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean getCondicion(){
        return condicion;
    }
}
