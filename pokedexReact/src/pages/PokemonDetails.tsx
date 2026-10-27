import { useParams } from "react-router";
import { Link } from "react-router";
import dados from "../data/pokedex-data.json";
import "../css/PokemonDetails.css";

export default function PokemonDetails() {
  const { id } = useParams();

  const pokemon = dados.pokemon.find((pokemon) => pokemon.id === Number(id));

  if (!pokemon) {
    return (
      <div className="not-found">
        <h1 className="not-found-title">Página não encontrada</h1>
        <Link to={`/`} style={{ textDecoration: "none" }}>
          <button className="home-button">Voltar à Pokédex</button>
        </Link>
      </div>
    );
  }

  const statColors: Record<string, string> = {
    hp: "#ff5959",
    attack: "#f5ac78",
    defense: "#fae078",
    specialAttack: "#9db7f5",
    specialDefense: "#a7db8d",
    speed: "#fa92b2",
  };

  const statNames: Record<string, string> = {
    hp: "Vida",
    attack: "Ataque",
    defense: "Defesa",
    specialAttack: "Ataque Especial",
    specialDefense: "Defesa Especial",
    speed: "Velocidade",
  };

  return (
    <div className="details-container">
      <Link to={`/`} style={{ textDecoration: "none" }}>
        <button className="back-button">⟸ Voltar</button>
      </Link>

      <div className="details-card">
        <h1 className="pokemon-id">
          #{pokemon.id.toString().padStart(3, "0")}
        </h1>

        <img
          src={`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.id}.png`}
          alt={pokemon.name}
          className="pokemon-image"
        />

        <h1 className="pokemon-name">{pokemon.name}</h1>

        <div className="types-section">
          <h2 className="types-title">Tipos</h2>
          <div className="types-container">
            {pokemon.types.map((tipo: any, index: number) => (
              <span key={index} className="type-badge">
                {tipo.name}
              </span>
            ))}
          </div>
        </div>

        <div className="stats-section">
          <h2 className="stats-title">Estatísticas</h2>
          {Object.entries(pokemon.stats).map(([key, value]: [string, any]) => (
            <div key={key} className="stat-row">
              <div className="stat-header">
                <span className="stat-name">{statNames[key]}</span>
                <span className="stat-value">{value}</span>
              </div>
              <div className="stat-bar-bg">
                <div
                  className="stat-bar-fill"
                  style={{
                    width: `${Math.min((value / 200) * 100, 100)}%`,
                    backgroundColor: statColors[key] || "#2a75bb",
                  }}
                />
              </div>
            </div>
          ))}
        </div>
      </div>

      <div className="navigation">
        {Number(pokemon.id) > 1 ? (
          <Link to={`/pokemon/${pokemon.id - 1}`} style={{ flex: 1 }}>
            <button className="nav-button">⟵ Anterior</button>
          </Link>
        ) : (
          <button className="nav-button disabled" disabled>
            ⟵ Anterior
          </button>
        )}

        {Number(pokemon.id) < 151 ? (
          <Link to={`/pokemon/${pokemon.id + 1}`} style={{ flex: 1 }}>
            <button className="nav-button">Próximo ⟶</button>
          </Link>
        ) : (
          <button className="nav-button disabled" disabled>
            Próximo ⟶
          </button>
        )}
      </div>
    </div>
  );
}
