# Winter Magic – Entwicklungsstand (Version 0.2.0)

**Implementiert:** 43 Amboss-Namen werden mit ihrem jeweiligen Vanilla-Grundgegenstand abgeglichen. Bei Übereinstimmung wird das clientseitige `minecraft:item_model`-Datenkomponentenfeld auf das vorhandene `wintermagic`-Item-Modell gesetzt. Dies betrifft Inventar, Hotbar und ausgerüstete Rüstung **als Inventargegenstand**. Nach Umbenennung zurück wird das Vanilla-Item-Modell wiederhergestellt.

**Noch nicht implementiert:** 3D-Rüstungsmodelle *am Körper*; eigene Darstellung *platzierter* Blöcke; Synchronisation für andere Spieler; Nordlichter. Die vorhandenen 43 JSON-Modelle sind geometrische Prototypen. Auf fremden Servern können Änderungen an Item-Komponenten durch Serversynchronisation überschrieben werden. Diese Version wurde hier nicht gegen Minecraft zur Laufzeit getestet.

**Installation:** GitHub Actions `Build Winter Magic` starten, Artefakt `Winter-Magic-JAR` laden, die eigentliche Mod-JAR aus dem Artefakt in den Fabric-Mods-Ordner legen (nicht die `-sources.jar`). Fabric API ist erforderlich. Vorherige Version entfernen.
