

export default function ParticipanteCard({ participante, onVotar }) {
    const { nome, foto, naRoca } = participante;

    return (
        <>
            <article className={naRoca ? 'card card-roca' : 'card'}>
                {naRoca && <span className="selo-roca">Na roça</span>}
                <img src={foto} alt={nome} className="card-foto" />
                {onVotar && (
                    <button type="button" onClick={() => onVotar(participante)}>
                        Votar para eliminar
                    </button>
                )}
            </article>
        </>
    );
}