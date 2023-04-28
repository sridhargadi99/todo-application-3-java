// Write your code here
package com.example.todo.repository;

import java.util.*;
import com.example.todo.model.Todo;

public interface TodoRepository{
    ArrayList<Todo> allTodos();
    Todo createTodo(Todo todo);
    Todo getTodo(int id);
    Todo updateTodo(int id, Todo todo);
    void deleteTodo(int id);
    
    
}