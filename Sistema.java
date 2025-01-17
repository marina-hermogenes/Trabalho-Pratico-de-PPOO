import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Sistema {
    private static final int QUANT_CAIXAS = 4;
    private Fila menorFila;
    private Random rand;
    private ArrayList<Caixa> listaCaixa;

    public Sistema(){
        menorFila = null;
        rand = new Random(3578);
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
        if (menorFila != null){
            menorFila.novoCliente(cliente);
        } else {
            
        }
    }

    public void moverCliente(){
        for (Caixa caixa: listaCaixa){
            if(caixa.getFila().getQuantidadeClientes() > menorFila.getQuantidadeClientes()){
                Cliente cliente = caixa.getFila().removerCliente((caixa.getFila().getQuantidadeClientes())-1);
                menorFila.novoCliente(cliente);
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
}
