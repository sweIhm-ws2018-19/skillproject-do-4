# Alexa, ich brauche ein Alibi...

Jeder kennt es: man verpasst einen Termin oder eine Frist wurde nicht eingehalten. 
Man bekommt schon wieder Ärger weil man den Müll nicht rausgebracht hat...
Jetzt wird man zur Rede gestellt. Was sagt man?

Mit dem Alibi Skill für Alexa löst sich dieses Problem mit Leichtigkeit.
Frage Alexa einfach nach einem Alibi und sofort erhälst du eine passende Ausrede.

_"Alexa, starte Alibi."_

Gib einfach deinen derzeitigen Standort und das gewünschte Datum an und schon bastelt Alexa dir deine Geschichte.

## Travis CI status:

![](https://api.travis-ci.org/sweIhm-ws2018-19/skillproject-do-4.svg?branch=master)

## Sonarqube status

![](https://sonarcloud.io/api/project_badges/measure?project=alexa-skills-kit-samples%3Aalibi&metric=alert_status)

## Coverage

![](https://sonarcloud.io/api/project_badges/measure?project=alexa-skills-kit-samples%3Aalibi&metric=coverage)

**_Einfache Funktionalität_**

Als Nutzer gibt man Alexa ein Datum, eine Uhrzeit an. Alexa durchsucht im folgenden den eigenen Kalender nach einem Termin zu dem fraglichen Zeitpunkt, falls ein anderer Termin zu dem Zeitpunkt bereits stattfand.

**_Personalisiert_**

Da ein Alibi etwas persönliches darstellt, gib Alexa die zusätzliche Option, eine Zielgruppe, gegenüber wem muss das Alibi veräußert werden, anzugeben. Die Uhrzeit lässt sich als Zeitspannen oder Perioden angeben. Aktivitäten, die einem besonders liegen können ebenso angegeben werden, als Referenz. Falls man dann doch etwas generalisieren will, lässt sich ein Umfeld angeben, aus dem sich ein Aktivität ableiten lässt.

**_Glaubwürdig_**

Für den Fall, dass Alexa nicht fündig wird, wird ein passendes Event generiert und in den eigenen Kalender eingetragen. Dieses "Custom- Event" wird anschließend ausgegeben.

