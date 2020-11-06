package com.anton.converter;

import com.anton.dto.HistoryDTO;
import com.anton.model.History;
import com.anton.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryConverter {

    @Autowired
    private HistoryService historyService;

    public HistoryDTO getHistoryDTO(Long id){
        History history = historyService.getHistoryById(id);
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setAction(history.getAction());
        historyDTO.setDate(history.getDate());
        historyDTO.setDescription(history.getDescription());
        historyDTO.setTicketId(history.getTicket().getId());
        historyDTO.setUserId(history.getUser().getId());
        return historyDTO;
    }

    public List<HistoryDTO> getListOfHistoryDTO(){
        List<HistoryDTO> historyDTOList = new ArrayList<>();
        for (History history: historyService.getListOfHistories()){
            HistoryDTO historyDTO = new HistoryDTO();
            historyDTO.setAction(history.getAction());
            historyDTO.setDate(history.getDate());
            historyDTO.setDescription(history.getDescription());
            historyDTO.setTicketId(history.getTicket().getId());
            historyDTO.setUserId(history.getUser().getId());
            historyDTOList.add(historyDTO);
        }
        return historyDTOList;
    }

}
