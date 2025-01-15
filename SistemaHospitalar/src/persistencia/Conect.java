package persistencia;

import java.sql.Connection;
import java.sql.SQLException;

public class Conect {
    public static void main(String[] args) {
        ConexaoBanco conexaoBanco = new ConexaoBanco();
        Connection conexao = null;
        try {
            conexao = conexaoBanco.getConexao();
            if (conexao != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao estabelecer a conexão: " + e.getMessage());
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        }
    }
}