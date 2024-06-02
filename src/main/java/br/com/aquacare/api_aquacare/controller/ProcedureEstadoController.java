package br.com.aquacare.api_aquacare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procedure_estado")
public class ProcedureEstadoController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/add")
    public void addEstado(@RequestParam String uf, @RequestParam String estado) {
        String sql = "BEGIN CRUD_AQUACARE_ESTADO('CREATE', NULL, ?, ?); END;";
        jdbcTemplate.update(sql, uf, estado);
    }

    @PutMapping("/update")
    public void updateEstado(@RequestParam Integer codigoEstado, @RequestParam String uf, @RequestParam String estado) {
        String sql = "BEGIN EXEC CRUD_AQUACARE_ESTADO('UPDATE', ?, ?, ?); END;";
        jdbcTemplate.update(sql, codigoEstado, uf, estado);
    }

    @DeleteMapping("/delete")
    public void deleteEstado(@RequestParam Integer codigoEstado) {
        String sql = "BEGIN EXEC CRUD_AQUACARE_ESTADO('DELETE', ?, NULL, NULL); END;";
        jdbcTemplate.update(sql, codigoEstado);
    }
}
