package DAO;

import model.ModelAnuncio;
import util.ConexaoSQLite;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ariadna Morais
 */
public class DAOAnuncio extends ConexaoSQLite {

    /**
     * grava Anuncio
     *
     * @param pModelAnuncio
     * @return int
     */
    public int salvarAnuncioDAO(ModelAnuncio pModelAnuncio) {
        this.conectar();
        String sql
                = "INSERT INTO tbl_anuncio ("
                + "anu_descricao,"
                + "anu_cliente,"
                + "anu_valinvest,"
                + "anu_dateinicio,"
                + "anu_datefim,"
                + "anu_valtotalinvest,"
                + "anu_qtdmaxvisu,"
                + "anu_qtdmaxcliq,"
                + "anu_qtdmaxcompt"
                + ") VALUES (?,?,?,?,?,?,?,?,?);";

        try ( PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, pModelAnuncio.getAnuDescricao());
            preparedStatement.setString(2, pModelAnuncio.getAnuCliente());
            preparedStatement.setDouble(3, pModelAnuncio.getAnuValinvest());
            preparedStatement.setDouble(4, pModelAnuncio.getAnuDateinicio());
            preparedStatement.setDouble(5, pModelAnuncio.getAnuDatefim());
            preparedStatement.setDouble(6, pModelAnuncio.getAnuValtotalinvest());
            preparedStatement.setDouble(7, pModelAnuncio.getAnuQtdmaxvisu());
            preparedStatement.setDouble(8, pModelAnuncio.getAnuQtdmaxcliq());
            preparedStatement.setDouble(9, pModelAnuncio.getAnuQtdmaxcompt());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.desconectar();
        }

    }

    /**
     * recupera Anuncio
     *
     * @param pAnuncId
     * @return ModelAnuncio
     */
    public ModelAnuncio getAnuncioDAO(int pAnuncId) {
        ModelAnuncio modelAnuncio = null;

        String sql = "SELECT "
                + "pk_anunc_id,"
                + "anu_descricao,"
                + "anu_cliente,"
                + "anu_valinvest,"
                + "anu_dateinicio,"
                + "anu_datefim,"
                + "anu_valtotalinvest,"
                + "anu_qtdmaxvisu,"
                + "anu_qtdmaxcliq,"
                + "anu_qtdmaxcompt"
                + " FROM"
                + " tbl_anuncio"
                + " WHERE"
                + " pk_anunc_id = ?"
                + ";";

        this.conectar();

        try ( PreparedStatement preparedStatement = criarPreparedStatement(sql)) {

            preparedStatement.setInt(1, pAnuncId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelAnuncio = new ModelAnuncio();
                modelAnuncio.setAnuncId(resultSet.getInt(1));
                modelAnuncio.setAnuDescricao(resultSet.getString(2));
                modelAnuncio.setAnuCliente(resultSet.getString(3));
                modelAnuncio.setAnuValinvest(resultSet.getDouble(4));
                modelAnuncio.setAnuDateinicio(resultSet.getDouble(5));
                modelAnuncio.setAnuDatefim(resultSet.getDouble(6));
                modelAnuncio.setAnuValtotalinvest(resultSet.getDouble(7));
                modelAnuncio.setAnuQtdmaxvisu(resultSet.getDouble(8));
                modelAnuncio.setAnuQtdmaxcliq(resultSet.getDouble(9));
                modelAnuncio.setAnuQtdmaxcompt(resultSet.getDouble(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
        return modelAnuncio;
    }

    /**
     * recupera uma lista de Anuncio
     *
     * @return ArrayList
     */
    public ArrayList<ModelAnuncio> getListaAnuncioDAO() {
        ArrayList<ModelAnuncio> listamodelAnuncio = new ArrayList();
        ModelAnuncio modelAnuncio = null;

        String sql = "SELECT "
                + "pk_anunc_id,"
                + "anu_descricao,"
                + "anu_cliente,"
                + "anu_valinvest,"
                + "anu_dateinicio,"
                + "anu_datefim,"
                + "anu_valtotalinvest,"
                + "anu_qtdmaxvisu,"
                + "anu_qtdmaxcliq,"
                + "anu_qtdmaxcompt"
                + " FROM"
                + " tbl_anuncio"
                + ";";

        this.conectar();

        try ( PreparedStatement preparedStatement = criarPreparedStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelAnuncio = new ModelAnuncio();
                modelAnuncio.setAnuncId(resultSet.getInt(1));
                modelAnuncio.setAnuDescricao(resultSet.getString(2));
                modelAnuncio.setAnuCliente(resultSet.getString(3));
                modelAnuncio.setAnuValinvest(resultSet.getDouble(4));
                modelAnuncio.setAnuDateinicio(resultSet.getDouble(5));
                modelAnuncio.setAnuDatefim(resultSet.getDouble(6));
                modelAnuncio.setAnuValtotalinvest(resultSet.getDouble(7));
                modelAnuncio.setAnuQtdmaxvisu(resultSet.getDouble(8));
                modelAnuncio.setAnuQtdmaxcliq(resultSet.getDouble(9));
                modelAnuncio.setAnuQtdmaxcompt(resultSet.getDouble(10));
                listamodelAnuncio.add(modelAnuncio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
        return listamodelAnuncio;
    }

    /**
     * Vai calcular os valores de maxima
     * @paramp CondigoAnu
     * @return boolean
     */
    public boolean atualizarAnuncioDAO(int pCondigoAnu) {
        conectar();
        PreparedStatement preparedStatement;
        String sql
                = "update tbl_anuncio set anu_qtdmaxvisu = anu_valinvest * 33.416, anu_qtdmaxcliq = anu_valinvest * 0.39,  anu_qtdmaxcompt = anu_valinvest * 0.029"
                + " where pk_anunc_id = '" + pCondigoAnu + "'"
                + ";";

        //System.out.println(sql);
        preparedStatement = this.criarPreparedStatement(sql);
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAnuncio.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(DAOAnuncio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        this.desconectar();

        return true;

    }

    /**
     * exclui Anuncio
     *
     * @param pAnuncId
     * @return boolean
     */
    public boolean excluirAnuncioDAO(int pAnuncId) {
        conectar();
        PreparedStatement preparedStatement;
        String sql
                = "DELETE FROM tbl_anuncio "
                + " WHERE pk_anunc_id = '" + pAnuncId + "'";

        preparedStatement = this.criarPreparedStatement(sql);
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAnuncio.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(DAOAnuncio.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        this.desconectar();

        return true;

    }

}
