import java.util.ArrayList;

public class Fila {
    private ArrayList<Cliente> listaClientes;
    int quantidadeClientes;

    public Fila(){
        listaClientes = new ArrayList<Cliente>();
        quantidadeClientes = 0;
    }

    public void novoCliente(Cliente cliente){
        listaClientes.add(cliente);
        quantidadeClientes++;
    }

    public void removerCliente(int posicao){
        listaClientes.remove(posicao);
        quantidadeClientes--;
    }

    public ArrayList<Cliente> getListaClientes(){
        ArrayList<Cliente> novaLista = new ArrayList<Cliente>();
        for (Cliente cliente : listaClientes) {
            novaLista.add(cliente.clone());
        }
        return novaLista;
    }

    public int getQuantidadeClientes(){
        return quantidadeClientes;
    }
}
