package com.eps.org.example.orquestator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eps.org.example.orquestator.Validators.Constants;
import com.eps.org.example.orquestator.Validators.EpsValidators;
import com.eps.org.example.orquestator.models.EpsValidate;

@SpringBootTest
class OrquestatorApplicationTests {

	@Autowired
	private EpsValidators epsValidators;

	@Test
	void contextLoads() {
	}

	@Test()
	public void checkValidateIfNotNUll() {
		epsValidators.validateIfNotNUll(null);
	}

	@Test()
	public void checkEpsNameNotNumber() {
		EpsValidate eps = new EpsValidate();
		eps.setIdEps(1);
		eps.setNombreEps("RIMAC11111");
		eps.setPorcentaje(10);
		eps.setComisionSobreRA(1.2);
		eps.setPrimaSeguro(1.1);
		assertEquals(Constants.EPS_NAME_NOT_NUMBER, epsValidators.validateIfNotNUll(eps));
	}

	@Test()
	public void checkEpsNotName() {
		EpsValidate eps = new EpsValidate();
		eps.setIdEps(1);
		eps.setNombreEps("");
		eps.setPorcentaje(10);
		eps.setComisionSobreRA(1.2);
		eps.setPrimaSeguro(1.1);
		assertEquals(Constants.EPS_NAME_NOT_NULL, epsValidators.validateIfNotNUll(eps));
	}

	@Test()
	public void checkEpsNotComission() {
		EpsValidate eps = new EpsValidate();
		eps.setIdEps(1);
		eps.setNombreEps("RIMAC");
		eps.setPorcentaje(10);
		eps.setComisionSobreRA(0);
		eps.setPrimaSeguro(1.1);
		assertEquals(Constants.EPS_COMMISSION_NOT_NULL, epsValidators.validateIfNotNUll(eps));
	}

	@Test()
	public void checkEpsNotPorcentaje() {
		EpsValidate eps = new EpsValidate();
		eps.setIdEps(1);
		eps.setNombreEps("RIMAC");
		eps.setPorcentaje(0);
		eps.setComisionSobreRA(10);
		eps.setPrimaSeguro(1.1);
		assertEquals(Constants.EPS_PERCENTAGE_NOT_NULL, epsValidators.validateIfNotNUll(eps));
	}

	@Test()
	public void checkEpsNegativePorcentaje() {
		EpsValidate eps = new EpsValidate();
		eps.setIdEps(1);
		eps.setNombreEps("RIMAC");
		eps.setPorcentaje(-1);
		eps.setComisionSobreRA(10);
		eps.setPrimaSeguro(1.1);
		assertEquals(Constants.EPS_PERCENTAGE_NOT_NEGATIVE, epsValidators.validateIfNotNUll(eps));
	}

	@Test()
	public void checkEpsNegativeComision() {
		EpsValidate eps = new EpsValidate();
		eps.setIdEps(1);
		eps.setNombreEps("RIMAC");
		eps.setPorcentaje(10);
		eps.setComisionSobreRA(-1);
		eps.setPrimaSeguro(1.1);
		assertEquals(Constants.EPS_COMMISSION_NOT_NEGATIVE, epsValidators.validateIfNotNUll(eps));
	}

	@Test()
	public void checkEpsNegativePrima() {
		EpsValidate eps = new EpsValidate();
		eps.setIdEps(1);
		eps.setNombreEps("RIMAC");
		eps.setPorcentaje(10);
		eps.setComisionSobreRA(1);
		eps.setPrimaSeguro(-1.1);
		assertEquals(Constants.EPS_PRIMA_NOT_NEGATIVE, epsValidators.validateIfNotNUll(eps));
	}

	@Test()
	public void checkEpsNullPrima() {
		EpsValidate eps = new EpsValidate();
		eps.setIdEps(1);
		eps.setNombreEps("RIMAC");
		eps.setPorcentaje(10);
		eps.setComisionSobreRA(1);
		eps.setPrimaSeguro(0);
		assertEquals(Constants.EPS_PRIMA_NOT_NULL, epsValidators.validateIfNotNUll(eps));
	}
}
