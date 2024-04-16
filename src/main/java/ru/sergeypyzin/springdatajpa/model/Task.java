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
@Table
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String description;

    @Column(nullable = false)
    private TaskStatus taskStatus = TaskStatus.NOT_STARTED;

    @Column(nullable = false)
    private LocalDateTime creationTime = LocalDateTime.now(Clock.systemDefaultZone());
}
