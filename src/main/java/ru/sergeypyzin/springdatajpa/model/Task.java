package ru.sergeypyzin.springdatajpa.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.sergeypyzin.springdatajpa.enums.TaskStatus;


import java.time.Clock;
import java.time.LocalDateTime;


/**
 * Класс, представляющий модель задачи.
 */
@Data
@Entity
@Table (name = "tasks")
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, name = "description")
    private String description;

    @Column(nullable = false, name = "task_status")
    private TaskStatus taskStatus = TaskStatus.NOT_STARTED;

    @Column(nullable = false, name = "creation_time")
    private LocalDateTime creationTime = LocalDateTime.now(Clock.systemDefaultZone());
}
