package com.db.estudo.repositorio;

import com.db.estudo.config.SQLiteDBConfig;
import com.db.estudo.model.Pessoa;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component("sqlite")
public class RepositorioPessoaSQLite implements RepositorioPessoa {

    public void cadastrarPessoa(String nome, int idade) throws RepositorioGenericException {
        String sql = "INSERT INTO PES_PESSOA (PES_NOME, PES_IDADE) VALUES (?, ?)";

        try (
                Connection conn = SQLiteDBConfig.getConnection();
                PreparedStatement psmt = conn.prepareStatement(sql)
        ) {
            log.debug("Conexão com o banco de dados OK!");
            psmt.setString(1, nome);
            psmt.setInt(2, idade);
            int rowsInserted = psmt.executeUpdate();
            log.debug("rowsInserted: {}", rowsInserted);
        } catch (SQLException exception) {
            log.error("Ocorreu um exception: {}", exception.toString());
            throw new RepositorioGenericException(exception.getMessage(), exception);
        }
    }

    public List<Pessoa> buscarTodasPessoas() throws RepositorioGenericException {
        String sql = "SELECT PES_ID, PES_NOME, PES_IDADE, PES_OBSERVACAO FROM PES_PESSOA";

        try (
                Connection conn = SQLiteDBConfig.getConnection();
                PreparedStatement psmt = conn.prepareStatement(sql)
        ) {
            try (ResultSet rs = psmt.executeQuery()) {
                if (!rs.next()) {
                    log.debug("Nenhuma pessoa retornada.");
                    return Collections.emptyList();
                }

                List<Pessoa> pessoas = new ArrayList<>();
                do {
                    pessoas.add(new Pessoa(rs.getString("PES_NOME"), rs.getInt("PES_IDADE")));
                } while (rs.next());

                log.debug("{} pessoas retornadas.", pessoas.size());
                return pessoas;
            }
        } catch (SQLException exception) {
            log.error("Ocorreu um exception: {}", exception.toString());
            throw new RepositorioGenericException(exception.getMessage(), exception);
        }
    }

}
