package uz.app.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uz.app.quiz.entity.Attachment;
import uz.app.quiz.entity.AttachmentContent;
import uz.app.quiz.entity.User;
import uz.app.quiz.exception.ResourceNotFoundException;
import uz.app.quiz.payload.ApiResponseModel;
import uz.app.quiz.payload.ResUploadFile;
import uz.app.quiz.repository.AttachmentContentRepository;
import uz.app.quiz.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;


    @Autowired
    AttachmentContentRepository attachmentContentRepository;





    @Transactional
    public ApiResponseModel uploadFile(MultipartHttpServletRequest request, User user) throws IOException {
        Iterator<String> itr = request.getFileNames();
        MultipartFile file;
        List<ResUploadFile> resUploadFiles = new ArrayList<>();
        while (itr.hasNext()) {
            file = request.getFile(itr.next());
            Attachment attachment;
            try {
                Attachment attachment1 = new Attachment(file.getOriginalFilename(),file.getOriginalFilename(), file.getSize(),file.getContentType());
                attachment1.setCreatedBy(user.getId());
                if(file.getContentType().contains("video")){
                    Path path;
                    String path1= new File(".").getCanonicalPath();

                    File file1=new File(path1+"/videos");
                    boolean created=file1.mkdir();
                    path = Files.write(Paths.get("videos/"+attachment1.getName()), file.getBytes());
                    File video = path.toFile();
                    FileServlet fileServlet = new FileServlet(video);
                    attachment1.setName(path1+"/videos/"+attachment1.getName()+"///filePath///"+attachment1.getName());
                    attachment1= attachmentRepository.save(attachment1);

                }
                attachment = attachmentRepository.save(attachment1);
            } catch (Exception e) {
                attachment = attachmentRepository.save(new Attachment(file.getOriginalFilename(),file.getOriginalFilename(), file.getSize(),file.getContentType()));

            }
            try {
                attachmentContentRepository.save(new AttachmentContent(file.getBytes(),attachment));
            } catch (IOException e) {
                e.printStackTrace();
            }
            resUploadFiles.add(new ResUploadFile(attachment.getId(),
                    attachment.getName(),
                    ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/file/").path(attachment.getId().toString()).toUriString(),
                    attachment.getContentType(),
                    attachment.getFileSize()));

        }
        return new ApiResponseModel(true, "", resUploadFiles);
    }

    public HttpEntity<?> getAttachmentContent(UUID attachmentId, HttpServletResponse response, String download) {

        Attachment attachment = attachmentRepository.findById(attachmentId).orElseThrow(() -> new ResourceNotFoundException("Attachment", "id", attachmentId));

        try {
            String path1= attachment.getName().split("///filePath///")[0];
            File video=new File(path1);

//                   path = Files.write(Paths.get("videos/"+file.getAttachment().getName()), file.getContent());
            byte[]bytes=Files.readAllBytes(Paths.get(path1));
            FileServlet fileServlet = new FileServlet(video);
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(attachment.getContentType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachment.getName() + "\"")
                    .body(bytes);        }
        catch (Exception e){
            AttachmentContent attachmentContent = attachmentContentRepository.findByAttachment(attachment).orElseThrow(() -> new ResourceNotFoundException("Attachment content", "attachment id", attachmentId));

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(attachment.getContentType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachment.getName() + "\"")
                    .body(attachmentContent.getContent());
        }
    }







}
