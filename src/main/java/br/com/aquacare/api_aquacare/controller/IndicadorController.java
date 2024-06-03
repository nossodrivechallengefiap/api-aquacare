package br.com.aquacare.api_aquacare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aquacare.api_aquacare.model.IndicadorRepository;
import br.com.aquacare.api_aquacare.model.LocalRepository;
import br.com.aquacare.api_aquacare.model.dto.DadosAtualizacaoIndicador;
import br.com.aquacare.api_aquacare.model.dto.DadosCadastroIndicador;
import br.com.aquacare.api_aquacare.model.dto.DadosListagemIndicador;
import br.com.aquacare.api_aquacare.model.entity.Indicador;
import br.com.aquacare.api_aquacare.model.entity.Local;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/indicador")
public class IndicadorController 
{
	@Autowired
	private IndicadorRepository indicadorRepository;
	
	@Autowired
	private LocalRepository localRepository;
	
	@PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid DadosCadastroIndicador dados) {
        try {
        	Local localExistente = localRepository.findById(dados.codigoLocal())
                    .orElseThrow(() -> new EntityNotFoundException("Local não encontrado. codigoLocal: " + dados.codigoLocal()));

            Indicador novoIndicador = new Indicador(dados);
            novoIndicador.setLocal(localExistente);
            
            indicadorRepository.save(novoIndicador);

            return ResponseEntity.ok("Indicador criado com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao criar indicador: " + e.getMessage());
        }
    }
	
	@GetMapping
	public Page<DadosListagemIndicador> listar(Pageable paginacao) {
		return indicadorRepository.findAll(paginacao).map(DadosListagemIndicador::new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemIndicador obterPorId(@PathVariable Long id) {
	    Indicador indicador = indicadorRepository.findById(id).orElse(null);
	    
	    if (indicador != null) {
	        return new DadosListagemIndicador(indicador);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<String> atualizar(@RequestBody @Valid DadosAtualizacaoIndicador dados) {
		try {
            Indicador indicador = indicadorRepository.findById(dados.codigoIndicador())
                    .orElseThrow(() -> new EntityNotFoundException("Indicador não encontrado. codigoIndicador: " + dados.codigoIndicador()));
            
            indicador.atualizar(dados, localRepository);
            indicadorRepository.save(indicador);

            return ResponseEntity.ok("Indicador atualizado com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao atualizar indicador: " + e.getMessage());
        }
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		indicadorRepository.deleteById(id);
	}
	
}
