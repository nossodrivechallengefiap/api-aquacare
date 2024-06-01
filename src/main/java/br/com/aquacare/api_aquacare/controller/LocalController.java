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

import br.com.aquacare.api_aquacare.model.CidadeRepository;
import br.com.aquacare.api_aquacare.model.LocalRepository;
import br.com.aquacare.api_aquacare.model.dto.DadosAtualizacaoLocal;
import br.com.aquacare.api_aquacare.model.dto.DadosCadastroLocal;
import br.com.aquacare.api_aquacare.model.dto.DadosListagemLocal;
import br.com.aquacare.api_aquacare.model.entity.Cidade;
import br.com.aquacare.api_aquacare.model.entity.Local;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/local")
public class LocalController 
{
	@Autowired
	private LocalRepository localRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid DadosCadastroLocal dados) {
        try {
            Cidade cidadeExistente = cidadeRepository.findById(dados.codigoCidade())
                    .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada. codigoCidade: " + dados.codigoCidade()));

            Local novoLocal = new Local(dados);
            novoLocal.setCidade(cidadeExistente);
            
            localRepository.save(novoLocal);

            return ResponseEntity.ok("Local criado com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao criar local: " + e.getMessage());
        }
    }
	
	@GetMapping
	public Page<DadosListagemLocal> listar(Pageable paginacao) {
		return localRepository.findAll(paginacao).map(DadosListagemLocal::new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemLocal obterPorId(@PathVariable Long id) {
	    Local local = localRepository.findById(id).orElse(null);
	    
	    if (local != null) {
	        return new DadosListagemLocal(local);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<String> atualizar(@RequestBody @Valid DadosAtualizacaoLocal dados) {
		try {
            Local local = localRepository.findById(dados.codigoLocal())
                    .orElseThrow(() -> new EntityNotFoundException("Local não encontrado. CódigoLocal: " + dados.codigoLocal()));

            local.atualizar(dados, cidadeRepository);
            localRepository.save(local);

            return ResponseEntity.ok("Local atualizado com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao atualizar local: " + e.getMessage());
        }
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		localRepository.deleteById(id);
	}
	
}
