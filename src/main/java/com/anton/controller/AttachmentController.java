package com.anton.controller;

import com.anton.converter.AttachmentConverter;
import com.anton.dto.AttachmentDTO;
import com.anton.model.Attachment;
import com.anton.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private AttachmentConverter attachmentConverter;

    @GetMapping()
    public ResponseEntity<List<AttachmentDTO>> getListOfTickets(){
        List<AttachmentDTO> attachment = attachmentConverter.getListOfAttachmentsDTO();
        return ResponseEntity.ok().body(attachment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id){
        attachmentService.deleteAttachment(id);
        return ResponseEntity.ok().body("");
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Attachment attachment){
        attachmentService.addAttachment(attachment);
        return ResponseEntity.ok().body("");
    }

    @PutMapping("/{id}")
    public void updateTicket(@PathVariable("id") Long id, Attachment attachment){
        attachmentService.updateAttachment(id, attachment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttachmentDTO> getTicketById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(attachmentConverter.getAttachmentDTO(id));
    }
}
