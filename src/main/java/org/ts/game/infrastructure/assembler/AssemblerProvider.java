package org.ts.game.infrastructure.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AssemblerProvider {

	@Bean
	public ModelMapper provideModelMapper() {
		return new ModelMapper();
	}
}
