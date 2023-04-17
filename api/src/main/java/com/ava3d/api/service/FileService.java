package com.ava3d.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class FileService {

    Set<String> extensionesImagenes = new HashSet<>(Arrays.asList("jpg", "jpeg", "png", "gif", "bmp", "tif", "tiff"));
    public String guardarArchivoCarrito(MultipartFile archivo) throws IOException {

        //nos devuelve la extension del archivo sin el punto
        String extension=obtenerExtension(archivo);
        String ruta=obtenerRuta(extension);
        // Generar un nombre de archivo único para evitar colisiones
        String nombreArchivo = System.currentTimeMillis() + "_" + archivo.getOriginalFilename();
        // Crear el directorio de las imágenes si no existe
        Path directorio = Paths.get(ruta);
        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio);
        }
        // Guardar la imagen en el servidor
        Path rutaArchivo = directorio.resolve(nombreArchivo);
        Files.copy(archivo.getInputStream(), rutaArchivo);
        // Devolver la ruta de la imagen
        return rutaArchivo.toAbsolutePath().toString();
    }
    //valida que la extension sea de una imagen
    public boolean validarImagen(MultipartFile archivo){
        String extension= obtenerExtension(archivo);
        if(extensionesImagenes.contains(extension)){
            return true;
        }
        return false;
    }
    //valida que la extension sea de un stl
    public boolean validarStl(MultipartFile archivo){
        String extension= obtenerExtension(archivo);
        if(extension.equals("stl")){
            return true;
        }
        return false;
    }

    //devuelve la extension del archivo, si la extension del archivo esta vacia devuelve un String vacio
    public String obtenerExtension(MultipartFile archivo){
        //obtengo el nombre del archivo y lo vuelvo cadena
        String nombreArchivo=archivo.getOriginalFilename().toString();
        int ultimoIndicePunto = nombreArchivo.lastIndexOf(".");
        return nombreArchivo.substring(ultimoIndicePunto + 1).toLowerCase();
    }

    //busca que ruta usar en caso de que sea imagen o archivo
    public String obtenerRuta(String extension) {
        if (extension.equals("stl")) {
            //return "/ava3d/carrito/modelo";
            return "/Users/ferse/OneDrive/Escritorio/STL-Calculator/model";
        }
        //return "/ava3d/carrito/img";
        return "/Users/ferse/OneDrive/Escritorio/STL-Calculator/img";
    }


}
