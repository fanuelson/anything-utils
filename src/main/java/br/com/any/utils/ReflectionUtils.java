package br.com.any.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;

import br.com.any.exception.FieldNotFoundException;

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
	
	public static void resetFieldsToNull(Object obj, String... campos) {
		for (String nomeCampo : campos) {
			try {
				Object f = FieldUtils.readField(obj, nomeCampo, true);
				if (f != null) {
					atribuirValorAoCampo(null, obj, nomeCampo);
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException("REFLECTION ERROR READING FIELD: " + nomeCampo, e);
			}
		}
	}

	public static void resetFieldsToNewInstance(Object obj, String... campos) {
		for (String nomeCampo : campos) {
			try {
				Object f = FieldUtils.readField(obj, nomeCampo, true);
				if (f != null) {
					Object newInstance = getNewInstanceOfClass(f.getClass());
					atribuirValorAoCampo(newInstance, obj, nomeCampo);
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException("REFLECTION ERROR FIELD: " + nomeCampo, e);
			}
		}
	}
	
	private static <T> T getNewInstanceOfClass(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException("REFLECTION ERROR", e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("REFLECTION ERROR", e);
		}
	}
	
}
