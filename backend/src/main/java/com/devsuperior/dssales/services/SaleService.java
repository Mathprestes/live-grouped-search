package com.devsuperior.dssales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dssales.dto.SalesByStoreDTO;
import com.devsuperior.dssales.repositories.SaleRepository;

//Camada de serviço, executa regras de negocio(logica de negocio) e garantir a transação dos dados do banco
@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Transactional (readOnly = true)
	public List<SalesByStoreDTO> searchByStore() {
		return repository.searchByStore();		
	}

}
