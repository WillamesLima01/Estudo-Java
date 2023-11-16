package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.PatchNotasRequest;
import br.com.alunoonline.api.exception.MatriculaNotFoundException;
import br.com.alunoonline.api.exception.ValidarNota;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody MatriculaAluno matriculaAluno){

        try {
            service.create(matriculaAluno);
            return ResponseEntity.status(HttpStatus.CREATED).body("Matrícula realizada com sucesso.");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PatchMapping("/notas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void patchNotas(@PathVariable Long id, @RequestBody PatchNotasRequest patchNotasRequest){

            service.patchNotas(id, patchNotasRequest);
            //return ResponseEntity.noContent().build();
    }

    @PatchMapping("/patchStatusParaTrancado/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchStatusParaTrancado(@PathVariable Long id){

        service.patchStatusParaTrancado(id);
    }
}

    //public void atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) throws ChangeSetPersister.NotFoundException {
      //  service.atualizar(id, alunoAtualizado);
    //}
