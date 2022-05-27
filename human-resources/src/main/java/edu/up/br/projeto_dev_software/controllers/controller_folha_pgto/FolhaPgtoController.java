package edu.up.br.projeto_dev_software.controllers.controller_folha_pgto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.up.br.projeto_dev_software.domain.domain_cadastro_funcionario.Funcionario;
import edu.up.br.projeto_dev_software.domain.domain_folha_pgto.FolhaPgto;
import edu.up.br.projeto_dev_software.repository.FuncionarioRepository;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "folhaPgto")
@RestController
@RequestMapping("/folhaPgto")
public class FolhaPgtoController {
    
    @Autowired
    private FuncionarioRepository funcionarioRepositoryRP;

    @GetMapping("/listar")
    List<FolhaPgto> buscarPorId(){
    List<Funcionario> listaDefuncionarios = funcionarioRepositoryRP.findAll();
    List<FolhaPgto> listaFolhaPgto = new ArrayList<>();

    for(Funcionario f: listaDefuncionarios ){
        FolhaPgto folha = new FolhaPgto();
        folha.setNomeFuncionario(f.getNome());
        folha.setCpfFuncioanrio(f.getCpf());
        folha.setSalário(f.getSalario());
        folha.setDescontoPlanoSaude(f.getPlanoSaude().getValorPlano());
        if(f.getTrans() == true){
            folha.setDescontoTrans(
                f.getSalario()*0.06                
            );
        }else{
            folha.setDescontoTrans(0.0);
        }
        folha.setValorPagar(folha.getSalário()- (folha.getDescontoPlanoSaude() + folha.getDescontoTrans())); 
        listaFolhaPgto.add(folha);       
    }
    return listaFolhaPgto;
    }
}
