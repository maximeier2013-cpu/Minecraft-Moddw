# Winter Magic 1.21.11 – Fabric-Entwicklungsprojekt

**Dies ist ein Quellcode-Grundgerüst, keine fertige Mod.** Die 43 vorhandenen 3D-Item-Modelle und die Amboss-Namensliste liegen bei. Der Client-Entrypoint schreibt derzeit nur eine Startmeldung. Eine funktionierende automatische Umbenennung, platzierbare Dekorationen, Rüstungsrenderer, Nordlichter und GUI sind **noch nicht programmiert**. Die Modell-Assets wurden aus dem vorherigen Prototyp übernommen und sind nicht auf Minecraft 1.21.11 validiert.

## Warum nicht einfach eine ZIP als Mod?

Eine installierbare Fabric-Mod benötigt eine gebaute `.jar`, kompatible Fabric-Abhängigkeiten und Tests in Minecraft. Eine bloße ZIP mit `fabric.mod.json` ist keine lauffähige Mod.

## Bauen (nach Prüfung der Versionsnummern)

1. Java 21 installieren.
2. Gradle 8/9 und Fabric-Loom nach offizieller Dokumentation einrichten; ein Gradle-Wrapper liegt nicht bei.
3. Die Versionsangaben in `gradle.properties` gegen die aktuellen Fabric-Maven-Veröffentlichungen prüfen (hier nicht verifiziert).
4. Im Projektordner `gradle build` ausführen.
5. Die resultierende JAR liegt bei erfolgreichem Build in `build/libs/`.

## Technische Grenzen

Auf fremden Servern können clientseitige Mods nur die eigene Anzeige ändern. Der Server kennt den Namen eines bereits platzierten Kürbisses nicht mehr. Die Zuordnung muss der Client selbst verfolgen und speichern. Änderungen anderer Spieler bei Abwesenheit können die Zuordnung ungültig machen. Die Änderung der Blockdarstellung und getragener Rüstungsmodelle erfordert Renderer/Mixins; diese fehlen hier noch.

Siehe `docs/AMBOSS_NAMEN.md` für alle 43 Namen.
