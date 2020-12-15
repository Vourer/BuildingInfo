# BuildingInfo ![Build status](https://travis-ci.com/Vourer/BuildingInfo.svg?branch=main)
## Projekt inżynieria oprogramowania
Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.

## Odnośnik do Sprint Backlogu
[Sprint Backlog](https://docs.google.com/spreadsheets/d/16znxdigmIjH9Ctsls1MjmpRbJEqhQWi9s8FN0uXtZ7c/edit?fbclid=IwAR0Kn5xUXAWT_VG_3k3Oe-oNO7aCE1dR0_XrBs0P8TZpBLMFevUKOjk8Qbs#gid=959724132)

## Struktura danych
- Lokacja to budynek, poziom, lub pomieszczenie
- Budynek może składać się z poziomów a te z pomieszczeń
- Każda lokalizacja jest charakteryzowana przez:
  - id – unikalny identyfikator
  - name – opcjonalna nazwa lokalizacji
- Pomieszczenie dodatkowo jest charakteryzowane przez:
  - area = powierzchnia w m^2
  - cube = kubatura pomieszczenia w m^3
  - heating = poziom zużycia energii ogrzewania (float)
  - light – łączna moc oświetlenia
  
[Implementacja struktury danych](https://github.com/Vourer/BuildingInfo/wiki/Struktura-do-przechowywania-informacji)

## Członkowie zespołu:
- Anna Gruszka
- Adam Marciniak (Proxy Product Owner)
- Eryk Kosmala (Scrum Master)
- Mateusz Gajewski
