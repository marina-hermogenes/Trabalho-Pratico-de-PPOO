import java.awt.Image;
import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Sistema {
    private static final int QUANT_CAIXAS = 4;
    private Fila menorFila;
    private Random rand;
    private ArrayList<Caixa> listaCaixa;

    public Sistema(){
        rand = new Random(3578);
        int X = 2;
        listaCaixa = new ArrayList<Caixa>();
        Image imagemCaixa = new ImageIcon(getClass().getResource("Imagens/caixa.jpeg")).getImage();
        for (int i = 0; i < QUANT_CAIXAS; i++){
            listaCaixa.add(new Caixa(new Localizacao(X, 0), imagemCaixa));
            X += 2;
        }
        menorFila = listaCaixa.get(0).getFila();
    }

    public Cliente criarCliente(){
        Image imagem;
        if (rand.nextInt(2) == 0){
            imagem = new ImageIcon(getClass().getResource("Imagens/homemCostas.jpeg")).getImage();
        } else {
            imagem = new ImageIcon(getClass().getResource("Imagens/mulherCostas.jpeg")).getImage();
        }
        Cliente novoCliente = new Cliente(new Localizacao(35,0), imagem);
        return novoCliente;
    }

    public void adicionarClienteNaFila(Cliente cliente){
        menorFila.novoCliente(cliente);
    }

    public void moverCliente(){
        for (Caixa caixa: listaCaixa){
            if(caixa.getFila().getQuantidadeClientes() > menorFila.getQuantidadeClientes()){
                Cliente cliente = caixa.getFila().removerCliente((caixa.getFila().getQuantidadeClientes())-1);
                menorFila.novoCliente(cliente);
                cliente.trocarFilaCliente(this, menorFila);
            }
        }
    }

    public Fila getMenorFila(){
        return menorFila;
    }

    public Fila calcularMenorFila(){
        for (Caixa caixa: listaCaixa){
            if (caixa.getFila().getQuantidadeClientes() < menorFila.getQuantidadeClientes()){
                menorFila = caixa.getFila();
            }
        }
        return menorFila;
    }

    public ArrayList<Caixa> getListaCaixa(){
        return listaCaixa;
    }
}
