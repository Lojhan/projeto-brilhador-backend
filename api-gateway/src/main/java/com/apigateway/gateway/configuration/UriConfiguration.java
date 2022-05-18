package com.apigateway.gateway.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class UriConfiguration {

	private Map<String, String> uris = new HashMap<>(); 

	public Map<String, String> getUris() {
		return uris;
	}

	UriConfiguration() {
		uris.put("authentication", "http://authentication-service-brilhador");
		uris.put("client-relationship", "http://client-relationship-service-brilhador");
		uris.put("strategic-systems", "http://strategic-systems-services-brilhador");
		uris.put("financial-service-lancamentos-contabeis", "http://financial-lancamentos-contabeis-brilhador");
		uris.put("financial-service-operacao-contabil", "http://financial-operacaocontabil-brilhador");
		uris.put("financial-service-patrimonial", "http://financial-patrimonial-brilhador");
		uris.put("financial-service-plano-contas", "http://financial-plano-contas-brilhador");
		uris.put("supply-chain", "http://supply-chain-brilhador");
	}

}
