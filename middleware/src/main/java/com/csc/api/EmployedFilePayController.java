package com.csc.api;


import lombok.SneakyThrows;
import mapper.MapperEmployedList;
import model.Employed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("EmployedManagement/v1")
public class EmployedFilePayController {

    MapperEmployedList muck;
    @SneakyThrows
    @GetMapping("/employers")
    public ResponseEntity<List<?>> getEmployed(){

        List<?> employers= MapperEmployedList.getCustomers();
        return ResponseEntity.ok(employers);
    }


}
