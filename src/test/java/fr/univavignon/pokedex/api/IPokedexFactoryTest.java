package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;
    IPokedex pokedex;
    IPokemonFactory pokemonFactory;
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void init(){
        pokedexFactory = new PokedexFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider(pokedex);
    }

    @Test
    public void PokedexFactoryTest(){
        pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        Assert.assertEquals(pokedex.size(), 0);

    }

}
