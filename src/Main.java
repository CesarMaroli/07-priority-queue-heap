import entidades.Paciente;
import heap.FilaComPrioridadeHeap;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hospital São Binário - Triagem do Pronto-Socorro ===\n");

        FilaComPrioridadeHeap<Paciente> triagem = new FilaComPrioridadeHeap<>(10);

        Paciente[] pacientes = {
            new Paciente("Carlos",  2, 45, false),
            new Paciente("Maria",   5,  5, false),
            new Paciente("João",    3, 20, false),
            new Paciente("Beatriz", 3, 35, true),
            new Paciente("Pedro",   5,  2, false),
            new Paciente("Helena",  2, 45, true)
        };

        System.out.println("--- Registro de chegada dos pacientes ---");
        for (Paciente p : pacientes) {
            triagem.enfileirar(p);
            System.out.println("\nChegou: " + p.getNome());
            System.out.println("Heap interno: " + triagem);
        }

        System.out.println("\n--- Ordem de atendimento ---");
        int posicao = 1;
        while (!triagem.estaVazia()) {
            Paciente atendido = triagem.desenfileirar();
            System.out.println(posicao + ". " + atendido);
            posicao++;
        }
    }
}
