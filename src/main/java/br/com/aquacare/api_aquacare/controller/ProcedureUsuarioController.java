package br.com.aquacare.api_aquacare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procedure_usuario")
public class ProcedureUsuarioController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/add")
    public void addUsuario(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String senha) {
        String sql = "BEGIN CRUD_AQUACARE_USUARIO('CREATE', NULL, ?, ?, ?); END;";
        jdbcTemplate.update(sql, nome, email, senha);
    }

    @PutMapping("/update")
    public void updateUsuario(
            @RequestParam Integer codigoUsuario,
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String senha) {
        String sql = "BEGIN CRUD_AQUACARE_USUARIO('UPDATE', ?, ?, ?, ?); END;";
        jdbcTemplate.update(sql, codigoUsuario, nome, email, senha);
    }

    @DeleteMapping("/delete")
    public void deleteUsuario(@RequestParam Integer codigoUsuario) {
        String sql = "BEGIN CRUD_AQUACARE_USUARIO('DELETE', ?, NULL, NULL, NULL); END;";
        jdbcTemplate.update(sql, codigoUsuario);
    }
}
