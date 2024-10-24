LIM Oudam-dara

Question 2 : Identifiez les principaux éléments de cette fonction. Jetez un coup d’oeil à l’API de  Graphics, une classe du JDK, ainsi que celle de Scene qui est fournie avec le ray tracer. En quoi consiste la double boucle qui est le corps de cette fonction ?
Les principaux éléments de la fonction sont :
- Scene : Elle Représente l'état de la scène 3D, avec les sphères et les sources de lumière. 
renderScene utilise la scène pour obtenir des informations sur la géométrie et l'éclairage.
- Graphics gfx : Elle est utilisée ici pour dessiner les couleurs calculées pour chaque pixel de l'image, grâce à gfx.setColor et gfx.fillRect.
- Dimensions (swidth, height) : La fonction prend la largeur et la hauteur de la fenêtree, ce qui correspond au nombre total de pixels horizontaux et verticaux.
- Resolution : Ce paramètre contrôle la qualité du rendu. Plus la résolution est proche de 1, plus le ray tracing trace de rayons pour chaque pixel.

La double boucle imbriquée est responsable du calcul de la couleur pour chaque pixel de l’image.
La boucle sur x : Elle parcourt chaque colonne de pixels de gauche à droite.
La boucle sur y : Elle parcourt chaque ligne de pixels de haut en bas.

À chaque itération des deux boucles, la fonction calcule les coordonnées de l’écran avec getNormalizedScreenCoordinates, puis elle trace un rayon vers la scène, avec computePixelInfo et enfin détermine la couleur du pixel.

Question 4. Quel problème se pose dans l’accès à la variable nouvellement partagé “gfx” ? 
Le problème principal concerne l'accès concurrent à l'objet Graphics, gfx.
Comme on a plusieurs threads qui tentent de dessiner sur l'objet gfx en même temps dans la méthode renderScene2, cela créer des problèmes.

Comment l’avez vous résolu ?
Pour corriger ce problème, la solution consiste à synchroniser l'accès à l'objet gfx.
synchronized (gfx) {
    gfx.setColor(pixelData.getColor().toAWTColor());
    gfx.fillRect(xFinal, yFinal, blockSize, blockSize);
}

Question 5 :  Quel est le problème posé par le nombre de threads engendrés ? 

- La surcharge du CPU : Plus la résolution est élevée, plus le nombre de threads augmente et donc cela peut créer des milliers, voire des millions de threads.
A la fin, cela surchage le cpu.
- Excès de Mémoire :  Chaque thread occupe une certaine quantité de mémoire. 

Comparaison :

Résolution = 0,05f.
- Temps pris sans thread : Rendered in ~7ms
- Temps pris avec un thread par pixel : Rendered in ~945ms 
- Temps pris avec un thread par ligne : Rendered in ~25ms

Donc, c'est le sans thread qui est le plus rapide.

