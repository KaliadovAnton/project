package com.anton.service;

import com.anton.model.Attachment;
import com.anton.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
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
        return attachmentRepository.getAttachmentById(id).orElseThrow(()->new NoResultException("No attachment found with id" + id));
    }

    public void updateAttachment(Long id, Attachment attachment) {
        attachmentRepository.updateAttachment(id, attachment);
    }
}
