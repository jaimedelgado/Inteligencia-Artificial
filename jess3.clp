;  Autores: 
;     -Jaime Delgado Linares
;     -Carmen Acosta Morales
;  Grupo: 8
   
;////// Constantes
;**** Sirven para ajustar la dieta segun las necesidades de la persona
(defglobal ?*MargenCalorias* = 0.1) ;////
(defglobal ?*MargenProteinas* = 0.6);//// => Margenes 
(defglobal ?*MargenGrasas* = 0.4)   ;////
(defglobal ?*MargenHC* = 0.6)      ;////
;*** Sirven para repartir las calorias en las comidas
(defglobal ?*%des* = 0.2)   ;||||
(defglobal ?*%alm* = 0.4)   ;|||| => Reparticion de las calorias en las comidas
(defglobal ?*%mer* = 0.15)  ;||||
(defglobal ?*%cena* = 0.25) ;||||

;;;;;;; PERSONA
(deftemplate persona
    (slot nombre (type STRING))
	(slot edad (type NUMBER))
	(slot estatura (type NUMBER))
	(slot peso (type NUMBER))
	(slot sexo	(allowed-values varón mujer) (default varón))
	(slot actividad (allowed-values sedentaria ligera moderada alta atleta) (default sedentaria))
    (slot calorias(type NUMBER)(default 0))
    (slot proteinas(type NUMBER)(default 0))
    (slot grasas(type NUMBER)(default 0))
    (slot hc(type NUMBER)(default 0))
)

