import { useState } from "react";
import { calcularResultado, calcularTotalVotos, obterVotos, zerarVotos } from "../services/votacaoService";


export default function Resultado() {

    function handleZerar(){
        if(window.confirm('Apagar todos os votos?')){
            zerarVotos();
            setVotos({});
        }
    }

    const [votos, setVotos] = useState(() => obterVotos());

    const total = calcularTotalVotos(votos);
    const resultado = calcularResultado(votos);

    return (
        <div>
            {
                resultado.forEach(percentual => (
                    <div className="barra">
                        <div
                            className="barra-preenchida"
                            style={{ width: `${percentual.percentual}%` }}
                        />
                    </div>
                ))
            }
            {
                total === 0 ?
                    <button type="button" onClick={() => handleZerar()}>
                        Zerar a votação
                    </button>
                : ''
            }
        </div>
    )
}