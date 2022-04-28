package fr.univavignon.pokedex.api;

/**
 * Custom exception for pokedex related error.
 *
 * @author fv
 */
 public final class PokedexException extends Exception {

   /** Serialization index. **/
   private static final long serialVersionUID = 1L;

   /**
    * Default constructor.
    *
    * @see Exception#Exception(String)
    */
   public PokedexException() {
     super();
   }

 }
