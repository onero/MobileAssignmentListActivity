package dk.adamino.mobileassignmentlistactivity.Model;

import java.util.ArrayList;
import java.util.List;

import dk.adamino.mobileassignmentlistactivity.BE.Entity;

/**
 * Created by Adamino.
 */

public class EntityModel {
    private static final EntityModel instance = new EntityModel();

    private List<Entity> mEntities;

    public static EntityModel getInstance() {
        return instance;
    }

    private EntityModel() {
        mEntities = new ArrayList<>();
    }

    public List<Entity> getEntities() {
        return mEntities;
    }

    public void setEntities(List<Entity> entities) {
        mEntities = entities;
    }
    public void addEntity(Entity entity) {
        mEntities.add(entity);
    }
}
