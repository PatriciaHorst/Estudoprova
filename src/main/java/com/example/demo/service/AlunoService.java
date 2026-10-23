package com.example.demo.service;

import com.example.demo.entity.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AlunoService {


    List<Aluno> listaAlunos = new ArrayList<>();
    AtomicInteger aplicadorId = new AtomicInteger(1);

    public AlunoService(){
        listaAlunos.add( new Aluno( aplicadorId.getAndIncrement(),"Patricia",15193501998L, "19-03-2009","Rua Uruguai-Centro-96"));
        listaAlunos.add( new Aluno( aplicadorId.getAndIncrement(),"Renan",15193501998L, "08-12-2008","Rua Uruguai-Centro-96"));
        listaAlunos.add( new Aluno( aplicadorId.getAndIncrement(),"Murilo",3935918730L, "12-02-2009","Rua Uruguai-Centro-96"));
        listaAlunos.add( new Aluno( aplicadorId.getAndIncrement(),"Nathan",15193501998L, "16-03-2009","Rua Uruguai-Centro-96"));
    }

    public Aluno criar(Aluno aluno){
        if(aluno.getId() <= 0){
            aluno.setId(aplicadorId.getAndIncrement());
        }
        listaAlunos.add(aluno);

        return aluno;
    }

    public List<Aluno> listar(){
        return listaAlunos;
    }

    public Aluno buscar(int id){
        for(Aluno alunos : listaAlunos){
           if (alunos.getId() == id){
               return alunos;
           }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "não achou");
    }

    public Aluno atualizar(int id, Aluno aluno){
        Aluno alunoAntigo = buscar(id);

        listaAlunos.remove(alunoAntigo);
        aluno.setId(id);
        listaAlunos.add(aluno);
        return aluno;
    }

    public void excluir(int id){
        Aluno excluido = buscar(id);

        listaAlunos.remove(excluido);
    }


}
