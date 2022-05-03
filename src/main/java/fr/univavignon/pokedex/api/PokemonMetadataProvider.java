package fr.univavignon.pokedex.api;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    IPokedex pokedex;

    public PokemonMetadataProvider(IPokedex pokedex) {
        this.pokedex = pokedex;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        Pokemon pokemon = pokedex.getPokemon(index);
        return new PokemonMetadata(pokemon.getIndex(), pokemon.getName(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getStamina());
    }
}
