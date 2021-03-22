package com.reciclajeApp.mapper;

import com.reciclajeApp.domain.Venta;

import com.reciclajeApp.dto.VentaDTO;

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
public interface VentaMapper {
    @Mapping(source = "estadoventa.idestadoventa", target = "idestadoventa_Estadoventa")
    @Mapping(source = "tiporesiduo.idtiporesiduo", target = "idtiporesiduo_Tiporesiduo")
    @Mapping(source = "usuario.email", target = "email_Usuario")
    public VentaDTO ventaToVentaDTO(Venta venta);

    @Mapping(source = "idestadoventa_Estadoventa", target = "estadoventa.idestadoventa")
    @Mapping(source = "idtiporesiduo_Tiporesiduo", target = "tiporesiduo.idtiporesiduo")
    @Mapping(source = "email_Usuario", target = "usuario.email")
    public Venta ventaDTOToVenta(VentaDTO ventaDTO);

    public List<VentaDTO> listVentaToListVentaDTO(List<Venta> ventas);

    public List<Venta> listVentaDTOToListVenta(List<VentaDTO> ventaDTOs);
}
