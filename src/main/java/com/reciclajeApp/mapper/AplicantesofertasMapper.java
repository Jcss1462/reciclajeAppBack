package com.reciclajeApp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.reciclajeApp.domain.Aplicantesofertas;
import com.reciclajeApp.dto.AplicantesofertasDTO;


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
public interface AplicantesofertasMapper {
    
	
	@Mapping(source = "ofertas.idoferta", target = "idoferta_Ofertas")
    @Mapping(source = "email_reciclador.email", target = "email_Usuario")
    public AplicantesofertasDTO aplicantesofertasToAplicantesofertasDTO(
        Aplicantesofertas aplicantesofertas);

    @Mapping(source = "idoferta_Ofertas", target = "ofertas.idoferta")
    @Mapping(source = "email_Usuario", target = "email_reciclador.email")
    public Aplicantesofertas aplicantesofertasDTOToAplicantesofertas(
        AplicantesofertasDTO aplicantesofertasDTO);

    public List<AplicantesofertasDTO> listAplicantesofertasToListAplicantesofertasDTO(
        List<Aplicantesofertas> aplicantesofertass);

    public List<Aplicantesofertas> listAplicantesofertasDTOToListAplicantesofertas(
        List<AplicantesofertasDTO> aplicantesofertasDTOs);
}
