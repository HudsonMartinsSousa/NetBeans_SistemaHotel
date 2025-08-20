package teste;

import modelo.bean.funcionarios;
import modelo.dao.FuncionarioDAO;

public class TesteFuncionario {
    public static void main(String[] args) {
        funcionarios f = new funcionarios();
        f.setNome("Hudson");
        f.setSobrenome("Martins");
        f.setCpf("12345678900");
        f.setUsuario("hudson");
        f.setSenha("1234");
        f.setEmail("hudson@email.com");
        f.setCidade("Belo Horizonte");

        FuncionarioDAO dao = new FuncionarioDAO();

        // CREATE
        dao.create(f);

        // READ
        for (funcionarios func : dao.read()) {
            System.out.println(func);
        }

        // UPDATE
        f.setId(1); // exemplo
        f.setNome("Hudson Atualizado");
        dao.update(f);

        // DELETE
        // dao.delete(f);
    }
}