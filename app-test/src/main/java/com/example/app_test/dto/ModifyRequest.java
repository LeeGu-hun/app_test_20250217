package com.example.app_test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModifyRequest {
    private JournalDTO journalDTO;
    private PageRequestDTO pageRequestDTO;
}
