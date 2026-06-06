package model;

public enum EstadoProcesso {
    // Enum de estado de processo/thread
    NOVO, // processo acabou de ser criado mais nao entrou na fila
    PRONTO, // aguardando na fila para ser executado pela CPU
    EXECUTANDO, // sendo processado ativamente pelo nucleo da CPU
    BLOQUEADO, // esperando por alguma operação simulada, ex: entrada/saida
    CONCLUIDO // execução finalizada com sucesso
}
