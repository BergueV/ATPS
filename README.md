# ATPS

# Sistema de Atendimento

Este projeto implementa um Sistema de Atendimento simples utilizando estruturas de dados manuais, uma fila para gerenciar os atendimentos pendentes e uma pilha para armazenar o histórico de atendimentos concluídos.

O código segue restrições de não utilizar funções prontas de manipulação de estruturas


## Estrutura

O arquivo principal:

```
SistemaAtendimento.java
```

Ele contém as seguintes classes:

# Elemento

Representa um item do sistema (um atendimento).

Atributos:

`String id` Identificação do atendimento.
  `String descricao` Descrição do atendimento.
  `String dataHora` Data e hora do atendimento.

Construtores:

Um com `id`, `descricao` e `dataHora`.
Outro com `id` e `descricao`.

# `Node`

Representa um nó das estruturas encadeadas.

Atributos:

 `Elemento elemento` O conteúdo do nó.
  `Node proximo` Referência para o próximo nó.

# `Pilha`

Implementa uma pilha manualmente.

Principais métodos:

`push(Elemento e)` → Empilha um novo elemento no topo.
`pop()` → Remove e retorna o elemento do topo.
`estaVazia()` → Verifica se a pilha está vazia.
`exibir()` → Mostra todos os elementos do histórico.

Uso no sistema:
Armazena o histórico de atendimentos concluídos.

# `Fila`

Implementa uma fila manualmente.

Principais métodos:

`enfileirar(Elemento e)` Adiciona um novo elemento ao fim da fila.
 `desenfileirar()` Remove e retorna o elemento da frente da fila.
 `estaVazia()` Verifica se a fila está vazia.
 `exibir()` Exibe os atendimentos pendentes.

Uso no sistema:
Gerencia os atendimentos ainda não realizados.


# `SistemaAtendimento`

Classe principal que controla o fluxo do programa e interage com o usuário.

Funcionalidades do Menu:

Adicionar atendimento à fila
   Solicita `id` e `descrição` e adiciona um novo elemento na fila de espera.

Atender próximo da fila
   Remove o próximo elemento da fila e o adiciona ao histórico.

Exibir fila atual
   Mostra todos os atendimentos que ainda não foram realizados.

Exibir histórico de atendimentos
   Mostra os atendimentos já concluídos.

Sair do sistema

# Lógica de Funcionamento

Quando o usuário adiciona um novo atendimento: ele entra na fila (`enfileirar`).
Ao escolher “atender próximo”: o primeiro da fila é removido (`desenfileirar`) e empilhado no histórico (`push`).
O histórico mantém a ordem inversa.
O sistema permite exibir tanto a fila de espera quanto o histórico concluído.


# Execução

Para compilar e executar:

```bash
javac SistemaAtendimento.java
java SistemaAtendimento
```

O sistema abrirá um menu interativo no console, permitindo adicionar, atender e visualizar atendimentos.

---