;;;;;;;; PLATO
(deftemplate plato
    (slot nombre (type STRING))
	(slot calorias(type NUMBER)(default 0))
    (slot proteinas(type NUMBER)(default 0))
    (slot grasas(type NUMBER)(default 0))
    (slot hc(type NUMBER)(default 0))
	(slot tipo (allowed-values primero segundo ambos postre)(default postre))
)
;;;;; PLATOS INICIALES
(deffacts platosIniciales
    (plato (nombre "Zumo de naranja")(calorias 140)(proteinas 1.8)( grasas 0.6)(hc 36)(tipo postre))
	(plato (nombre "Tostada de pan")(calorias 40) (proteinas 1.3)( grasas 0.2)(hc 7.7)(tipo postre))
	(plato (nombre "Platano") (calorias 170) (proteinas 1.8)( grasas 0.2)(hc 36.8)(tipo postre))
	(plato (nombre "Cafe con leche")(calorias 126)(proteinas 8.6)( grasas 5.4)(hc 12.2)(tipo postre))
	(plato (nombre "Infusion") (calorias 4) (proteinas 0)( grasas 0)(hc 0.1)(tipo postre))
	(plato (nombre "Croissant") (calorias 350) (proteinas 5.5)( grasas 17.8)(hc 41.6)(tipo postre))
	(plato (nombre "Yogurt desnatado")(calorias 70)(proteinas 6.6)( grasas 1.8)(hc 8)(tipo postre))
	(plato (nombre "Natillas")(calorias 160)(proteinas 5.8)( grasas 4.6)(hc 24.2)(tipo postre))
	(plato (nombre "Platano")(calorias 170)(proteinas 1.8)( grasas 0.2)(hc 36.8)(tipo postre))
	(plato (nombre "Helado")(calorias 206)(proteinas 4.6)( grasas 10)(hc 24.4)(tipo postre))
	(plato (nombre "Tarta de manzana")(calorias 320)(proteinas 3.8)( grasas 15.4)(hc 40.6)(tipo postre))
	(plato (nombre "Sopa de fideos")(calorias 91)(proteinas 3.1)( grasas 1.2)(hc 16.3)(tipo primero))
	(plato (nombre "Pisto")(calorias 171)(proteinas 3.4	)( grasas 11.2)(hc 17.4)(tipo primero))
	(plato (nombre "Melon con jamon")(calorias 190)(proteinas 23.1)( grasas 6.2)(hc 12)(tipo primero))
	(plato (nombre "Lentejas")(calorias 403)(proteinas 26.6)( grasas 2)(hc 63)(tipo primero))
	(plato (nombre "Macarrones con tomate")(calorias 458)(proteinas 14.9)( grasas 6.5)(hc 82.7)(tipo primero))
	(plato (nombre "Paella")(calorias 754)(proteinas 21.3)( grasas 3)(hc 152)(tipo primero))
	(plato (nombre "Tortilla francesa")(calorias 185)(proteinas 14.4)( grasas 13.7)(hc 0.7)(tipo segundo))
	(plato (nombre "Filete de ternera")(calorias 281)(proteinas 40)( grasas 13.3)(hc 0)(tipo segundo))
	(plato (nombre "Sepia a la plancha")(calorias 310)(proteinas 69.2)( grasas 3.9)(hc 0)(tipo ambos))
	(plato (nombre "Croquetas de pollo")(calorias 298)(proteinas 7.4)( grasas 8)(hc 46.2)(tipo ambos))
	(plato (nombre "Cordero al ajillo")(calorias 291)(proteinas 29.5)( grasas 19.4)(hc 0)(tipo segundo))
	(plato (nombre "Hamburguesa con cebolla")(calorias 495)(proteinas 48.9)( grasas 15.5)(hc 47.5)(tipo segundo))
	(plato (nombre "San jacobos")(calorias 564)(proteinas 8.7)( grasas 27.1)(hc 50.4)(tipo ambos))
	(plato (nombre "Bacalao a la vizcaina")(calorias 600)(proteinas 77.38)( grasas 28.9)(hc 6.1)(tipo segundo))
	(plato (nombre "Pollo asado")(calorias 488)(proteinas 55.9)( grasas 29.3)(hc 0)(tipo segundo))
	; (plato (nombre "Ninguno")(calorias 0)(proteinas 0)( grasas 0)(hc 0)(tipo primero))

)
/*(deffacts personaInicial
	;(persona (nombre "Pedro Suarez Fernandez") (edad 20) (estatura 170) (peso 75) (sexo varón) (actividad moderada) 
    ;(calorias 0)(proteinas 0)(grasas 0)(hc 0))
   
    ;(persona (nombre "Juan Martin Lopez") (edad 17) (estatura 182) (peso 110) (sexo varón) (actividad sedentaria) 
    ;(calorias 0)(proteinas 0)(grasas 0)(hc 0))
    
    (persona (nombre "Maria Gonzalez Perez") (edad 18) (estatura 169) (peso 52) (sexo mujer) (actividad atleta) 
    (calorias 0)(proteinas 0)(grasas 0)(hc 0))
)
*/
;/////////////////////////////////////////////////////////////////////////////////////////////////
(defmodule calculaCalorias)  ; Modulo que reparte las calorias segun las caracteristicas de la persona
(deffunction actividadFunct (?act)
    if(eq ?act sedentaria) then
    (return 1.2)
    else if (eq ?act ligera) then
    (return 1.375)
    else if(eq ?act moderada) then
    (return 1.55)
    else if(eq ?act alta) then
    (return 1.725)
    else if(eq ?act atleta) then
    (return 1.9) else
    (return 1.2)
    
)
; ------------------- HOMBRES ---------------------
(defrule reparteCaloriasHombre
    ?persona <- (persona (nombre ?n)(edad ?edad)(estatura ?est)(peso ?peso) (sexo varón) (actividad ?act) (calorias 0))
    => (modify ?persona (calorias (* (actividadFunct ?act) (+ 66 (+ (* 13.7 ?peso)(- (* 5 ?est)(* 6.8 ?edad)))))))
)
; ------------------- MUJERES ---------------------
(defrule reparteCaloriasMujeres
    ?persona <- (persona (nombre ?n)(edad ?edad)(estatura ?est)(peso ?peso) (sexo mujer) (actividad ?act) (calorias 0))
    => (modify ?persona (calorias (* (actividadFunct ?act) (+ 655 (+ (* 9.6 ?peso)(- (* 1.8 ?est)(* 4.7 ?edad)))))))
)
;Distribucion de necesidades (calorias, proteinas, grasas y HC):
(defrule reparte
   ?persona <- (persona (nombre ?n)(edad ?edad)(estatura ?est)(peso ?peso) (sexo ?sexo) (actividad ?act) (calorias ?cal))
    (test(> ?cal 0)) 
    => (modify ?persona (proteinas (/ (round(* 100 (* ?cal 0.15))) 100)) (grasas (/ (round(* 100 (* ?cal 0.25))) 100))
     (hc (/ (round(* 100 (* ?cal 0.57))) 100)))
)

