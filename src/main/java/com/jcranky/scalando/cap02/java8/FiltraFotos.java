package com.jcranky.scalando.cap02.java8;

import com.jcranky.scalando.cap02.java7.Foto;

import java.util.Collection;
import java.util.LinkedList;

public class FiltraFotos {
    static Collection<Foto> fotos = new LinkedList<Foto>() {{
        add(new Foto(10, "119192561@N02", "Scala", 7));
        add(new Foto(20, "130046925@N04", "NY", 7));
        add(new Foto(30, "76999786@N02", "Future starts slow", 2));
        add(new Foto(40, "124408581@N06", "Elizabeth Dress &amp; Shoes_003", 2));
        add(new Foto(50, "124408581@N06", "Elizabeth Dress &amp; Shoes_004", 7));
        add(new Foto(60, "124408581@N06", "Lonely Robot London Scala 201215", 2));
    }};

    public static void main(String[] args) {
        Collection<Foto> fotosFarm7 = new LinkedList<>();
        fotos.stream().filter((foto) -> (foto.getFarm() == 7)).forEach((foto) -> {
            fotosFarm7.add(foto);
        });

        System.out.println(fotosFarm7.size());
    }
}
