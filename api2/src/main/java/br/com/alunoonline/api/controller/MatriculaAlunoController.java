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

    @PatchMapping("/{id}/notas")
    public ResponseEntity<Object> patchNotas(@PathVariable Long id, @RequestBody PatchNotasRequest patchNotasRequest){
        try{
            service.patchNotas(id, patchNotasRequest);
            return ResponseEntity.noContent().build();
        } catch (MatriculaNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (ValidarNota ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno de servidor");
        }
    }
}

    //public void atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) throws ChangeSetPersister.NotFoundException {
      //  service.atualizar(id, alunoAtualizado);
    //}
