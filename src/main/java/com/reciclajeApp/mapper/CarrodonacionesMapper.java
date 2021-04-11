package com.reciclajeApp.mapper;

import com.reciclajeApp.domain.Carrodonaciones;

import com.reciclajeApp.dto.CarrodonacionesDTO;

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
public interface CarrodonacionesMapper {
    @Mapping(source = "estadocarrodonacion.idestadodonacion", target = "idestadodonacion_Estadocarrodonacion")
    @Mapping(source = "usuario.email", target = "email_Usuario")
    public CarrodonacionesDTO carrodonacionesToCarrodonacionesDTO(
        Carrodonaciones carrodonaciones);

    @Mapping(source = "idestadodonacion_Estadocarrodonacion", target = "estadocarrodonacion.idestadodonacion")
    @Mapping(source = "email_Usuario", target = "usuario.email")
    public Carrodonaciones carrodonacionesDTOToCarrodonaciones(
        CarrodonacionesDTO carrodonacionesDTO);

    public List<CarrodonacionesDTO> listCarrodonacionesToListCarrodonacionesDTO(
        List<Carrodonaciones> carrodonacioness);

    public List<Carrodonaciones> listCarrodonacionesDTOToListCarrodonaciones(
        List<CarrodonacionesDTO> carrodonacionesDTOs);
}
