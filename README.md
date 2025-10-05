🏦 Lånekalkylator
Detta är en ren och enkel konsolapplikation (ett program som körs i terminalen) skriven i Java. Huvudsyftet är att beräkna och visa en komplett betalningsplan för ett lån.

Huvudfunktioner & Tekniker
Jag använde separata klasser som Amortering för att hålla data och LoanCalculator för att hantera beräkningen för att hålla koden ren.

Kalkylatorn använder en matematisk formel för att säkerställa att din totala månatliga betalning är exakt densamma varje månad.

Jag skrev tester för att kontrollera att formeln fungerar matematiskt korrekt, särskilt för att se till att den sista betalningen gör den återstående skulden till noll.

Programmet hanterar felaktig inmatning från användaren och kan läsa decimaler oavsett om systemet använder punkt eller komma.

Hur Du Använder Appen
Klona eller ladda ner projektet:

Bash

git clone https://github.com/Abdii111/LoanCalculator
Öppna: Öppna projektet i IntelliJ IDEA.

Kör: Starta klassen Main.java.

Programmet kommer att be dig ange lånebelopp, ränta och löptid.
