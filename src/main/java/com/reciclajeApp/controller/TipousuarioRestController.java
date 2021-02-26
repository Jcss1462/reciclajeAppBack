package com.reciclajeApp.controller;

import com.reciclajeApp.domain.*;

import com.reciclajeApp.dto.TipousuarioDTO;

import com.reciclajeApp.mapper.TipousuarioMapper;

import com.reciclajeApp.service.TipousuarioService;
import com.reciclajeApp.service.TipousuarioServiceImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@RestController
@RequestMapping("/api/v1/tipousuario")
@CrossOrigin(origins = "*")
public class TipousuarioRestController {
	
	private final static Logger log = LoggerFactory.getLogger(TipousuarioRestController.class);
	
    @Autowired
    private TipousuarioService tipousuarioService;
    @Autowired
    private TipousuarioMapper tipousuarioMapper;

    
}
