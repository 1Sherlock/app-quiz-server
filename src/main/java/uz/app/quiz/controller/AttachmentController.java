package uz.app.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.app.quiz.entity.Attachment;
import uz.app.quiz.entity.AttachmentContent;
import uz.app.quiz.entity.User;
import uz.app.quiz.exception.ResourceNotFoundException;
import uz.app.quiz.payload.ApiResponse;
import uz.app.quiz.payload.ApiResponseModel;
import uz.app.quiz.repository.AttachmentContentRepository;
import uz.app.quiz.repository.AttachmentRepository;
import uz.app.quiz.security.CurrentUser;
import uz.app.quiz.service.AttachmentService;
import uz.app.quiz.service.FileServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/file")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @PostMapping
    public ApiResponseModel uploadFile(MultipartHttpServletRequest request, @CurrentUser User user) throws IOException {
        return attachmentService.uploadFile(request,user);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getFile(@PathVariable UUID id, HttpServletResponse response, @RequestParam(value = "download", defaultValue ="") String download) {

        return attachmentService.getAttachmentContent(id, response,download);
    }

    @GetMapping("/{id}/{status}")
    public HttpEntity<?> getFileSetDownload(@PathVariable(value = "id") UUID id, HttpServletResponse response, @PathVariable(value = "status") String download) {

        return attachmentService.getAttachmentContent(id, response,download);
    }


//    @GetMapping("/getAttachmentList/{id}")
//    public HttpEntity<?> getAttachmentList(@PathVariable UUID id , @CurrentUser User user){
//        return  ResponseEntity.ok(attachmentService.getAttachmentList(id, user));
//    }

    @GetMapping("/content/{id}")
    public HttpEntity<?> getFileContent(@PathVariable UUID id, HttpServletResponse response) {

        return ResponseEntity.ok(new ApiResponseModel(true,"attachmentContent",attachmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("attachment not found", "id", id))));
    }


    @DeleteMapping("/{id}")
    public HttpEntity<?> delAttachment(@PathVariable UUID id){
        Optional<Attachment> byId = attachmentRepository.findById(id);
        if (byId.isPresent()){
            Optional<AttachmentContent> byAttachment = attachmentContentRepository.findByAttachment(byId.get());
        if (byAttachment.isPresent()){
            attachmentContentRepository.delete(byAttachment.get());
            attachmentRepository.delete(byId.get());
            return ResponseEntity.ok(new ApiResponse(true,"deleted"));

        }
        }
        return ResponseEntity.ok(new ApiResponse(false,"Error"));
    }


    @GetMapping("/byByte/{id}")
    public void getFileByByte(@PathVariable UUID id, HttpServletRequest request, HttpServletResponse response){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()){
            Attachment attachment= optionalAttachment.get();
            try{
                String path1= attachment.getName().split("///filePath///")[0];
                String path2= attachment.getName().split("///filePath///")[1];
                Path path;
                try {

                    File video=new File(path1);

//                   path = Files.write(Paths.get("videos/"+file.getAttachment().getName()), file.getContent());

                    FileServlet fileServlet = new FileServlet(video);
                    fileServlet.processRequest(request, response, true, attachment.getContentType());
                } catch (IOException k) {
                    k.printStackTrace();
                }
            }catch (Exception e){
                AttachmentContent file = attachmentContentRepository.getByAttachment(attachment);
                Path path;
                try {
                    String path1= new File(".").getCanonicalPath();

                    File file1=new File(path1+"/videos");
                    boolean created=file1.mkdir();
                    path = Files.write(Paths.get("videos/"+file.getAttachment().getName()), file.getContent());
                    File video = path.toFile();
                    FileServlet fileServlet = new FileServlet(video);
                    attachment.setName(path1+"/videos/"+attachment.getName()+"///filePath///"+attachment.getName());
                    attachmentRepository.save(attachment);
                    fileServlet.processRequest(request, response, true, file.getAttachment().getContentType());

                } catch (IOException k) {
                    k.printStackTrace();
                }
            }

//            response.setContentType(file.getAttachment().getContentType());


        }

    }
}
