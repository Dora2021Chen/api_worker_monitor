package com.workerMonitor.api.repository;

import com.workerMonitor.api.model.WorkerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerModel, Long> {
    @Override
    List<WorkerModel> findAll();

    @Override
    Optional<WorkerModel> findById(Long id);

    @Override
    <S extends WorkerModel> S save(S s);

    @Override
    <S extends WorkerModel> List<S> saveAll(Iterable<S> iterable);

    @Override
    <S extends WorkerModel> List<S> saveAllAndFlush(Iterable<S> iterable);

    @Override
    void deleteById(Long id);
}
