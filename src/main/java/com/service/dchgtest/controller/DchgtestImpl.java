package com.service.dchgtest.controller;


import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.servicecomb.provider.rest.common.RestSchema;

import java.io.File;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2018-07-11T04:02:56.386Z")

@RestSchema(schemaId = "dchgtest")
@RequestMapping(path = "/dchgTest/base", produces = MediaType.APPLICATION_JSON)
public class DchgtestImpl {

    @Autowired
    private DchgtestDelegate userDchgtestDelegate;


    @RequestMapping(value = "/helloworld",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public String helloworld( @RequestParam(value = "name", defaultValue = "/", required = false) String name){
        return userDchgtestDelegate.helloworld(name);
    }

}
