package com.reciclajeApp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.reciclajeApp.domain.Visitarecicladores;
import com.reciclajeApp.dto.VisitarecicladoresDTO;


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
public interface VisitarecicladoresMapper {
    @Mapping(source = "estadovisita.idestadovisita", target = "idestadovisita_Estadovisita")
    @Mapping(source = "emailCentroDeAcopio.email", target = "emailCentroDeAcopio")
    @Mapping(source = "venta.idventa", target = "idventa_Venta")
    public VisitarecicladoresDTO visitarecicladoresToVisitarecicladoresDTO(
        Visitarecicladores visitarecicladores);

    @Mapping(source = "idestadovisita_Estadovisita", target = "estadovisita.idestadovisita")
    @Mapping(source = "emailCentroDeAcopio", target = "emailCentroDeAcopio.email")
    @Mapping(source = "idventa_Venta", target = "venta.idventa")
    public Visitarecicladores visitarecicladoresDTOToVisitarecicladores(
        VisitarecicladoresDTO visitarecicladoresDTO);

    public List<VisitarecicladoresDTO> listVisitarecicladoresToListVisitarecicladoresDTO(
        List<Visitarecicladores> visitarecicladoress);

    public List<Visitarecicladores> listVisitarecicladoresDTOToListVisitarecicladores(
        List<VisitarecicladoresDTO> visitarecicladoresDTOs);
}
