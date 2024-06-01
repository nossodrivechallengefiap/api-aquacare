package br.com.aquacare.api_aquacare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aquacare.api_aquacare.model.CidadeRepository;
import br.com.aquacare.api_aquacare.model.dto.DadosAtualizacaoCidade;
import br.com.aquacare.api_aquacare.model.dto.DadosCadastroCidade;
import br.com.aquacare.api_aquacare.model.dto.DadosListagemCidade;
import br.com.aquacare.api_aquacare.model.entity.Cidade;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cidade")
public class CidadeController 
{
	@Autowired
	private CidadeRepository repository;
	
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroCidade dados) {
		repository.save(new Cidade(dados));
	}
	
	@GetMapping
	public Page<DadosListagemCidade> listar(Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemCidade::new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemCidade obterPorId(@PathVariable Long id) {
	    Cidade cidade = repository.findById(id).orElse(null);
	    
	    if (cidade != null) {
	        return new DadosListagemCidade(cidade);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoCidade dados) {
		Cidade cidade = new Cidade();
		
		cidade = repository.getReferenceById(dados.codigoCidade());
		cidade.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
