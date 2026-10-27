import "../css/SearchBar.css"

interface Props {
  texto: string;
  pesquisa: string;
  setPesquisa: (valor: string) => void;
}

export default function SearchBar({ texto, pesquisa, setPesquisa }: Props) {
  return (
    <div className="Tudo">
      <h1>{texto}</h1>
      <input className="Barra-Pesquisa"
        type="text"
        value={pesquisa}
        onChange={(e) => setPesquisa(e.target.value)}
        placeholder="Digite o nome ou ID do pokemon"
      />
    </div>
  );
}
