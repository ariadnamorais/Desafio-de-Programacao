package controller;

import model.ModelAnuncio;
import DAO.DAOAnuncio;
import java.util.ArrayList;

/**
 *
 * @author Ariadna Morais
 */
public class ControllerAnuncio {

    private DAOAnuncio daoAnuncio = new DAOAnuncio();

    /**
     * grava Anuncio
     *
     * @param pModelAnuncio
     * @return int
     */
    public int salvarAnuncioController(ModelAnuncio pModelAnuncio) {
        return this.daoAnuncio.salvarAnuncioDAO(pModelAnuncio);
    }

    /**
     * recupera Anuncio
     *
     * @param pAnuncId
     * @return ModelAnuncio
     */
    public ModelAnuncio getAnuncioController(int pAnuncId) {
        return this.daoAnuncio.getAnuncioDAO(pAnuncId);
    }

    /**
     * recupera uma lista deAnuncio
     *
     * @param pAnuncId
     * @return ArrayList
     */
    public ArrayList<ModelAnuncio> getListaAnuncioController() {
        return this.daoAnuncio.getListaAnuncioDAO();
    }

    /**
     * atualiza Anuncio
     *
     * @return boolean
     */
    //public int atualizarAnuncioController(ModelAnuncio modelAnuncio) {
    //    return this.daoAnuncio.atualizarAnuncioDAO(modelAnuncio);
   // }

    /**
     * exclui Anuncio
     * @param codigo
     * @return boolean
     */
    public boolean excluirAnuncioController(int codigo) {
        return this.daoAnuncio.excluirAnuncioDAO(codigo);
    }

    //public boolean atualizarAnuncioController(int codigoanun) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //  }

    public boolean calcularAnuncioController(int pCondigoAnu) {
        return this.daoAnuncio.atualizarAnuncioDAO(pCondigoAnu);
    }
    
}
