/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controladores;

import java.util.List;
import restaurante.entidades.ItemDoMenu;
import restaurante.modelos.listas.MenuList;
import restaurante.modelotabela.ModeloTabelaItemDeMenu;

/**
 *
 * @author David .V
 */
public class  TabelaDeItensDoMenu{
    List<ItemDoMenu> menu = new MenuList();
    private javax.swing.table.TableModel modeloTabela = new ModeloTabelaItemDeMenu(getListaMenu());
    private javax.swing.JTable filaDeEsperaTabela;
    Thread thmodelo = new Thread((Runnable) modeloTabela);
    
    public TabelaDeItensDoMenu(){    
    }
    
    public MenuList getListaMenu(){
        return (MenuList)menu;
    }

    /**
     * @return the modeloTabela
     */
    public javax.swing.table.TableModel getModeloTabela() {
        return modeloTabela;
    }
}
