/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelUsuario;
import util.ConexaoSQLite;

/**
 *
 * @author Ariadna Morais
 */
public class DAOUsuario extends ConexaoSQLite {

    /**
     * Método que salva um novo usuário no banco de dados
     *
     * @param pModelUsuario
     * @return
     *
     */
    public boolean salvarUsuarioDAO(ModelUsuario pModelUsuario) {

        conectar();
        //executar sql
        String sql = "INSERT INTO tbl_usuario ("
                + "usu_nome, "
                + "usu_login, "
                + "usu_senha) "
                + "VALUES (?,?,?)";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, pModelUsuario.getUsuNome());
            preparedStatement.setString(2, pModelUsuario.getUsuLogin());
            preparedStatement.setString(3, pModelUsuario.getUsuSenha());
            int executeUpdate = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        desconectar();
        return true;
    }

    /**
     * Retorna lista de objetos do banco
     *
     * @return
     */
    public List<ModelUsuario> getListaUsuarioDAO() {
        List<ModelUsuario> listaUsuario = new ArrayList<>();
        ModelUsuario modelUsuario = new ModelUsuario();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT pk_usu_id, "
                + "usu_nome, "
                + "usu_login, "
                + "usu_senha "
                + "FROM tbl_usuario";

        try {
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                modelUsuario = new ModelUsuario(); //serve para limpar o resultado, para nao acumular lixo de memoria
                modelUsuario.setUsuId(resultSet.getInt(1)); //a numeração é referente ao numero da coluna da tabela de usuario
                modelUsuario.setUsuNome(resultSet.getString(2)); //a numeração é referente ao numero da coluna da tabela de usuario
                modelUsuario.setUsuLogin(resultSet.getString(3)); //a numeração é referente ao numero da coluna da tabela de usuario
                modelUsuario.setUsuSenha(resultSet.getString(4)); //a numeração é referente ao numero da coluna da tabela de usuario
                listaUsuario.add(modelUsuario);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        desconectar();
        return listaUsuario;
    }

    /**
     * exclui um usuario pelo código
     *
     * @param pCodigo
     * @return boolean
     */
    public boolean excluirUsuarioDAO(int pCodigo) {
        conectar();
        PreparedStatement preparedStatement;
        String sql = "DELETE FROM tbl_usuario WHERE pk_usu_id = '" + pCodigo + "'";
        preparedStatement = this.criarPreparedStatement(sql);
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.desconectar();
        return true;
    }

    // Editar Usuário
    public ModelUsuario getUsuarioDAO(int pCodigoUsuario) {
        ModelUsuario modelUsuario = new ModelUsuario();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT pk_usu_id, "
                + "usu_nome, "
                + "usu_login, "
                + "usu_senha "
                + "FROM tbl_usuario WHERE pk_usu_id = '" + pCodigoUsuario + "'";

        preparedStatement = criarPreparedStatement(sql);
        try {
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setUsuId(resultSet.getInt("pk_usu_id"));
                modelUsuario.setUsuNome(resultSet.getString("usu_nome"));
                modelUsuario.setUsuLogin(resultSet.getString("usu_login"));
                modelUsuario.setUsuSenha(resultSet.getString("usu_senha"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e);
        }
        desconectar();
        return modelUsuario;
    }

    /*
    * Atualizar Usuario
    * @param modelUsuario
    * @return
     */
    public boolean atualizarUsuario(ModelUsuario modelUsuario) {
        this.conectar();
        String sql = "UPDATE tbl_usuario SET "
                + "usu_nome=?, "
                + "usu_login=?, "
                + "usu_senha=? "
                + "WHERE pk_usu_id = '" + modelUsuario.getUsuId() + "'";

        PreparedStatement preparedStatement = this.criarPreparedStatement(sql);
        try {
            preparedStatement.setString(1, modelUsuario.getUsuNome());
            preparedStatement.setString(2, modelUsuario.getUsuLogin());
            preparedStatement.setString(3, modelUsuario.getUsuSenha());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.desconectar();
        return true;
    }

    /**
     * Valida Usuario e senha no banco de dados
     *
     * @param modelUsuario
     * @return
     */
    public boolean validarUsuario(ModelUsuario modelUsuario) {
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT pk_usu_id, "
                + "usu_nome, "
                + "usu_login, "
                + "usu_senha "
                + "FROM tbl_usuario WHERE usu_login = '" + modelUsuario.getUsuLogin() + "' AND "
                + "usu_senha = '" + modelUsuario.getUsuSenha() + "'";
        
        //System.out.println(sql); //em caso de erro com a consulta do sql, utilizar esse println para informar no terminal a consulta e identificar o erro.

        preparedStatement = criarPreparedStatement(sql);
        try {
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                desconectar();

            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        }
    }

}
