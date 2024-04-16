package ru.sergeypyzin.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sergeypyzin.springdatajpa.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
