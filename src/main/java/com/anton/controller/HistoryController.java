package com.anton.controller;

import com.anton.model.History;
import com.anton.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/history")
@CrossOrigin("*")
@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping()
    public ResponseEntity<List<History>> getListOfHistories(){
        List<History> History = historyService.getListOfHistories();
        return ResponseEntity.ok().body(History);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHistory(@PathVariable("id") Long id){
        historyService.deleteHistory(id);
        return ResponseEntity.ok().body("");
    }

    @PostMapping
    public ResponseEntity<?> saveHistory(@RequestBody History history){
        historyService.addHistory(history);
        return ResponseEntity.ok().body("");
    }

    @PutMapping("/{id}")
    public void updateHistory(@PathVariable("id") Long id, History history){

    }

    @GetMapping("/{id}")
    public ResponseEntity<History> getHistoryById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(historyService.getHistoryById(id));
    }
}
