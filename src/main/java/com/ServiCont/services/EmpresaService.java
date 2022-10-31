package com.ServiCont.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ServiCont.entities.Empresa;
import com.ServiCont.repositories.EmpresaRepository;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;


    
    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository=empresaRepository;
    }

    public Optional<Empresa> getEmpresaByID(Long id){
        return this.empresaRepository.findById(id);
    }

    public List<Empresa> getListEmpresas(){
        return this.empresaRepository.findAll();
    }

    //Servicio para guardar la tarea
    public Empresa createEmpresa(Empresa newEmpresa){
        return this.empresaRepository.save(newEmpresa);
    }

    public  Boolean updateEmpresa(Long id, Empresa newEmpresa){
        Optional<Empresa> empresa = this.empresaRepository.findById(id);
        if(empresa.isPresent()){
            empresa.get().setNombre(newEmpresa.getNombre());
            empresa.get().setDireccion(newEmpresa.getDireccion());
            empresa.get().setTelefono(newEmpresa.getTelefono());
            empresa.get().setNit(newEmpresa.getNit());
            this.empresaRepository.save(empresa.get());
            return true;
        }

        return false;

    }

    public Boolean deleteEmpresa(Long id){
        this.empresaRepository.deleteById(id);
        return true;
    }
    
}

