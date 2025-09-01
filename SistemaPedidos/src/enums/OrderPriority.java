package enums;

//define la prioridad de un pedido
//cada pedido tiene asociado un nivel numerico
public enum OrderPriority {
	LOW(1), //prioridad baja
	MEDIUM(2),//prioridad media
	HIGH(2);//prioridad alta

	private final int level;// muestra en numero de la prioridad 

	//constructore con el nivel 
	OrderPriority(int level) {
		this.level = level;
	}

	//devuelve el nivel asociado a la prioridad
	public int getLevel() {
		return level;
	}

	
}
