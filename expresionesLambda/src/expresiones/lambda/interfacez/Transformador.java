package expresiones.lambda.interfacez;

@FunctionalInterface
public interface Transformador<T, R> {

	R transformar(T dato);
	
}