;/////////////////////////////////////////////////////////////////////////////////////////////////
(defmodule creaMenu) ; Modulo que imprime el menu a la persona con todas las necesidades ya calculadas
(defrule ImprimePersona
    (persona(nombre ?nombre)(edad ?edad)(estatura ?est)(peso ?peso)(sexo ?sexo)(actividad ?act)
       ; (calorias ?alm)(calorias ?cena)(caloriasDesayuno ?des)(calorias ?mer))
        (calorias ?cal)(proteinas ?pr)(grasas ?gr)(hc ?hc))
    (test (> ?cal 0))=>
    (printout t ?nombre "." crlf "Sexo:"?sexo " | Edad:"?edad " | Estatura:"?est"cm" " | Peso:"?peso"kg" " | Actividad:" ?act
        crlf "Necesita:" (/ (round(* 100 ?cal)) 100) " calorias, " (/ (round(* 100 ?pr)) 100) " proteinas, " (/ (round(* 100 ?gr)) 100) " grasas y " (/ (round(* 100 ?hc)) 100) " HC." crlf)
    (printout t "Estos son los posibles menus:" crlf)
    (printout t "----------------------------------------------------" crlf)
)
;/////////////////////////////////////////////////////////////////////////////////////////////////
(defmodule creaDesayuno) ;Modulo que crea el desayuno segun las necesidades de la persona
(defrule Desayuno
    (persona(nombre ?nombre)(calorias ?cal)(proteinas ?pr)(grasas ?gr)(hc ?hc))
    (plato(nombre ?plato1)(calorias ?cal1)(proteinas ?pr1)(grasas ?gr1)(hc ?hc1)(tipo postre))
    (plato(nombre ?plato2)(calorias ?cal2)(proteinas ?pr2)(grasas ?gr2)(hc ?hc2)(tipo postre))
 	
	(test (<(+ ?cal1  ?cal2 ) (* (* ?cal ?*%des*) (+ 1 ?*MargenCalorias*))))
    (test (>(+ ?cal1 ?cal2) (* (* ?cal ?*%des*) (- 1 ?*MargenCalorias*))))
    (test (<(+ ?pr1  ?pr2) (* (* (* ?cal 0.0375) ?*%des*) (+ 1 ?*MargenProteinas*))))
    (test (>(+ ?pr1  ?pr2 ) (* (* (* ?cal 0.0375) ?*%des*) (- 1 ?*MargenProteinas*))))
    (test (<(+ ?gr1 ?gr2  ) (* (* (* ?cal 0.0625) ?*%des*) (+ 1 ?*MargenGrasas*))))
    (test (>(+ ?gr1 ?gr2  ) (* (* (* ?cal 0.0625) ?*%des*) (- 1 ?*MargenGrasas*))))
    (test (<(+ ?hc1 ?hc2  ) (* (* (* ?cal 0.175) ?*%des*) (+ 1 ?*MargenHC*))))
    (test (>(+ ?hc1 ?hc2  ) (* (* (* ?cal 0.175) ?*%des*) (- 1 ?*MargenHC*))))
    => (assert (Desayuno ?plato1 ?plato2 (/ (round(* 100 (+ ?cal1 ?cal2))) 100) (/ (round(* 100 (+ ?pr1 ?pr2) )) 100)
             (/ (round(* 100  (+ ?gr1 ?gr2) )) 100) (/ (round(* 100  (+ ?hc1 ?hc2) )) 100)))
   
)
(defrule quitaRepetidos
    ?des1 <- (Desayuno ?plato1 ?plato2 ?cal ?pr ?gr ?hc)
    ?des2 <- (Desayuno ?plato1* ?plato2* ?cal* ?pr* ?gr* ?hc*)
    (test (eq ?plato1 ?plato2*))
    (test (eq ?plato2 ?plato1*))
    => (retract ?des2)
)
(defrule ImprimeDesayunos
    (creaDesayuno::Desayuno ?plato1 ?plato2 ?cal ?pr ?gr ?hc)
    =>  
    (printout t "Desayuno : " ?plato1 ", " ?plato2  ". " 
        ?cal " kcal, " ?pr " proteinas, " ?gr " grasas, " ?hc " HC" crlf)
)
;/////////////////////////////////////////////////////////////////////////////////////////////////
(defmodule creaAlmuerzo) ;Crea el almuerzo segun las necesidades de la persona
(defrule Almuerzo
    (persona(nombre ?nombre)(calorias ?cal)(proteinas ?pr)(grasas ?gr)(hc ?hc))
    (plato(nombre ?plato1)(calorias ?cal1)(proteinas ?pr1)(grasas ?gr1)(hc ?hc1)(tipo ?tipo1))
    (plato(nombre ?plato2)(calorias ?cal2)(proteinas ?pr2)(grasas ?gr2)(hc ?hc2)(tipo ?tipo2))
    (plato(nombre ?postre)(calorias ?cal3)(proteinas ?pr3)(grasas ?gr3)(hc ?hc3)(tipo postre))

	(test (<(+ ?cal1 (+ ?cal2 ?cal3)) (* (* ?cal ?*%alm*) (+ 1 ?*MargenCalorias*))))
    (test (>(+ ?cal1 (+ ?cal2 ?cal3)) (* (* ?cal ?*%alm*) (- 1 ?*MargenCalorias*))))
    (test (<(+ ?pr1 (+ ?pr2 ?pr3)) (* (* (* ?cal 0.0375) ?*%alm*) (+ 1 ?*MargenProteinas*))))
    (test (>(+ ?pr1 (+ ?pr2 ?pr3)) (* (* (* ?cal 0.0375) ?*%alm*) (- 1 ?*MargenProteinas*))))
    (test (<(+ ?gr1 (+ ?gr2 ?gr3)) (* (* (* ?cal 0.0625) ?*%alm*) (+ 1 ?*MargenGrasas*))))
    (test (>(+ ?gr1 (+ ?gr2 ?gr3)) (* (* (* ?cal 0.0625) ?*%alm*) (- 1 ?*MargenGrasas*))))
    (test (<(+ ?hc1 (+ ?hc2 ?hc3)) (* (* (* ?cal 0.175) ?*%alm*) (+ 1 ?*MargenHC*))))
    (test (>(+ ?hc1 (+ ?hc2 ?hc3)) (* (* (* ?cal 0.175) ?*%alm*) (- 1 ?*MargenHC*))))
    (test (or(eq ?tipo1 primero)(eq ?tipo1 ambos)))
    (test (or(eq ?tipo2 segundo)(eq ?tipo2 ambos)))
    => (assert (Almuerzo ?plato1 ?plato2 ?postre (/ (round(* 100 (+ (+ ?cal1 ?cal2) ?cal3))) 100) (/ (round(* 100 (+ (+ ?pr1 ?pr2) ?pr3))) 100)
             (/ (round(* 100 (+ (+ ?gr1 ?gr2) ?gr3))) 100) (/ (round(* 100 (+ (+ ?hc1 ?hc2) ?hc3))) 100)))
   )
