package br.com.consulta_cnpj.consulta_cnpj.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import br.com.consulta_cnpj.consulta_cnpj.DTO.CNPJ_DTO;
import br.com.consulta_cnpj.consulta_cnpj.UTIL.Captura_DADOS_CNPJ;


@RestController

public class Return_Controler {
	
private static final String URL_BASE = "https://internet-consultapublica.apps.sefaz.ce.gov.br/sintegra/consultar?tipdocumento=2&numcnpjcgf=";
	
	@Autowired
	Captura_DADOS_CNPJ capt;

	@GetMapping("/cnpj=/{cnpj}")
	public CNPJ_DTO callCNPJ(@PathVariable String cnpj){
		
		return capt.main(capt.montaURL(URL_BASE, cnpj));
		
		
		
	}
}
