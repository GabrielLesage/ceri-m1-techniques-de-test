package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPokedexTest {

    IPokedexFactory pokedexFactory;
    IPokedex pokedex;
    Pokemon bulbizarre;
    PokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;

    @Before
    public void init() throws PokedexException {
        pokedexFactory = new PokedexFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider(pokedex);
        pokemonFactory = new RocketPokemonFactory();
        pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void sizeCreateTest(){
        Assert.assertEquals(pokedex.size(), 0);
    }

    @Test
    public void addPokemonTest() throws PokedexException {
        Assert.assertEquals(pokedex.addPokemon(bulbizarre),0);
        Assert.assertEquals(pokedex.size(), 1);
        Assert.assertEquals(pokedex.getPokemon(0).getCp(), bulbizarre.getCp());
    }

    @Test
    public void getExceptionTest() throws PokedexException {
        Assert.assertThrows(PokedexException.class,() -> {pokedex.getPokemon(-1);});
    }
}
