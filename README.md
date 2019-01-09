# Alexa, ich brauche ein Alibi...

Jeder kennt es: man verpasst einen Termin oder eine Frist wurde nicht eingehalten. 
Man bekommt schon wieder Ärger weil man den Müll nicht rausgebracht hat...
Jetzt wird man zur Rede gestellt. Was sagt man?

Mit dem Alibi Skill für Alexa löst sich dieses Problem mit Leichtigkeit.
Frage Alexa einfach nach einem Alibi und sofort erhälst du eine passende Ausrede.

_"Alexa, starte Alibi."_

Gib einfach deinen derzeitigen Standort und das gewünschte Datum an und schon bastelt Alexa dir deine Geschichte.

![Näheres hier](https://github.com/sweIhm-ws2018-19/skillproject-do-4/blob/master/docs/index.md)


# Log

## Travis CI status:

![](https://api.travis-ci.org/sweIhm-ws2018-19/skillproject-do-4.svg?branch=master)

## Sonarqube status

![](https://sonarcloud.io/api/project_badges/measure?project=alexa-skills-kit-samples%3Aalibi&metric=alert_status)

## Coverage

![](https://sonarcloud.io/api/project_badges/measure?project=alexa-skills-kit-samples%3Aalibi&metric=coverage)

**_Derzeitige Funktionalitäten_**

Der Nutzer kann folgende Parameter angeben: -> Standort, Datum.

Alexa filtert aus diesen Informationen ein passendes Alibi und gibt es dann aus.

**_Funktionalitäten für zukünftige Sprints_**

Der Nutzer gibt bis zu 4 Parameter an -> Uhrzeit, Datum, Standort, Zielperson.

Alexa prüft nun deinen Kalender und generiert, sollte der Kalender leer sein, mit den gegebenen Parametern ein glaubwürdiges Alibi.
Abschließend fügt Alexa diesen generierten Event nun in deinen Kalender ein um auch noch den letzten Zweifel von etwaigen Zeugen im Keim zu ersticken.
