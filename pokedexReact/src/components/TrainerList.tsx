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
                <p key={pokemon.id} className="team-pokemon">
                  #{pokemon.id} - {pokemon.name}
                </p>
              );
            })}
          </div>
        </li>
      ))}
    </div>
  );
}
