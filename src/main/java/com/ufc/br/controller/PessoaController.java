package com.ufc.br.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Pessoa;
import com.ufc.br.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping("/formulario")
	public ModelAndView formularioPessoa() {
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("pessoa", new Pessoa());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarPessoa(Pessoa pessoa) {
		pessoaService.adicionarPessoa(pessoa);
		
		
		ModelAndView mv = new ModelAndView("redirect:/");
		mv.addObject("mensagem", "Usuário cadastrado com sucesso");
		
		return mv;
	}
	
	
	@RequestMapping("/logar")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	
	
	
	
	
	

}
