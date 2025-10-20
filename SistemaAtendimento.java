import java.util.Scanner;

class Elemento {
    String id;
    String descricao;
    String dataHora;

    Elemento(String id, String descricao, String dataHora) {
        this.id = id;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }

    Elemento(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.dataHora = null;
    }
}

class Node {
    Elemento elemento;
    Node proximo;

    Node(Elemento elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }
}

class Pilha {
    private Node topo;

    public Pilha() {
        topo = null;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public void push(Elemento elemento) {
        Node novo = new Node(elemento);
        novo.proximo = topo;
        topo = novo;
    }

    public Elemento pop() {
        if (estaVazia()) {
            System.out.println("Pilha vazia");
            return null;
        }
        Elemento e = topo.elemento;
        topo = topo.proximo;
        return e;
    }

    public void exibir() {
        if (estaVazia()) {
            System.out.println("Nenhum histórico disponível");
            return;
        }
        Node atual = topo;
        System.out.println("\n Histórico de Solicitações");
        while (atual != null) {
            System.out.println(atual.elemento.id + " | " + atual.elemento.descricao + " | " + atual.elemento.dataHora);
            atual = atual.proximo;
        }
    }
}

class Fila {
    private Node frente;
    private Node tras;

    public Fila() {
        frente = null;
        tras = null;
    }

    public boolean estaVazia() {
        return frente == null;
    }

    public void enfileirar(Elemento elemento) {
        Node novo = new Node(elemento);
        if (tras != null) {
            tras.proximo = novo;
        }
        tras = novo;
        if (frente == null) {
            frente = novo;
        }
    }

    public Elemento desenfileirar() {
        if (estaVazia()) {
            System.out.println("Fila vazia");
            return null;
        }
        Elemento e = frente.elemento;
        frente = frente.proximo;
        if (frente == null) tras = null;
        return e;
    }

    public void exibir() {
        if (estaVazia()) {
            System.out.println("Nenhum cliente na fila");
            return;
        }
        Node atual = frente;
        System.out.println("\n Fila de Atendimento ");
        while (atual != null) {
            System.out.println(atual.elemento.id + " | " + atual.elemento.descricao);
            atual = atual.proximo;
        }
    }
}

public class SistemaAtendimento {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pilha historico = new Pilha();
        Fila fila = new Fila();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n MENU PRINCIPAL ");
            System.out.println("1 Histórico de Solicitações");
            System.out.println("2 Fila de Atendimento");
            System.out.println("0 Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    menuHistorico(input, historico);
                    break;
                case 2:
                    menuFila(input, fila);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        input.close();
    }

    public static void menuHistorico(Scanner input, Pilha historico) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n HISTÓRICO DE SOLICITAÇÕES");
            System.out.println("1 Adicionar solicitação");
            System.out.println("2 Remover última solicitação");
            System.out.println("3 Exibir histórico");
            System.out.println("0 Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.print("ID da solicitação: ");
                    String id = input.nextLine();
                    System.out.print("Descrição: ");
                    String desc = input.nextLine();
                    System.out.print("Data e hora: ");
                    String dataHora = input.nextLine();
                    historico.push(new Elemento(id, desc, dataHora));
                    break;

                case 2:
                    Elemento removido = historico.pop();
                    if (removido != null)
                        System.out.println("Removido: " + removido.id);
                    break;

                case 3:
                    historico.exibir();
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal");
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public static void menuFila(Scanner input, Fila fila) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n FILA DE ATENDIMENTO ");
            System.out.println("1 Adicionar cliente à fila");
            System.out.println("2 Atender próximo cliente");
            System.out.println("3 Exibir fila");
            System.out.println("0 Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = input.nextLine();
                    System.out.print("Motivo do atendimento: ");
                    String motivo = input.nextLine();
                    fila.enfileirar(new Elemento(nome, motivo));
                    break;

                case 2:
                    Elemento atendido = fila.desenfileirar();
                    if (atendido != null)
                        System.out.println("Atendendo cliente: " + atendido.id + " | " + atendido.descricao);
                    break;

                case 3:
                    fila.exibir();
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal");
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
