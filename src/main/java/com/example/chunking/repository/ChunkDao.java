package com.example.chunking.repository;

import com.example.chunking.model.Chunk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChunkDao extends JpaRepository<Chunk, Long> {
}
