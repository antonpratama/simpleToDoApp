package com.example.todoapp.repo;

import com.example.todoapp.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IToDoRepo extends JpaRepository<ToDo, Long> {
}
