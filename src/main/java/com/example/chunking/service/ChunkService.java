package com.example.chunking.service;

import com.example.chunking.model.Chunk;
import com.example.chunking.repository.ChunkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChunkService {

    @Autowired
    ChunkDao chunkDao;

    public Chunk create(Chunk chunk) {
        return chunkDao.save(chunk);
    }
}
