# NotesCommand

### Descripcion
Aplicacion para recoger los pedidos de una mesa en un restaurante.

En este caso tendremos 6 mesas y clicando en cada una de ellas nos
dara la informacion de los platos que se hayan pedido.

Al principio nos indica que no existe ningun plato por lo que con el
menu de **plato** podemos cambiar de pantalla a la que tenemos
todo el menu y elegir un plato.

Cuando se produce la eleccion podemos pedirle la informacion del
plato seleccionado, lo que nos dara una descripcion del mismo asi
como los alergenos que tiene, o podemos cancelar la accion o aladir
el plato como pedido a la mesa.

En esta ultima accion podemos tambien poner una nota que se adjuntara
a al plato seleccionado

### Actividades
La aplicacion tiene cuatro acividades que son:
- RoomActivity: Donde definimos el conjunto de las mesas existentes.
- TableActivity: Definiria una mesa en articular.
- MenuActivity: En esta estan definidos todos los platos que hay en el menu.
- PlateActivity: Da la informacion de un plato en concreto con sus alergenos.

### Clase Room
Utilizamos la clase Room para hacerla generica a toda la aplicacion  y que sea
la que comparta la informacion de todo el proceso.