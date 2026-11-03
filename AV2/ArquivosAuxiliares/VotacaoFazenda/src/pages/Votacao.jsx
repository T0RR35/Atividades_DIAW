import { useState } from "react";
import { listarNaRoca, listarForaDaRoca, registrarVoto } from "../services/votacaoService"
import ParticipanteCard from "../components/ParticipanteCard";


export default function Votacao() {
    const [ultimoVoto, setUltimoVoto] = useState(null);
    const [votosNaSessao, setVotosNaSessao] = useState(0);
    const naRoca = listarNaRoca();
    const foraDaRoca = listarForaDaRoca();

    function handleVotar(participante) {
        registrarVoto(participante.id);

        setUltimoVoto(participante.id);
        setVotosNaSessao(votosNaSessao + 1);
        if(ultimoVoto != null){
            alert("Boa! Você votou em " + participante.nome + ". VocÊ tem um total de " + votosNaSessao + " votos!");
        }
    }


    return (
        <>
            <div className="grade-roca">
                {
                    naRoca.map((p) => (
                        <ParticipanteCard key={p.id} participante={p} onVotar={handleVotar} />
                    ))
                }
            </div>

            <div className="grade-fora-da-roca">
                {
                    foraDaRoca.map((f) => (
                        <ParticipanteCard key={f.id} participante={f}/>
                    ))
                }
            </div>
        </>
    )

}