package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.PatchNotasRequest;
import br.com.alunoonline.api.enums.StatusMatricula;
import br.com.alunoonline.api.exception.MatriculaException;
import br.com.alunoonline.api.exception.MatriculaNotFoundException;
import br.com.alunoonline.api.exception.TrancarMatricula;
import br.com.alunoonline.api.exception.ValidarNota;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaAlunoService {

    @Autowired
    MatriculaAlunoRepository repository;

    //Média para aprovação em constante.
    private static final Double MEDIA_PARA_APROVACAO = 7.0;

    public void create(MatriculaAluno matriculaAluno) {
        if (isAlunoJaMatriculado(matriculaAluno.getAluno().getId(), matriculaAluno.getDisciplina().getId())) {
            throw new MatriculaException("Aluno cadastrado nessa disciplina.");
        } else {
            matriculaAluno.setStatus(String.valueOf(StatusMatricula.MATRICULADO));
            repository.save(matriculaAluno);
        }
    }

    public void patchNotas(Long id, PatchNotasRequest patchNotasRequest) {
        Optional<MatriculaAluno> matriculaAluno = repository.findById(id);

        //fazer a validação para ver se a matricula existe
        if (matriculaAluno.isPresent()) {
            MatriculaAluno matriculaUpdated = matriculaAluno.get();

            //validarNotas(patchNotasRequest.getNota1(), patchNotasRequest.getNota2());
            validarNotas(patchNotasRequest.getNota1(), patchNotasRequest.getNota2());
            matriculaUpdated.setNota1(patchNotasRequest.getNota1());
            matriculaUpdated.setNota2(patchNotasRequest.getNota2());
            //matriculaUpdated.setStatus(calcularStatus(media(matriculaUpdated.getNota1(),matriculaUpdated.getNota2())));
            Double media = media(patchNotasRequest.getNota1(), patchNotasRequest.getNota2());
            matriculaUpdated.setStatus(calcularStatus(media));
            repository.save(matriculaUpdated);

        } else {
            throw new MatriculaNotFoundException("Matrícula não encontrada para o ID: " + id);
        }
    }

    //quero que verifique o valor do status em método por fora.
    private String calcularStatus(Double media){

        if(media < MEDIA_PARA_APROVACAO){
            return String.valueOf(StatusMatricula.REPROVADO);
        } else {
            return String.valueOf(StatusMatricula.APROVADO);
        }
    }

    public void patchStatusParaTrancado(Long id){
        Optional<MatriculaAluno> matriculaAluno = repository.findById(id);

        if (matriculaAluno.isPresent()) {

            MatriculaAluno matriculaAlunoToLuck = matriculaAluno.get();

            matriculaAlunoToLuck.setStatus(validarNotasTrancar(matriculaAlunoToLuck.getNota1(),matriculaAlunoToLuck.getNota2()));
            repository.save(matriculaAlunoToLuck);

        } else {
            throw new MatriculaNotFoundException("Matrícula não encontrada para o ID: " + id);
        }
    }

    //Validar matrícula
    private boolean isAlunoJaMatriculado(Long alunoId, Long disciplinaId) {
        List<MatriculaAluno> matriculas = repository.findByAlunoIdAndDisciplinaId(alunoId, disciplinaId);
        return !matriculas.isEmpty();
    }

    private void validarNotas(Double nota1, Double nota2){
        if(nota1 == null || nota2 == null || nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10){
            throw new ValidarNota("Notas inválidas. Certifique-se de que as notas estã dentro do intervalo de 0 a 10");
        }
    }

    //quero a regra de calcular a média fora daqui
    private Double media(Double nota1, Double nota2){
        return (nota1 + nota2)/2;
    }

    private String validarNotasTrancar(Double nota1, Double nota2){

        if (nota1 == null || nota2 == null) {
            return String.valueOf(StatusMatricula.TRANCADA);
        } else {
            throw new TrancarMatricula("Não é permitido trancar matricula quando se tem uma das notas no sistema!");
        }
    }

    //Utilizando o toString
  // private String calcularStatus(Double media) {
    //    return (media < MEDIA_PARA_APROVACAO) ? StatusMatricula.REPROVADO.toString() : StatusMatricula.APROVADO.toString();


    //Utilizando Enum como String
   //private String calcularStatus(Double media) {
   //    return (media < MEDIA_PARA_APROVACAO) ? StatusMatricula.REPROVADO.name() : StatusMatricula.APROVADO.name();
  //}

    //Utilizando ternário sem toString
   // private String calcularStatus(Double media) {
    //    return (media < MEDIA_PARA_APROVACAO) ? "REPROVADO" : "APROVADO";
    //}


}


