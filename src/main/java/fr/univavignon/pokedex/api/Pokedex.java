package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    IPokemonFactory pokemonFactory;
    ArrayList<Pokemon> listPokemon;
    IPokemonMetadataProvider pokemonMetadataProvider;

    public Pokedex() {
        listPokemon = new ArrayList<>();
    }

    public void setPokemonFactory(IPokemonFactory pokemonFactory) {
        this.pokemonFactory = pokemonFactory;
    }

    public void setPokemonMetadataProvider(IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    @Override
    public int size() {
        return listPokemon.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        listPokemon.add(pokemon);
        return listPokemon.size()-1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if(id < 0 || id >= listPokemon.size()){
            throw new PokedexException();
        }
        else{
            return listPokemon.get(id);
        }
    }

    @Override
    public List<Pokemon> getPokemons() {
        final ArrayList<Pokemon> retour = new ArrayList<>(listPokemon);
        return retour;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        final ArrayList<Pokemon> retour = new ArrayList<>(listPokemon);
        retour.sort(order);
        return retour;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
