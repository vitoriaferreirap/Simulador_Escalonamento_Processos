package sheduler;

import model.ThreadSimulada;
import queue.FilaCompartilhada;

public class Escalonador {
    /**
     * Decide quem vai usar a CPU e por quanto tempo. Devido As threads
     * compartilharem o mesmo espaço de memoria )
     * * Chaveamento de contexto - Pausar uma thread, salvar seu estado e carregar
     * o estado da proximoa a ser excecutar.
     * Custo Chaveamento : salvar registradores, recarregar a MMU, pode invalidar
     * cache
     * * Como escolhe a proxima thread (algoritmos):
     * Circular : fatia de tempo iguais - 20 à 50ms quantum perfeito (grande -
     * trava, pequeno-tempoChaveamento)
     * Prioridades: excecução hierarquica
     * Loteria: sorteio - previsibilidade matemática
     *
     */

    private FilaCompartilhada filaDeProntos;
    private int quantum;

    public Escalonador(FilaCompartilhada filaDeProntos, int quantum) {
        this.filaDeProntos = filaDeProntos;
        this.quantum = quantum;
    }

    // Executa a lógica de escalonamento
    public void iniciarEscalonamento() {
        while (!filaDeProntos.estaVazia()) {
            ThreadSimulada threadAtual = filaDeProntos.removerProcesso();

            if (threadAtual != null) {
                // Inicia o thread (o SO dá o start)
                threadAtual.start();

                try {
                    // Simula o tempo do quantum na CPU
                    Thread.sleep(quantum);

                    // Se a thread ainda estiver viva, interrompe para chaveamento
                    if (threadAtual.isAlive()) {
                        threadAtual.interrupt();
                    }
                } catch (InterruptedException e) {
                    System.err.println("Erro no escalonamento de processo.");
                }
            }
        }
    }
}