package com.reciclajeApp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.reciclajeApp.domain.Ofertas;
import com.reciclajeApp.dto.OfertasDTO;


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
public interface OfertasMapper {
    
	
	@Mapping(source = "estadooferta.idestadooferta", target = "idestadooferta_Estadooferta")
    @Mapping(source = "tiporesiduo.idtiporesiduo", target = "idtiporesiduo_Tiporesiduo")
    @Mapping(source = "emailCentroDeAcopio.email", target = "email_Usuario")
	@Mapping(source = "aplicantesofertases", target = "aplicantesofertases")
	@Mapping(source = "estadooferta.estado", target = "estadoOferta")
	@Mapping(source = "tiporesiduo.tipo", target = "tipoResiduo")
    public OfertasDTO ofertasToOfertasDTO(Ofertas ofertas);

    @Mapping(source = "idestadooferta_Estadooferta", target = "estadooferta.idestadooferta")
    @Mapping(source = "idtiporesiduo_Tiporesiduo", target = "tiporesiduo.idtiporesiduo")
    @Mapping(source = "email_Usuario", target = "emailCentroDeAcopio.email")
    public Ofertas ofertasDTOToOfertas(OfertasDTO ofertasDTO);

    public List<OfertasDTO> listOfertasToListOfertasDTO(List<Ofertas> ofertass);

    public List<Ofertas> listOfertasDTOToListOfertas(
        List<OfertasDTO> ofertasDTOs);
}
