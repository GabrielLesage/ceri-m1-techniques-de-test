package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {
    IPokemonTrainerFactory pokemonTrainerFactory;
    PokemonTrainer pokemonTrainer;
    IPokedex pokedex;
    IPokedexFactory pokedexFactory;
    @Before
    public void init(){
        pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        pokedex = Mockito.mock(IPokedex.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokemonTrainer = new PokemonTrainer("Gabriel", Team.VALOR, pokedex);
        when(pokemonTrainerFactory.createTrainer("Gabriel", Team.VALOR, pokedexFactory)).thenReturn(pokemonTrainer);
    }

    @Test
    public void createTrainerTest(){
        Assert.assertEquals(pokemonTrainerFactory.createTrainer("Gabriel", Team.VALOR, pokedexFactory), pokemonTrainer);
    }
}
