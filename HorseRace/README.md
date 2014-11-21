home-work-1
===========

Innehåller tomma filer till inlämningen. Huvudet i filerna är inte korrekta utan anger endast vilken typ av klass det är. Behöver ni lägga till fler filer är det ok. Vill ni döpa om filer görs detta enklast via GUI klienten. Vid användning av shell kör mv kommandot.

Arbetsgång:

- [X] Gör en fork av denna repo till din github användare.
- [X] Skriv färdigt projektet (kom ihåg att göra en push ofta i fall det skulle hända något mwed koden).
- [X] Fyll i logfilen eftersom du skriver projektet
    - Log-filen skrivs enligt:
        - Datum
        - Vad skall jag göra idag.
        - Vad är problemet?
        - Till nästa gång
- [X] Readme-filen
     - Fyll i under rubrikerna nedan.
- [ ] När projektet är färdigt gör en sista push till din användare.
- [ ] Sista steget är att göra en pull-request till den här repo:n. Se till att göra den till din branch.


---


Inledning
---
Jag har fått i uppgift att skriva ett program där man kan tävla flera hästar mot
varandra. Det finns vissa krav på de klasser som ska finnas med (t.ex. en
abstrakt klass och minst 2 st subklasser) och även på vissa andra saker
(t.ex. Comparable). Programmet ska köras via ett GUI som jag har skrivit själv.

- Presentation av projektet/programmet  
När programmet körs öppnas ett EventWindow med tillhörande GUI. Det finns
knappar för att starta och avsluta programmet och även för att visa information
om det. 

När man trycker på start tävlar två hästar mot varandra genom att turas
om att ta ett slumpmässigt antal steg åt gången. Den första hästen som passerar
mållinjen vinner den omgången och genom att trycka på start igen kan man tävla
hästarna mot varandra så många gånger man vill. Efter varje slutförd omgång
öppnas en ruta som innehåller information om vilken häst som vann och hur många
gånger den hästen har vunnit. 

För att ge programmet lite variation finns det två
olika hästtyper. NormalHorse, som går ett slumpmässigt antal steg varje gång
och inte har några övriga funktioner, och JumpingHorse, som inte kan rulla lika
höga tal som NormalHorse, men för att kompensera för den svagheten kommer
hästen att göra ett långt hopp när den rullar ett speciellt tal.

Efter några tester verkar hästarna vara ganska balanserade. Vilket innebär att 
de har ungefär lika stor chans att vinna.


Genomförande  
---
Se loggboken. I princip allt jag har gjort är dokumenterat där.

Hur gick det?  
I början gick det väldigt segt pga att jag inte riktigt visste var jag skulle 
börja. Efter att ha frågat läraren ett antal gånger började saker klarna och i 
slutet kände jag inte att jag hade några problem med uppgiften. Jag har fått 
kringgå några saker som har krånglat längs vägen och programmet har därför 
inte blivit så bra som jag först hade önskat, men jag tycker att slutresultatet
ändå är acceptabelt.

Slutresultat/Analys/Diskussion
---

- Buggar  
Programmet kan inte köras i realtid på grund av hur trådar fungerar tillsammans
med ActionPerformed, därför ritas inte hästarnas framsteg ut föränn efter att
tävlingen är slutförd. Utöver det har jag inte stött på några buggar.

- Förbättringar  
Först och främst hade det varit bra om programmet hade kunnat köras i realtid,
sättet det körs på just nu drar ner helhetsintrycket. Det hade även varit bra
om man själv hade kunnat få välja vilka hästar som ska vara med och tävla men
på grund av jag inte lyckades få ArrayList att fungera så hårdkodade jag in två
hästar för att kunna lämna in ett fungerande program.

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
lyckas lägga till dem på annat sätt.

- 2014-11-15 21:41  
Idag har jag hårdkodat in två hästar. I övrigt fungerar programmet, dock inte så
som jag hade önskat. Främst på grund av att delay() fortfarande inte gör
det den ska göra. Jag har inte lyckats hitta någon lösning på det problemet. 
Programmet fungerar fortfarande, det enda som händer är att racet inte sker i 
realtid. Programmet är till största del klart, framöver ska jag finputsa det
och lägga till några småfunktioner. Sedan blir det att kommentera och skapa
ett klassdiagram.

- 2014-11-18 11:48  
Nu har jag skapat en separat klass för att skriva ut resultaten och även börjat
kommentera min kod, när jag har kommenterat ska jag skapa klassdiagrammet.

- 2014-11-18 18:25  
Nu är jag i stort sett färdig med kommenteringen. Det enda som återstår är att
skapa klassdiagrammet som ska lämnas in tillsammans med uppgiften.