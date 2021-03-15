package com.reciclajeApp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.reciclajeApp.domain.Estadoresiduo;
import com.reciclajeApp.dto.EstadoresiduoDTO;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface EstadoresiduoMapper {
    public EstadoresiduoDTO estadoresiduoToEstadoresiduoDTO(
        Estadoresiduo estadoresiduo);

    public Estadoresiduo estadoresiduoDTOToEstadoresiduo(EstadoresiduoDTO estadoresiduoDTO);

    public List<EstadoresiduoDTO> listEstadoresiduoToListEstadoresiduoDTO(
        List<Estadoresiduo> estadoresiduos);

    public List<Estadoresiduo> listEstadoresiduoDTOToListEstadoresiduo(
        List<EstadoresiduoDTO> estadoresiduoDTOs);
}
