package com.example.chunking.controller;

import com.example.chunking.dto.ChunkDto;
import com.example.chunking.model.Chunk;
import com.example.chunking.service.ChunkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ChunkController {

  @Autowired private ChunkService chunkService;

  @PostMapping(path = "/chunk")
  public ResponseEntity<ChunkDto> createChunk(@RequestBody ChunkDto chunkDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(chunkService.create(Chunk.fromDto(chunkDto)).toDto());
  }

  @GetMapping(path = "/chunk/{id}")
  public ResponseEntity<ChunkDto> getChunk(@PathVariable("id") Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(chunkService.findById(id).toDto());
  }
}
