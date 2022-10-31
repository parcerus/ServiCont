package com.ServiCont.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ServiCont.entities.Empresa;
import com.ServiCont.services.EmpresaService;

@Controller
public class EmpresaFController {

    EmpresaService empresaService;

    public EmpresaFController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GetMapping("/enterprises")
    public String empresas(Model model){
        List<Empresa> empresas = empresaService.getListEmpresas();
        model.addAttribute("empresas", empresas);
        return "empresas";
    } 

    @GetMapping("/enterprises/new")
    public String newEmpresa(Model model){
        model.addAttribute("empresa", new Empresa());
        return"nuevaEmpresa";
    }

    @GetMapping("/enterprises/update/{id}")
    public String updateEmpresa(Model model, @PathVariable("id") Long id){
        Optional<Empresa> empresa = this.empresaService.getEmpresaByID(id);
        if(empresa.isPresent()){
            model.addAttribute("empresa", empresa.get());
            return "modificarEmpresa";
        }

        return "empresas";
    }
    
}
