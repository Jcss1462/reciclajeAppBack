package com.reciclajeApp.mapper;

import com.reciclajeApp.domain.Solicitudesrecoleccion;

import com.reciclajeApp.dto.SolicitudesrecoleccionDTO;

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
public interface SolicitudesrecoleccionMapper {
    @Mapping(source = "carrodonaciones.idcarrodonacion", target = "idcarrodonacion_Carrodonaciones")
    @Mapping(source = "emailReciclador.email", target = "emailReciclador")
    public SolicitudesrecoleccionDTO solicitudesrecoleccionToSolicitudesrecoleccionDTO(
        Solicitudesrecoleccion solicitudesrecoleccion);

    @Mapping(source = "idcarrodonacion_Carrodonaciones", target = "carrodonaciones.idcarrodonacion")
    @Mapping(source = "emailReciclador", target = "emailReciclador.email")
    public Solicitudesrecoleccion solicitudesrecoleccionDTOToSolicitudesrecoleccion(
        SolicitudesrecoleccionDTO solicitudesrecoleccionDTO);

    public List<SolicitudesrecoleccionDTO> listSolicitudesrecoleccionToListSolicitudesrecoleccionDTO(
        List<Solicitudesrecoleccion> solicitudesrecoleccions);

    public List<Solicitudesrecoleccion> listSolicitudesrecoleccionDTOToListSolicitudesrecoleccion(
        List<SolicitudesrecoleccionDTO> solicitudesrecoleccionDTOs);
}
