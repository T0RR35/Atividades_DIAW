import SearchBar from "../components/SearchBar"
import { useState } from "react"
import TrainerList from "../components/TrainerList"
export default function Trainer(){
    const [pesquisa, setPesquisa] = useState("")
    return(
        <div>
            <SearchBar texto="Treinadores" pesquisa={pesquisa} setPesquisa={setPesquisa}/>

            <TrainerList pesquisa={pesquisa}/>
        </div>
    )
}