package org.nqh.asm2.service.impl;

import java.util.List;

import org.nqh.asm2.pojo.SaveJob;
import org.nqh.asm2.pojo.User;
import org.nqh.asm2.repository.SaveJobRepository;
import org.nqh.asm2.service.SaveJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveJobServiceImpl implements SaveJobService{

    @Autowired
    private SaveJobRepository saveJobRepository;
    
    @Override
    public void saveJob(SaveJob idRe) {
        this.saveJobRepository.save(idRe);
    }

    @Override
    public List<SaveJob> getListSaveJobByUser(User user) {
        return this.saveJobRepository.findByUserByUserId(user);
    }

    @Override
    public void deleteSaveJob(int id) {
        this.saveJobRepository.deleteById(id);
    }
    
}
