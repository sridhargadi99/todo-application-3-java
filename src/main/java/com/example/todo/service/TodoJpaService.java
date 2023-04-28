/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoJpaRepository;
import com.example.todo.repository.TodoRepository;

@Service 
public class TodoJpaService implements TodoRepository{
    @Autowired 
    private TodoJpaRepository todoJpaRepository;

    @Override 
    public ArrayList<Todo> allTodos(){
        try{
            List<Todo> todoCollection = todoJpaRepository.findAll();
            ArrayList<Todo> todos = new ArrayList<>(todoCollection);
            return todos;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 
    public Todo createTodo(Todo todo){
        todoJpaRepository.save(todo);
        return todo;
    }

    @Override 
    public Todo getTodo(int id){
        try{
            Todo todoDetails = todoJpaRepository.findById(id).get();
            return todoDetails;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 
    public Todo updateTodo(int id, Todo todo){
        try{
            Todo newTodo = todoJpaRepository.findById(id).get();
            if(todo.getTodo() != null){
                newTodo.setTodo(todo.getTodo());
            }
            if(todo.getPriority() != null){
                newTodo.setPriority(todo.getPriority());
            }
            if(todo.getStatus() != null){
                newTodo.setStatus(todo.getStatus());
            }

            todoJpaRepository.save(newTodo);
            return newTodo;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 
    public void deleteTodo(int id){
        try{
            todoJpaRepository.deleteById(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
