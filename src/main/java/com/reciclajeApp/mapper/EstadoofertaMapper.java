package com.reciclajeApp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.reciclajeApp.domain.Estadooferta;
import com.reciclajeApp.dto.EstadoofertaDTO;


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
public interface EstadoofertaMapper {
    public EstadoofertaDTO estadoofertaToEstadoofertaDTO(
        Estadooferta estadooferta);

    public Estadooferta estadoofertaDTOToEstadooferta(
        EstadoofertaDTO estadoofertaDTO);

    public List<EstadoofertaDTO> listEstadoofertaToListEstadoofertaDTO(
        List<Estadooferta> estadoofertas);

    public List<Estadooferta> listEstadoofertaDTOToListEstadooferta(
        List<EstadoofertaDTO> estadoofertaDTOs);
}
