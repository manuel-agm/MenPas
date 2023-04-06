package com.uma.menpas.models.adapters

import com.uma.menpas.models.Usuario
import org.ksoap2.serialization.SoapObject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AdaptadorUsuario {

    companion object {

        fun soapObjectAModelo(result: SoapObject): Usuario {
            val listaAtributosUsuario = mutableListOf<String>()
            val listaPropiedades: SoapObject = result.getProperty(0) as SoapObject
            for (i in 0 until listaPropiedades.propertyCount) {
                listaAtributosUsuario.add(listaPropiedades.getPropertyAsString(i))
            }
            return convertirAModelo(listaAtributosUsuario)
        }

        fun modeloASoapObject() {
            TODO()
        }

        private fun convertirAModelo(result: MutableList<String>): Usuario {
            val nombreUsuario = result[0]
            val contrasenya = result[1]
            val nombre = result[2]
            val apellidos = result[3]
            val edad = Integer.parseInt(result[4])
            val telefono = result[5]
            val dni = result[6]
            val sexo = result[7]
            val fechaRegistro =
                LocalDateTime.parse(result[8], DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
            val perfil = result[9]
            val correo = result[10]
            val deportePracticado = result[11]
            val grupo = result[12]
            val nacionalidad = result[13]
            val estadoCivil = result[14]
            val horasSemanales = Integer.parseInt(result[15])
            val estudios = result[16]
            val profesion = result[17]
            val aComienzoDeporte = Integer.parseInt(result[18])

            return Usuario(
                nombreUsuario,
                contrasenya,
                nombre,
                apellidos,
                edad,
                telefono,
                dni,
                sexo,
                fechaRegistro,
                perfil,
                correo,
                deportePracticado,
                grupo,
                nacionalidad,
                estadoCivil,
                horasSemanales,
                estudios,
                profesion,
                aComienzoDeporte
            )
        }
    }
}