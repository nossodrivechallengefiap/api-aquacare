package br.com.aquacare.api_aquacare.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/procedure_indicador")
public class ProcedureIndicadorController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/add")
    public void addIndicador(
            @RequestParam Integer codigoLocal,
            @RequestParam String dataHoraMedicao,
            @RequestParam Double nivelColiformes,
            @RequestParam Double nivelPh,
            @RequestParam Double nivelOxigenioDissolvido,
            @RequestParam Double nivelTurbidez,
            @RequestParam Double nivelTemperatura) {
        String sql = "BEGIN CRUD_AQUACARE_INDICADOR('CREATE', NULL, ?, TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'), ?, ?, ?, ?, ?); END;";
        jdbcTemplate.update(sql, codigoLocal, dataHoraMedicao, nivelColiformes, nivelPh, nivelOxigenioDissolvido, nivelTurbidez, nivelTemperatura);
    }

    @PutMapping("/update")
    public void updateIndicador(
            @RequestParam Integer codigoIndicador,
            @RequestParam Integer codigoLocal,
            @RequestParam String dataHoraMedicao,
            @RequestParam Double nivelColiformes,
            @RequestParam Double nivelPh,
            @RequestParam Double nivelOxigenioDissolvido,
            @RequestParam Double nivelTurbidez,
            @RequestParam Double nivelTemperatura) {
        String sql = "BEGIN CRUD_AQUACARE_INDICADOR('UPDATE', ?, ?, TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'), ?, ?, ?, ?, ?); END;";
        jdbcTemplate.update(sql, codigoIndicador, codigoLocal, dataHoraMedicao, nivelColiformes, nivelPh, nivelOxigenioDissolvido, nivelTurbidez, nivelTemperatura);
    }

    @DeleteMapping("/delete")
    public void deleteIndicador(@RequestParam Integer codigoIndicador) {
        String sql = "BEGIN CRUD_AQUACARE_INDICADOR('DELETE', ?, NULL, NULL, NULL, NULL, NULL, NULL, NULL); END;";
        jdbcTemplate.update(sql, codigoIndicador);
    }
}

