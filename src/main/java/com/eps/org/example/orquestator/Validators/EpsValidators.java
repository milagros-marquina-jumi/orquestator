package com.eps.org.example.orquestator.Validators;

import org.springframework.stereotype.Service;

import com.eps.org.example.orquestator.models.EpsValidate;

@Service
public class EpsValidators {

    public EpsValidators() {
    }

    public String validateIfNotNUll(EpsValidate eps) {
        String result = "";
        if(eps == null) {
            return Constants.EPS_NOT_NULL;
        }
        if (eps.getNombreEps() == null || eps.getNombreEps().equals("") || eps.getNombreEps().equals(" ")
                || !(eps.getNombreEps() instanceof String)) {
            result += Constants.EPS_NAME_NOT_NULL;
        }
        if (eps.getNombreEps().matches(".*\\d.*")) {
            result += Constants.EPS_NAME_NOT_NUMBER;
        }
        if (eps.getPorcentaje() == 0) {
            result += Constants.EPS_PERCENTAGE_NOT_NULL;
        }
        if (eps.getComisionSobreRA() == 0) {
            result += Constants.EPS_COMMISSION_NOT_NULL;
        }
        if (eps.getPrimaSeguro() == 0) {
            result += Constants.EPS_PRIMA_NOT_NULL;
        }
        if (eps.getPorcentaje() < 0) {
            result += Constants.EPS_PERCENTAGE_NOT_NEGATIVE;
        }
        if (eps.getComisionSobreRA() < 0) {
            result += Constants.EPS_COMMISSION_NOT_NEGATIVE;
        }
        if (eps.getPrimaSeguro() < 0) {
            result += Constants.EPS_PRIMA_NOT_NEGATIVE;
        }
        return result;
    }
}
