package br.com.escola.core.modelmapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class ModelMapperConfigTest {

	@InjectMocks
	ModelMapperConfig modelMapperConfig;

	@Test
	public void modelMapperConfigTest() {
		modelMapperConfig.modelMapper();
	}
}