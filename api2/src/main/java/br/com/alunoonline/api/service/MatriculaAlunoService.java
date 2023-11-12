package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.PatchNotasRequest;
import br.com.alunoonline.api.exception.MatriculaException;
import br.com.alunoonline.api.exception.MatriculaNotFoundException;
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
            matriculaAluno.setStatus("MATRICULADO");
            repository.save(matriculaAluno);
        }
    }

    public void patchNotas(Long id, PatchNotasRequest patchNotasRequest) {
        Optional<MatriculaAluno> matriculaAluno = repository.findById(id);

        //fazer a validação para ver se a matricula existe
        if (matriculaAluno.isPresent()) {
            MatriculaAluno matriculaUpdated = matriculaAluno.get();

            // Adicionando validação de notas
            if (patchNotasRequest.getNota1() == null || patchNotasRequest.getNota2() == null ||
                    patchNotasRequest.getNota1() < 0 || patchNotasRequest.getNota1() > 10 ||
                    patchNotasRequest.getNota2() < 0 || patchNotasRequest.getNota2() > 10) {
                throw new ValidarNota("Notas inválidas. Certifique-se de que as notas estão dentro do intervalo de 0 a 10.");
            } else {

                matriculaUpdated.setStatus(calcularStatus(media(matriculaUpdated.getNota1(), matriculaUpdated.getNota2()), MEDIA_PARA_APROVACAO));

            }

            repository.save(matriculaUpdated);

        } else {
            throw new MatriculaNotFoundException("Matrícula não encontrada para o ID: " + id);
        }

    }

    //quero que verifique o valor do status em método por fora.
    private String calcularStatus(Double media, Double MEDIA_PARA_APROVACAO){

        if(media <=4){
            return "Reprovado";
        } else if(media < MEDIA_PARA_APROVACAO){
            return "Recuperação";
        } else {
            return "Aprovado";
        }

        //return (media >= MEDIA_PARA_APROVACAO)? "Aprovado":"Reprovado";
    }

    //quero a regra de calcular a média fora daqui
    private Double media(Double nota1, Double nota2){
        return (nota1 + nota2)/2;
    }

    //Validar matrícula
    private boolean isAlunoJaMatriculado(Long alunoId, Long disciplinaId) {
        List<MatriculaAluno> matriculas = repository.findByAlunoIdAndDisciplinaId(alunoId, disciplinaId);
        return !matriculas.isEmpty();
    }
}


