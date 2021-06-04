package com.reciclajeApp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.reciclajeApp.domain.Estadovisita;
import com.reciclajeApp.dto.EstadovisitaDTO;


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
public interface EstadovisitaMapper {
    public EstadovisitaDTO estadovisitaToEstadovisitaDTO(
        Estadovisita estadovisita);

    public Estadovisita estadovisitaDTOToEstadovisita(
        EstadovisitaDTO estadovisitaDTO);

    public List<EstadovisitaDTO> listEstadovisitaToListEstadovisitaDTO(
        List<Estadovisita> estadovisitas);

    public List<Estadovisita> listEstadovisitaDTOToListEstadovisita(
        List<EstadovisitaDTO> estadovisitaDTOs);
}
