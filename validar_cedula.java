/**
 * Comprueba el correcto formato de las cédula dominicana pasada
 * por parámetro.
 *
 *
 * @param cedula
 *
 *
 * @return verdadero si tiene el formato correcto
 *
 * Ejemplo para prueba: 00118595792
 */

public static boolean validarCedula(String cedula){
	
    int suma = 0;

    final char[] peso = { '1', '2', '1', '2', '1', '2', '1', '2', '1', '2' };

    // Comprobaciones iniciales
	
    if ((cedula == null) || (cedula.length() != 11)){
    	return false;
    }

    // Si no es un nº => la descartamos  

 	try{
		Long.parseLong(cedula);
	}
	catch (Exception e){
    	return false;
	}
    
	for (int i = 0; i < 10; i++){

		int a = Character.getNumericValue(cedula.charAt(i));

		int b = Character.getNumericValue(peso[i]);
	
        char[] mult = Integer.toString(a * b).toCharArray();

	    if (mult.length > 1){
			a = Character.getNumericValue(mult[0]);
            b = Character.getNumericValue(mult[1]);
        }
		else{
           	a = 0;
            b = Character.getNumericValue(mult[0]);
    	}

		suma = suma + a + b;
	}

	int digito = (10 - (suma % 10)) % 10;

    // Comprobamos que el dígito de control coincide    
	if (digito != Character.getNumericValue(cedula.charAt(10))){
	    return false;
	}

    return true;
}
