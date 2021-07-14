package com.devsuperior.dssales.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.devsuperior.dssales.dto.SalesByStoreDTO;
import com.devsuperior.dssales.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	//consulta agrupada
	//buscando do banco novos objetos do tipo "SalesByStoreDTO" passando o campo store e a soma do total
	//e depois agrupando pela loja
	@Query("SELECT new com.devsuperior.dssales.dto.SalesByStoreDTO(obj.store, SUM(obj.total))"
			+ " FROM Sale AS obj"
			+ " GROUP BY obj.store") 
	
	List<SalesByStoreDTO> searchByStore();  //retornando uma lista de dados
	
}
