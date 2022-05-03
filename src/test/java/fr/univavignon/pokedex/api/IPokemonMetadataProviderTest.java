package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pokemonMetadataProvider;
    PokemonMetadata pokemonMetadata;
    Pokemon bulbizarre;
    @Before
    public void init() throws outOfBoundException {
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void exceptionMetadataTest(){
        Assert.assertThrows(outOfBoundException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
    }

    @Test
    public void getMetadataTest() throws outOfBoundException {
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getName(),bulbizarre.getName());
    }
}
