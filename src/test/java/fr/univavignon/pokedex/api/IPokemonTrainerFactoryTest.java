package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {
    IPokemonTrainerFactory pokemonTrainerFactory;
    IPokedexFactory pokedexFactory;
    @Before
    public void init(){
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void createTrainerTest(){
        Assert.assertEquals(pokemonTrainerFactory.createTrainer("Gabriel", Team.VALOR, pokedexFactory).getName(),"Gabriel");
    }
}
