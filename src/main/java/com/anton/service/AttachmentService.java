package com.anton.service;

import com.anton.model.Attachment;
import com.anton.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttachmentService {
    @Autowired
    private AttachmentRepository attachmentRepository;

    public List<Attachment> getListOfAttachments(){
        return attachmentRepository.getAllAttachments();
    }

    public void deleteAttachment(Long id) {
        attachmentRepository.deleteAttachment(id);
    }

    public void addAttachment(Attachment attachment) {
        attachmentRepository.addAttachment(attachment);
    }

    public Attachment getAttachmentById(Long id) {
        return attachmentRepository.getAttachmentById(id);
    }
}
