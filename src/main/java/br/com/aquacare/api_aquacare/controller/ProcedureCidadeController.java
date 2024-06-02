package br.com.aquacare.api_aquacare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procedure_cidade")
public class ProcedureCidadeController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/add")
    public void addCidade(@RequestParam String nome, @RequestParam Integer codigoEstado) {
        String sql = "BEGIN CRUD_AQUACARE_CIDADE('CREATE', NULL, ?, ?); END;";
        jdbcTemplate.update(sql, nome, codigoEstado);
    }

    @PutMapping("/update")
    public void updateCidade(@RequestParam Integer codigoCidade, @RequestParam String nome, @RequestParam Integer codigoEstado) {
        String sql = "BEGIN CRUD_AQUACARE_CIDADE('UPDATE', ?, ?, ?); END;";
        jdbcTemplate.update(sql, codigoCidade, nome, codigoEstado);
    }

    @DeleteMapping("/delete")
    public void deleteCidade(@RequestParam Integer codigoCidade) {
        String sql = "BEGIN CRUD_AQUACARE_CIDADE('DELETE', ?, NULL, NULL); END;";
        jdbcTemplate.update(sql, codigoCidade);
    }
}
