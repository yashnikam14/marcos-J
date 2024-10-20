package com.justfun.justfun.controller;

import com.justfun.justfun.DTO.FunDTO;
import com.justfun.justfun.services.FunService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fun")
public class FunController {

    private final FunService funService;

    public FunController(FunService funService){
        this.funService = funService;
    }
    @GetMapping
    public String justTest(){
        return "Testing controller";
    }

    @PostMapping(path = "/create-fun")
    public ResponseEntity<FunDTO> createFun(@RequestBody FunDTO funDTO){
        try{
            FunDTO fun = funService.create_fun(funDTO);
            return new ResponseEntity<>(fun, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(path = "get-fun")
    public ResponseEntity<List<FunDTO>> getfun(){
        try{
//            boolean validate = validateToken();
//            Optional <FunDTO> funs = funService.getAllFun();
            List<FunDTO> allfuns = funService.agetAllFun();
            return new ResponseEntity<>(allfuns, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/get-fun/{id}")
    public ResponseEntity<Optional<FunDTO>> getOneFun(@PathVariable("id") Long id){
        try{
            Optional<FunDTO> fun = Optional.ofNullable(funService.getOneFun(id));
            if (fun.isPresent()){

                return new ResponseEntity<>(fun, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @PutMapping(path = "/put-fun/{id}")
//    public FunDTO putFun(@RequestBody FunDTO funDTO, @PathVariable Long id){
//        return funService.putFun(id, funDTO);
//    }

    @DeleteMapping("delete-fun/{id}")
    public ResponseEntity<Boolean> deleteFun(@PathVariable Long id){
        try{
            boolean fun = funService.deleteFun(id);
            return new ResponseEntity<>(fun, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
