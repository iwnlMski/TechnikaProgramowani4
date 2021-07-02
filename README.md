# TechnikaProgramowania 4
![alt text](https://github.com/iwnlMski/TechnikaProgramowani4/blob/master/readmeimg/TP4photo1.PNG?raw=true)

### Projekt numer 4
### Autor projektu: Seweryn Majewski ACiR WETI 2sem. Indeks: 181675
### Użyta technologia: Java 

### Dokumentacja:
### 1. Działanie programu: 
Celem programu jest wizualizajca działania windy, w dwóch wymiarach. Program opiera się na
dwóch klasach. 
      
#### a. MyForm.java
Jest to klasa implementująca elementy GUI, oraz jednocześnie pełni funkjcę klasy main.
Poza implementacją elementów interfejsu graficznego, definiuje również ich zachowanie
w poszczególnych scenariuszach użytkowania. Bowiem zaimplementowane są tak zwane
“Listenery” czekające na input z przycisków, niektóre funkcje walidujące wejście
użytkownika oraz jedna z ważniejszych funkcji programu: **runGraph()**, która nie
przyjmuję żadnych argumentów I jest wywołyana przy wciśnięciu odpowiedniego
przycisku. 

#### b. GraphicsDemo.java
Jest to klasa odpowiedzialna za rysowanie I kalkulowanie trasy windy. Metoda
implementująca tworzenie trasy windy to metoda **createPath(int destinationLevel)**
przyjmująca jeden argument typu int mówiący o tym na który poziom winda ma
wjechać. Metodą odpowiedzialną za rysowanie ekranu jest metoda
**paintComponent(Graphics g)**. Jest to metoda dziedziczona z parent klasy.
Jako ostatni element tej klasy mamy konstruktor, który jest odpowiedzialny za
kontrolowanie całego przebiegu rysowania oraz updatetowania zmiennych w klasie
MyForm. 

### 2. GUI
![alt text](https://github.com/iwnlMski/TechnikaProgramowani4/blob/master/readmeimg/tp4photo2.PNG?raw=true)
#
Gui opiera się na 4 przyciskach, które pozwalają nam na przywołanie windy na dany poziom.
Jeżeli winda dojedzie na dany poziom, czeka 5sekund, po czym zjeżdża na parter 
