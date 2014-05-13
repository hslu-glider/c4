# GameModel
GameModel enthält den aktuellen Zustand des Spiels. Also zum Beispiel 
die aktuellen Spieler, ihre Steine auf dem Spielbrett usw. Das Model 
notifiziert Listeners falls es sich geändert hat (z.B. mit dem 
Observer-Pattern http://en.wikipedia.org/wiki/Observer_pattern). 
Listeners können sich mit der Methode void addModelListener(final 
GameModelListener listener) beim Model für Notifications registrieren. 
Listeners sind zum Beispiel die View oder ein Opponent.

  * Spiellogik
  * Lokaler Speicher
