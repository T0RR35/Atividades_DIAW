import dados from "../data/pokedex-data.json";
import "../css/PokemonList.css";
import { Link } from "react-router";
import { Heart } from "lucide-react";
import { useState, useEffect } from "react";

interface Props {
  pesquisa: string;
  tipoSelecionado: string;
}

export default function PokemonList({ pesquisa, tipoSelecionado }: Props) {
  // Lê os favoritos salvos (se existirem) na primeira renderização
  const [favoritos, setFavoritos] = useState<number[]>(() => {
    try {
      const salvo = localStorage.getItem("favoritos");
      return salvo ? JSON.parse(salvo) : [];
    } catch {
      return [];
    }
  });

  useEffect(() => {
    try {
      localStorage.setItem("favoritos", JSON.stringify(favoritos));
    } catch {
    }
  }, [favoritos]);

  const alternarFavorito = (id: number) => {
    setFavoritos((prev) =>
      prev.includes(id) ? prev.filter((favId) => favId !== id) : [...prev, id]
    );
  };

  const pokemonFilter = dados.pokemon.filter((pokemon) => {
    const correspondePesquisa =
      pokemon.name.toLowerCase().includes(pesquisa.toLowerCase()) ||
      pokemon.id.toString().includes(pesquisa);

    const correspondeTipo =
      tipoSelecionado === "Todos" ||
      (tipoSelecionado === "Favoritos"
        ? favoritos.includes(pokemon.id)
        : pokemon.types.some(
            (tipo) => tipo.name.toLowerCase() === tipoSelecionado.toLowerCase()
          ));

    return correspondePesquisa && correspondeTipo;
  });

  if (pokemonFilter.length === 0) {
    return (
      <div className="Pokemons">
        <h3>
          {tipoSelecionado === "Favoritos"
            ? "Você ainda não favoritou nenhum pokémon"
            : "Nenhum pokémon encontrado"}
        </h3>
      </div>
    );
  }

  return (
    <ul className="Pokemons">
      {pokemonFilter.map((pokemon) => {
        const favorito = favoritos.includes(pokemon.id);

        return (
          <li key={pokemon.id}>
            <Link to={`/pokemon/${pokemon.id}`}>
              <img
                src={`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.id}.png`}
                alt={pokemon.name}
                loading="lazy"
              />
            </Link>
            <h1>
              {pokemon.name},{" "}
              <button
                type="button"
                onClick={() => alternarFavorito(pokemon.id)}
                aria-label={
                  favorito ? "Remover dos favoritos" : "Adicionar aos favoritos"
                }
                aria-pressed={favorito}
                className={`fav-button ${favorito ? "ativo" : ""}`}
              >
                <Heart size={18} fill={favorito ? "currentColor" : "none"} />
              </button>
              <br />#{pokemon.id}
            </h1>
            <h2>Tipos: {pokemon.types.map((tipo) => tipo.name).join(", ")}</h2>
          </li>
        );
      })}
    </ul>
  );
}