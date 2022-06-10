package com.apigateway.gateway.configuration;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UriConfiguration {
	private Map<String, String> uris = new HashMap<>();
	GatewayRoutesRefresher gatewayRoutesRefresher;

	RefreshableRoutesLocator refreshableRoutesLocator;

	public Map<String, String> getUris() {
		return uris;
	}

	UriConfiguration(
		GatewayRoutesRefresher gatewayRoutesRefresher,
		RefreshableRoutesLocator refreshableRoutesLocator
		) {
		this.refreshableRoutesLocator = refreshableRoutesLocator;
		this.gatewayRoutesRefresher = gatewayRoutesRefresher;
		uris.put("strategic-systems", "http://strategic-systems-services-brilhador");
		uris.put("financial-service-lancamentos-contabeis", "http://financial-lancamentos-contabeis-brilhador");
		uris.put("financial-service-operacao-contabil", "http://financial-operacaocontabil-brilhador");
		uris.put("financial-service-patrimonial", "http://financial-patrimonial-brilhador");
		uris.put("financial-service-plano-contas-brilhador", "http://financial-plano-contas-brilhador");
		uris.put("financial-service-plano-contas-brilhador2", "http://financial-plano-contas-brilhador2");
		uris.put("supply-chain-movement-brilhador", "http://supply-chain-movement-brilhador");
		uris.put("supply-chain-task-brilhador", "http://supply-chain-task-brilhador");
		uris.put("inventory", "http://inventory-brilhador");
		uris.put("strategic-systems-brilhador", "http://strategic-systems-services-brilhador");

		gatewayRoutesRefresher.refreshRoutes();
		uris.forEach((key, value) -> addRoute(key, key, value));
	}

	public void addUri(String key, String value) {
		uris.put(key, value);
		addRoute(key, key, value);
	}

	public void addRoute(String id, String key, String value) {
		try {
			refreshableRoutesLocator.addRoute(key, key, value);
			refreshableRoutesLocator.buildRoutes();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		gatewayRoutesRefresher.refreshRoutes();
	}

	public void removeUri(String key) {
		System.out.println("\t -> Removing uri: " + key);
		uris.remove(key);
	}
}
