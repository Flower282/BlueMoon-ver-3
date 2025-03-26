package org.example.bluemoon.dao;

import org.example.bluemoon.models.NopTien;
import org.example.bluemoon.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class NopTienDAO implements CrudDAO<NopTien, Integer> {
    @Override
    public void save(NopTien nopTien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nopTien);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Deprecated
    @Override
    public void update(NopTien nopTien) {
        throw new UnsupportedOperationException("Không được phép cập nhật thông tin nộp tiền!");
    }

    @Deprecated
    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Không được phép xóa thông tin nộp tiền!");
    }

    @Override
    public NopTien get(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(NopTien.class, id);
        }
    }

    @Override
    public List<NopTien> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<NopTien> query = session.createQuery(
                    "FROM NopTien ORDER BY ngayNop DESC",
                    NopTien.class
            );
            return query.list();
        }
    }
}