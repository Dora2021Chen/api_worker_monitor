package com.workerMonitor.api.repository;

import com.workerMonitor.api.model.SystemLogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface SystemLogRepository extends JpaRepository<SystemLogModel, Long> {
    @Override
    List<SystemLogModel> findAll();

    @Override
    Optional<SystemLogModel> findById(Long id);

    @Override
    <S extends SystemLogModel> S save(S s);

    @Override
    <S extends SystemLogModel> List<S> saveAll(Iterable<S> iterable);

    @Override
    <S extends SystemLogModel> List<S> saveAllAndFlush(Iterable<S> iterable);

    @Override
    void deleteById(Long id);
}
