(deffacts ini
    (dd Juan María Luis v)
	(dd Juan María Rosa m)
	(dd José Laura Pilar m)
	(dd Luis Pilar Miguel v))

(defrule padre
    
	(dd ?padre ? ?hijo ?) 
	=> (assert (padre ?padre ?hijo)))

(defrule madre
	(dd ? ?madre ?hijo ?) 
    => (assert (madre ?madre ?hijo)))
   
(defrule hijo
	(dd ?padre ?madre ?hijo v)
	=> 
    (assert (hijo ?hijo ?padre))
    (assert (hijo ?hijo ?madre)))

(defrule hija
	(dd ?padre ?madre ?hija m)
	=> 
    (assert (hija ?hija ?padre))
    (assert (hija ?hija ?madre)))

(defrule hermano
	(dd ?padre1 ?madre1 ?hijo1 v)
    (dd ?padre2 ?madre2 ?hijo2 ?)
    (test (and (neq ?hijo1 ?hijo2) (or (eq ?madre1 ?madre2) (eq ?padre1 ?padre2)) ))
	=> 
    (assert (hermano ?hijo1 ?hijo2)))

(defrule hermana
	(dd ?padre1 ?madre1 ?hijo1 m)
    (dd ?padre2 ?madre2 ?hijo2 ?)
    (test (and (neq ?hijo1 ?hijo2) (or (eq ?madre1 ?madre2) (eq ?padre1 ?padre2)) ))
	=> 
    (assert (hermana ?hijo1 ?hijo2)))

(defrule abuelo
	(dd ?padre1 ? ?hijo1 ?)
    (dd ?padre2 ?madre2 ?hijo2 ?)
    (test (or (eq ?hijo1 ?padre2)  (eq ?hijo1 ?madre2)))
	=> 
    (assert (abuelo ?padre1 ?hijo2)))

(defrule abuela
	(dd ? ?madre1 ?hijo1 ?)
    (dd ?padre2 ?madre2 ?hijo2 ?)
    (test (or (eq ?hijo1 ?padre2)  (eq ?hijo1 ?madre2)))
	=> 
    (assert (abuela ?madre1 ?hijo2)))

(reset)
(facts)
(run)
(facts)