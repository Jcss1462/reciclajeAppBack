package com.reciclajeApp.mapper;

import com.reciclajeApp.domain.Donacion;

import com.reciclajeApp.dto.DonacionDTO;

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
public interface DonacionMapper {
    @Mapping(source = "tiporesiduo.idtiporesiduo", target = "idtiporesiduo_Tiporesiduo")
    public DonacionDTO donacionToDonacionDTO(Donacion donacion);

    @Mapping(source = "idtiporesiduo_Tiporesiduo", target = "tiporesiduo.idtiporesiduo")
    public Donacion donacionDTOToDonacion(DonacionDTO donacionDTO);

    public List<DonacionDTO> listDonacionToListDonacionDTO(
        List<Donacion> donacions);

    public List<Donacion> listDonacionDTOToListDonacion(
        List<DonacionDTO> donacionDTOs);
}
