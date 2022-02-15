package org.botscrewtesttask.service.impl;

import org.botscrewtesttask.model.Lector;
import org.botscrewtesttask.repository.LectorRepository;
import org.botscrewtesttask.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;
    @Autowired
    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public List<Lector> searchByTemplate(String template) {
        return lectorRepository.searchByTemplate("[a-zA-Z]*" + template + "[a-zA-Z]*");
    }
}
