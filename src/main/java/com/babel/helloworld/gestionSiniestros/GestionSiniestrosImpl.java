package com.babel.helloworld.gestionSiniestros;

import com.babel.helloworld.gestionSiniestros.model.Bien;
import com.babel.helloworld.gestionSiniestros.model.TipoBien;
import com.babel.helloworld.gestionSiniestros.service.*;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.Scanner;


public class GestionSiniestrosImpl implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca los siguientes datos: \n");

        System.out.println("Fecha del siniestro: ");
        LocalDate fechaSiniestro = LocalDate.parse(scanner.nextLine());

        System.out.println("Tipo de bien: ");
        String input = scanner.nextLine().toUpperCase();

        TipoBien tipoBien = null;
        try {
            tipoBien = TipoBien.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Valor inválido. Debes introducir uno de los siguientes tipos de bienes: " +
                    "ORDENADOR \n" +
                    "    VEHICULO,\n" +
                    "    TELEVISOR,\n" +
                    "    MUEBLE,\n" +
                    "    NEVERA\n");
        }

        System.out.println("Valor de compra del bien: ");
        Double valorCompra = scanner.nextDouble();

        System.out.println("Fecha de compra del bien: ");
        LocalDate fechaCompraBien = LocalDate.parse(scanner.nextLine());

        Bien bien = new Bien(tipoBien, valorCompra, fechaCompraBien);
        Depreciacion depreciacion;

        System.out.println("De acuerdo, ¿qué seguro tienes contratado? ");
        String seguro = scanner.nextLine().toUpperCase();

        if (seguro.equals("ALLIANZ")) {
            depreciacion = new DepreciacionAllianzImpl();
        } else if (seguro.equals("MAPFRE")) {
            depreciacion = new DepreciacionMapfreImpl();
        } else if (seguro.equals("MUTUAMADRILEÑA")) {
            depreciacion = new DepreciacionMutuaMadrilenaImpl();
        } else {
            depreciacion = new DepreciacionGeneralImpl();
        }
        System.out.println("El precio final calculado para su bien es: " + depreciacion.CalcularPrecioBien(fechaSiniestro, bien));

    }
}
