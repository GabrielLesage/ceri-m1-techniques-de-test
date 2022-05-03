package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory;
    Pokemon pokemon;
    @Before
    public void init(){
        pokemonFactory = new RocketPokemonFactory();
        pokemon = new Pokemon(0, "test", 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @Test
    public void createPokemonTest(){
        Assert.assertEquals(pokemonFactory.createPokemon(0,1,1,1,1).getCp(),pokemon.getCp());
    }
}
