package com.rbondarovich;

import java.util.List;
import java.util.Set;

public interface EntityBeanConverter  {

    <E, B> B convertToBean(E entity, Class<B> beanClass);

    <E, B> List<B> convertToBeanList(Iterable<E> entities, Class<B> beanClass);

    <E, B> E convertToEntity(B bean, Class<E> entityClass);
}
