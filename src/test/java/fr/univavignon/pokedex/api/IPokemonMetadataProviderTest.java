package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pokemonMetadataProvider;
    PokemonMetadata pokemonMetadata;
    IPokedex pokedex;
    Pokemon bulbizarre;
    IPokedexFactory pokedexFactory;
    @Before
    public void init() throws PokedexException {
        pokedexFactory = new PokedexFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider(pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, new RocketPokemonFactory()));
        pokemonMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void exceptionMetadataTest(){
        Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
    }

    @Test
    public void getMetadataTest() throws PokedexException {
        pokedex.addPokemon(bulbizarre);
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getName(),bulbizarre.getName());
    }
}
