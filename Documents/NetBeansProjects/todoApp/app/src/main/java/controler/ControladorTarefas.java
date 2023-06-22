/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Tarefas;
import util.conexaodb;

/**
 *
 * @author prisc
 */
public class ControladorTarefas {
    
    public void salvar (Tarefas tarefas) throws SQLException{
        
        String sql = "INSERT INTO (idProjeto" 
                + "nome,"
                + "descricao,"
                + "completado,"
                + "observacoes,"
                + "prazo,"
                + "dataCriacao,"
                + "dataAtualizacao) VALUES (?,?,?,?,?,?,?,?)";
                                        
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = conexaodb.getConnection();
            statement = connection.prepareStatement(sql); 
            statement.setInt(1, tarefas.getIdProjeto());
            statement.setString(2, tarefas.getNome());
            statement.setString(3, tarefas.getDescricao());
            statement.setBoolean(4, tarefas.getCompletado());
            statement.setString(5, tarefas.getObservacoes());
            statement.setDate(6, new java.sql.Date(tarefas.getPrazo().getTime()));
            statement.setDate(7, new java.sql.Date (tarefas.getDataCriacao().getTime()));
            statement.setDate(8, new java.sql.Date (tarefas.getDataAtualizacao().getTime()));
        }catch(Exception e){
        
        }
    }
    
    public void atualizar (Tarefas tarefas){
        
    }
    
    public void removerPorId (int tarefaId) throws SQLException{
        
        String sql = "DELETE FROM tarefas WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
          conn = conexaodb.getConnection();
          //ajuda a preparar o comando sql que vai ser executado no DB
          statement = conn.prepareStatement(sql);
          //setar o valor no '?' no sql
          statement.setInt(1, tarefaId);
          statement.execute();
            
        } catch (SQLException e){
            throw new SQLException("Erro ao deletar a tarefa");
        } finally {
            conexaodb.closeConnection(conn);
        }
    }
    
    public List<Tarefas> getAll(int idProjeto){
        return null;
    }
}
