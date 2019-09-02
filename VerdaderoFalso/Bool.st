!classDefinition: #Falso category: #Bool!
DenotativeObject subclass: #Falso
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Bool'!

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

!classDefinition: 'Falso class' category: #Bool!
Falso class
	instanceVariableNames: ''!

!Falso class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 22:58:49'!
no
	^Verdadero! !

!Falso class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 23:20:50'!
o: unBooleano
	unBooleano siVerdadero: [^Verdadero].
	unBooleano siFalso: [^Falso].! !

!Falso class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 23:03:45'!
siFalso: aClosure
	^aClosure value.! !

!Falso class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 23:03:22'!
siVerdadero: aClosure
	^self! !

!Falso class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 23:01:43'!
y: unBooleano
	^Falso! !


!classDefinition: #Verdadero category: #Bool!
DenotativeObject subclass: #Verdadero
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Bool'!

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

!classDefinition: 'Verdadero class' category: #Bool!
Verdadero class
	instanceVariableNames: ''!

!Verdadero class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 23:04:18'!
no
	^Falso! !

!Verdadero class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 23:04:31'!
o: unBooleano
	^Verdadero! !

!Verdadero class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 23:04:44'!
siFalso: aClosure
	^self.! !

!Verdadero class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 23:04:58'!
siVerdadero: aClosure
	^aClosure value.! !

!Verdadero class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 23:20:16'!
y: unBooleano
	unBooleano siVerdadero: [^Verdadero].
	unBooleano siFalso: [^Falso].! !