(defrule quitaRepetidos
    ?al1 <- (Almuerzo ?plato1 ?plato2 ?plato3 ?cal ?pr ?gr ?hc)
    ?al2 <- (Almuerzo ?plato1* ?plato2* ?plato3* ?cal* ?pr* ?gr* ?hc*)
    (test (eq ?plato1 ?plato2*))
    (test (eq ?plato2 ?plato1*))
    (test (eq ?plato3 ?plato3*))    
    => (retract ?al2)
)
(defrule ImprimeAlmuerzos
    (creaAlmuerzo::Almuerzo ?plato1 ?plato2 ?postre ?cal ?pr ?gr ?hc)
    => 
    (printout t "Almuerzo : " ?plato1", "?plato2 " y " ?postre ". " 
        ?cal " kcal, " ?pr " proteinas, " ?gr " grasas, " ?hc " HC" crlf)
)
;/////////////////////////////////////////////////////////////////////////////////////////////////
(defmodule creaMerienda) ;Crea la merienda segun las necesidades de la persona
(defrule Merienda
    
    (persona(nombre ?nombre)(calorias ?cal)(proteinas ?pr)(grasas ?gr)(hc ?hc))
    (plato(nombre ?plato1)(calorias ?cal1)(proteinas ?pr1)(grasas ?gr1)(hc ?hc1)(tipo postre))
    (plato(nombre ?plato2)(calorias ?cal2)(proteinas ?pr2)(grasas ?gr2)(hc ?hc2)(tipo postre))
 	
	(test (<(+ ?cal1 ?cal2) (* (* ?cal ?*%mer*) (+ 1 ?*MargenCalorias*))))
    (test (>(+ ?cal1 ?cal2) (* (* ?cal ?*%mer*) (- 1 ?*MargenCalorias*))))
    (test (<(+ ?pr1 ?pr2 ) (* (* (* ?cal 0.0375) ?*%mer*) (+ 1 ?*MargenProteinas*))))
    (test (>(+ ?pr1 ?pr2 ) (* (* (* ?cal 0.0375) ?*%mer*) (- 1 ?*MargenProteinas*))))
    (test (<(+ ?gr1 ?gr2 ) (* (* (* ?cal 0.0625) ?*%mer*) (+ 1 ?*MargenGrasas*))))
    (test (>(+ ?gr1 ?gr2 ) (* (* (* ?cal 0.0625) ?*%mer*) (- 1 ?*MargenGrasas*))))
    (test (<(+ ?hc1 ?hc2 ) (* (* (* ?cal 0.175) ?*%mer*) (+ 1 ?*MargenHC*))))
    (test (>(+ ?hc1 ?hc2) (* (* (* ?cal 0.175) ?*%mer*) (- 1 ?*MargenHC*))))
     => (assert (Merienda ?plato1 ?plato2 (/ (round(* 100 (+ ?cal1 ?cal2))) 100) (/ (round(* 100 (+ ?pr1 ?pr2) )) 100)
             (/ (round(* 100  (+ ?gr1 ?gr2) )) 100) (/ (round(* 100  (+ ?hc1 ?hc2) )) 100)))
   
)
(defrule quitaRepetidos
    ?mer1 <- (Merienda ?plato1 ?plato2 ?cal ?pr ?gr ?hc)
    ?mer2 <- (Merienda ?plato1* ?plato2* ?cal* ?pr* ?gr* ?hc*)
    (test (eq ?plato1 ?plato2*))
    (test (eq ?plato2 ?plato1*))
    => (retract ?mer2)
)
(defrule ImprimeMeriendas
    (creaMerienda::Merienda ?plato1 ?plato2 ?cal ?pr ?gr ?hc)
    =>  
    (printout t "Merienda : " ?plato1 " y " ?plato2". " 
        ?cal " kcal, " ?pr " proteinas, " ?gr " grasas, " ?hc " HC" crlf)
)
;/////////////////////////////////////////////////////////////////////////////////////////////////
(defmodule creaCena) ;Crea la cena segun las necesidades de la persona
(defrule Cena
    (persona(nombre ?nombre)(calorias ?cal)(proteinas ?pr)(grasas ?gr)(hc ?hc))
    (plato(nombre ?plato1)(calorias ?cena1)(proteinas ?pr1)(grasas ?gr1)(hc ?hc1)(tipo ?tipo1))
    (plato(nombre ?plato2)(calorias ?cena2)(proteinas ?pr2)(grasas ?gr2)(hc ?hc2)(tipo ?tipo2))
    (plato(nombre ?postre)(calorias ?cena3)(proteinas ?pr3)(grasas ?gr3)(hc ?hc3)(tipo postre))

	(test (<(+ ?cena1 (+ ?cena2 ?cena3)) (* (* ?cal ?*%cena*) (+ 1 ?*MargenCalorias*))))
    (test (>(+ ?cena1 (+ ?cena2 ?cena3)) (* (* ?cal ?*%cena*) (- 1 ?*MargenCalorias*))))
    (test (<(+ ?pr1 (+ ?pr2 ?pr3)) (* (* (* ?cal 0.0375) ?*%cena*) (+ 1 ?*MargenProteinas*))))
    (test (>(+ ?pr1 (+ ?pr2 ?pr3)) (* (* (* ?cal 0.0375) ?*%cena*) (- 1 ?*MargenProteinas*))))
    (test (<(+ ?gr1 (+ ?gr2 ?gr3)) (* (* (* ?cal 0.0625) ?*%cena*) (+ 1 ?*MargenGrasas*))))
    (test (>(+ ?gr1 (+ ?gr2 ?gr3)) (* (* (* ?cal 0.0625) ?*%cena*) (- 1 ?*MargenGrasas*))))
    (test (<(+ ?hc1 (+ ?hc2 ?hc3)) (* (* (* ?cal 0.175) ?*%cena*) (+ 1 ?*MargenHC*))))
    (test (>(+ ?hc1 (+ ?hc2 ?hc3)) (* (* (* ?cal 0.175) ?*%cena*) (- 1 ?*MargenHC*))))
    (test (or(eq ?tipo1 primero)(eq ?tipo1 ambos)))
    (test (or(eq ?tipo2 segundo)(eq ?tipo2 ambos)))
       => (assert (Cena ?plato1 ?plato2 ?postre (/ (round(* 100 (+ (+ ?cena1 ?cena2) ?cena3))) 100) (/ (round(* 100 (+ (+ ?pr1 ?pr2) ?pr3))) 100)
             (/ (round(* 100 (+ (+ ?gr1 ?gr2) ?gr3))) 100) (/ (round(* 100 (+ (+ ?hc1 ?hc2) ?hc3))) 100)))
   
)
(defrule quitaRepetidos
    ?c1 <- (Cena ?plato1 ?plato2 ?plato3 ?cal ?pr ?gr ?hc)
    ?c2 <- (Cena ?plato1* ?plato2* ?plato3* ?cal* ?pr* ?gr* ?hc*)
    (test (eq ?plato1 ?plato2*))
    (test (eq ?plato2 ?plato1*))
    (test (eq ?plato3 ?plato3*))    
    => (retract ?c2)
)
(defrule ImprimeCenas
    (creaCena::Cena ?plato1 ?plato2 ?postre ?cal ?pr ?gr ?hc)
    =>  
    (printout t "Cena     : " ?plato1 ", " ?plato2 " y " ?postre ". " 
        ?cal " kcal, " ?pr " proteinas, " ?gr " grasas, " ?hc " HC" crlf)
)

;(reset)
;(focus calculaCalorias creaMenu creaDesayuno creaAlmuerzo creaMerienda creaCena )
;(run)
