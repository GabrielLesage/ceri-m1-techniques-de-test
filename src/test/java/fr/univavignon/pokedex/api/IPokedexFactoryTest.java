package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;
    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;
    IPokedex pokedex;

    @Before
    public void init(){
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokedex = Mockito.mock(IPokedex.class);
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
        when(pokedex.size()).thenReturn(0);
    }

    @Test
    public void PokedexFactoryTest(){
        pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        Assert.assertEquals(pokedex.size(), 0);

    }

}
