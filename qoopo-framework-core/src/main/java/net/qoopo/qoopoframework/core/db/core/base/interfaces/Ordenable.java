package net.qoopo.qoopoframework.core.db.core.base.interfaces;

/**
 * Esta interfaz es para las entidades que deben tener un campo para ordenar
 *
 * @author alberto
 */
public interface Ordenable extends Comparable<Ordenable> {

    public Integer getOrder();

    public void setOrder(Integer order);

}
