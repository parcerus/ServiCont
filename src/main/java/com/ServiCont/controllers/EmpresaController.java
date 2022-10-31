package com.ServiCont.controllers;


import com.ServiCont.entities.Empresa;
import com.ServiCont.services.EmpresaService;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class EmpresaController {

    EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }
    
    @PostMapping("/enterprises")
    public RedirectView createEmpresa(@ModelAttribute Empresa empresa, Model model){
        model.addAttribute(empresa);
        this.empresaService.createEmpresa(empresa);
        return new RedirectView("/enterprises");
    }

    @PatchMapping("/enterprises/{id}")
    public RedirectView updateEmpresa(@PathVariable("id") Long id, @ModelAttribute Empresa newEmpresa){
        this.empresaService.updateEmpresa(id, newEmpresa);
        return new RedirectView("/enterprises");
    }
    
    @DeleteMapping("/enterprises/{id}")
    public RedirectView deleteEmpresa(@PathVariable("id") Long id){
        this.empresaService.deleteEmpresa(id);
        return new RedirectView("/enterprises");
    }
}
