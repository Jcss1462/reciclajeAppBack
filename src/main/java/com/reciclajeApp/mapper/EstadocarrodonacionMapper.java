package com.reciclajeApp.mapper;

import com.reciclajeApp.domain.Estadocarrodonacion;

import com.reciclajeApp.dto.EstadocarrodonacionDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


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
public interface EstadocarrodonacionMapper {
    public EstadocarrodonacionDTO estadocarrodonacionToEstadocarrodonacionDTO(
        Estadocarrodonacion estadocarrodonacion);

    public Estadocarrodonacion estadocarrodonacionDTOToEstadocarrodonacion(
        EstadocarrodonacionDTO estadocarrodonacionDTO);

    public List<EstadocarrodonacionDTO> listEstadocarrodonacionToListEstadocarrodonacionDTO(
        List<Estadocarrodonacion> estadocarrodonacions);

    public List<Estadocarrodonacion> listEstadocarrodonacionDTOToListEstadocarrodonacion(
        List<EstadocarrodonacionDTO> estadocarrodonacionDTOs);
}
