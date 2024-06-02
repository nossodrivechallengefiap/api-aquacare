package br.com.aquacare.api_aquacare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procedure_local")
public class ProcedureLocalController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/add")
    public void addLocal(
            @RequestParam Integer codigoCidade,
            @RequestParam String nome,
            @RequestParam String descricao,
            @RequestParam Double latitude,
            @RequestParam Double longitude) {
        String sql = "BEGIN CRUD_AQUACARE_LOCAL('CREATE', NULL, ?, ?, ?, ?, ?); END;";
        jdbcTemplate.update(sql, codigoCidade, nome, descricao, latitude, longitude);
    }

    @PutMapping("/update")
    public void updateLocal(
            @RequestParam Integer codigoLocal,
            @RequestParam Integer codigoCidade,
            @RequestParam String nome,
            @RequestParam String descricao,
            @RequestParam Double latitude,
            @RequestParam Double longitude) {
        String sql = "BEGIN CRUD_AQUACARE_LOCAL('UPDATE', ?, ?, ?, ?, ?, ?); END;";
        jdbcTemplate.update(sql, codigoLocal, codigoCidade, nome, descricao, latitude, longitude);
    }

    @DeleteMapping("/delete")
    public void deleteLocal(@RequestParam Integer codigoLocal) {
        String sql = "BEGIN CRUD_AQUACARE_LOCAL('DELETE', ?, NULL, NULL, NULL, NULL, NULL); END;";
        jdbcTemplate.update(sql, codigoLocal);
    }
}
