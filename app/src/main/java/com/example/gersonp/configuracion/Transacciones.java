package com.example.gersonp.configuracion;

public class Transacciones {

    public static final String namedb = "PM012023";


    public static final String Tabla = "personas";

    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = " edad";
    public static final String correo = " correo";


    public static final String CreateTablePersonas = "CREATE TABLE Personas "+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT, edad INTEGER,"+
            "correo TEXT)";



    public static final String DropTablePersonas = "DROP TABLE IF EXISTS personas";

    public static final String SelectTablePersonas = "SELECT * FROM" + Transacciones.Tabla;



}
