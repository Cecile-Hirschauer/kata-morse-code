# kata-morse-code

## 1) Écrire un programme en mode console qui permettra de décoder des messages rédigés en code morse.
    • Les messages à décoder seront passés par l’entrée standard (stdin).
    • Les messages décodés seront écrits sur la sortie standard (stdout).

Les messages en entrée seront construits à l’aide des caractères suivants :

    • « . » 	: period			code ASCII 0x2E		point
    • « - » 	: dash/minus/hyphen	code ASCII 0x2D	tiret
    • «   » 	: space			code ASCII 0x20	séparateur de lettres
    • 5 espaces minimum :					séparateurs de mots
Évidemment, comme dans tous systèmes de transmissions, certaines parties des messages en entrée pourraient être malformés. Dans ce cas ils devront être décodés du mieux possible.

### Exemples

Exemples de messages en code morse :
    • ... --- ...								SOS
    • .... . .-.. .-.. ---     .-- --- .-. .-.. -..			Hello World
    • -.-. --- -.. .     -- --- .-. ... .					Code Morse
    • ..--- ----- .---- --...						2017

## 2) Ecrire un programme qui encode de l'anglais en code morse


