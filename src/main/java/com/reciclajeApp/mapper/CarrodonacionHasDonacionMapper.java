package com.reciclajeApp.mapper;

import com.reciclajeApp.domain.CarrodonacionHasDonacion;

import com.reciclajeApp.dto.CarrodonacionHasDonacionDTO;

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
public interface CarrodonacionHasDonacionMapper {
    @Mapping(source = "carrodonaciones.idcarrodonacion", target = "idcarrodonacion_Carrodonaciones")
    @Mapping(source = "donacion.iddonacion", target = "iddonacion_Donacion")
    public CarrodonacionHasDonacionDTO carrodonacionHasDonacionToCarrodonacionHasDonacionDTO(
        CarrodonacionHasDonacion carrodonacionHasDonacion);

    @Mapping(source = "idcarrodonacion_Carrodonaciones", target = "carrodonaciones.idcarrodonacion")
    @Mapping(source = "iddonacion_Donacion", target = "donacion.iddonacion")
    public CarrodonacionHasDonacion carrodonacionHasDonacionDTOToCarrodonacionHasDonacion(
        CarrodonacionHasDonacionDTO carrodonacionHasDonacionDTO);

    public List<CarrodonacionHasDonacionDTO> listCarrodonacionHasDonacionToListCarrodonacionHasDonacionDTO(
        List<CarrodonacionHasDonacion> carrodonacionHasDonacions);

    public List<CarrodonacionHasDonacion> listCarrodonacionHasDonacionDTOToListCarrodonacionHasDonacion(
        List<CarrodonacionHasDonacionDTO> carrodonacionHasDonacionDTOs);
}
