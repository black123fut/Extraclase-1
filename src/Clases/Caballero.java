package Clases;

/**
 * La clase aplica Herencia ya que extiende de Heroe
 */
public class Caballero extends Heroe
{
    //Metodos
    /**
     * Constuctor
     * @param nombre establece una identificar al Heroe
     */
    public Caballero(String nombre){
        super(nombre + "(Caballero)");
        this.ataque = 20;
        this.defensa = 20;
    }

    /**
     * Metodo que baja la vida al enemigo
     * El metodo esta sobre-escribiendo al metodo de Heroe
     * @param enemigo Heroe al que se va atacar
     */
    @Override
    public void hacerAtaque(Heroe enemigo) {
        if ( enemigo.getNombre().equals(getNombre()) ) {
            System.out.println("No te puedes atacar a ti mismo.");
        } else {
            enemigo.setVida(enemigo.getVida() - (ataque - enemigo.defensa / 2));
        }
    }

}
