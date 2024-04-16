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

    // Уникальный идентификатор задачи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Описание задачи
    @Column(nullable = false)
    private String description;

    // Статус задачи по умолчанию - "Не начата"
    @Column(nullable = false)
    private TaskStatus taskStatus = TaskStatus.NOT_STARTED;

    // Время создания задачи, устанавливается при создании экземпляра класса
    @Column(nullable = false)
    private LocalDateTime creationTime = LocalDateTime.now(Clock.systemDefaultZone());
}
