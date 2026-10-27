import { useState } from "react";
import SearchBar from "../components/SearchBar";
import PokemonList from "../components/PokemonList";
import FiltroTipo from "../components/FiltroTipo";
export default function Home() {
  const [pesquisa, setPesquisa] = useState("");
  const [tipoSelecionado, setTipoSelecionado] = useState("Todos");
  const tiposPokemon = [
    { nome: "Fogo", valor: "fire" },
    { nome: "Água", valor: "water" },
    { nome: "Planta", valor: "grass" },
    { nome: "Elétrico", valor: "electric" },
    { nome: "Psíquico", valor: "psychic" },
    { nome: "Gelo", valor: "ice" },
    { nome: "Dragão", valor: "dragon" },
    { nome: "Sombrio", valor: "dark" },
    { nome: "Fada", valor: "fairy" },
    { nome: "Normal", valor: "normal" },
    { nome: "Lutador", valor: "fighting" },
    { nome: "Voador", valor: "flying" },
    { nome: "Veneno", valor: "poison" },
    { nome: "Terrestre", valor: "ground" },
    { nome: "Pedra", valor: "rock" },
    { nome: "Inseto", valor: "bug" },
    { nome: "Fantasma", valor: "ghost" },
    { nome: "Aço", valor: "steel" },
  ];

  return (
    <div>
      <SearchBar
        pesquisa={pesquisa}
        setPesquisa={setPesquisa}
        texto="Pokedéx"
      />

      <FiltroTipo tipoSelecionado={tipoSelecionado} tipos={tiposPokemon} setTipoSelecionado={setTipoSelecionado}/>
      
      <PokemonList pesquisa={pesquisa} tipoSelecionado={tipoSelecionado} />
    </div>
  );
}
