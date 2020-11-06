package com.anton.service;

import com.anton.model.History;
import com.anton.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
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
        return historyRepository.getHistoryById(id).orElseThrow(()-> new NoResultException("Theres no history with id "+id));
    }

    public void addHistory(History history) {
        historyRepository.addHistory(history);
    }

    public void updateHistory(Long id, History history) {
        historyRepository.updateHistory(id, history);
    }
}
