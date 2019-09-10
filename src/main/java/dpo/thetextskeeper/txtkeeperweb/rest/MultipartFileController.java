package dpo.thetextskeeper.txtkeeperweb.rest;

import dpo.thetextskeeper.txtkeeperweb.entity.FileData;
import dpo.thetextskeeper.txtkeeperweb.repository.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file/")
public class MultipartFileController {


    @Autowired
    private FileDataRepository fileDataRepository;

    @PostMapping
    public void handleFileUpload(@RequestParam("file") MultipartFile file) {
        final FileData fileData = new FileData();
        fileData.setFileName(file.getOriginalFilename());
        fileData.setFileSize(file.getSize());
        fileDataRepository.save(fileData);

    }


    @GetMapping
    public Iterable handleFileUpload() {
        return fileDataRepository.findAll();
    }


    @DeleteMapping
    public void deleteAll() {
         fileDataRepository.deleteAll();
    }
}
