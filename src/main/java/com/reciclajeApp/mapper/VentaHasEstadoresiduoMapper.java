package com.reciclajeApp.mapper;

import com.reciclajeApp.domain.VentaHasEstadoresiduo;

import com.reciclajeApp.dto.VentaHasEstadoresiduoDTO;

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
public interface VentaHasEstadoresiduoMapper {
    //@Mapping(source = "estadoresiduo.idestadoresiduo", target = "idestadoresiduo_Estadoresiduo")
    //@Mapping(source = "venta.idventa", target = "idventa_Venta")
    public VentaHasEstadoresiduoDTO ventaHasEstadoresiduoToVentaHasEstadoresiduoDTO(
        VentaHasEstadoresiduo ventaHasEstadoresiduo);

    //@Mapping(source = "idestadoresiduo_Estadoresiduo", target = "estadoresiduo.idestadoresiduo")
    //@Mapping(source = "idventa_Venta", target = "venta.idventa")
    public VentaHasEstadoresiduo ventaHasEstadoresiduoDTOToVentaHasEstadoresiduo(
        VentaHasEstadoresiduoDTO ventaHasEstadoresiduoDTO);

    public List<VentaHasEstadoresiduoDTO> listVentaHasEstadoresiduoToListVentaHasEstadoresiduoDTO(
        List<VentaHasEstadoresiduo> ventaHasEstadoresiduos);

    public List<VentaHasEstadoresiduo> listVentaHasEstadoresiduoDTOToListVentaHasEstadoresiduo(
        List<VentaHasEstadoresiduoDTO> ventaHasEstadoresiduoDTOs);
}
