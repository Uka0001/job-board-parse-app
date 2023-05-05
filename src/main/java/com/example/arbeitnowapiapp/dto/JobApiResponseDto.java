package com.example.arbeitnowapiapp.dto;

import java.util.List;

public record JobApiResponseDto(
        List<JobDto> data,
        LinkDto links,
        MetaDto meta
) {

}
