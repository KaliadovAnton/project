package com.anton.converter;

import com.anton.dto.AttachmentDTO;
import com.anton.model.Attachment;
import com.anton.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttachmentConverter {

    @Autowired
    private AttachmentService attachmentService;

    public AttachmentDTO getAttachmentDTO(Long id){
        Attachment attachment = attachmentService.getAttachmentById(id);
        AttachmentDTO attachmentDTO = new AttachmentDTO();
        attachmentDTO.setBlob(attachment.getBlob());
        attachmentDTO.setName(attachment.getName());
        attachmentDTO.setTicketId(attachment.getTicket().getId());
        return attachmentDTO;
    }

    public List<AttachmentDTO> getListOfAttachmentsDTO(){
        List<AttachmentDTO> attachmentDTOList = new ArrayList<>();
        for(Attachment attachment: attachmentService.getListOfAttachments()){
            AttachmentDTO attachmentDTO = new AttachmentDTO();
            attachmentDTO.setBlob(attachment.getBlob());
            attachmentDTO.setName(attachment.getName());
            attachmentDTO.setTicketId(attachment.getTicket().getId());
            attachmentDTOList.add(attachmentDTO);
        }
        return attachmentDTOList;
    }
}
