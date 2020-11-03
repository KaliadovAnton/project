package com.anton.controller;

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

    @GetMapping()
    public ResponseEntity<List<Attachment>> getListOfTickets(){
        List<Attachment> attachment = attachmentService.getListOfAttachments();
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
    public void updateTicket(@PathVariable("id") Long id, Attachment ticket){

    }

    @GetMapping("/{id}")
    public ResponseEntity<Attachment> getTicketById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(attachmentService.getAttachmentById(id));
    }
}
