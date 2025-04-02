package com.babel.helloworld.gestionSiniestros;

import com.babel.helloworld.gestionSiniestros.model.Bien.Bien;
import com.babel.helloworld.gestionSiniestros.model.Bien.TipoBien;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.*;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.implementaciones.DepreciacionAllianzImpl;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.implementaciones.DepreciacionGeneralImpl;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.implementaciones.DepreciacionMapfreImpl;
import com.babel.helloworld.gestionSiniestros.service.depreciacion.implementaciones.DepreciacionMutuaMadrilenaImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class GestionSiniestrosImpl implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca los siguientes datos... \n");

        System.out.println("Fecha del siniestro: ");
        LocalDate fechaSiniestro = LocalDate.parse(scanner.nextLine());

        System.out.println("Tipo de bien: ");
        String input = scanner.nextLine().toUpperCase();

        TipoBien tipoBien = null;
        do {
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
        } while (tipoBien == null);

        System.out.println("Valor de compra del bien: ");
        Double valorCompra = Double.parseDouble(scanner.nextLine());

        System.out.println("Fecha de compra del bien: ");
        LocalDate fechaCompraBien = LocalDate.parse(scanner.nextLine());

        Bien bien = new Bien("nombre", tipoBien, valorCompra, fechaCompraBien);
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
