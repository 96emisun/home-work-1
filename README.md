home-work-1
===========

Innehåller tomma filer till inlämningen. Huvudet i filerna är inte korrekta utan anger endast vilken typ av klass det är. Behöver ni lägga till fler filer är det ok. Vill ni döpa om filer görs detta enklast via GUI klienten. Vid användning av shell kör mv kommandot.

Arbetsgång:

- [ ] Gör en fork av denna repo till din github användare.
- [ ] Skriv färdigt projektet (kom ihåg att göra en push ofta i fall det skulle hända något mwed koden).
- [ ] Fyll i logfilen eftersom du skriver projektet
    - Log-filen skrivs enligt:
        - Datum
        - Vad skall jag göra idag.
        - Vad är problemet?
        - Till nästa gång
- [ ] Readme-filen
     - Fyll i under rubrikerna nedan.
- [ ] När projektet är färdigt gör en sista push till din användare.
- [ ] Sista steget är att göra en pull-request till den här repo:n. Se till att göra den till din branch.


---


Inledning
---

Presentation av projektet/programmet


Genomförande
---

Hur gick det?


Slutresultat/Analys/Diskussion
---

- Buggar
- Förbättringar
- Övrigt

LOG
---
- 2014-10-15 15:13
Idag har jag skapat mitt projekt och städat upp lite i EvenWindow-klassen som 
jag fick av Stefan. Problemet just nu är att klasserna endast är skapade och ej fungerande.
Nästa gång ska jag försöka lägga till lite innehåll i subklasserna.

- 2014-10-17 15:06
Idag har jag försökt lägga till en sub-klass vid namn JumpingHorse och även 
städa upp lite i den abstrakta klassen. Just nu kan jag inte få mitt GUI att 
fungera och det ska jag fortsätta med nästa gång så att jag kan få börja se lite
framsteg medan de händer. Än så länge ser jag bara text på en skärm.

- 2014-10-24 15:04
Idag har jag fått GUIet att fungera. Nästa gång ska jag börja lägga till lite 
knappar och även skriva lite mer i klasserna. Just nu har jag egentligen inget
stort problem förutom att jag vill få knapparna på rätt ställe.

- 2014-11-05 14:55
Idag har jag sett till att allting i min kod är på samma språk (hade blandat
svenska och engelska) och även fixat så att mina två knappar (starta och
starta om) har rätt storlek. Ett problem just nu är att knapparna
är aningen för långt ner vilket lämnar ett tomt utrymme i mitten och när jag gör 
JFramen mindre så försvinner knapparna helt. Detta problem påverkar bara 
programmets utseende, inte dess funktion. Därför lägger jag inte mer energi 
på det just nu, jag vill fokusera på det som är viktigt så jag behåller 
knapparna som de ser ut just nu.

- 2014-11-12 15:05
Idag har jag börjat bygga på min modellklass där programmet ska köras. Jag har
skapat en ArrayList som ska innnehålla alla hästar. Genom att lägga till en
knapp för varje häst (t.ex. "Add Normal Horse") ska man kunna lägga till 
valfritt antal hästar själv. En For-Each loop i modellklassen kollar varje hästs
position för att kunna avbryta programmet när en häst har korsat mållinjen.

- 2014-11-14 15:18
Idag har jag och Stefan konstaterat att det var mycket svårare att lägga till
hästarna till en ArrayList än vad det borde vara (med andra ord så fick vi det 
ej att fungera). Jag ska i stället fokusera på att fixa till alla klasser
ungefär som de ska vara så ska jag sedan hårdkoda in hästarna om jag inte
lyckas lägga till dem.