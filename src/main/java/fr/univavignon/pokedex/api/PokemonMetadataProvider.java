package fr.univavignon.pokedex.api;

import java.util.ArrayList;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    ArrayList<PokemonMetadata> pokemonMetadatas;

    public PokemonMetadataProvider() {
        this.pokemonMetadatas = new ArrayList<>();
        pokemonMetadatas.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonMetadatas.add(new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws outOfBoundException {
        if(index < 0 || index >= pokemonMetadatas.size()){
            throw new outOfBoundException();
        }
        else{
            return pokemonMetadatas.get(index);
        }
        }
}
