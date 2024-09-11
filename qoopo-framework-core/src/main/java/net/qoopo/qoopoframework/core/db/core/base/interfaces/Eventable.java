package net.qoopo.qoopoframework.core.db.core.base.interfaces;

import java.time.LocalDateTime;

/**
 * Esta interfaz es para las entidades que representan un evento
 *
 * @author alberto
 */
public interface Eventable {

    public String getEventoNombre();

    public LocalDateTime getFechaInicio();

    public LocalDateTime getFechaFin();

    public boolean isAllDay();

    public String getStyleEvent();

}
