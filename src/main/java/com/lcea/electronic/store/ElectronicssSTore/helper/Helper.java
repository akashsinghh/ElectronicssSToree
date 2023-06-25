package com.lcea.electronic.store.ElectronicssSTore.helper;

import com.lcea.electronic.store.ElectronicssSTore.dtos.PageableResponse;
import com.lcea.electronic.store.ElectronicssSTore.dtos.ThingDto;
import com.lcea.electronic.store.ElectronicssSTore.entities.Thing;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    public static <U,V>PageableResponse<V> getPageableResponse(Page<U> page,Class <V> type){
        List<U> entity=page.getContent();
        //  List<Thing> users=thingReposistry.findAll();
        List<V> dtoList=entity.stream().map(object ->new ModelMapper().map(object,type)).collect(Collectors.toList());
        PageableResponse<V> response=new PageableResponse<>();
        response.setContent(dtoList);
        response.setPageNumber(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setPageSize(page.getTotalPages());
        response.setLastPage(page.isLast());
        return response;
    }
}
