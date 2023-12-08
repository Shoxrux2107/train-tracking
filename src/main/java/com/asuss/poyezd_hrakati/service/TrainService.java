package com.asuss.poyezd_hrakati.service;

import com.asuss.poyezd_hrakati.entity.Train_activity;
import com.asuss.poyezd_hrakati.exception.ResourceNotFoundException;
import com.asuss.poyezd_hrakati.poyezd_dto.Train_dto;
import com.asuss.poyezd_hrakati.repository.TrainRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class TrainService {

 private final TrainRepository trainRepository;
    private final ModelMapper modelMapper;


    public List<Train_activity> saveTrain(Train_dto train_dto){

        Train_activity train_activity =new Train_activity();
        train_activity.setNumber(train_dto.getNumber());
        train_activity.setIndex(train_dto.getIndex());
        train_activity.setActivity(train_dto.getActivity());
        train_activity.setNumberOfLine(train_dto.getNumberOfLine());
        train_activity.setDateTime(LocalDateTime.now());

        trainRepository.save(train_activity);

    return  trainRepository.getAllBy();
    }

    public Train_dto getTrainInfo(Long id) {
        Train_activity train_activity= trainRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Train not found with id:" + id));

        return modelMapper.map(train_activity, Train_dto.class);

    }

    public Train_dto update(Long id, Train_dto traindto) {
        Train_activity train_activity= trainRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Train not found with id:" + id));

    train_activity.setNumber(traindto.getNumber());
    train_activity.setIndex(traindto.getIndex());
    train_activity.setActivity(traindto.getActivity());
    train_activity.setNumberOfLine(traindto.getNumberOfLine());

    trainRepository.save(train_activity);

        Train_activity train_activit_updated=trainRepository.findById(id).get();

        return modelMapper.map(train_activit_updated, Train_dto.class);
    }


    public List<Train_dto> getAllTrains() {
        List<Train_activity> getAll= trainRepository.findAll();

        return getAll.stream().map((train) -> modelMapper.map(train, Train_dto.class))
                .collect(Collectors.toList());
    }

    public void delete(Long id){

        trainRepository.deleteById(id);
    }

}
