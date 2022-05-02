package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pokemonMetadataProvider;
    PokemonMetadata pokemonMetadata;
    @Before
    public void init() throws PokedexException {
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        when(pokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException());
    }

    @Test
    public void exceptionMetadataTest(){
        Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
    }

    @Test
    public void getMetadataTest() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(0),pokemonMetadata);
    }
}
