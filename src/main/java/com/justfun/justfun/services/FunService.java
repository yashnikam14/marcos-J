package com.justfun.justfun.services;

import com.justfun.justfun.DTO.FunDTO;
import com.justfun.justfun.entities.FunEntity;
import com.justfun.justfun.repositories.FunRepositories;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FunService {

    final FunRepositories funRepositories;
    final ModelMapper modelMapper;

    public FunService(FunRepositories funRepositories, ModelMapper modelMapper){
        this.funRepositories= funRepositories;
        this.modelMapper= modelMapper;

    }

    public FunDTO create_fun(FunDTO funDTO) {
        FunEntity funEntity= modelMapper.map(funDTO, FunEntity.class);
        return modelMapper.map(funRepositories.save(funEntity), FunDTO.class);
    }


    public List<FunDTO> getAllFun() {
        return funRepositories.findAll().stream()
                .map(funEntity -> modelMapper.map(funEntity, FunDTO.class))
                .collect(Collectors.toList());
    }

    public FunDTO getOneFun(Long id) {
        FunEntity funEntity = funRepositories.getById(id);
        return modelMapper.map(funEntity, FunDTO.class);
    }

    public boolean deleteFun(Long id) {
        FunEntity fun = funRepositories.getById(id);
        if (fun != null){
            funRepositories.deleteById(id);
        }
        return true;
    }

//    public FunDTO putFun(Long id, FunDTO funDTO) {
//
//        FunEntity fun = funRepositories.getById(id);
//        modelMapper.map(funRepositories.save(funDTO.getTitle()), fun.getTitle());
//        return modelMapper.map(funRepositories.save(fun), FunDTO.class);
//
//    }
}
