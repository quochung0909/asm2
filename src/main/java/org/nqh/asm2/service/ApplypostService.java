package org.nqh.asm2.service;
import java.util.List;

import org.nqh.asm2.pojo.Applypost;
import org.springframework.web.multipart.MultipartFile;

public interface ApplypostService {
    void applyJob(int idRe, String text);
    void applyJob(int idRe, String text, MultipartFile file);

    List<Applypost> getAllApplypost();
}
