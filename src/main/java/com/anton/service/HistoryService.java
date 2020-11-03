package com.anton.service;

import com.anton.model.History;
import com.anton.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public List<History> getListOfHistory(){
        return historyRepository.getAllHistories();
    }

    public List<History> getListOfHistories() {
        return historyRepository.getAllHistories();
    }

    public void deleteHistory(Long id) {
        historyRepository.deleteHistory(id);
    }

    public History getHistoryById(Long id) {
        return historyRepository.getHistoryById(id);
    }

    public void addHistory(History history) {
        historyRepository.addHistory(history);
    }
}
