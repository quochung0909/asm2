package org.nqh.asm2.service;

import java.util.List;

import org.nqh.asm2.pojo.SaveJob;
import org.nqh.asm2.pojo.User;

public interface SaveJobService {
    void saveJob(SaveJob idRe);

    List<SaveJob> getListSaveJobByUser(User user);

    void deleteSaveJob(int id);
}
