package com.asuss.poyezd_hrakati.controller;

import com.asuss.poyezd_hrakati.entity.Train_activity;
import com.asuss.poyezd_hrakati.poyezd_dto.Train_dto;
import com.asuss.poyezd_hrakati.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@Controller
@RequiredArgsConstructor
@RequestMapping("api/train")
public class TrainController {
    final TrainService trainService;
    @CrossOrigin("*")
    @PostMapping
    HttpEntity<?> saveTrain(@RequestBody Train_dto traindto){
         List<Train_activity> train_activity=trainService.saveTrain(traindto);


             //  return  ResponseEntity.ok(train_activity);
               return new ResponseEntity<>(train_activity, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    HttpEntity<?> getTrainById(@PathVariable Long id){

        Train_dto trainDto= trainService.getTrainInfo(id);

        return new ResponseEntity<>(trainDto, HttpStatus.OK);
    }

    @GetMapping("trains")
    HttpEntity<?> getTrainById(){

        List<Train_dto> trainDtos=trainService.getAllTrains();


        return new ResponseEntity<>(trainDtos, HttpStatus.OK);
    }

    @PutMapping("{id}")
    HttpEntity<?> updateDate(@PathVariable Long id, @RequestBody Train_dto traindto){
        Train_dto train_dto =trainService.update(id, traindto);
        return new ResponseEntity<>(train_dto, HttpStatus.OK);

    }
//Continue please
    @DeleteMapping("{id}")
    HttpEntity<?> delete(@PathVariable Long id){
        trainService.delete(id);
        return new ResponseEntity<>( HttpStatus.OK);

    }



}
