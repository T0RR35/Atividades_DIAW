import dados from "../data/pokedex-data.json";
import "../css/TrainerList.css";

interface Props {
  pesquisa: string;
}

export default function TrainerList({ pesquisa }: Props) {
  const treinadorFilter = dados.trainers.filter(
    (treinador) =>
      treinador.name.toLowerCase().includes(pesquisa.toLowerCase()) ||
      treinador.id.toString().includes(pesquisa),
  );

  if (treinadorFilter.length === 0) {
    return (
      <div style={{ width: "100%" }}>
        <h3 className="no-trainer">Nenhum treinador encontrado</h3>
      </div>
    );
  }

  return (
    <div className="trainer-list">
      {treinadorFilter.map((treinador) => (
        <li key={treinador.id} className="trainer-card">
          <img
            src={`https://play.pokemonshowdown.com/sprites/trainers/${treinador.name.toLowerCase().replace(/[.\s]/g, "")}.png`}
            alt={treinador.name}
            loading="lazy"
            height={150}
            width={150}
          />
          <h1 className="trainer-name">
            {treinador.name} #{treinador.id}
          </h1>
          <p className="trainer-badges">Insígnias: {treinador.badges}</p>
          <div className="team-section">
            <p className="team-title">Equipe:</p>
            {treinador.pokemonIds.map((pokemonId) => {
              const pokemon = dados.pokemon.find(
                (pokemon) => pokemon.id === pokemonId,
              );
              if (!pokemon) return null;

              return (
                <img
                  src={`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.id}.png`}
                  alt={pokemon.name}
                  loading="lazy"
                  height={50}
                  width={50}
                />
              );
            })}
          </div>
        </li>
      ))}
    </div>
  );
}
