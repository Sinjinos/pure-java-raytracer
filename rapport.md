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
