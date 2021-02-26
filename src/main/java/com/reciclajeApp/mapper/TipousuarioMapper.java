package com.reciclajeApp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.reciclajeApp.domain.Tipousuario;
import com.reciclajeApp.dto.TipousuarioDTO;


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
public interface TipousuarioMapper {
    public TipousuarioDTO tipousuarioToTipousuarioDTO(Tipousuario tipousuario);

    public Tipousuario tipousuarioDTOToTipousuario(
        TipousuarioDTO tipousuarioDTO);

    public List<TipousuarioDTO> listTipousuarioToListTipousuarioDTO(
        List<Tipousuario> tipousuarios);

    public List<Tipousuario> listTipousuarioDTOToListTipousuario(
        List<TipousuarioDTO> tipousuarioDTOs);
}
