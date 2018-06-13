package org.ts.lotto.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.lang.reflect.ParameterizedType;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.ts.game.interfaces.game.rest.DivisionDto;
import org.ts.game.interfaces.game.rest.DrawDto;
import org.ts.game.interfaces.game.rest.GameDto;

/**
 * @author juan
 *
 */
public abstract class AbstractGameTest<G extends GameDto, D extends DrawDto<G>, V extends DivisionDto<G>> {
	@Autowired
	protected TestRestTemplate restTemplate;
	
	protected HttpHeaders defaultHeaders = new HttpHeaders();
	
	protected final Class<G> gameClass;
	protected final Class<D> drawClass;
	protected final Class<V> divisionClass;
	
	@SuppressWarnings("unchecked")
	public AbstractGameTest() {
		this.gameClass = (Class<G>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.drawClass = (Class<D>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		this.divisionClass = (Class<V>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Before
	public void setup() {
		defaultHeaders.add(CONTENT_TYPE, APPLICATION_JSON_VALUE);
		defaultHeaders.add(ACCEPT, APPLICATION_JSON_VALUE);
	}
	
	protected G postForNewInstance(G gameDto) {
		
		ResponseEntity<G> responseEntity = this.restTemplate.exchange(getGameInstancePath(), HttpMethod.POST, new HttpEntity<>(gameDto, defaultHeaders), gameClass);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(responseEntity.getBody()).isNotNull();
		
		return responseEntity.getBody();
	}
	
	protected D postForNewDraw(D drawDto) {
		
		ResponseEntity<D> responseEntity = this.restTemplate.exchange(getGameDrawPath(), HttpMethod.POST, new HttpEntity<>(drawDto, defaultHeaders), drawClass);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(responseEntity.getBody()).isNotNull();
		
		return responseEntity.getBody();
	}
	
	protected String postForDivision(V divisionDto) {
		
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(getGameDivisionPath(), HttpMethod.POST, new HttpEntity<>(divisionDto, defaultHeaders), String.class);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNotNull();
		
		return responseEntity.getBody();
	}

	protected abstract String getGameInstancePath();
	
	protected abstract String getGameDrawPath();
	
	protected abstract String getGameDivisionPath();
}
