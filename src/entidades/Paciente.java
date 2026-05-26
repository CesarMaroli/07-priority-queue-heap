package entidades;

public class Paciente implements Comparable<Paciente> {
    private final String nome;
    private final int nivelUrgencia;
    private final int tempoEsperaMinutos;
    private final boolean grupoVulneravel;

    public Paciente(String nome, int nivelUrgencia, int tempoEsperaMinutos, boolean grupoVulneravel) {
        if (nivelUrgencia < 1 || nivelUrgencia > 5) {
            throw new IllegalArgumentException("nivelUrgencia deve estar entre 1 e 5.");
        }
        if (tempoEsperaMinutos < 0) {
            throw new IllegalArgumentException("tempoEsperaMinutos não pode ser negativo.");
        }

        this.nome = nome;
        this.nivelUrgencia = nivelUrgencia;
        this.tempoEsperaMinutos = tempoEsperaMinutos;
        this.grupoVulneravel = grupoVulneravel;
    }

    public String getNome() {
        return nome;
    }

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    public int getTempoEsperaMinutos() {
        return tempoEsperaMinutos;
    }

    public boolean isGrupoVulneravel() {
        return grupoVulneravel;
    }

    public String getCor() {
        switch (nivelUrgencia) {
            case 5: return "Vermelho";
            case 4: return "Laranja";
            case 3: return "Amarelo";
            case 2: return "Verde";
            case 1: return "Azul";
            default: return "Indefinido";
        }
    }

    @Override
    public int compareTo(Paciente outro) {
        if (this.nivelUrgencia != outro.nivelUrgencia) {
            return Integer.compare(this.nivelUrgencia, outro.nivelUrgencia);
        }

        if (this.tempoEsperaMinutos != outro.tempoEsperaMinutos) {
            return Integer.compare(this.tempoEsperaMinutos, outro.tempoEsperaMinutos);
        }

        if (this.grupoVulneravel != outro.grupoVulneravel) {
            return this.grupoVulneravel ? 1 : -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Paciente [nome=" + nome
                + ", urgencia=" + nivelUrgencia + " (" + getCor() + ")"
                + ", espera=" + tempoEsperaMinutos + "min"
                + ", vulneravel=" + grupoVulneravel + "]";
    }
}
