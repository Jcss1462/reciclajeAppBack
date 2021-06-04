package com.reciclajeApp.mapper;

import com.reciclajeApp.domain.Visitacivil;

import com.reciclajeApp.dto.VisitacivilDTO;

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
public interface VisitacivilMapper {
    @Mapping(source = "estadovisita.idestadovisita", target = "idestadovisita_Estadovisita")
    @Mapping(source = "emailPropietario.email", target = "emailPropietario")
    @Mapping(source = "emailRecolector.email", target = "emailRecolector")
    public VisitacivilDTO visitacivilToVisitacivilDTO(Visitacivil visitacivil);

    @Mapping(source = "idestadovisita_Estadovisita", target = "estadovisita.idestadovisita")
    @Mapping(source = "emailPropietario", target = "emailPropietario.email")
    @Mapping(source = "emailRecolector", target = "emailRecolector.email")
    public Visitacivil visitacivilDTOToVisitacivil(
        VisitacivilDTO visitacivilDTO);

    public List<VisitacivilDTO> listVisitacivilToListVisitacivilDTO(
        List<Visitacivil> visitacivils);

    public List<Visitacivil> listVisitacivilDTOToListVisitacivil(
        List<VisitacivilDTO> visitacivilDTOs);
}
