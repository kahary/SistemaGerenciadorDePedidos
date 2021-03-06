/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelotabela;

import javax.swing.table.AbstractTableModel;
import restaurante.modelos.listas.PedidosConcluidosList;
import restaurante.entidades.Pedido;

/**
 *
 * @author David .V
 */
public class ModeloTabelaPedidosConcluidos extends AbstractTableModel implements Runnable{
    
    private final String[] nomeColunas = {"Pedido", "TempoTotal"};
    private PedidosConcluidosList pedidosConcluidos;
    
    public ModeloTabelaPedidosConcluidos(PedidosConcluidosList pedidosConcluidos){
        this.pedidosConcluidos = pedidosConcluidos;
    }
    
    @Override
    public int getRowCount() {
        return pedidosConcluidos.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
               Pedido item = (Pedido) pedidosConcluidos.get( rowIndex );
         switch( columnIndex ) {
             case 0: return item.getNome();
             case 1: if((item.getTempoTotal()/60) <10 && item.getTempoTotal()%60 >=10){
                        return ("0"+item.getTempoTotal()/60) +":"+ Math.abs((item.getTempoTotal()%60));
                    } 
                     else if(item.getTempoTotal()/60 <10 && item.getTempoTotal()%60 <10){
                        return ("0"+item.getTempoTotal()/60) +":0"+ Math.abs((item.getTempoTotal()%60));
                    }
                     else if((item.getTempoTotal()%60) <10 && item.getTempoTotal()/60 >=10){
                        return (item.getTempoTotal()/60) +":0"+ Math.abs((item.getTempoTotal()%60));
                    }
                     return (item.getTempoTotal()/60) +":"+ Math.abs((item.getTempoTotal()%60));
         }
         return null;
        
    }

    @Override
    public void run() {
        super.fireTableDataChanged();
    }
    
}
