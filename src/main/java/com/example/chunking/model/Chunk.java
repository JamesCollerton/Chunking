package com.example.chunking.model;

import com.example.chunking.dto.ChunkDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Base64;

@Entity
@Data
@Builder
@Table(name = "chunk")
@NoArgsConstructor
@AllArgsConstructor
public class Chunk {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String chunkName;

  @Column(columnDefinition = "VARBINARY(MAX)")
  private byte[] chunkBytes;

  public static Chunk fromDto(ChunkDto chunkDto) {
    return Chunk.builder()
        .chunkName(chunkDto.getChunkName())
        .chunkBytes(Base64.getDecoder().decode(chunkDto.getBase64Bytes()))
        .build();
  }

  public ChunkDto toDto() {
    return ChunkDto.builder()
        .id(id)
        .chunkName(chunkName)
        .base64Bytes(Base64.getEncoder().encodeToString(chunkBytes))
        .build();
  }
}
