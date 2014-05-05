# GameModel
GameModel enthält den aktuellen Zustand des Spiels. Also zum Beispiel 
die aktuellen Spieler, ihre Steine auf dem Spielbrett usw. Das Model 
notifiziert Listeners falls es sich geändert hat (z.B. mit dem 
Observer-Pattern http://en.wikipedia.org/wiki/Observer_pattern). 
Listeners können sich mit der Methode void addModelListener(final 
GameModelListener listener) beim Model für Notifications registrieren. 
Listeners sind zum Beispiel die View oder ein Opponent.

# GameView
GameView wird durch das Model notifiziert, falls sich etwas am Model 
geändert hat und stellt anschliessend das Model grafisch dar. Also zum 
Beispiel die aktuellen Spieler, ihre Steine auf dem Spielbrett usw. 
Ausserdem leitet die View Eingaben des Benutzers (Disc in Kolonne 
eingefügt, Neues Spiel etc.) an das Control weiter.

# GameControl
Das GameControl empfängt Input (Commands von Opponent oder View), 
entscheidet ob die Commands gültig sind und darf als einziges das 
Model ändern.

# Opponent
Opponent wird vom Model notifiziert, wenn das Model geändert hat und 
darf Befehle an das Control senden. Der Opponent besitzt damit viel 
Ähnlichkeit mit der View. Entsprechend können hier gemeinsame 
Schnittstellen definiert werden.
