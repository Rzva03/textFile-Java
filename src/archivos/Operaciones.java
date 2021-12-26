package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Operaciones {

    public void Escritura(String nomArchivo, Alumnos al) {
        try {
            FileWriter fw = new FileWriter(nomArchivo, true);
            BufferedWriter archivoEscritura = new BufferedWriter(fw);
            String guardar = al.toString();
            archivoEscritura.write(guardar);
            archivoEscritura.newLine();//como salto de linea
            archivoEscritura.flush();//para borrar el bufferedWrite
            archivoEscritura.close();//cierra el archivo
            fw.close();
        } catch (IOException e) {
            System.out.println(e);

        }

    }

    public void Lectura(String nomArchivo) {
        String cadena = "";
        FileReader fr;

        try {
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            Alumnos al = new Alumnos();
            cadena = archivoLectura.readLine();
            while (cadena != null) {
                StringTokenizer st = new StringTokenizer(cadena, ",");
                al.setCodigo(Integer.parseInt(st.nextToken()));
                al.setNombre(st.nextToken());
                al.setCarrera(st.nextToken());
                System.out.println(al.toString());
                cadena = archivoLectura.readLine();

            }
            archivoLectura.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("no se encuentra el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("no se encuentra el archivo");
            e.printStackTrace();

        }
    }

    
    public Alumnos buscarObj(String nomArchivo, int i) {
        Alumnos al = new Alumnos();
        String cadena = "";
        FileReader fr;
        try {
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadena = archivoLectura.readLine();
            while (cadena != null) {
                StringTokenizer st = new StringTokenizer(cadena, ",");
                int indice = Integer.parseInt(st.nextToken());
                if (indice == i) {
                    al.setCodigo(indice);
                    al.setNombre(st.nextToken());
                    al.setCarrera(st.nextToken());
                    
                    //System.out.println(al.toString());
                }

                cadena = archivoLectura.readLine();
            }
            archivoLectura.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se puede leer el archivo");
            e.printStackTrace();

        }
        return al;
    }

    public boolean Eliminar(String nomArchivo, String temporal, int i) {
        String cadenaEncontrada = "";
        FileReader fr;
        try {
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            Alumnos alumno = new Alumnos();
            cadenaEncontrada = archivoLectura.readLine();
            while (cadenaEncontrada != null) {
                StringTokenizer st = new StringTokenizer(cadenaEncontrada, ",");
                int indice = Integer.parseInt(st.nextToken());
                if (indice != i) {
                    try {
                        FileWriter fw = new FileWriter(temporal, true);
                        BufferedWriter archivoEscritura = new BufferedWriter(fw);
                        alumno.setCodigo(indice);
                        alumno.setNombre(st.nextToken());
                        alumno.setCarrera(st.nextToken());
                        String guardar = alumno.toString();
                        archivoEscritura.write(guardar);
                        archivoEscritura.newLine();
                        archivoEscritura.flush();
                        archivoEscritura.close();
                        fw.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
                cadenaEncontrada = archivoLectura.readLine();
            }
            archivoLectura.close();
            fr.close();
            File file = new File(nomArchivo);
            file.delete();
            File file2 = new File(temporal);
            file2.renameTo(file);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo");
        }
        return false;
    }


    public boolean modificar(String Archivo, int c, Alumnos al, String temporal) {
    String cadenaEncontrada = "";
        FileReader fr;
        try {
            fr = new FileReader(Archivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaEncontrada = archivoLectura.readLine();
            while (cadenaEncontrada != null) {
                StringTokenizer st = new StringTokenizer(cadenaEncontrada, ",");
                int indice = Integer.parseInt(st.nextToken());
                if (indice != c) {
                    try {
                        FileWriter fw = new FileWriter(temporal, true);
                        BufferedWriter archivoEscritura = new BufferedWriter(fw);
                        String guardar = al.toString();
                        archivoEscritura.write(guardar);
                        archivoEscritura.newLine();
                        al.setCodigo(indice); 
                        al.setNombre(st.nextToken());
                        al.setCarrera(st.nextToken());
                        String guardar2 = al.toString();
                        archivoEscritura.write(guardar2);
                        archivoEscritura.newLine();
                        archivoEscritura.flush();
                        archivoEscritura.close();
                        fw.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
                cadenaEncontrada = archivoLectura.readLine();
            }
            archivoLectura.close();
            fr.close();
            File file = new File(Archivo);
            file.delete();
            File file2 = new File(temporal);
            file2.renameTo(file);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo");
        }
        return false;    
    }
    }
