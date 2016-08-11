package ffnunes.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;

import ffnunes.exception.FieldNotFoundException;

public final class ReflectionUtils {

	private ReflectionUtils() {
	}
	
	public static void atribuirValorAoCampo(Object valor, Object target, String nomeDoCampo) {
		try {
			FieldUtils.writeField(target, nomeDoCampo, valor, true);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new FieldNotFoundException("Field \""+nomeDoCampo+"\" not found on class "+target.getClass().getName());
		}
	}
	
	public static List<Field> recuperarCamposAnotadosCom(Class<?> clazz, Class<? extends Annotation> anotation) {
		return FieldUtils.getFieldsListWithAnnotation(clazz, anotation);
	}

	public static Field[] recuperarTodosCampos(Class<?> clazz) {
		return FieldUtils.getAllFields(clazz);
	}

	public static Object recuperarValorCampo(Object objeto, String nomeDoCampo) {
		try {
			return FieldUtils.readField(objeto, nomeDoCampo, true);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new FieldNotFoundException("Field \""+nomeDoCampo+"\" not found on class "+objeto.getClass().getName());
		} 
	}
	
}
