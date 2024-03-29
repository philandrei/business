package com.phl.business.domain.store.mapper;

import com.phl.business.domain.store.dto.StoreRequestDto;
import com.phl.business.domain.store.dto.StoreResponseDto;
import com.phl.business.domain.store.model.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {

    public Store storeDtoToStore(StoreRequestDto storeRequestDto) {
        Store store = Store.builder()
                              .name(storeRequestDto.getName())
                              .build();
        return store;
    }

    public StoreRequestDto storeToStoreDto(Store store) {
        StoreRequestDto storeRequestDto = StoreRequestDto.builder()
                                                  .name(store.getName())
                                                  .build();
        return storeRequestDto;
    }

    public StoreResponseDto storeToStoreResponseDto(Store store) {
        StoreResponseDto storeResponseDto = StoreResponseDto.builder()
                                                    .name(store.getName())
                                                    .uuid(store.getUuid())
                                                    .build();
        return storeResponseDto;
    }
}