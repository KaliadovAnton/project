package com.anton.controller;

import com.anton.converter.HistoryConverter;
import com.anton.dto.HistoryDTO;
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
    @Autowired
    private HistoryConverter historyConverter;

    @GetMapping()
    public ResponseEntity<List<HistoryDTO>> getListOfHistories(){
        List<HistoryDTO> history = historyConverter.getListOfHistoryDTO();
        return ResponseEntity.ok().body(history);
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
        historyService.updateHistory(id, history);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryDTO> getHistoryById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(historyConverter.getHistoryDTO(id));
    }
}
