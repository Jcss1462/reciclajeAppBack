package com.reciclajeApp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.reciclajeApp.domain.Estadoventa;
import com.reciclajeApp.dto.EstadoventaDTO;


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
public interface EstadoventaMapper {
    public EstadoventaDTO estadoventaToEstadoventaDTO(Estadoventa estadoventa);

    public Estadoventa estadoventaDTOToEstadoventa(
        EstadoventaDTO estadoventaDTO);

    public List<EstadoventaDTO> listEstadoventaToListEstadoventaDTO(
        List<Estadoventa> estadoventas);

    public List<Estadoventa> listEstadoventaDTOToListEstadoventa(
        List<EstadoventaDTO> estadoventaDTOs);
}
