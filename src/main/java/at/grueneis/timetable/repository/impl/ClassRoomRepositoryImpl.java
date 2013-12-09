/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.repository.impl;

import at.grueneis.timetable.domain.ClassRoom;
import at.grueneis.timetable.domain.QClassRoom;
import at.grueneis.timetable.repository.ClassRoomRepositoryCustom;
import com.mysema.query.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 */
public class ClassRoomRepositoryImpl implements ClassRoomRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ClassRoom> findWithQueryDsl(String building) {
        JPAQuery query = new JPAQuery(entityManager);
        QClassRoom classRoom = QClassRoom.classRoom;

        query.from(classRoom).
                where(classRoom.building.eq(building)).
                orderBy(classRoom.name.asc());

        return query.list(classRoom);
    }

    @Override
    public List<ClassRoom> findWithJqlQuery(String building) {
        return entityManager.
                createQuery("from ClassRoom where building = :building", ClassRoom.class).
                setParameter("building", building).
                getResultList();
    }

    @Override
    public List<ClassRoom> findWithCriteriaApi(String building) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassRoom> query = builder.createQuery(ClassRoom.class);
        Root<ClassRoom> root = query.from(ClassRoom.class);
        Predicate buildingPredicate = builder.equal(root.get("building"), building);
        query.where(buildingPredicate);

        return entityManager.
                createQuery(query.select(root)).
                getResultList();
    }
}
