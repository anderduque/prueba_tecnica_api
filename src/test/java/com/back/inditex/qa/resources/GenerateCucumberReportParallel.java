package com.back.inditex.qa.resources;


import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 Clase que genera el reporte cucumber con todos los features ejecutados en el runner
 */
public class GenerateCucumberReportParallel {
    /**
     Método que genera el reporte cucumber con los datos de los features ejecutados
     *
     @param jsonFiles   Colección de todos los archivos json creado por karate tras la ejecución de un feature o scenario
     @param target      Nombre de la carpeta que contendrá el reporte
     @param projectName Nombre del proyecto, se mostrará dentro del reporte cucumber
     */
    public static void generateReport(Collection<File> jsonFiles, String target, String projectName) {
        String reportPATH = target;
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> {
            try {
                getPathFile(file).forEach(path -> jsonPaths.add(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Configuration config = new Configuration(new File(reportPATH), projectName);
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
    /**
     Mètodo que obtiene los path absolutos encontrados del archivo, si el archivo se encuentra duplicado devuelve la
     cantidad encontrada
     *
     @param file nombre del archivo json generado por karate
     @return listado de todos los path encontrados del file
     @throws IOException
     */
    public static List<Path> getPathFile(File file)
            throws IOException {
        Path path = Paths.get(file.getAbsoluteFile().getParentFile().getParentFile().getAbsolutePath());
        String fileName = file.getName();
        List<Path> result;
        try (Stream<Path> pathStream = Files.find(path,
                Integer.MAX_VALUE,
                (p, basicFileAttributes) ->
                        p.getFileName().toString().equalsIgnoreCase(fileName))
        ) {
            result = pathStream.collect(Collectors.toList());
        }
        return result;
    }
}
