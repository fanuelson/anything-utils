# anything-utils

Provide utilities for java project


-Utilities

 - DataUtils
```java
boolean dataEstaDentroDoPeriodo(Date data, Date inicioPeriodo, Date fimPeriodo,
			boolean inicioInclusive, boolean fimInclusive);
boolean periodosColidem(Date inicioPeriodo1, Date fimPeriodo1, Date inicioPeriodo2, Date fimPeriodo2,
			boolean inclusive)
```
 - FormatadorUtils
```java
String formatarCelular(String str);
String formatarCPF(String CPF);
String formatarCNPJ(String cnpj);
String formatarCEP(String cep);
```
 - NumeroUtils
```java
int getNumeroPrimoMaisProximoAcima(int num);
boolean isPrimo(int num);
```
 - ReflectionUtils
```java
void atribuirValorAoCampo(Object valor, Object target, String nomeDoCampo);
List<Field> recuperarCamposAnotadosCom(Class<?> clazz, Class<? extends Annotation> anotation);
Field[] recuperarTodosCampos(Class<?> clazz);
Object recuperarValorCampo(Object objeto, String nomeDoCampo);
void resetFieldsToNull(Object obj, String... campos);
void resetFieldsToNewInstance(Object obj, String... campos);
```
  - TimeControllerUtils
```java
void startTime();
void finishTime();
Period getLastPeriod();
void printLastPeriod();
Duration getTotalDuration();
void imprimirTotal();
```
 - ValidadorUtils
```java
boolean isCPF(String CPF);
boolean isCNPJ(String CNPJ);
```
