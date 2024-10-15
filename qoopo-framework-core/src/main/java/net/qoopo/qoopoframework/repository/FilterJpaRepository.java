package net.qoopo.qoopoframework.repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.qoopo.qoopoframework.QoopoFramework;
import net.qoopo.qoopoframework.jpa.daos.FilterDAO;
import net.qoopo.qoopoframework.jpa.filter.Filter;
import net.qoopo.qoopoframework.util.QLogger;
import net.qoopo.util.db.jpa.Transaccion;

public class FilterJpaRepository<T> {

    public static final Logger log = Logger.getLogger("Qoopo");

    private FilterDAO<T> dao;

    public FilterJpaRepository() {
        dao=new FilterDAO<T>();
    }

    public List<T> filtrar(Filter filtro) {
        long inicial = System.currentTimeMillis();
        Transaccion trx = Transaccion.get(QoopoFramework.get().getDataSourceName());
        trx.abrir();
        List<T> valor = null;
        try {
            valor = (List<T>) dao.filtrar(trx, filtro);
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            trx.close();
        }
        log.log(Level.INFO, "Filtro [{0}] -- Terminado {1}",
                new Object[] { filtro.getNombre() + " (" + filtro.getTablaJPL() + ")",
                        QLogger.getTime(inicial) });
        return valor;
    }

    public Long filtrarCount(Filter filtro) {
        long inicial = System.currentTimeMillis();
        Transaccion trx = Transaccion.get(QoopoFramework.get().getDataSourceName());
        trx.abrir();
        Long valor = null;
        try {
            valor = dao.filtrarCount(trx, filtro);
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            trx.close();
        }
        log.log(Level.INFO, "Filtro Count [{0}] -- Terminado {1}",
                new Object[] { filtro.getNombre() + " (" + filtro.getTablaJPL() + ")", QLogger.getTime(inicial) });
        return valor;
    }

    public List<T> filtrar(Filter filtro, int first, int pageSize) {
        long inicial = System.currentTimeMillis();
        Transaccion trx = Transaccion.get(QoopoFramework.get().getDataSourceName());
        trx.abrir();
        List<T> valor = null;
        try {
            valor = (List<T>) dao.filtrar(trx, filtro, first, pageSize);
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
            e.printStackTrace();
        } finally {
            trx.close();
        }
        log.log(Level.INFO, "Filtro [{0}] -- Terminado {1}",
                new Object[] { filtro.getNombre() + " (" + filtro.getTablaJPL() + ")", QLogger.getTime(inicial) });
        return valor;
    }

    public Long filtrarCount(Filter filtro, int first, int pageSize) {
        long inicial = System.currentTimeMillis();
        Transaccion trx = Transaccion.get(QoopoFramework.get().getDataSourceName());
        trx.abrir();
        Long valor = null;
        try {
            valor = dao.filtrarCount(trx, filtro, first, pageSize);
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            trx.close();
        }
        log.log(Level.INFO, "Filtro Count [{0}] -- Terminado {1}",
                new Object[] { filtro.getNombre() + " (" + filtro.getTablaJPL() + ")",
                        QLogger.getTime(inicial) });
        return valor;
    }

}
