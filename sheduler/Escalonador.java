package sheduler;

import java.util.ArrayList;
import java.util.List;

import model.ThreadSimulada;
import queue.FilaCompartilhada;

public class Escalonador {
    /**
     * * Decide quem vai usar a CPU e por quanto tempo. Devido As
     * threadscompartilharem o mesmo espaço de memoria )
     * Chaveamento de contexto - Pausar uma thread, salvar seu estado e carregar
     *
     * o estado da proximoa a ser excecutar.
     * Custo Chaveamento : salvar registradores, recarregar a MMU, pode
     * invalidarcache
     * Como escolhe a proxima thread (algoritmos):
     * Circular : fatia de tempo iguais - 20 à 50ms quantum perfeito (grande -
     * trava, pequeno-tempoChaveamento)
     * Prioridades: excecução hierarquica
     * Loteria: sorteio - previsibilidade matemática
     */

    private FilaCompartilhada filaDeProntos;
    private int quantum;
    private String algoritmo; // "ROUND_ROBIN" ou "FIFO"

    // AQUI ESTÁ O REQUISITO: Lista de núcleos para atender a arquitetura multicore
    private List<NucleoCPU> nucleos;

    public Escalonador(FilaCompartilhada filaDeProntos, int quantum, String algoritmo, int numNucleos) {
        this.filaDeProntos = filaDeProntos;
        this.quantum = quantum;
        this.algoritmo = algoritmo;
        this.nucleos = new ArrayList<>();
        // Inicializa os núcleos simulados
        for (int i = 0; i < numNucleos; i++) {
            nucleos.add(new NucleoCPU(i));
        }
    }

    // AQUI ESTÁ O REQUISITO: Implementação de dois algoritmos (Round Robin e FIFO)
    public void iniciarEscalonamento() {
        new Thread(() -> {
            while (!filaDeProntos.estaVazia()) {
                ThreadSimulada threadAtual = filaDeProntos.removerProcesso();

                if (threadAtual != null) {
                    NucleoCPU nucleoEscolhido = buscarNucleoLivre();

                    if (nucleoEscolhido != null) {
                        nucleoEscolhido.executar(threadAtual);

                        // Não bloquea, Lança uma nova thread para gerenciar o tempo do
                        // núcleo
                        new Thread(() -> {
                            if (algoritmo.equalsIgnoreCase("ROUND_ROBIN")) {
                                executarRoundRobin(threadAtual, nucleoEscolhido);
                            } else {
                                executarFIFO(threadAtual, nucleoEscolhido);
                            }
                        }).start();

                    } else {
                        // Se não há núcleo, espera um pouco antes de tentar de novo
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                        }
                        filaDeProntos.adicionarProcesso(threadAtual);
                    }
                }
            }
        }).start();
    }

    // Busca um núcleo disponível (Requisito de arquitetura multicore)
    private NucleoCPU buscarNucleoLivre() {
        for (NucleoCPU n : nucleos) {
            if (n.isEstaLivre())
                return n;
        }
        return null;
    }

    // Algoritmo: Round Robin (com interrupção via quantum)
    private void executarRoundRobin(ThreadSimulada t, NucleoCPU n) {
        try {
            Thread.sleep(quantum);
            if (t.isAlive()) {
                t.interrupt();
                System.out.println("Processo " + t.getProcesso().getId() + " interrompido (RR).");
            }
            n.setEstaLivre(true); // Libera o núcleo após o quantum
        } catch (InterruptedException e) {
            System.err.println("Erro Round Robin.");
        }
    }

    // AQUI ESTÁ O REQUISITO: Algoritmo FIFO (executa até o fim, sem interrupção por
    // quantum)
    private void executarFIFO(ThreadSimulada t, NucleoCPU n) {
        try {
            t.join(); // O escalonador espera o processo terminar completamente
            System.out.println("Processo " + t.getProcesso().getId() + " finalizado (FIFO).");
            n.setEstaLivre(true); // Libera o núcleo após finalizar
        } catch (InterruptedException e) {
            System.err.println("Erro FIFO.");
        }
    }
}