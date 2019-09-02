!classDefinition: #I category: #Peano!
DenotativeObject subclass: #I
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Peano'!

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

!classDefinition: 'I class' category: #Peano!
I class
	instanceVariableNames: 'next previous'!

!I class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 20:14:34'!
* unNumeroDePeano
	^unNumeroDePeano! !

!I class methodsFor: 'as yet unclassified' stamp: 'FL 8/26/2019 19:00:57'!
+ unNumeroDePeano
	^unNumeroDePeano next! !

!I class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 20:48:27'!
- unNumeroDePeano
	self error: self descripcionDeErrorDeNumerosNegativosNoSoportados! !

!I class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 22:19:10'!
/ unNumeroDePeano
	^self! !

!I class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 20:32:20'!
decrementarA: unNumeroDePeano
	^unNumeroDePeano previous! !

!I class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 20:38:47'!
descripcionDeErrorDeNumerosNegativosNoSoportados
	^'Los numeros negativos no estan soportados'! !

!I class methodsFor: 'as yet unclassified' stamp: 'FL 9/2/2019 15:58:24'!
initializeCollaboratorsFromFile
	"Auto generated method for loading purposes - Do not modify it"

	next := II.
	previous := nil.! !

!I class methodsFor: 'as yet unclassified' stamp: 'FL 8/26/2019 18:56:16'!
next
	next ifNil: [
		next _ self cloneNamed: self name, 'I'.
		next previous: self.
	].
	^next! !


!classDefinition: #II category: #Peano!
DenotativeObject subclass: #II
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Peano'!

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

!classDefinition: 'II class' category: #Peano!
II class
	instanceVariableNames: 'next previous'!

!II class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 20:15:03'!
* unNumeroDePeano
	^self previous * unNumeroDePeano + unNumeroDePeano! !

!II class methodsFor: 'as yet unclassified' stamp: 'FL 8/26/2019 19:01:07'!
+ unNumeroDePeano
	^self previous + unNumeroDePeano next! !

!II class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 19:49:23'!
- unNumeroDePeano
	^unNumeroDePeano decrementarA: self! !

!II class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 22:50:29'!
/ unNumeroDePeano
	unNumeroDePeano isIdenticalTo: self.
		[^I] value.
	^[self - unNumeroDePeano / unNumeroDePeano + I] value.
	! !

!II class methodsFor: 'as yet unclassified' stamp: 'FL 8/28/2019 19:52:57'!
decrementarA: unNumeroDePeano
	^self previous decrementarA: (unNumeroDePeano previous)! !

!II class methodsFor: 'as yet unclassified' stamp: 'FL 9/2/2019 15:58:24'!
initializeCollaboratorsFromFile
	"Auto generated method for loading purposes - Do not modify it"

	next := nil.
	previous := I.! !

!II class methodsFor: 'as yet unclassified' stamp: 'FL 8/26/2019 19:05:14'!
next
	next ifNil: [
		next _ self cloneNamed: self name, 'I'.
		next previous: self.
	].
	^next! !

!II class methodsFor: 'as yet unclassified' stamp: 'FL 8/26/2019 19:01:23'!
previous
	^previous! !

!II class methodsFor: 'as yet unclassified' stamp: 'FL 8/26/2019 19:04:58'!
previous: unNumeroDePeano
	previous _ unNumeroDePeano ! !

!II class methodsFor: 'as yet unclassified' stamp: 'FL 8/26/2019 18:54:33'!
removeAllNext
	next ifNotNil: [
		next removeAllNext.
		next removeFromSystem.
		next _ nil.
	]! !

I initializeAfterFileIn!
II initializeAfterFileIn!