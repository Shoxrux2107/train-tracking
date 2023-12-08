package com.asuss.poyezd_hrakati.repository;

import com.asuss.poyezd_hrakati.entity.Train_activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train_activity,Long> {

   Train_activity getByNumber(Integer number);

   List<Train_activity> getAllBy();




}
