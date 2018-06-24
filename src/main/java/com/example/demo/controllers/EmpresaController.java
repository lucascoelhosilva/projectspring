package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.EmpresaDto;
import com.example.demo.response.Response;

@RestController
@RequestMapping("api/empresas")
public class EmpresaController {

	@PostMapping
	public ResponseEntity<Response<EmpresaDto>> cadastrar(@Valid @RequestBody EmpresaDto empresaDto,
			BindingResult result){
		Response<EmpresaDto> response = new Response<EmpresaDto>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		empresaDto.setId(1L);
		response.setData(empresaDto);
		
		return ResponseEntity.ok(response);
	}
}
