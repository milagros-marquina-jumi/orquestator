package com.eps.org.example.orquestator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import com.eps.org.example.orquestator.Validators.EpsValidators;
import com.eps.org.example.orquestator.client.ClientBase;
import com.eps.org.example.orquestator.models.EpsValidate;
import com.eps.org.example.orquestator.models.GenericExcepction;

@RestController
@RequestMapping("/orquestator/eps")
public class OrqEpsController {

    Logger logger = LoggerFactory.getLogger(OrqEpsController.class);

    @Autowired
    private EpsValidators epsValidators;

    @Autowired
    private ClientBase clientBase;

    @PostMapping("create")
    public ResponseEntity<GenericExcepction> validateAndCreateEps(@RequestBody EpsValidate epsDetail) {
        try {
            String result = epsValidators.validateIfNotNUll(epsDetail);

            if (result != "") {
                logger.error("Error al crear la eps: " + result);
                return new ResponseEntity<GenericExcepction>(new GenericExcepction(result, 400),
                        HttpStatus.BAD_REQUEST);
            }

            try {
                EpsValidate eps = clientBase.callApiOP(epsDetail);

                if (eps == null) {
                    logger.error("Error al crear la eps: " + "Error al crear la eps en el api de onepremise");
                    return new ResponseEntity<GenericExcepction>(
                            new GenericExcepction("Error al crear la eps en el api de onepremise", 400),
                            HttpStatus.BAD_REQUEST);
                }
                return ResponseEntity.ok(new GenericExcepction("Eps creada exitosamente", 200));
            } catch (Exception e) {
                logger.error("Error al crear la eps: " + "Error al crear la eps en el api de onepremise");
                return validateError(e);
            }

        } catch (Exception e) {
            logger.error("Error al crear la eps: " + e.getMessage());
            return new ResponseEntity<GenericExcepction>(new GenericExcepction(e.getMessage(), 500),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<GenericExcepction> validateError(Exception e) {
        int status = 0;
        String message = "";
        HttpStatus codeHttp = null;
        if (e instanceof HttpClientErrorException) {
            status = 400;
            message = "Error en los datos ingresados.";
            codeHttp = HttpStatus.BAD_REQUEST;
        } else if (e instanceof ResourceAccessException) {
            status = 503;
            message = "Api no disponible";
            codeHttp = HttpStatus.SERVICE_UNAVAILABLE;
        } else if (e instanceof HttpServerErrorException) {
            status = 500;
            message = "Error en el servidor del API OnePremise.";
            codeHttp = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            logger.error(e.getMessage());
            message = "Error en el servidor del Orquestador.";
            codeHttp = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        logger.error(e.getMessage());

        return new ResponseEntity<GenericExcepction>(new GenericExcepction(message, status),
                codeHttp);
    }
}
