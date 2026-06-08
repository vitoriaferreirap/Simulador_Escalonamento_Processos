package model;

/**
 * 
 * A classe ThreadSimulada atua como motor de execução do Processo. Ela
 * encapsula um objeto
 * Processo e estende a classe Thread nativa do java, que permite que o
 * escalonador gerencia seu ciclo de vida
 * (inicio, pausa, termino) dentro da JVM
 */

public class ThreadSimulada extends Thread {
    // Referência direta ao objeto Processo que esta thread representa
    // Serve como ponte, entre os dados do processo e a execução do SO
    private Processo processo;

    /**
     * Atributos de controle de escalonador: Esses valores permitem que o
     * escalonador tome
     * decisães de priorização e organização mas filas (Ready/Wait)
     */
    private int tempoChegada;
    private int prioridade;

    public ThreadSimulada(Processo processo) {
        this.processo = processo;
        // inicializa aqui a prioridade ou o tempo se vierem do obj Processo
    }

    // Método para executar logica de processamento - forma de consumir a CPU

}
