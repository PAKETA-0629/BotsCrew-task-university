package org.botscrewtesttask.service;

import org.botscrewtesttask.model.Lector;

import java.util.List;

public interface LectorService {

    List<Lector> searchByTemplate(String template);
}
