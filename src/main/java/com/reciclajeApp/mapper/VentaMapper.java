package com.reciclajeApp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.dto.VentaDTO;


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
    @Mapping(source = "tiporesiduo.tipo", target = "tipo")
    @Mapping(source = "tiporesiduo.precio", target = "precioPorKiloTipo")
    @Mapping(source = "emailCentroDeAcopio.email", target = "emailCentroDeAcopio")
    public VentaDTO ventaToVentaDTO(Venta venta);

    @Mapping(source = "idestadoventa_Estadoventa", target = "estadoventa.idestadoventa")
    @Mapping(source = "idtiporesiduo_Tiporesiduo", target = "tiporesiduo.idtiporesiduo")
    @Mapping(source = "email_Usuario", target = "usuario.email")
    @Mapping(source = "tipo", target = "tiporesiduo.tipo")
    @Mapping(source = "precioPorKiloTipo", target = "tiporesiduo.precio")
    @Mapping(source = "emailCentroDeAcopio", target = "emailCentroDeAcopio.email")
    public Venta ventaDTOToVenta(VentaDTO ventaDTO);

    public List<VentaDTO> listVentaToListVentaDTO(List<Venta> ventas);

    public List<Venta> listVentaDTOToListVenta(List<VentaDTO> ventaDTOs);
}
