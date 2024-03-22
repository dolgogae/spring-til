package com.example.projectdirection.pharmacy.service;

import com.example.projectdirection.api.dto.DocumentDto;
import com.example.projectdirection.api.dto.KakaoApiResponseDto;
import com.example.projectdirection.api.service.KakaoAddressSearchService;
import com.example.projectdirection.direction.entity.Direction;
import com.example.projectdirection.direction.service.DirectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class PharmacyRecommendationService {

    private final KakaoAddressSearchService kakaoAddressSearchService;
    private final DirectionService directionService;

    public void recommendPharmacyList(String address){

        KakaoApiResponseDto kakaoApiResponseDto = kakaoAddressSearchService.requestAddressSearch(address);

        if(Objects.isNull(kakaoApiResponseDto) || CollectionUtils.isEmpty(kakaoApiResponseDto.getDocumentDtoList())){
            log.error("[PharmacyRecommendationService recommendPharmacyList] Input address: {}", address);
            return;
        }

        DocumentDto documentDto = kakaoApiResponseDto.getDocumentDtoList().get(0);

        List<Direction> directionList = directionService.buildDirectionListByCategoryApi(documentDto);
        directionService.saveAll(directionList);
    }
}
