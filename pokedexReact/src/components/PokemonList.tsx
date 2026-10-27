import dados from "../data/pokedex-data.json";
import "../css/PokemonList.css";
import { Link } from "react-router";

interface Props {
  pesquisa: string;
  tipoSelecionado: string
}

export default function PokemonList({ pesquisa, tipoSelecionado }: Props) {
  const pokemonFilter = dados.pokemon.filter((pokemon) => {
    const correspondePesquisa = pokemon.name.toLowerCase().includes(pesquisa.toLowerCase()) || pokemon.id.toString().includes(pesquisa)

    const correspondeTipo = tipoSelecionado === "Todos" || pokemon.types.some((tipo) => tipo.name.toLowerCase() === tipoSelecionado.toLocaleLowerCase())
  
  return correspondePesquisa && correspondeTipo
  });

  if (pokemonFilter.length == 0) {
    return (
      <div style={{ width: "100%" }}>
        <h3>Nenhum pokemon encontrado</h3>
      </div>
    );
  }

  return (
    <div className="Pokemons">
      {pokemonFilter.map((pokemon) => (
        <Link to={`/pokemon/${pokemon.id}`}>
          <li>
            <img
              src={`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.id}.png`}
              alt={pokemon.name}
            />
            <h1>
              {pokemon.name}, <br />#{pokemon.id}
            </h1>
            <h2>
              Tipos:
              {pokemon.types
                .map((tipo) => `${tipo.name}`)
                .join(", ")}
              <br />
            </h2>
          </li>
        </Link>
      ))}
    </div>
  );
}
