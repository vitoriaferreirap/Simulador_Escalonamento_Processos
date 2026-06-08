package sheduler;

public class Escalonador {
    /**
     * Decide quem vai usar a CPU e por quanto tempo. Devido As threads
     * compartilharem o mesmo espaço de memoria )
     * 
     * Chaveamento de contexto - Pausar uma thread, salvar seu estado e carregar
     * o estado da proximoa a ser excecutar.
     * Custo Chaveamento : salvar registradores, recarregar a MMU, pode invalidar
     * cache
     * 
     * Como escolhe a proxima thread (algoritmos):
     * Circular : fatia de tempo iguais - 20 à 50ms quantum perfeito (grande -
     * trava, pequeno-tempoChaveamento)
     * Prioridades: excecução hierarquica
     * Loteria: sorteio - previsibilidade matemática
     *
     * aqui entra algoritmos de escalonamento
     */
}