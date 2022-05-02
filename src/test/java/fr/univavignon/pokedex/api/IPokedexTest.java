package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class IPokedexTest {
    IPokedex pokedex;
    Pokemon bulbizarre;
    ArrayList<Pokemon> listPokemon;

    @Before
    public void init() throws PokedexException {
        pokedex = Mockito.mock(IPokedex.class);
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        listPokemon = new ArrayList<>();
        when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        when(pokedex.size()).thenReturn(0);
        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        when(pokedex.getPokemon(-1)).thenThrow(new PokedexException());
        when(pokedex.getPokemons()).thenReturn(listPokemon);
    }

    @Test
    public void sizeCreateTest(){
        Assert.assertEquals(pokedex.size(), 0);
    }

    @Test
    public void addPokemonTest() throws PokedexException {
        Assert.assertEquals(pokedex.addPokemon(bulbizarre),0);
        listPokemon.add(bulbizarre);
        when(pokedex.size()).thenReturn(1);
        Assert.assertEquals(pokedex.size(), 1);
        Assert.assertEquals(pokedex.getPokemon(0), bulbizarre);
    }

    @Test
    public void getExceptionTest() throws PokedexException {
        Assert.assertThrows(PokedexException.class,() -> {pokedex.getPokemon(-1);});
    }
}
