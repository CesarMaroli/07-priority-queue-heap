package heap;

public class FilaComPrioridadeHeap<T extends Comparable<T>> {
    private final T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public FilaComPrioridadeHeap(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }
        this.elementos = (T[]) new Comparable[capacidade];
        this.tamanho = 0;
    }

    public void enfileirar(T elemento) {
        if (estaCheia()) {
            throw new RuntimeException("A fila está cheia.");
        }

        elementos[tamanho] = elemento;
        subir(tamanho);
        tamanho++;
    }

    public T desenfileirar() {
        if (estaVazia()) {
            throw new RuntimeException("A fila está vazia.");
        }

        T raiz = elementos[0];
        tamanho--;
        elementos[0] = elementos[tamanho];
        elementos[tamanho] = null;

        if (tamanho > 0) {
            descer(0);
        }

        return raiz;
    }

    public T frente() {
        if (estaVazia()) {
            throw new RuntimeException("A fila está vazia.");
        }
        return elementos[0];
    }

    private void subir(int indice) {
        while (indice > 0) {
            int pai = (indice - 1) / 2;
            if (elementos[indice].compareTo(elementos[pai]) > 0) {
                trocar(indice, pai);
                indice = pai;
            } else {
                break;
            }
        }
    }

    private void descer(int indice) {
        while (true) {
            int esquerda = 2 * indice + 1;
            int direita = 2 * indice + 2;
            int maior = indice;

            if (esquerda < tamanho && elementos[esquerda].compareTo(elementos[maior]) > 0) {
                maior = esquerda;
            }
            if (direita < tamanho && elementos[direita].compareTo(elementos[maior]) > 0) {
                maior = direita;
            }

            if (maior == indice) {
                break;
            }

            trocar(indice, maior);
            indice = maior;
        }
    }

    private void trocar(int i, int j) {
        T temp = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = temp;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == elementos.length;
    }

    public int tamanho() {
        return tamanho;
    }

    public int capacidade() {
        return elementos.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(elementos[i]);
            if (i < tamanho - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
