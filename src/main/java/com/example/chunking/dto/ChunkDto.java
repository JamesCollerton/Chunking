package com.example.chunking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChunkDto {

  private Long id;

  private String chunkName;

  private String base64Bytes;
}
