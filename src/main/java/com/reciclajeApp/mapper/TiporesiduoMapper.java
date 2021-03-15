package com.reciclajeApp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.reciclajeApp.domain.Tiporesiduo;
import com.reciclajeApp.dto.TiporesiduoDTO;


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
public interface TiporesiduoMapper {
    public TiporesiduoDTO tiporesiduoToTiporesiduoDTO(Tiporesiduo tiporesiduo);

    public Tiporesiduo tiporesiduoDTOToTiporesiduo(
        TiporesiduoDTO tiporesiduoDTO);

    public List<TiporesiduoDTO> listTiporesiduoToListTiporesiduoDTO(
        List<Tiporesiduo> tiporesiduos);

    public List<Tiporesiduo> listTiporesiduoDTOToListTiporesiduo(
        List<TiporesiduoDTO> tiporesiduoDTOs);
}
