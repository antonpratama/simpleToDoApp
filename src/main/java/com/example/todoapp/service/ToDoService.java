package com.example.todoapp.service;

import com.example.todoapp.repo.IToDoRepo;
import com.example.todoapp.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    IToDoRepo repo;

    public List<ToDo> getAllToDoItems(){
        ArrayList<ToDo> todoList = new ArrayList<>();

        repo.findAll().forEach(toDo -> todoList.add(toDo));

        return todoList;
    }

    public ToDo getToDoItemById(Long id){
        return repo.findById(id).get();
    }

    public boolean updateStatus(Long id){
        ToDo toDo = getToDoItemById(id);
        toDo.setStatus("Completed");

        return saveOrUpdateToDoItem(toDo);
    }

    public boolean saveOrUpdateToDoItem(ToDo todo){
        ToDo updatedObj = repo.save(todo);

        if (getToDoItemById(updatedObj.getId()) != null) {
            return true;
        }

        return false;
    }

    public boolean deleteToDoItem(Long id){
        repo.deleteById(id);

        if (repo.findById(id).isEmpty()){
            return true;
        }

        return false;
    }
}
