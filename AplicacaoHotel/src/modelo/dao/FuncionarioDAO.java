package modelo.dao;

import conexao.FabricaConexao;
import modelo.bean.funcionarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    // CREATE
    public void create(funcionarios f) {
        Connection con = FabricaConexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "INSERT INTO funcionarios (nome, sobrenome, cpf, rg, sexo, cargo, foto, usuario, senha, acesso, email, celular, fixo, rua, numero, complemento, bairro, cidade) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
            );
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getSobrenome());
            stmt.setString(3, f.getCpf());
            stmt.setString(4, f.getRg());
            stmt.setString(5, f.getSexo());
            stmt.setString(6, f.getCargo());
            stmt.setString(7, f.getFoto());
            stmt.setString(8, f.getUsuario());
            stmt.setString(9, f.getSenha());
            stmt.setString(10, f.getAcesso());
            stmt.setString(11, f.getEmail());
            stmt.setString(12, f.getCelular());
            stmt.setString(13, f.getFixo());
            stmt.setString(14, f.getRua());
            stmt.setString(15, f.getNumero());
            stmt.setString(16, f.getComplemento());
            stmt.setString(17, f.getBairro());
            stmt.setString(18, f.getCidade());

            stmt.executeUpdate();
            System.out.println("Funcionario salvo com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar: " + ex);
        } finally {
            FabricaConexao.closeConnection(con, stmt);
        }
    }

    // READ
    public List<funcionarios> read() {
        Connection con = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<funcionarios> funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios");
            rs = stmt.executeQuery();

            while (rs.next()) {
                funcionarios f = new funcionarios();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setSobrenome(rs.getString("sobrenome"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setSexo(rs.getString("sexo"));
                f.setCargo(rs.getString("cargo"));
                f.setFoto(rs.getString("foto"));
                f.setUsuario(rs.getString("usuario"));
                f.setSenha(rs.getString("senha"));
                f.setAcesso(rs.getString("acesso"));
                f.setEmail(rs.getString("email"));
                f.setCelular(rs.getString("celular"));
                f.setFixo(rs.getString("fixo"));
                f.setRua(rs.getString("rua"));
                f.setNumero(rs.getString("numero"));
                f.setComplemento(rs.getString("complemento"));
                f.setBairro(rs.getString("bairro"));
                f.setCidade(rs.getString("cidade"));

                funcionarios.add(f);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler: " + ex);
        } finally {
            FabricaConexao.closeConnection(con, stmt, rs);
        }

        return funcionarios;
    }

    // UPDATE
    public void update(funcionarios f) {
        Connection con = FabricaConexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "UPDATE funcionarios SET nome=?, sobrenome=?, cpf=?, rg=?, sexo=?, cargo=?, foto=?, usuario=?, senha=?, acesso=?, email=?, celular=?, fixo=?, rua=?, numero=?, complemento=?, bairro=?, cidade=? WHERE id=?"
            );

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getSobrenome());
            stmt.setString(3, f.getCpf());
            stmt.setString(4, f.getRg());
            stmt.setString(5, f.getSexo());
            stmt.setString(6, f.getCargo());
            stmt.setString(7, f.getFoto());
            stmt.setString(8, f.getUsuario());
            stmt.setString(9, f.getSenha());
            stmt.setString(10, f.getAcesso());
            stmt.setString(11, f.getEmail());
            stmt.setString(12, f.getCelular());
            stmt.setString(13, f.getFixo());
            stmt.setString(14, f.getRua());
            stmt.setString(15, f.getNumero());
            stmt.setString(16, f.getComplemento());
            stmt.setString(17, f.getBairro());
            stmt.setString(18, f.getCidade());
            stmt.setInt(19, f.getId());

            stmt.executeUpdate();
            System.out.println("Funcionario atualizado com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar: " + ex);
        } finally {
            FabricaConexao.closeConnection(con, stmt);
        }
    }

    // DELETE
    public void delete(funcionarios f) {
        Connection con = FabricaConexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM funcionarios WHERE id = ?");
            stmt.setInt(1, f.getId());

            stmt.executeUpdate();
            System.out.println("Funcionario deletado com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar: " + ex);
        } finally {
            FabricaConexao.closeConnection(con, stmt);
        }
    }
}

