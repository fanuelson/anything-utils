package ffnunes.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import ffnunes.exception.FieldNotFoundException;

public final class ReflectionUtils {

	private ReflectionUtils() {
	}
	
	public static List<Field> recuperarCamposAnotadosCom(Class<?> clazz, Class<? extends Annotation> anotattion){
		List<Field> camposAnotados = new ArrayList<>();
		Field[] todosCampos = recuperarTodosCampos(clazz);
		for (Field field : todosCampos) {
			if(field.isAnnotationPresent(anotattion)){
				camposAnotados.add(field);
			}
		}
		return camposAnotados;
	}
	
	public static Field[] recuperarTodosCampos(Class<?> clazz){
		return clazz.getDeclaredFields();
	}

	public static Object recuperarValorCampo(Object objeto, String nomeDoCampo) {
		return recuperarValorCampo(objeto, nomeDoCampo, objeto.getClass());
	}

	public static Object recuperarValorCampo(Object objeto, String nomeDoCampo, Class<?> clazz) {
		try {
			if (clazz.equals(Object.class)) {
				throw new FieldNotFoundException("Field \""+nomeDoCampo+"\" not found on class "+objeto.getClass().getName());
			}
			Field campo = clazz.getDeclaredField(nomeDoCampo);
			campo.setAccessible(true);
			return campo.get(objeto);
		} catch (NoSuchFieldException e) {
			return recuperarValorCampo(objeto, nomeDoCampo, clazz.getSuperclass());
		} catch (SecurityException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
