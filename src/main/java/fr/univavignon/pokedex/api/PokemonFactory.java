package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    IPokemonMetadataProvider pokemonMetadataProvider;

    public PokemonFactory() {
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws outOfBoundException {
        PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
        return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getDefense(), cp, hp, dust, candy, 100);
    }
}
