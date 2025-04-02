package com.babel.helloworld.gestionSiniestros;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import com.babel.helloworld.gestionSiniestros.model.Bien.TipoBien;
import com.babel.helloworld.gestionSiniestros.model.Siniestro.Siniestro;
import com.babel.helloworld.gestionSiniestros.model.Siniestro.TipoIndemnizacion;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.*;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.implementaciones.DepreciacionAllianzImpl;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.implementaciones.DepreciacionGeneralImpl;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.implementaciones.DepreciacionMapfreImpl;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.implementaciones.DepreciacionMutuaMadrilenaImpl;
import com.babel.helloworld.gestionSiniestros.service.valoracion.Valoracion;
import com.babel.helloworld.gestionSiniestros.service.valoracion.ValoracionImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

@Component
public class GestionSiniestrosImpl implements CommandLineRunner {

    private Valoracion valoracion;

    public GestionSiniestrosImpl(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public void run(String... args) throws Exception {

        Depreciacion depreciacion = new DepreciacionGeneralImpl();
        Bien bien1 = new Bien("Tesla",TipoBien.VEHICULO,  1000.0, LocalDate.of(2010, 10, 10));
        Bien bien2 = new Bien("Mesa",TipoBien.MUEBLE,  1000.0, LocalDate.of(2015, 10, 10));
        Bien bien3 = new Bien("Silla",TipoBien.MUEBLE,  1000.0, LocalDate.of(2015, 10, 10));
        List<Bien> bienesAfectados = List.of(bien1, bien2, bien3);
        Siniestro siniestro = Siniestro.builder()
                .fechaOcurrencia(LocalDate.of(2024, 4, 2))
                .numeroPoliza("POL123456")
                .direccionSiniestro("Av. Principal 123, Ciudad")
                .aseguradora("Seguros XYZ")
                .tipoIndemnizacion(TipoIndemnizacion.A_NUEVO)
                .bienesAfectados(bienesAfectados)
                .horaSiniestro(LocalTime.of(14, 30))
                .descripcionSiniestro("Incendio en el área de cocina")
                .build();
        System.out.println("Siniestro: " + siniestro);
        System.out.println("Precio final: " + valoracion.calcularValoracionBienesAfectados(siniestro));

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Introduzca los siguientes datos... \n");
//
//        System.out.println("Fecha de ocurrencia del siniestro: ");
//        LocalDate fechaSiniestro = LocalDate.parse(scanner.nextLine());
//
//        System.out.println("Hora de siniestro: ");
//        LocalTime horaSiniestro = LocalTime.parse(scanner.nextLine());
//
//        System.out.println("Descripción del siniestro: ");
//        String descripcion = scanner.nextLine();
//
//        System.out.println("Número de póliza: ");
//        int numeroPoliza = scanner.nextInt();
//
//        System.out.println("Dirección del siniestro: ");
//        String direccionSiniestro = scanner.nextLine();
//
//        System.out.println("Nombre del seguro: Allianz, Mapfre, MutuaMadrileña o General");
//        String idSeguro = scanner.nextLine().toUpperCase();
//
//        System.out.println("Tipo de indemnización: ");
//        String indemnizacion = "";
//        do {
//            try {
//                indemnizacion = scanner.nextLine().toUpperCase();
//            } catch (IllegalArgumentException e) {
//                System.out.println("Valor inválido. Debes introducir si quiere una indemnizacion a NUEVO o REAL");
//            }
//        } while (indemnizacion != "NUEVO" || indemnizacion != "REAL");
//
//
//        System.out.println("LISTADO DE BIENES AFECTADOS");
//
//        System.out.println("Nombre del bien: ");
//        String bien = "";
//
//        do {
//            try {
//                bien = scanner.nextLine().toUpperCase();
//            } catch (IllegalArgumentException e) {
//                System.out.println("Valor inválido. Debes introducir uno de los siguientes tipos de bienes: VEHICULO, VIVIENDA, MOBILIARIO, ELECTRONICA, JOYAS, ARTE, OTROS");
//            }
//        } while (bien == " ");
//
//        System.out.println("Fecha de compra del bien: ");
//        LocalDate fechaCompraBien = LocalDate.parse(scanner.nextLine());
//
//        System.out.println("Valor de compra del bien: ");
//        Double valorCompra = Double.parseDouble(scanner.nextLine());


//        if (seguro.equals("ALLIANZ")) {
//            depreciacion = new DepreciacionAllianzImpl();
//        } else if (seguro.equals("MAPFRE")) {
//            depreciacion = new DepreciacionMapfreImpl();
//        } else if (seguro.equals("MUTUAMADRILEÑA")) {
//            depreciacion = new DepreciacionMutuaMadrilenaImpl();
//        } else {
//            depreciacion = new DepreciacionGeneralImpl();
//        }
//
//        System.out.println("El precio final calculado para su bien es: " + depreciacion.CalcularPrecioBien(fechaSiniestro, bien));

    }
}
