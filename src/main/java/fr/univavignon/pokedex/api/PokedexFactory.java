package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        Pokedex pokedex = new Pokedex();
        metadataProvider = new PokemonMetadataProvider(pokedex);
        pokedex.setPokemonFactory(pokemonFactory);
        pokedex.setPokemonMetadataProvider(metadataProvider);
        return pokedex;
    }
}
