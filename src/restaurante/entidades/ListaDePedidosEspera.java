/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.controladores.PedidosList;
import restaurante.modelotabela.ModeloTabelaPedidosEspera;

/**
 *
 * @author David .V
 */
public class  ListaDePedidosEspera implements Runnable{
    List<Pedido> pedidos = new PedidosList();
    private javax.swing.table.TableModel modeloTabela = new ModeloTabelaPedidosEspera(getListadePedidos());
    private javax.swing.JTable filaDeEsperaTabela;
    ItemDoMenu item = new ItemDoMenu(1, "Macarronada", 2.50, 30);
    Pedido pedido = new Pedido(item);
    Thread thpedidos = new Thread((Runnable) pedidos);
    Thread thmodelo = new Thread((Runnable) modeloTabela);
    
    public ListaDePedidosEspera(){
        this.pedidos.add(pedido);      
    }
    
    public long getTempoDecorrido(){
        return pedido.getTempoEsperando();
    }
    
    public  String getNomeDoPedido(){
        return pedido.getNome();
    }
    
    public PedidosList getListadePedidos(){
        return (PedidosList)pedidos;
    }
    
    public void addPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }
    
    @Override
    public void run() {
        while(true){
            try {
                thpedidos.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ListaDePedidosEspera.class.getName()).log(Level.SEVERE, null, ex);
            }
                thpedidos.run();
            for (Pedido pedidoF : pedidos) {
                if(pedidoF.isAtrazado()){
                    
                }
            }
                thmodelo.run();
            
        }
    }

    /**
     * @return the modeloTabela
     */
    public javax.swing.table.TableModel getModeloTabela() {
        return modeloTabela;
    }

    /**
     * @param modeloTabela the modeloTabela to set
     */
    public void setModeloTabela(javax.swing.table.TableModel modeloTabela) {
        this.modeloTabela = modeloTabela;
    }
}