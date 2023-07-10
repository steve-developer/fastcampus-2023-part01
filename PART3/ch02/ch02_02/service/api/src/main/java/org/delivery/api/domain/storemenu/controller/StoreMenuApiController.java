package org.delivery.api.domain.storemenu.controller;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.api.Api;
import org.delivery.api.domain.storemenu.business.StoreMenuBusiness;
import org.delivery.api.domain.storemenu.controller.model.StoreMenuResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/store-menu")
public class StoreMenuApiController {

    private final StoreMenuBusiness storeMenuBusiness;

    @GetMapping("/search")
    public Api<List<StoreMenuResponse>> search(
        @RequestParam Long storeId
    ){
        var response = storeMenuBusiness.search(storeId);
        return Api.OK(response);
    }
}
