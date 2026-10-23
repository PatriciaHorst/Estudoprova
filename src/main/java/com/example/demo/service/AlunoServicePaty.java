package com.example.demo.service;

import com.example.demo.entity.Aluno;
import org.hibernate.validator.cfg.context.ReturnValueConstraintMappingContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AlunoServicePaty {

   List<Aluno> alunos = new ArrayList<>();
   AtomicInteger novoId = new AtomicInteger(1);

   public Aluno criar(Aluno aluno){
       if(aluno.getId() <= 0){
           aluno.setId(novoId.getAndIncrement());

       }alunos.add(aluno);
       return aluno;
   }

   public List<Aluno> listar(){
       return alunos;
   }

   public Aluno buscar(int id){
       for(Aluno umAluno: alunos){
           if(umAluno.getId()== id){
               return umAluno;
           }
       }
       throw new ResponseStatusException(HttpStatus.NOT_FOUND,"nao foi");
   }
   public Aluno atualizar(int id, Aluno aluno){
       Aluno alunoAntigo = buscar(id);

       alunos.remove(alunoAntigo);
       aluno.setId(id);
       alunos.add(aluno);
       return aluno;
   }

   public void excluir(int id){
       Aluno alunoExcluir = buscar(id);

       alunos.remove(alunoExcluir);
   }

}
